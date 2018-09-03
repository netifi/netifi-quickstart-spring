package io.netifi.proteus.quickstart.service.protobuf;

@javax.annotation.Generated(
    value = "by Proteus proto compiler (version 0.8.9)",
    comments = "Source: io/netifi/proteus/quickstart/service/protobuf/service.proto")
@io.netifi.proteus.annotations.internal.ProteusGenerated(
    type = io.netifi.proteus.annotations.internal.ProteusResourceType.CLIENT,
    idlClass = BlockingHelloService.class)
public final class BlockingHelloServiceClient implements BlockingHelloService {
  private final io.netifi.proteus.quickstart.service.protobuf.HelloServiceClient delegate;

  public BlockingHelloServiceClient(io.rsocket.RSocket rSocket) {
    this.delegate = new io.netifi.proteus.quickstart.service.protobuf.HelloServiceClient(rSocket);
  }

  public BlockingHelloServiceClient(io.rsocket.RSocket rSocket, io.micrometer.core.instrument.MeterRegistry registry) {
    this.delegate = new io.netifi.proteus.quickstart.service.protobuf.HelloServiceClient(rSocket, registry);
  }

  @io.netifi.proteus.annotations.internal.ProteusGeneratedMethod(returnTypeClass = io.netifi.proteus.quickstart.service.protobuf.HelloResponse.class)
  public io.netifi.proteus.quickstart.service.protobuf.HelloResponse sayHello(io.netifi.proteus.quickstart.service.protobuf.HelloRequest message) {
    return sayHello(message, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }

  @java.lang.Override
  @io.netifi.proteus.annotations.internal.ProteusGeneratedMethod(returnTypeClass = io.netifi.proteus.quickstart.service.protobuf.HelloResponse.class)
  public io.netifi.proteus.quickstart.service.protobuf.HelloResponse sayHello(io.netifi.proteus.quickstart.service.protobuf.HelloRequest message, io.netty.buffer.ByteBuf metadata) {
    return delegate.sayHello(message, metadata).block();
  }

}

