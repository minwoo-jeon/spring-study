package com.fastcampus.ch3.d2Pr;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class Car{}
class SportsCar extends Car{}
class Truck extends Car{ }

class Engine {}

class ApplicationContext {
    Map map; //객체저장소

    ApplicationContext() {
        map = new HashMap();

        try {
            Properties p = new Properties();
            p.load(new FileReader("config.txt"));

            map = new HashMap(p);

            for(Object key: map.keySet()){
                Class clazz = Class.forName((String) map.get(key));
                map.put(key,clazz.newInstance());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public Object getBean(String key){
        return map.get(key);
    }

}
public class Main1 {

    public static void main(String[] args) throws Exception {
        ApplicationContext ac = new ApplicationContext();
        Car car = (Car)ac.getBean("car");
        System.out.println("car = " + car);
    }
}