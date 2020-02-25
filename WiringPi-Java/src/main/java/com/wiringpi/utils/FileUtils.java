package com.wiringpi.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 文件处理工具类
 *
 * @author HouKunLin
 * @date 2020/2/12 0012 1:47
 */
public class FileUtils {
    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static File copyResourcesToTempDir(String filename) throws IOException {
        File tempFile = File.createTempFile("java_resources_", ".tmp");
        return copyResourcesToTempDir(filename, tempFile);
    }

    public static File copyResourcesToTempDir(String filename, File file) throws IOException {
        if (!file.isFile()) {
            InputStream inputStream = getResources(filename);
            String md5Hex = DigestUtils.md5Hex(inputStream);

            close(inputStream);

            file = new File(file, md5Hex + "-" + System.mapLibraryName(filename));
            logger.debug("把classpath的库复制到指定文件：{}", file.getAbsolutePath());
        }
        return copyResourcesToFile(filename, file);
    }

    public static File copyResourcesToFile(String filename, File file) throws IOException {
        InputStream inputStream = getResources(filename);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        IOUtils.copy(inputStream, fileOutputStream);
        close(inputStream, fileOutputStream);
        return file;
    }

    private static InputStream getResources(String filename) throws IOException {
        filename = System.mapLibraryName(filename);
        logger.debug("从classpath中加载文件：{}", filename);
        InputStream inputStream;
        inputStream = FileUtils.class.getResourceAsStream(filename);
        if (inputStream == null) {
            inputStream = FileUtils.class.getClassLoader().getResourceAsStream(filename);
        }
        if (inputStream == null) {
            throw new IOException("从classpath中加载文件失败：" + filename);
        }
        return inputStream;
    }

    public static void close(Closeable... closeables) {
        for (Closeable closeable : closeables) {
            try {
                if (closeable != null) {
                    closeable.close();
                }
            } catch (final IOException ioe) {
                // ignore
            }
        }
    }
}
