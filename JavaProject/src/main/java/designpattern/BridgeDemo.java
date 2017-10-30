package designpattern;


/*
 * 桥接模式就是把事物和其具体实现分开，使他们可以各自独立的变化。桥接的用意是：将抽象化与实现化解耦，
 * 使得二者可以独立变化，像我们常用的JDBC桥DriverManager一样，JDBC进行连接数据库的时候，在
 * 各个数据库之间进行切换，基本不需要动太多的代码，甚至丝毫不用动，原因就是JDBC提供统一接口，每个数
 * 据库提供各自的实现，用一个叫做数据库驱动的程序来桥接就行了。我们来看看关系图：
 * 
 * 
 * */

interface BridgeSourceable{
	public void method();
}

class SourceSubone implements BridgeSourceable{

	@Override
	public void method() {
		System.out.println("this is the first sub");
	}
}
class SourceSubtwo implements BridgeSourceable{
	
	@Override
	public void method() {
		System.out.println("this is the second sub");
	}
}

abstract class Bridge{
	private BridgeSourceable source;
	
	public void method(){
		source.method();
	}
	public BridgeSourceable getSource(){
		return source;
	}
	public void setSource(BridgeSourceable source){
		this.source = source;
	}
}

class MyBridge extends Bridge{
	public void method(){
		getSource().method();
	}
}

public class BridgeDemo {

	public static void main(String[] args) {
		Bridge bridge = new MyBridge();  
        
        /*调用第一个对象*/  
        BridgeSourceable source1 = new SourceSubone();  
        bridge.setSource(source1);  
        bridge.method();  
          
        /*调用第二个对象*/  
        BridgeSourceable source2 = new SourceSubtwo();  
        bridge.setSource(source2);  
        bridge.method();  
	}

}


/*
 * 这样，就通过对Bridge类的调用，实现了对接口BridgeSourceable的实现类SourceSubone和SourceSubtwo的调用。
 * 
 * */
 