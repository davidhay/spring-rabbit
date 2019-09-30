#!/bin/bash

curl --header "Content-Type: application/json" \
  --request POST \
  --data @src/test/resources/json/valid/position-example-1.json \
  http://localhost:8080/sendJsonPOSMessage
