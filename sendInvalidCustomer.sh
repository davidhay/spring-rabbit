#!/bin/bash

curl http://localhost:8080/sendConstrained/5050/ABCDEF

# 2019-09-30 22:29:02.100  INFO 79474 --- [nio-8080-exec-3] c.e.config.RabbitPostProcessorConfig     : outbound post processing [{"age":5050,"nino":"ABCDEF"}]
# 2019-09-30 22:29:02.104  INFO 79474 --- [tContainer#10-1] c.e.c.RabbitConvertAndValidateConfig     : CONSTRAINT VIOLATION receiveCustomer.domain.nino: must match "[A-Z]{4}", receiveCustomer.domain.age: must be less than or equal to 150
