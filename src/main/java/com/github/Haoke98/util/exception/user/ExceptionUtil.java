package com.github.Haoke98.util.exception.user;

/**
 * 工具类异常
 *

 */
public class ExceptionUtil extends RuntimeException{
    private static final long serialVersionUID = 7012545941794630876L;

    public ExceptionUtil(Throwable e)
    {
        super(e.getMessage(), e);
    }

    public ExceptionUtil(String message)
    {
        super(message);
    }

    public ExceptionUtil(String message, Throwable throwable)
    {
        super(message, throwable);
    }

}
