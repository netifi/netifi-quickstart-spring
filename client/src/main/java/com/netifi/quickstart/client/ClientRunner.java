package com.netifi.quickstart.client;

import com.netifi.quickstart.service.HelloRequest;
import com.netifi.quickstart.service.HelloServiceClient;
import com.netifi.spring.core.annotation.Group;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/** Calls the Hello Service */
@Component
public class ClientRunner implements CommandLineRunner {
  private static final Logger logger = LogManager.getLogger(ClientRunner.class);

  @Group("quickstart.services.helloservices")
  private HelloServiceClient client;

  @Override
  public void run(String... args) throws Exception {
    Flux.interval(Duration.ofSeconds(1)) // emit tick ever second
        .onBackpressureBuffer() // buffer ticks on back-pressure
        .concatMap(
            l -> {
              String name = "World-" + l;
              // Create Request to HelloService
              HelloRequest request = HelloRequest.newBuilder().setName(name).build();

              logger.info("Sending '{}' to HelloService...", name);
              return client
                  .sayHello(request)
                  .doOnNext(
                      response -> {
                        logger.info("Got response '{}'", response.getMessage());
                      });
            }) // allow one at a lime
        .doOnError(Throwable::printStackTrace)
        .blockLast();
  }
}
