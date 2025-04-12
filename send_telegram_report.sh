#!/bin/bash

# Bot token and chat ID (copied manually from telegram.json)
BOT_TOKEN="7180756173:AAHED6gExH-f5MpYP8R1mbbxRDw8_ZTR6n8"
CHAT_ID="639177218"

# Message content
MESSAGE="✅ LinkedIn UI tests are finished. Check the Allure report."

# Send message to Telegram
curl -s -X POST "https://api.telegram.org/bot7180756173:AAHED6gExH-f5MpYP8R1mbbxRDw8_ZTR6n8/sendMessage" \
     -d chat_id="$CHAT_ID" \
     -d text="$MESSAGE"

echo "✅ Telegram notification sent."
