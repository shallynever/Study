package designpattern;

/*
 * ��������Singleton����һ�ֳ��õ����ģʽ����JavaӦ���У����������ܱ�֤��һ��JVM�У��ö���ֻ��һ��ʵ�����ڡ�
 * ������ģʽ�м����ô���
	1��ĳЩ�ഴ���Ƚ�Ƶ��������һЩ���͵Ķ�������һ�ʺܴ��ϵͳ������	
	2��ʡȥ��new��������������ϵͳ�ڴ��ʹ��Ƶ�ʣ�����GCѹ����	
	3����Щ���罻�����ĺ��Ľ������棬�����Ž������̣����������Դ�������Ļ���ϵͳ��ȫ���ˡ�
	     ������һ�����ӳ����˶��˾��Աͬʱָ�ӣ��϶����ҳ�һ�ţ�������ֻ��ʹ�õ���ģʽ�����ܱ�
	       ֤���Ľ��׷��������������������̡�
*/
public class Singleton {
	public static void main(String[] args) {
	
	}
}

class SingletonOne{	
	/* ����˽�о�̬ʵ������ֹ�����ã��˴���ֵΪnull��Ŀ����ʵ���ӳټ��� */ 
	private static SingletonOne instance = null;	
	/* ˽�й��췽������ֹ��ʵ���� */
	private SingletonOne(){
		
	}	
	/* ����public��̬���̷�������ȡʵ�� */
	public static SingletonOne getInstance(){
		if(instance == null){
			instance = new SingletonOne();
		}			
		return instance;	
	}	
	/* ����ö����������л������Ա�֤���������л�ǰ�󱣳�һ�� */ 
	public Object readResolve(){
		return null;	
	}
}

/* �������������������Ҫ�󣬵��ǣ������������̰߳�ȫ�������࣬������ǰ���������̵߳Ļ�
 * ���£��϶��ͻ���������ˣ���ν�����������Ȼ��뵽��getInstance������synchronized��
 * ���֣����£�
 */
class SingletonTwo{	
	/* ����˽�о�̬ʵ������ֹ�����ã��˴���ֵΪnull��Ŀ����ʵ���ӳټ��� */ 
	private static SingletonTwo instance = null;	
	/* ˽�й��췽������ֹ��ʵ���� */
	private SingletonTwo(){
		
	}
	/* ����public��̬���̷��������Ҽ���ͬ���ؼ��֣���ȡʵ�� */
//	public static synchronized SingletonTwo getInstance() {  
//        if (instance == null) {  
//            instance = new SingletonTwo();  
//        }  
//        return instance;  
//    }
	/* ���ǣ�synchronized�ؼ�����ס������������������÷����������ϻ������½���
	 * ��Ϊÿ�ε���getInstance()����Ҫ�Զ�����������ʵ�ϣ�ֻ���ڵ�һ�δ��������
	 * ʱ����Ҫ������֮��Ͳ���Ҫ�ˣ����ԣ�����ط���Ҫ�Ľ������Ǹĳ����������
	 * 
	 */	
	public static SingletonTwo getInstance() {  
		//λ��1
        if (instance == null) {  
        	//λ��2
            synchronized (instance) {  
            	//λ��3
                if (instance == null) {  
                	//λ��4
                    instance = new SingletonTwo();  
                }  
            }  
        }  
        return instance;  
    }  
	
	/* 
	 * �ƺ������֮ǰ�ᵽ�����⣬��synchronized�ؼ��ּ������ڲ���Ҳ����˵�����õ�ʱ���ǲ���Ҫ�����ģ�
	 * ֻ����instanceΪnull�������������ʱ�����Ҫ������������һ�������������ǣ������������������
	 * ����������ģ���������������Javaָ���д�������͸�ֵ�����Ƿֿ����еģ�
	 * Ҳ����˵instance = new Singleton();����Ƿ�����ִ�еġ�����
	 * JVM������֤�������������Ⱥ�˳��Ҳ����˵�п���JVM��Ϊ�µ�Singleton
	 * ʵ������ռ䣬Ȼ��ֱ�Ӹ�ֵ��instance��Ա��Ȼ����ȥ��ʼ�����Singletonʵ����
	 * �����Ϳ��ܳ����ˣ�������A��B�����߳�Ϊ����

		a>A��B�߳�ͬʱ�����˵�һ��if�ж�
		b>A���Ƚ���synchronized�飬����instanceΪnull��������ִ��instance = new Singleton();
		c>����JVM�ڲ����Ż����ƣ�JVM�Ȼ�����һЩ�����Singletonʵ���Ŀհ��ڴ棬����ֵ��instance��Ա��ע���
		       ʱJVMû�п�ʼ��ʼ�����ʵ������Ȼ��A�뿪��synchronized�顣
		d>B����synchronized�飬����instance��ʱ����null������������뿪��synchronized�鲢��������ظ�
		         ���ø÷����ĳ���
		e>��ʱB�̴߳���ʹ��Singletonʵ����ȴ������û�б���ʼ�������Ǵ������ˡ�
		���Գ������п��ܷ���������ʵ���������й����Ǻܸ��ӵģ���������ǾͿ��Կ�������������д���̻߳����µĳ��������
		�ȣ�����ս�ԡ����ǶԸó�������һ���Ż���*/
	
