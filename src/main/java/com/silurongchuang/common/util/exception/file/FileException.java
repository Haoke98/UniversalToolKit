package com.silurongchuang.common.util.exception.file;


import com.silurongchuang.common.util.exception.BaseException;

/**
 * 文件信息类异常
 *
 *
 */
public class FileException extends BaseException {

    private static final long serialVersionUID = -7697754945745136785L;

    public FileException(String code, Object[] args)
    {
        super("static/uploadFile", code, args, null);
    }

    public FileException(String module, String code, Object[] args, String defaultMessage) {
        super(module, code, args, defaultMessage);
    }
}
