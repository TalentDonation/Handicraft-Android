package kr.co.landvibe.handicraft.error;


public class InternalServerException extends RuntimeException {
    public InternalServerException() {
    }

    public InternalServerException(String msg) {
        super(msg);
    }

    public InternalServerException(String msg, Throwable t) {
        super(msg, t);
    }
}
