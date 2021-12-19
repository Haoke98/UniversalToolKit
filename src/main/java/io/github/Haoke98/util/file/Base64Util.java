package io.github.Haoke98.util.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.Base64.Decoder;

/**
 * base64工具类
 *
 *
 */
public class Base64Util {

    private final static Logger logger = LoggerFactory.getLogger(Base64Util.class);

    public static MultipartFile base64ToMultipart(String base64) {
        try {
            String[] baseStr = base64.split(",");

            Decoder decoder= Base64.getMimeDecoder();//注不要使用.getDecoder();

            byte[] b = new byte[0];
            b = decoder.decode(baseStr[1]);

            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }

            return new BASE64DecodedMultipartFile(b, baseStr[0]);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}