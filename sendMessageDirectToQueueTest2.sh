#!/bin/bash

curl http://localhost:8080/sendSimple/test2/messageForTest2

# 2019-09-30 22:48:32.214  INFO 79474 --- [ntContainer#1-1] c.e.config.RabbitDirectListenersConfig   : RECVD {msg=messageForTest2, routingKey=test2, consumerQueue=test2, corrId=null, contentType=text/plain, length=0}
