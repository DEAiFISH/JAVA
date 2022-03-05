package IO;

import java.io.*;
import java.util.Date;

public class ObjectInOutputStreamTest {
    public static void main(String[] args) {
        TestObjectOutputStream();
        TestObjectInputStream();
    }


    public static void TestObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("src/IO/oos.dat")));

            oos.writeObject(new Date().toString());
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    public static void TestObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("src/IO/oos.dat")));

            System.out.println((String) ois.readObject());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
