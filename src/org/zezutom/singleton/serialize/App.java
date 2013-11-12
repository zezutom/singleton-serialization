package org.zezutom.singleton.serialize;

import java.io.*;

public class App {
    public static final String PATH = "singleton.ser";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Bar bar = Bar.getInstance();
        System.out.println("CREATED:\t\t" + bar);

        bar.setX(2);
        System.out.println("MODIFIED:\t\t" + bar);

        serializeSingleton();
        System.out.println("SERIALIZED:\t\t" + bar);

        bar.setX(3);
        System.out.println("MODIFIED:\t\t" + bar);

        bar = deserializeSingleton();
        System.out.println("DESERIALIZED:\t" + bar);

        bar.setX(4);
        System.out.println("MODIFIED:\t\t" + bar);

        serializeSingleton();
        System.out.println("SERIALIZED:\t\t" + bar);

        bar.setX(5);
        System.out.println("MODIFIED:\t\t" + bar);

        bar = deserializeSingleton();
        System.out.println("DESERIALIZED:\t" + bar);

    }

    public static void serializeSingleton() throws IOException {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(PATH);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(Bar.getInstance());
        } finally {
            oos.close();
        }
    }

    public static Bar deserializeSingleton() throws IOException, ClassNotFoundException {
        Bar instance = null;
        ObjectInputStream ois = null;

        try {
            FileInputStream fis = new FileInputStream(PATH);
            ois = new ObjectInputStream(fis);
            instance = (Bar) ois.readObject();
        } finally {
            ois.close();
        }
        return instance;
    }
}
