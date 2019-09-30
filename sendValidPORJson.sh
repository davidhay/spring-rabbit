#!/bin/bash

curl --header "Content-Type: application/json" \
  --request POST \
  --data @src/test/resources/json/valid/por-example-1.json \
  http://localhost:8080/sendJsonPORMessage

# 2019-09-30 22:30:28.786  INFO 79474 --- [nio-8080-exec-7] c.e.config.RabbitPostProcessorConfig     : outbound post processing [{	"positionID": 123456789123456,	"changeDeleteIndicator": "D",	"positionNumber": 1234567890,	"positionTitle": "test",	"deaneryNumber": "NTH/RTFED/040/STR/210",	"managingOffice": "Northern",	"odsCode": "CodingCode",	"hostLeadIndicator": "Host Employer",	"employingOrgVPDCode": 234,	"esrOrganisation": "Happy Org",	"esrLocation": "there"}]
# 2019-09-30 22:30:28.789  INFO 79474 --- [ntContainer#2-1] c.e.config.RabbitEsrListenersConfig      : VALID POR RECVD [com.ealanta.generated.cli.PORSchema@37aabc31[positionID=123456789123456,changeDeleteIndicator=D,positionNumber=1234567890,positionTitle=test,deaneryNumber=NTH/RTFED/040/STR/210,managingOffice=Northern,odsCode=CodingCode,hostLeadIndicator=Host Employer,employingOrgVPDCode=234,esrOrganisation=Happy Org,esrLocation=there]] from[uService007]
  