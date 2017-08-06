package kr.co.landvibe.handicraft.error;


public class UnAuthorizationException extends RuntimeException {

    public UnAuthorizationException() {
        super();
    }

    public UnAuthorizationException(String msg) {
        super(msg);
    }

    public UnAuthorizationException(String msg, Throwable t) {
        super(msg, t);
    }
}
