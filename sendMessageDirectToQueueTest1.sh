#!/bin/bash

curl http://localhost:8080/sendSimple/test1/messageForTest1

# 2019-09-30 22:47:05.386  INFO 79474 --- [ntContainer#1-1] c.e.config.RabbitDirectListenersConfig   : RECVD {msg=messageForTest1, routingKey=test1, consumerQueue=test1, corrId=abcd4937f348-b7a3-48fd-a99e-838c07df145b, contentType=text/plain, length=0}
