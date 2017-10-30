package designpattern;


/*
 * �Ž�ģʽ���ǰ�����������ʵ�ַֿ���ʹ���ǿ��Ը��Զ����ı仯���Žӵ������ǣ���������ʵ�ֻ����
 * ʹ�ö��߿��Զ����仯�������ǳ��õ�JDBC��DriverManagerһ����JDBC�����������ݿ��ʱ����
 * �������ݿ�֮������л�����������Ҫ��̫��Ĵ��룬����˿�����ö���ԭ�����JDBC�ṩͳһ�ӿڣ�ÿ����
 * �ݿ��ṩ���Ե�ʵ�֣���һ���������ݿ������ĳ������ŽӾ����ˡ�������������ϵͼ��
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
        
        /*���õ�һ������*/  
        BridgeSourceable source1 = new SourceSubone();  
        bridge.setSource(source1);  
        bridge.method();  
          
        /*���õڶ�������*/  
        BridgeSourceable source2 = new SourceSubtwo();  
        bridge.setSource(source2);  
        bridge.method();  
	}

}


/*
 * ��������ͨ����Bridge��ĵ��ã�ʵ���˶Խӿ�BridgeSourceable��ʵ����SourceSubone��SourceSubtwo�ĵ��á�
 * 
 * */
 