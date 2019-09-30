#!/bin/bash

curl http://localhost:8080/sendPubSub/type3

# there is 1 queue listening to 'type3' 
# 2019-09-30 22:41:56.364  INFO 79474 --- [ntContainer#9-1] c.e.config.RabbitPubSubListenersConfig   : PubSub:Recvd {msg=msga76ab763-e210-4b4a-a831-da29fbae2c79, type=ALL, routingKey=type3, consumerQueue=#}
