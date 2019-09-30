#!/bin/bash

curl http://localhost:8080/sendPubSub/type1

# there are 4 queues listening to 'type1' 

# 2019-09-30 22:36:54.846  INFO 79474 --- [ntContainer#4-1] c.e.config.RabbitPubSubListenersConfig   : PubSub:Recvd {msg=msg61c6c28c-53a6-4ca6-8b54-14ff1a7c3674, type=type1, routingKey=type1, consumerQueue=type1queue1}
# 2019-09-30 22:36:54.846  INFO 79474 --- [ntContainer#5-1] c.e.config.RabbitPubSubListenersConfig   : PubSub:Recvd {msg=msg61c6c28c-53a6-4ca6-8b54-14ff1a7c3674, type=type1, routingKey=type1, consumerQueue=type1queue2}
# 2019-09-30 22:36:54.846  INFO 79474 --- [ntContainer#6-1] c.e.config.RabbitPubSubListenersConfig   : PubSub:Recvd {msg=msg61c6c28c-53a6-4ca6-8b54-14ff1a7c3674, type=type1, routingKey=type1, consumerQueue=type1queue3}
# 2019-09-30 22:36:54.846  INFO 79474 --- [ntContainer#9-1] c.e.config.RabbitPubSubListenersConfig   : PubSub:Recvd {msg=msg61c6c28c-53a6-4ca6-8b54-14ff1a7c3674, type=ALL, routingKey=type1, consumerQueue=#}
