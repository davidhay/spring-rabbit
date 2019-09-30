#!/bin/bash

curl --header "Content-Type: application/json" \
  --request POST \
  --data @src/test/resources/json/valid/position-example-1.json \
  http://localhost:8080/sendJsonPOSMessage

# 2019-09-30 22:31:09.192  INFO 79474 --- [nio-8080-exec-8] c.e.config.RabbitPostProcessorConfig     : outbound post processing [{	"positionID": 123456789123456,	"changeDeleteIndicator": "D",	"positionNumber": 1234567890,	"positionTitle": "test",	"occupationCode": "ACODE",	"areaOfWork": "Around",	"secondSpeciality": "Spec",	"deaneryNumber": "NTH/RTFED/040/STR/210",	"managingOffice": "Northern",	"odsCode": "CodingCode",	"gradeTrust": "NTH",	"gradePayscale": "High",	"gradeDesc": "Senior",	"workplaceOrg": "WTO"}]
# 2019-09-30 22:31:09.195  INFO 79474 --- [ntContainer#3-1] c.e.config.RabbitEsrListenersConfig      : VALID POS RECVD [com.ealanta.generated.cli.PositionSchema@38aaa21[positionID=123456789123456,changeDeleteIndicator=D,positionNumber=1234567890,positionTitle=test,occupationCode=ACODE,areaOfWork=Around,secondSpeciality=Spec,deaneryNumber=NTH/RTFED/040/STR/210,managingOffice=Northern,odsCode=CodingCode,gradeTrust=NTH,gradePayscale=High,gradeDesc=Senior,workplaceOrg=WTO]] from[uService007]
  