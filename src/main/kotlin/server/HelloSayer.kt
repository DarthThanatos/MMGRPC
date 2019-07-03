package server

import io.grpc.stub.StreamObserver

interface HelloSayer{
    fun sayHello(req: HelloRequest, responseObserver: StreamObserver<HelloReply>)
    fun sayHelloAgain(req: HelloRequest, responseObserver: StreamObserver<HelloReply>)
}

class HelloSayerImpl: HelloSayer{

    override fun sayHello(req: HelloRequest, responseObserver: StreamObserver<HelloReply>) {
        val reply = HelloReply.newBuilder().setMessage("Hello ${req.name}").build()
        responseObserver.onNext(reply)
        responseObserver.onCompleted()
    }


    override fun sayHelloAgain(req: HelloRequest, responseObserver: StreamObserver<HelloReply>){
        val reply = HelloReply.newBuilder().setMessage("I hate you ${req.name}").build()
        responseObserver.onNext(reply)
        responseObserver.onCompleted()

    }

}