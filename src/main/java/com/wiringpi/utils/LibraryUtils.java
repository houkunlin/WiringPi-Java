package com.wiringpi.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * 引入系统库
 *
 * @author HouKunLin
 * @date 2020/2/12 0012 1:40
 */
public class LibraryUtils {
    private static final Logger logger = LoggerFactory.getLogger(LibraryUtils.class);

    public static void loadLibrary(String libName) {
        if (libName == null) {
            return;
        }
        try {
            loadLibrary0(libName);
        } catch (Throwable e1) {
            logger.error("从系统路径加载库(" + libName + ")失败，尝试从classpath中加载库", e1);
            try {
                File file = FileUtils.copyResourcesToTempDir(libName, new File("target/library-temp"));
                System.load(file.getAbsolutePath());
                logger.info("从classpath中加载库({})成功", libName);
            } catch (Throwable e2) {
                logger.info("从classpath中加载库({})失败", libName);
                throw new RuntimeException(e2);
            }
        }
    }

    private static void loadLibrary0(String libName) {
        // 不带 lib 前缀的库名
        String libName1;
        // 带 lib 前缀的库名
        String libName2;
        if (libName.startsWith("lib")) {
            libName1 = libName.substring(3);
            libName2 = libName;
        } else {
            libName1 = libName;
            libName2 = "lib" + libName;
        }
        try {
            System.loadLibrary(libName1);
            logger.info("从系统路径加载库({})成功", libName1);
        } catch (Throwable e1) {
            System.loadLibrary(libName2);
            logger.info("从系统路径加载库({})成功", libName2);
        }
    }
}
