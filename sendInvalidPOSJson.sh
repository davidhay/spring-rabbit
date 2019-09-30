#!/bin/bash

curl --header "Content-Type: application/json" \
  --request POST \
  --data @src/test/resources/json/invalid/position-example-1-invalid.json \
  http://localhost:8080/sendJsonPOSMessage

# Caused by: com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.ealanta.generated.cli.PositionSchema$ChangeDeleteIndicator`, problem: DOH
# at [Source: (String)"{	"positionID": 123456789123456,	"changeDeleteIndicator": "DOH",	"positionNumber": 1234567890,	"positionTitle": "test",	"occupationCode": "ACODE",	"areaOfWork": "Around",	"secondSpeciality": "Spec",	"deaneryNumber": "NTH/RTFED/040/STR/210",	"managingOffice": "Northern",	"odsCode": "CodingCode",	"gradeTrust": "NTH",	"gradePayscale": "High",	"gradeDesc": "Senior",	"workplaceOrg": "WTO"}"; line: 1, column: 59] (through reference chain: com.ealanta.generated.cli.PositionSchema["changeDeleteIndicator"])
  