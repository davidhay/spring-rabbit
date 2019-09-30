#!/bin/bash

curl --header "Content-Type: application/json" \
  --request POST \
  --data @src/test/resources/json/invalid/positon-example-1-invalid.json \
  http://localhost:8080/sendJsonPOSMessage
