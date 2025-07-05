package grpc.greeting.client;

import com.proto.sum.Sum;
import com.proto.sum.SumRequest;
import com.proto.sum.SumResponse;
import com.proto.sum.SumServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class SumClient {
    public static void main(String[] args) {
        System.out.println("This is the gRPC SUM Client");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        System.out.println("Channel Created");

        System.out.println("Creating Stub...");

        SumServiceGrpc.SumServiceBlockingStub stub = SumServiceGrpc.newBlockingStub(channel);


        Sum sum = Sum.newBuilder()
                .setFirstNumber(10)
                .setSecondNumber(20)
                .build();

        SumRequest request = SumRequest.newBuilder()
                .setSum(sum)
                .build();
        SumResponse response = stub.sum(request);

        System.out.println(response.getResult());


        System.out.println("Shutting Down");
        channel.shutdown();


    }
}
