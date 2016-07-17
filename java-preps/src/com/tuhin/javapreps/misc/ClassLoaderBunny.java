package com.tuhin.javapreps.misc;

import java.io.*;

/**
 * Created by tuhinmandal on 16/07/16.
 */
public class ClassLoaderBunny implements Cloneable, Serializable {

    private static final long serialVersionUID = 111232323232L;

    public volatile int count = 100;
    public transient int year = 2016;
    public String name = "tuhin";
    private String email = "mail@me.com";

    public ClassLoaderBunny() {
        System.out.println("ClassLoaderBunny cloneing...in constructor");
    }

    public void doSomething(String param) {
        System.out.println("this call will be loaded via classloader : " + param);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        return super.clone();
    }

    public static void serializer(ClassLoaderBunny bunny) throws FileNotFoundException, IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("myserialized.so"));
        out.writeObject(bunny);
        out.flush();
        out.close();
    }


    public  static void deSerializer() throws FileNotFoundException, IOException, ClassNotFoundException {
        ClassLoaderBunny bunny1, bunny2, bunny3;
        FileInputStream fileInputStream = new FileInputStream("myserialized.so");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        bunny1 = (ClassLoaderBunny) objectInputStream.readObject();
        bunny2 = (ClassLoaderBunny) objectInputStream.readObject();

        // check are they equal
        System.out.println(bunny1.equals(bunny2));


    }

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        ClassLoaderBunny bunny = new ClassLoaderBunny();
        ClassLoaderBunny.serializer(bunny);
        ClassLoaderBunny.deSerializer();
    }


}
