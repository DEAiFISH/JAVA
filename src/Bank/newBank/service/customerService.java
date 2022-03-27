package Bank.newBank.service;

import java.io.File;

public class customerService {
    public static File desCustomer(File file, int id) {
        File[] files = file.listFiles();
        int len = files.length;
        int index = 0;
        while (index < len) {
            if (files[index].getName().startsWith("" + id + "#")) {
                return files[index];
            }
            index++;
        }
        return null;
    }
}
