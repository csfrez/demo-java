package com.csfrez.demo.singleton;

import java.io.*;

/**
 * @author yangzhi
 * @date 2022/5/11
 * @email yangzhi@ddjf.com.cn
 */
public class SimpleSingleton2 implements Serializable {

    private SimpleSingleton2() {
        if (Inner.INSTANCE != null) {
            throw new RuntimeException("不能支持重复实例化");
        }
    }

    public static SimpleSingleton2 getInstance() {
        return Inner.INSTANCE;
    }

    private static class Inner {
        private static final SimpleSingleton2 INSTANCE = new SimpleSingleton2();
    }

    private static void writeFile() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            SimpleSingleton2 simpleSingleton5 = SimpleSingleton2.getInstance();
            fos = new FileOutputStream(new File("test.txt"));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(simpleSingleton5);
            System.out.println(simpleSingleton5.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private static void readFile() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File("test.txt"));
            ois = new ObjectInputStream(fis);
            SimpleSingleton2 myObject = (SimpleSingleton2) ois.readObject();

            System.out.println(myObject.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Object readResolve() throws ObjectStreamException {
        return Inner.INSTANCE;
    }

    public static void main(String[] args) {
        writeFile();
        readFile();
    }
}
