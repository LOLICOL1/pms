package me.lolico.pms.exception;

/**
 * @author lolico
 */
public class BussException extends CustomException {
    public BussException(String message) {
        super(message);
    }

    public BussException(String message, Integer code) {
        super(message, code);
    }

    public BussException(String message, Throwable e) {
        super(message, e);
    }
}
