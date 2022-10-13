package book.utils;

import org.springframework.util.ResourceUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author fanhongtao
 * 2022/10/13 15:34
 * 生成 一些字符串
 */
public class CommonUtils {

    /**
     * 生成32位 UUID
     *
     * @return
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 去掉UUID中的 -
     *
     * @return
     */
    public static String simpleUUID() {
        return randomUUID().replace("-", "");
    }

    /**
     * 得到字符串形式的日期
     *
     * 20220919
     *
     * @throws IOException
     */
    public static String dateToStr() {
        return DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDate.now());
    }

    /**
     * 当日内(00:00 - 23:59)，时间戳 单位 秒
     * @return
     */
    public static String timeToStr() {
        return String.valueOf(LocalDateTime.now().toLocalTime().toSecondOfDay());
    }

    /**
     * 重命名文件，加上前缀 日期_
     * 参数path是文件夹路径，如：classpath:static/img/db1/organ/
     *
     * @param path
     * @throws IOException
     */
    public static void renameFiles(String path) throws IOException {
        File file = ResourceUtils.getFile(path);
        // 路径存在
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                // 日期前缀
                String prefix = dateToStr();
                for (File childFile : files) {
                    // 原始文件名
                    String originName = childFile.getName();
                    // 新名字
                    String newName = prefix + "_" + originName;
                    // 父路径
                    String parentPath = childFile.getParent();
                    // 重命名
                    childFile.renameTo(new File(parentPath + "\\" + newName));
                }
            }
        }
    }
}
