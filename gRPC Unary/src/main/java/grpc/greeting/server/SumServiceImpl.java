package grpc.greeting.server;

import com.proto.sum.Sum;
import com.proto.sum.SumRequest;
import com.proto.sum.SumResponse;
import com.proto.sum.SumServiceGrpc;
import io.grpc.stub.StreamObserver;

public class SumServiceImpl extends SumServiceGrpc.SumServiceImplBase {
    @Override
    public void sum(SumRequest request, StreamObserver<SumResponse> responseObserver) {

        Sum sum = request.getSum();

        int first_number = sum.getFirstNumber();
        int second_number = sum.getSecondNumber();

        int result = first_number + second_number;

        SumResponse response = SumResponse.newBuilder()
                .setResult(result)
                .build();


        responseObserver.onNext(response);


        responseObserver.onCompleted();


        // super.sum(request, responseObserver);
    }
}
