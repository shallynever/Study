package designpattern;

/* ����ģʽ���Ƕ�һ���������������ԭ�������һЩ�����������������ⷿ�ӵ�ʱ���ȥ���н飬
 * Ϊʲô�أ���Ϊ��Ըõ������ݵ���Ϣ���յĲ���ȫ�棬ϣ����һ������Ϥ����ȥ���������˴�
 * �Ĵ�����������˼�����������е�ʱ����˾��������Ҫ����ʦ����Ϊ��ʦ�ڷ��ɷ�����ר����
 * ���������ǽ��в�����������ǵ��뷨
 */

interface Network{
	public void browse();
}

class Real implements Network{

	@Override
	public void browse() {
		System.out.println("���������Ϣ");
	}
}

class Proxy implements Network{

	private Network network;
	public Proxy(Network network){
		this.network = network;
	}
	public void check(){
		System.out.println("����û��Ƿ�Ϸ�");
	}
	@Override
	public void browse() {
		this.check();
		this.network.browse();
	}
	
}


public class ProxyTest {

	public static void main(String[] args) {
		Network net = null;
		net = new Proxy(new Real());
		net.browse();
	}

}


/*������еķ�����ʹ�õ�ʱ����Ҫ��ԭ�еķ������иĽ�����ʱ�����ְ취��

1���޸�ԭ�еķ�������Ӧ������Υ���ˡ�����չ���ţ����޸Ĺرա���ԭ��

2�����ǲ���һ�����������ԭ�еķ������ҶԲ����Ľ�����п��ơ����ַ������Ǵ���ģʽ��

ʹ�ô���ģʽ�����Խ����ܻ��ֵĸ��������������ں���ά����*/


