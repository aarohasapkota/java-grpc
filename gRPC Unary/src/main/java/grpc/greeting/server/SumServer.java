package grpc.greeting.server;

import com.proto.sum.SumServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class SumServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Starting SumServer");

        Server server = ServerBuilder.forPort(8080)
                .addService(new SumServiceImpl())
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("Received shutting down");
            server.shutdown();
            System.out.println("Shutting down");
        }));

        server.awaitTermination();
    }
}
