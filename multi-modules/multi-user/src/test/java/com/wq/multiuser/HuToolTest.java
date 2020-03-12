package com.wq.multiuser;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.ConverterRegistry;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class HuToolTest {
    public static void main(String[] args) {

    }

    //java 克隆
    @Test
    public void test() throws CloneNotSupportedException {
        Person p1 = Person.builder().firstName("wang").lastName("qiang").age(18).build();
        Student s1 = Student.builder().person(p1).schoolName("长沙大学").build();
        //浅克隆
        Student s2 = (Student) s1.clone();
        System.out.println(p1 == s2.getPerson());//true
        System.out.println(s1 == s2);//false
        //深克隆
        Student s3 = ObjectUtil.cloneByStream(s1);
        System.out.println(s1 == s3);
        System.out.println(p1 == s3.getPerson());

    }

    //java 类型转换
    @Test
    public void testConvert() {
        //字符串转换
        int a = 1;
        String aStr = Convert.toStr(a);
        System.out.println(aStr);
        // 转为制定类型数组
        String[] b = {"1", "2", "3", "4"};
        System.out.println(Arrays.toString(b));
        Integer[] intArray = Convert.toIntArray(b);
        System.out.println(Arrays.toString(intArray));
        //转为日期
        String dateStr = "2017-03-01 22:33:23";
        Date date = DateUtil.parse(dateStr);
        System.out.println(((DateTime) date).isAfter(new Date()));
        System.out.println(DateUtil.between(date, new Date(), DateUnit.DAY));
        System.out.println(DateUtil.offset(date, DateField.DAY_OF_MONTH, 2));

        //自定义转换
        Map map = new HashMap();
        map.put("firstName", "wang");
        map.put("lastName", "qiang");
        map.put("age", 18);
        List list = new ArrayList();
        list.add(map);
        String str = JSONObject.toJSONString(list);
        System.out.println(str);
        Person person = getStringToObject(JSON.toJSONString(map), Person.class);
        System.out.println(person);
        List<Person> personList = getStringToList(str, Person.class);
        System.out.println(personList);

    }

    @Test
    public void testIo() throws IOException {
        File file = new File("D:\\data\\logs\\overseas-media\\api\\test.txt");
        InputStream inputStream = null;
        Reader reader = null;
        //字节输入流
//        try {
//            inputStream = new FileInputStream(file);
//            int c;
//            byte[] bytes=new byte[10];
//            while ((c = inputStream.read(bytes)) != -1) {
//                System.out.println(Arrays.toString(bytes));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            inputStream.close();
//        }
        //字符输入流
        try {
            inputStream = new FileInputStream(file);
            reader = new InputStreamReader(inputStream, "UTF-8");
            int c;
            char[] chars = new char[10];
            while ((c = reader.read(chars)) != -1) {
                System.out.println((Arrays.toString(chars)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
        //缓存字符输入流
        Reader reader2 = null;
        BufferedReader bufferedReader = null;
        try {
            inputStream = new FileInputStream(file);
            reader2 = new InputStreamReader(inputStream, "UTF-8");
            bufferedReader = new BufferedReader(reader2);
            String line;
            while ((line=bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }

    }
    @Test
    public void testFile(){
        File file = new File("D:\\data\\logs\\overseas-media\\api\\test.txt");
        System.out.println(FileUtil.exist(file));
        FileUtil.appendString("我很好",file,"UTF-8");
        System.out.println(FileUtil.readUtf8String(file));
    }

    @Test
    public void testHttp(){
        String fileUrl="https://api-ott.kidsflix.com/getobjects?version=11&object_type=video&package_format=tcl_feed&cleanup_thumbnails=0&max=100&start=0";
        HttpUtil.downloadFile(fileUrl, FileUtil.file("f:/test.txt"), new StreamProgress() {
            @Override
            public void start() {
                System.out.println("开始下载...");
            }

            @Override
            public void progress(long l) {
                System.out.println("已下载:"+FileUtil.readableFileSize(l));
            }

            @Override
            public void finish() {
                System.out.println("下载完成");
            }
        });
    }

    @Test
    public void testHttp2(){

    }


    public <T> T getStringToObject(String jsonStr, Class<T> tClass) {
        return JSONObject.parseObject(jsonStr, tClass);
    }

    public <T> List<T> getStringToList(String jsonStr, Class<T> tClass) {
        return JSONArray.parseArray(jsonStr, tClass);
    }

}
