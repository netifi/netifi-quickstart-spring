package io.netifi.proteus.quickstart.service;

import io.netifi.proteus.quickstart.service.protobuf.HelloRequest;
import io.netifi.proteus.quickstart.service.protobuf.HelloResponse;
import io.netifi.proteus.quickstart.service.protobuf.HelloService;
import io.netty.buffer.ByteBuf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/** Service that returns a hello message. */
@Component
public class DefaultHelloService implements HelloService {
  private static final Logger logger = LogManager.getLogger(DefaultHelloService.class);

  @Override
  public Mono<HelloResponse> sayHello(HelloRequest message, ByteBuf metadata) {
    logger.info("received a message -> {}", message.getName());
    return Mono.just(
        HelloResponse.newBuilder()
            .setMessage("Hello, " + message.getName() + "! from " + METHOD_SAY_HELLO)
            .build());
  }
}
