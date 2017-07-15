package kr.co.landvibe.handicraft.error;


public class InternalServerException extends RuntimeException {
    public InternalServerException(){

    }

    public InternalServerException(String msg){
        super(msg);
    }
}
