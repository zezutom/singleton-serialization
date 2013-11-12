package org.zezutom.singleton.serialize;

import java.io.Serializable;

public class Bar extends Foo implements Serializable {

    private static Bar instance;

    private int x;

    private Bar() {
        System.out.println("Bar constructor");
    }
    private Bar(int x) {
        System.out.println("Bar constructor, x = " + x);
        this.x = x;
    }

    public void setX(int x) {
        this.x = x;
    }

    private Object readResolve() {
        System.out.println("read resolve");
        return getInstance();
    }

    public static Bar getInstance() {
        if (instance == null) {
            instance = new Bar(1);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "x=" + x +
                '}';
    }
}