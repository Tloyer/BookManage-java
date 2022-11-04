package book.utils;

import book.exception.BasicException;
import org.springframework.http.HttpStatus;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author fanhongtao
 * 2022/10/13 15:36
 */
public class UploadUtils {

    private static final String FILE_TYPE_IMG = "img";

    private static final String FILE_TYPE_VIDEO = "video";

    private static final String CLASS_PATH_PREFIX;

    static {
        try {
            CLASS_PATH_PREFIX = ResourceUtils.getURL("classpath:").getPath();
        } catch (FileNotFoundException e) {
            throw new BasicException(500, "文件上传失败！");
        }
    }


    /**
     * 图片上传，返回 classpath下的路径 如： /static/img/db1/organ/20211003_xxxx.jpg
     */
    public static String uploadPicture(MultipartFile file, String path) {
        return upload(file, FILE_TYPE_IMG, path);
    }

    /**
     * 视频上传，返回 classpath下的路径 如： /static/video/db1/xxx/20211003_xxxx.mp4
     */
    public static String uploadVideo(MultipartFile file, String path) {
        return upload(file, FILE_TYPE_VIDEO, path);
    }


    /**
     * 文件上传
     */
    private static String upload(MultipartFile file, String fileType, String path) {
        String fileName = file.getOriginalFilename();
        String pathPrefix, filePath;
        if (fileType.equals(FILE_TYPE_IMG)) {
            pathPrefix = "static/img";
        } else if (fileType.equals(FILE_TYPE_VIDEO)) {
            pathPrefix = "static/video";
        } else {
            pathPrefix = "static/other";
        }
        pathPrefix += path;
        try {
            File directory = new File(CLASS_PATH_PREFIX + pathPrefix);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            pathPrefix += CommonUtils.dateToStr() + "_";
            filePath = pathPrefix + fileName;
            File dest = new File(CLASS_PATH_PREFIX + filePath);
            if (dest.exists()) {
                filePath = pathPrefix + CommonUtils.timeToStr() + "_" + fileName;
                dest = new File(CLASS_PATH_PREFIX + filePath);
            }
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BasicException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "文件上传失败！");
        }
        return "/" + filePath;
    }

    /**
     * 文件删除，
     */
    public static void removeFile(String path) {
        try {
            String absPath = CLASS_PATH_PREFIX + path;
            File dest = new File(absPath);
            dest.delete();
        } catch (Exception e) {
            throw new BasicException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "文件删除失败！");
        }
    }
}
