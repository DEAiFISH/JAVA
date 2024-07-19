package IO.断点续传;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description 断点续传文件
 *
 * @author DEAiFISH
 * @date 2024/7/19 17:08
 */
public class Test {

    /**
     * @description 分割文件
     *
     * @author DEAiFISH
     * @date 2024/7/19 17:37
     * @param file
     * @param blockSize
     * @return java.util.List<java.io.File>
     */
    private List<File> splitFile(File file, int blockSize) throws IOException {
        List<File> fileList = new ArrayList<>();
        int blockCount = (int) (file.length() / blockSize) + 1;

        // 按照指定大小分割文件
        for (int i = 0; i < blockCount; i++) {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            raf.seek((long) i * blockSize);
            File tempFile = File.createTempFile("upload_", "_part_" + i);
            tempFile.deleteOnExit();
            FileOutputStream fos = new FileOutputStream(tempFile);
            byte[] buffer = new byte[blockSize];
            int len;
            while ((len = raf.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            raf.close();
            fileList.add(tempFile);
        }

        return fileList;
    }

    /**
     * @description 合并文件
     *
     * @author DEAiFISH
     * @date 2024/7/19 17:36
     * @param fileList
     * @param targetFile
     * @return void
     */
    public static void mergeFile(List<File> fileList, File targetFile) throws IOException {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(targetFile));
            for (File file : fileList) {
                bis = new BufferedInputStream(new FileInputStream(file));
                byte[] buffer = new byte[1024];
                int len;
                while ((len = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, len);
                }
            }
        } finally {
            if (bis != null) {
                bis.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
    }
}
