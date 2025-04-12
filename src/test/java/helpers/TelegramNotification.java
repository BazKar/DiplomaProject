package helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import java.util.Scanner;
import java.nio.file.Files;

public class TelegramNotification {
    public static void main(String[] args) {
        try {
            // Read the JSON file
            FileReader file = new FileReader("notifications/telegram.json");
            Scanner scanner = new Scanner(file);
            StringBuilder json = new StringBuilder();
            while (scanner.hasNextLine()) {
                json.append(scanner.nextLine());
            }
            scanner.close();

            // Parse the JSON using Jackson ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(json.toString());

            // Extract token and chatId
            String token = jsonNode.get("telegram").get("token").asText();
            String chatId = jsonNode.get("telegram").get("chat").asText();

            // Prepare the message
            String message = "Test Status: Failed. See the screenshot.";

            // Capture screenshot (this will be Allure's screenshot from the allure-results folder)
            File screenshot = getScreenshotFromAllure("test_failure");

            // Send message first (optional)
            sendTelegramMessage(token, chatId, message);

            // Send screenshot
            sendTelegramPhoto(token, chatId, screenshot);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static File getScreenshotFromAllure(String screenshotName) {
        // Assuming allure saves screenshots in the "allure-results/screenshots" directory
        File screenshotDir = new File("allure-results/screenshots");
        File screenshotFile = new File(screenshotDir, screenshotName + ".png");
        if (screenshotFile.exists()) {
            return screenshotFile;
        } else {
            // Handle error: screenshot not found
            return null;
        }
    }

    public static void sendTelegramMessage(String token, String chatId, String message) {
        try {
            String urlString = "https://api.telegram.org/bot" + token + "/sendMessage?chat_id=" + chatId + "&text=" + message;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendTelegramPhoto(String token, String chatId, File photo) {
        try {
            String urlString = "https://api.telegram.org/bot" + token + "/sendPhoto?chat_id=" + chatId;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Set content type for file upload
            connection.setRequestProperty("Content-Type", "multipart/form-data");

            // Send the file as a POST request
            String boundary = "----WebKitFormBoundary" + Long.toHexString(System.currentTimeMillis());
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            connection.setRequestProperty("Connection", "Keep-Alive");

            // Write the file and form data to the connection output stream
            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(("--" + boundary + "\r\n").getBytes());
                outputStream.write(("Content-Disposition: form-data; name=\"photo\"; filename=\"" + photo.getName() + "\"\r\n").getBytes());
                outputStream.write(("Content-Type: image/png\r\n\r\n").getBytes());
                Files.copy(photo.toPath(), outputStream);
                outputStream.write(("\r\n--" + boundary + "--\r\n").getBytes());
                outputStream.flush();
            }

            connection.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
