package io.bean;

import java.io.Serializable;

/**
 * @author 天启 zhouj@dtdream.com
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1553024266274165230L;
    private transient String name;  // transient
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void sayHello(){
        System.out.println("Hello.");
    }

    public String toString(){
        return "name:"+this.name+",age:"+this.age;
    }
}
