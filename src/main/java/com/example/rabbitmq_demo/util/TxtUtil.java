package com.example.rabbitmq_demo.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TxtUtil {
//    public static void main(String[] args) {
//        String m=readFile("C:\\Users\\chenming\\Desktop\\data.txt");
//        txtMapUtil(m);
//        System.out.println(m);
//    }

    public static String readFile(String path){
        BufferedReader reader=null;
        FileInputStream fileInputStream=null;
        InputStreamReader inputStreamReader=null;
        String str="";

        try {
            fileInputStream=new FileInputStream(path);
            inputStreamReader=new InputStreamReader(fileInputStream,"UTF-8");
            reader=new BufferedReader(inputStreamReader);
            String string=null;
            while ((string=reader.readLine())!=null ){
                str+=string;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
                try {
                    if (reader!=null){
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
        return str;
    }

    public static Map<Object,Object> txtMapUtil(String str){
        Map<Object ,Object> map=new HashMap<>();
        String[] s=str.split("=|,");
        for (int i = 0; i < s.length; i++) {
            map.put(s[i],s[i+1]);
            i+=1;
        }
        System.out.println(map);
        return map;
    }


}
