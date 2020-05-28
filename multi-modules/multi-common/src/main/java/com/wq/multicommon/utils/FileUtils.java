package com.wq.multicommon.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.UUID;

/**
 * @author HX0013522
 * @date 2019-06-12 11:38:38
 */
public class FileUtils {

    private final static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static byte[] fileToBytes(String filePath) {
        byte[] buffer = null;
        File file = new File(filePath);
        FileInputStream fis = null;
        ByteArrayOutputStream bos = null;
        try {
            fis = new FileInputStream(file);
            bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            buffer = bos.toByteArray();
        } catch (IOException ex) {
            logger.error("", ex);

        } finally {
            try {
                if (null != bos) {
                    bos.close();
                }
            } catch (IOException ex) {
                logger.error("", ex);

            } finally {
                try {
                    if (null != fis) {
                        fis.close();
                    }
                } catch (IOException ex) {
                    logger.error("", ex);

                }
            }
        }

        return buffer;
    }

    public static File bytesToFile(byte[] buffer, final String filePath) {
        File file = new File(filePath);
        OutputStream output = null;
        BufferedOutputStream bufferedOutput = null;
        try {
            output = new FileOutputStream(file);
            bufferedOutput = new BufferedOutputStream(output);
            bufferedOutput.write(buffer);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (null != bufferedOutput) {
                try {
                    bufferedOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != output) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String generateOssFileName() {
        return UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }

}
