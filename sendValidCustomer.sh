#!/bin/bash

curl http://localhost:8080/sendConstrained/50/ABCD

# 2019-09-30 22:29:34.482  INFO 79474 --- [nio-8080-exec-5] c.e.config.RabbitPostProcessorConfig     : outbound post processing [{"age":50,"nino":"ABCD"}]
# 2019-09-30 22:29:34.484  INFO 79474 --- [tContainer#10-1] c.e.c.RabbitValidatingListenersConfig    : RECVD [Constrained [age=50, nino=ABCD]] from[uService007]
