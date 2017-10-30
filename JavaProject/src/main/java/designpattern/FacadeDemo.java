package designpattern;

/*
 * 外观模式是为了解决类与类之间的依赖关系的，像spring一样，可以将类和类之间的关系配置到配置文件中，
 * 而外观模式就是将他们的关系放在一个Facade类中，降低了类类之间的耦合度，该模式中没有涉及到接口，
 * 看下类图：（我们以一个计算机的启动过程为例,在我们的测试中Compuetr类就是那个Facade类），
 * 如果没有这个Computer类，我们在设计CPU、Memory、Disk类时就需要把他们的关系设计在各自的类中，
 * 这样如果其中的一个类出现问题，其他类也不能正常工作
 * 
 * */

class CPU{
	public void startup(){
		System.out.println("CPU startup!");
	}
	public void shutdown(){
		System.out.println("CPU shutdown!");
	}
}

class Memory{
	public void startup(){
		System.out.println("Memory startup!");
	}
	public void shutdown(){
		System.out.println("Memory shutdown!");
	}
}

class Disk{
	public void startup(){
		System.out.println("Disk startup!");
	}
	public void shutdown(){
		System.out.println("Disk shutdown!");
	}
}

class Computer {  
    private CPU cpu;  
    private Memory memory;  
    private Disk disk;  
      
    public Computer(){  
        cpu = new CPU();  
        memory = new Memory();  
        disk = new Disk();  
    }  
      
    public void startup(){  
        System.out.println("start the computer!");  
        cpu.startup();  
        memory.startup();  
        disk.startup();  
        System.out.println("start computer finished!");  
    }  
      
    public void shutdown(){  
        System.out.println("begin to close the computer!");  
        cpu.shutdown();  
        memory.shutdown();  
        disk.shutdown();  
        System.out.println("computer closed!");  
    }  
}  
public class FacadeDemo {

	public static void main(String[] args) {
		Computer com = new Computer();
		com.startup();
		com.shutdown();
	}

}



/*
 * 如果我们没有Computer类，那么，CPU、Memory、Disk他们之间将会相互持有实例，产生关系，这样会造成严重的依赖，
 * 修改一个类，可能会带来其他类的修改，这不是我们想要看到的，有了Computer类，他们之间的关系被放在了Computer类
 * 里，这样就起到了解耦的作用，这，就是外观模式！
 * */
 