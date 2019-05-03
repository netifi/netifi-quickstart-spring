# netifi-spring-quickstart
Source code for the [Netifi Spring Boot QuickStart](https://www.netifi.com/getstarted-springboot).

This project provides a scaffolding for getting up and running quickly with [Netifi](http://www.netifi.com/) on [Spring Boot](https://spring.io/projects/spring-boot).

The project comes with a simple client and service. The client sends the word `World` to the service and the service responds with the message `Hello, World! from {service name}`.

## Projects
This repo contains the following projects:

* [client](client) - Client that sends data to the service
* [service](service) - Service that responds to the client
* [service-idl](service-idl) - Definition of the API served by the service

## Prerequisites
The Netifi Spring QuickStart requires you have the following items installed on your machine:

* [Docker](https://docs.docker.com/install/)

## Getting Started
Follow the steps below to get a client and service communicating via the Netifi Broker in just a few short minutes.

1. In a new terminal window, pull the latest Netifi Broker Docker image by running the following command:

        docker pull netifi/broker:1.6.2
        
2. Next, run the following command to start the Netifi Broker:

        docker run \
        -p 7001:7001 \
        -p 8001:8001 \
        -p 8101:8101 \
        -p 9000:9000 \
        -e BROKER_SERVER_OPTS=" \
        '-Dnetifi.broker.console.enabled=true' \
        '-Dnetifi.authentication.0.accessKey=9007199254740991'  \
        '-Dnetifi.authentication.0.accessToken=kTBDVtfRBO4tHOnZzSyY5ym2kfY=' \
        '-Dnetifi.broker.admin.accessKey=9007199254740991' \
        '-Dnetifi.broker.admin.accessToken=kTBDVtfRBO4tHOnZzSyY5ym2kfY='" \
        netifi/broker:1.6.2

3. In a new terminal window, start the example quickstart service by running the following command:

        ./gradlew :service:bootRun
        
4. Next, in a new terminal window, start the example quickstart client by running the following command:

        ./gradlew :client:bootRun
        
5. If successful, the client will have sent the word, `World`, to the service and received the response `Hello, World! from SayHello`. You can verify this by checking the terminals for the following:

    In the service terminal you will see the following message:
    
        2018-09-03 14:16:39.561  INFO 46994 --- [actor-tcp-nio-6] i.n.p.q.service.DefaultHelloService      : received a message -> World

    In the client terminal you will see the following message:
    
        2018-09-03 14:16:39.571  INFO 46998 --- [           main] i.n.p.quickstart.client.ClientRunner     : message: "Hello, World! from SayHello"

Congratulations! You were able to get a Netifi Broker up and running and send a message between a client and a microservice.

## Bugs and Feedback
For bugs, questions, and discussions please use the [Github Issues](https://github.com/netifi/netifi-quickstart-spring/issues).

## License
Copyright 2018 [Netifi Inc.](https://www.netifi.com)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
