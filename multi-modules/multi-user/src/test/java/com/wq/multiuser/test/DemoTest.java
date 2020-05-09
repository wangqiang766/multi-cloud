package com.wq.multiuser.test;

import com.wq.multiuser.service.*;
import com.wq.multiuser.entity.Person;
import com.wq.multiuser.service.impl.LogUtilService;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class DemoTest {
    public static void main(String[] args) {
        Person person = Person.builder().firstName("wang").lastName("qiang").age(18).build();
        Person person2 = Person.builder().firstName("wang2").lastName("qiang2").age(19).build();
        Person person3 = Person.builder().firstName("wang3").lastName("qiang3").age(20).build();
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person2);
        personList.add(person3);
        //lambda
        personList.stream().filter(p -> p.getAge() > 18).forEach(p -> System.out.println(p));

    }

    @Test
    public void test() {
        LazyInnerClassSingleton lazyInnerClassSingleton = LazyInnerClassSingleton.getInstance();
        LazyInnerClassSingleton lazyInnerClassSingleton2 = LazyInnerClassSingleton.getInstance();
        System.out.println(lazyInnerClassSingleton);
        System.out.println(lazyInnerClassSingleton2);
        System.out.println(lazyInnerClassSingleton == lazyInnerClassSingleton2);
    }

    //反射破坏单例模式
    @Test
    public void testSingleton() throws Exception {
        LazyInnerClassSingleton lazyInnerClassSingleton = LazyInnerClassSingleton.getInstance();

        Class claszz = LazyInnerClassSingleton.class;
        Constructor c = claszz.getDeclaredConstructor();
        c.setAccessible(true);
        LazyInnerClassSingleton lazyInnerClassSingleton1 = (LazyInnerClassSingleton) c.newInstance();
        System.out.println(lazyInnerClassSingleton);
        System.out.println(lazyInnerClassSingleton1);
        System.out.println(lazyInnerClassSingleton == lazyInnerClassSingleton1);
    }

    //序列化破坏单例模式
    @Test
    public void testSingleton2() throws Exception {
        LazyInnerClassSingleton lazyInnerClassSingleton = LazyInnerClassSingleton.getInstance();
        FileOutputStream fileOutputStream= new FileOutputStream("LazyInnerClassSingleton.obj");
        ObjectOutputStream oos=new ObjectOutputStream(fileOutputStream);
        oos.writeObject(lazyInnerClassSingleton);
        oos.flush();
        oos.close();

        FileInputStream fileInputStream= new FileInputStream("LazyInnerClassSingleton.obj");
        ObjectInputStream ois=new ObjectInputStream(fileInputStream);
        LazyInnerClassSingleton lazyInnerClassSingleton1= (LazyInnerClassSingleton) ois.readObject();
        System.out.println(lazyInnerClassSingleton);
        System.out.println(lazyInnerClassSingleton1);
        System.out.println(lazyInnerClassSingleton==lazyInnerClassSingleton1);
    }
    @Test
    public void testEnum(){
        System.out.println(EnumSingleton.RED);
        System.out.println(EnumSingleton.RED.getName());
        System.out.println(EnumSingleton.RED.getIndex());
    }

    @Test
    public void testStaticProxy(){
        ProxyUtilService proxyUtilService=new ProxyUtilService(new LogUtilService());
        proxyUtilService.doString();
    }

    @Test
    public void testJdkProxy(){
        UtilService jdkProxyUtilService= (UtilService) new JdkProxyService().getInstance(new LogUtilService());
        jdkProxyUtilService.doString();
        byte[] bytes= ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{UtilService.class});
        try {
            FileOutputStream os=new FileOutputStream("E://$Proxy0.class");
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
