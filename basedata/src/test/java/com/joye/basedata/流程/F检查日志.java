package com.joye.basedata.流程;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by joye on 2017/8/30.
 */

public class F检查日志 {

    public static final  Type logType=new TypeToken<LogEntity>(){}.getType();
    public static final Gson gson=new GsonBuilder().create();
    @Test
    public void testCheckLog() throws Exception {
        LogEntity entity;
        List<LogEntity> entitys=new ArrayList<>();
        StringBuffer sb= null;
        String filePath="/Users/joye/Documents/herhandset.com.user.log";
        File file =new File(filePath);
        if(file.exists()){
            sb=new StringBuffer();
            FileReader fileReader=null;
            BufferedReader bufferedReader=null;
            String temp=null;
            try {

                fileReader=new FileReader(file);
                bufferedReader=new BufferedReader(fileReader);
                while((temp=bufferedReader.readLine())!=null){
                    temp=temp.replace("escape=json","").replace("@timestamp","timestamp").replace("@fields","fields");
                     entity = gson.fromJson(temp, logType);
                    entitys.add(entity);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                bufferedReader.close();
                fileReader.close();
            }
            Set<String> http_user_agents= new HashSet();
            for (LogEntity entity1:entitys){
                http_user_agents.add(entity1.getFields().getHttp_user_agent());
                if(entity1.getFields().getHttp_user_agent().equals("Mozilla/5.0 (Windows NT 6.1; rv,2.0.1) Gecko/20100101 Firefox/4.0.1")){
                    System.out.println(entity1.getFields());
                }
            }
            Iterator<String> itar = http_user_agents.iterator();
            while(itar.hasNext()){
                System.out.println(itar.next());
            }
        }


    }
}
