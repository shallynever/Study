package io.bean;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author 天启 zhouj@dtdream.com
 */
public class Student implements Externalizable {
    private String name;
    private int age;
    public Student(){}
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "name:"+this.name+";age:"+this.age;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(this.age);
        out.writeUTF(this.name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.age = in.readInt();
        this.name = in.readUTF();
    }
}