	/* ����ö����������л������Ա�֤���������л�ǰ�󱣳�һ�� */ 
	public Object readResolve(){
		return null;	
	}
}

/* 
 * ʵ������ǣ�����ģʽʹ���ڲ�����ά��������ʵ�֣�JVM�ڲ��Ļ����ܹ���֤��һ���౻���ص�ʱ��
 * �����ļ��ع������̻߳���ġ����������ǵ�һ�ε���getInstance��ʱ��JVM�ܹ�������
 * ��֤instanceֻ������һ�Σ����һᱣ֤�Ѹ�ֵ��instance���ڴ��ʼ����ϣ��������ǾͲ�
 * �õ�����������⡣ͬʱ�÷���Ҳֻ���ڵ�һ�ε��õ�ʱ��ʹ�û�����ƣ������ͽ���˵��������⡣
 * ����������ʱ�ܽ�һ�������ĵ���ģʽ��
*/
class SingletonThree {  	  
    /* ˽�й��췽������ֹ��ʵ���� */  
    private SingletonThree() {  
    }   
    /* �˴�ʹ��һ���ڲ�����ά������ */  
    private static class SingletonFactory {  
        private static SingletonThree instance = new SingletonThree();  
    }  
  
    /* ��ȡʵ�� */  
    public static SingletonThree getInstance() {  
        return SingletonFactory.instance;  
    }  
    /* ����ö����������л������Ա�֤���������л�ǰ�󱣳�һ�� */  
    public Object readResolve() {  
        return getInstance();  
    }  
}  

/* 
 * ��ʵ˵��������Ҳ��һ��������ڹ��캯�����׳��쳣��ʵ������Զ�ò���������Ҳ�������
 * ����˵��ʮ�������Ķ�����û�еģ�����ֻ�ܸ���ʵ�������ѡ�����ʺ��Լ�Ӧ�ó�����ʵ
 * �ַ�����Ҳ��������ʵ�֣���Ϊ����ֻ��Ҫ�ڴ������ʱ�����ͬ��������ֻҪ��������
 * getInstance()�ֿ�������Ϊ������synchronized�ؼ��֣�Ҳ�ǿ��Եģ�
*/

class SingletonFour {  
	  
    private static SingletonFour instance = null;  
  
    private SingletonFour() {  
    }  
  
    private static synchronized void syncInit() {  
        if (instance == null) {  
            instance = new SingletonFour();  
        }  
    }  
  
    public static SingletonFour getInstance() {  
        if (instance == null) {  
            syncInit();  
        }  
        return instance;  
    }  
}  

/*
 * ͨ������ģʽ��ѧϰ�������ǣ�
	1������ģʽ���������򵥣����Ǿ���ʵ������������һ�����Ѷȡ�
	2��synchronized�ؼ����������Ƕ������õ�ʱ��һ��Ҫ��ǡ���ĵط�ʹ��
	��ע����Ҫʹ�����Ķ���͹��̣������е�ʱ�򲢲������������������̶���Ҫ������
	�����������ģʽ�����Ѿ������ˣ���β��������ͻȻ�뵽��һ�����⣬���ǲ�����ľ�
	̬������ʵ�ֵ���ģʽ��Ч����Ҳ�ǿ��еģ��˴�������ʲô��ͬ��

	���ȣ���̬�಻��ʵ�ֽӿڡ�������ĽǶ�˵�ǿ��Եģ������������ƻ��˾�̬�ˡ���Ϊ��
		���в�������static���εķ��������Լ�ʹʵ����Ҳ�ǷǾ�̬�ģ�
	��Σ��������Ա��ӳٳ�ʼ������̬��һ���ڵ�һ�μ����ǳ�ʼ����֮�����ӳټ��أ�����Ϊ
		��Щ��Ƚ��Ӵ������ӳټ����������������ܡ�
	�ٴΣ���������Ա��̳У����ķ������Ա���д�����Ǿ�̬���ڲ���������static���޷�����д��
	���һ�㣬������Ƚ����Ͼ���ʵ����ֻ��һ����ͨ��Java�ֻ࣬Ҫ���㵥���Ļ���������
		��������������������ʵ��һЩ�������ܣ����Ǿ�̬�಻�С���������Щ�����У��������Կ������ߵ����𣬵��ǣ�����һ���潲�������������ʵ�ֵ��Ǹ�����ģʽ���ڲ�������һ����̬����ʵ�ֵģ����ԣ������кܴ�Ĺ�����ֻ�����ǿ�������Ĳ��治ͬ���ˡ�����˼��Ľ�ϣ�������ͳ������Ľ������������HashMap��������+������ʵ��һ������ʵ�����кܶ����鶼�����������ò�ͬ�ķ������������⣬�������ŵ�Ҳ��ȱ�㣬�������ķ����ǣ���ϸ����������ŵ㣬������õĽ�����⣡
*/