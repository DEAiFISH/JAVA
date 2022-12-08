package IO;

import java.io.*;
import java.util.*;

/**
 * 文件加解密
 */
public class FileEncryption {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String FilePath = scanner.nextLine();

        long startTime = new Date().getTime();
        Encryption(FilePath);
//        Decrypt();
        long endTime = new Date().getTime();

        System.out.println("花费了：" + 1.0 * (endTime - startTime) / 1000 + "秒");
    }


    /**
     * 解密
     * @param FilePath
     */
    public static void Decrypt(String FilePath) {

        File file = new File(FilePath);
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;


        try {

            if (file.isDirectory()) {
                File[] allFile = file.listFiles();
                for (File f : allFile) {
                    Decrypt(f.getPath());
                }
            }

            String name = file.getName();
            if (file.exists() && name.startsWith("ENC")) {
                bis = new BufferedInputStream(new FileInputStream(file));

                bos = new BufferedOutputStream(new FileOutputStream(file.getParent() +
                        "/" + name.substring(3,name.length() - 3) + "mov"));

                byte[] buf = new byte[20];

                int len;

                while ((len = bis.read(buf)) != -1) {
                    for (int i = 0; i < len; i++) {
                        buf[i] = (byte) ((buf[i] - 3) ^ 5);
                    }

                    bos.write(buf, 0, len);
                }

                file.delete();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /**
     * 加密
     * @param FilePath
     */
    public static void Encryption(String FilePath) {

        File file = new File(FilePath);
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;


        try {

            if (file.isDirectory()) {
                File[] allFile = file.listFiles();
                for (File f : allFile) {
                    Encryption(f.getPath());
                }
            }

            String name = file.getName().toUpperCase(Locale.ROOT);
            if (file.exists() && name.endsWith(".MP4") || name.endsWith(".MOV")) {
                bis = new BufferedInputStream(new FileInputStream(file));

                bos = new BufferedOutputStream(new FileOutputStream(file.getParent() +
                        "/ENC" + name.substring(0,name.length() - 3)+ "txt"));

                byte[] buf = new byte[20];

                int len;

                while ((len = bis.read(buf)) != -1) {
                    for (int i = 0; i < len; i++) {
                        buf[i] = (byte) ((buf[i] ^ 5) + 3);
                    }

                    bos.write(buf, 0, len);
                }

                file.delete();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
