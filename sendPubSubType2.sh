#!/bin/bash

curl http://localhost:8080/sendPubSub/type2

# there are 3 queues listening to 'type2'

# 2019-09-30 22:40:05.561  INFO 79474 --- [ntContainer#7-1] c.e.config.RabbitPubSubListenersConfig   : PubSub:Recvd {msg=msga5d14989-8e0f-479c-82b3-020ee8a7e7e0, type=type2, routingKey=type2, consumerQueue=type2queue1}
# 2019-09-30 22:40:05.561  INFO 79474 --- [ntContainer#8-1] c.e.config.RabbitPubSubListenersConfig   : PubSub:Recvd {msg=msga5d14989-8e0f-479c-82b3-020ee8a7e7e0, type=type2, routingKey=type2, consumerQueue=type2queue2}
# 2019-09-30 22:40:05.561  INFO 79474 --- [ntContainer#9-1] c.e.config.RabbitPubSubListenersConfig   : PubSub:Recvd {msg=msga5d14989-8e0f-479c-82b3-020ee8a7e7e0, type=ALL, routingKey=type2, consumerQueue=#}
