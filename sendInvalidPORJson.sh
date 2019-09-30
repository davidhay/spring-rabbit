#!/bin/bash

curl --header "Content-Type: application/json" \
  --request POST \
  --data @src/test/resources/json/invalid/por-example-1-invalid.json \
  http://localhost:8080/sendJsonPORMessage


# Caused by: com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.ealanta.generated.cli.PORSchema$ChangeDeleteIndicator`, problem: DOH
# at [Source: (String)"{	"positionID": 123456789123456,	"changeDeleteIndicator": "DOH",	"positionNumber": 1234567890,	"positionTitle": "test",	"deaneryNumber": "NTH/RTFED/040/STR/210",	"managingOffice": "Northern",	"odsCode": "CodingCode",	"hostLeadIndicator": "Host Employer",	"employingOrgVPDCode": 234,	"esrOrganisation": "Happy Org",	"esrLocation": "there"}"; line: 1, column: 59] (through reference chain: com.ealanta.generated.cli.PORSchema["changeDeleteIndicator"])
  