package io.netifi.proteus.quickstart.service.protobuf;

/**
 */
@javax.annotation.Generated(
    value = "by Proteus proto compiler (version 0.7.15)",
    comments = "Source: io/netifi/proteus/quickstart/service/protobuf/service.proto")
public interface HelloService {
  String SERVICE = "io.netifi.proteus.quickstart.service.HelloService";
  String METHOD_SAY_HELLO = "SayHello";

  /**
   * <pre>
   * Returns a Hello World Message
   * </pre>
   */
  reactor.core.publisher.Mono<io.netifi.proteus.quickstart.service.protobuf.HelloResponse> sayHello(io.netifi.proteus.quickstart.service.protobuf.HelloRequest message, io.netty.buffer.ByteBuf metadata);
}
