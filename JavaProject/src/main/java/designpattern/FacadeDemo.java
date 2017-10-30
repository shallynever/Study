package designpattern;

/*
 * ���ģʽ��Ϊ�˽��������֮���������ϵ�ģ���springһ�������Խ������֮��Ĺ�ϵ���õ������ļ��У�
 * �����ģʽ���ǽ����ǵĹ�ϵ����һ��Facade���У�����������֮�����϶ȣ���ģʽ��û���漰���ӿڣ�
 * ������ͼ����������һ�����������������Ϊ��,�����ǵĲ�����Compuetr������Ǹ�Facade�ࣩ��
 * ���û�����Computer�࣬���������CPU��Memory��Disk��ʱ����Ҫ�����ǵĹ�ϵ����ڸ��Ե����У�
 * ����������е�һ����������⣬������Ҳ������������
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
 * �������û��Computer�࣬��ô��CPU��Memory��Disk����֮�佫���໥����ʵ����������ϵ��������������ص�������
 * �޸�һ���࣬���ܻ������������޸ģ��ⲻ��������Ҫ�����ģ�����Computer�࣬����֮��Ĺ�ϵ��������Computer��
 * ����������˽�������ã��⣬�������ģʽ��
 * */
 