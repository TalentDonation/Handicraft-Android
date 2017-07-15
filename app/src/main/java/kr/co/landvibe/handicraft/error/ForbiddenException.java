package kr.co.landvibe.handicraft.error;


public class ForbiddenException extends RuntimeException {
    public ForbiddenException(){}

    public ForbiddenException(String msg){
        super(msg);
    }
}
