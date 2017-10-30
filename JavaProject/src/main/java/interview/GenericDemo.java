package interview;

/**
 * @author jing
 *
 * ���ͣ�jdk1.5���ֵİ�ȫ���ơ�
 * �ô���
 * 1��������ʱ�ڵ�����ClassCastExceptionת���˱���ʱ�ڡ�
 * 2��������ǿ��ת�����鷳��
 * 
 * �������������������Ͳ�ȷ��ʱ�����Ǿ�Ҫʹ�õ�����
 *
 *
 */


/*�����Ͷ���������*/
public class GenericDemo<QQ>{
	
	private QQ q;

	public QQ getObject() {
		return q;
	}

	public void setObject(QQ object) {
		this.q = object;
	}
	
	/*�����Ͷ����ڷ����ϡ�*/
	public <W> void show(W str){
		System.out.println("show : "+str.toString());
	}
	
	/*ʹ�����϶���ķ��ͣ�������һ�㷽��*/
	public void print(QQ q){
		System.out.println("print : "+q);
	}
	
	/*��������д���ǲ��Եģ���Ϊ��̬�ǲ���Ҫ������������֪������
	����ķ��ͣ���������̬ʱ�����ܷ������϶���ķ��͡������̬����
	ʹ�÷��ͣ�ֻ�ܽ����Ͷ����ڷ����ϡ� ��Ϊ��̬�ķ�������Ҫ��
	public static void method1(QQ q){
		System.out.println("method:"+obj);
	}*/
	
	/*��ȷ�Ľ����Ͷ����ھ�̬������*/
	public static <Y> void method(Y obj){
		System.out.println("method:"+obj);
	}
		
}

/*���ͽӿڣ������Ͷ����ڽӿ��ϡ� */
interface Inter<T>{
	public void show(T t);
}

/*��������ȥʵ��������з��͵Ľӿڣ���һ����ʵ��֮���Ǵ��з��ͣ�˵������Ҫ�������������ͻ��ǲ�ȷ����
�ڶ��������þ�������ʵ�ֵģ�ָ�������������String���͵�����*/

class InterImpl2<Q> implements Inter<Q>{
	public void show(Q q){
		System.out.println("show :"+q);
	}
}

class InterImpl implements Inter<String>{
	public void show(String str){
		System.out.println("show :"+str);
	}
}