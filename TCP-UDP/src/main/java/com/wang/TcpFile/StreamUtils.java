package com.wang.TcpFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/21 10:53
 */
public class StreamUtils {
    
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len=is.read(bytes))!=-1){
            bos.write(bytes, 0, len);
        }
        byte[] array = bos.toByteArray();
        bos.close();
        return array;
    }
}

