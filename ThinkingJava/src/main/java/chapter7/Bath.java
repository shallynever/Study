package chapter7;
/*
 ��ʼ�����õ����ַ�ʽ
	��ʼ����ʽһ���ڶ���һ�������ǳ�ʼ��
	��ʼ����ʽ�����ڹ������г�ʼ��
	��ʼ����ʽ������ʹ��֮ǰ��ʼ����Ҳ��Ϊ���Գ�ʼ���������ɶ���ֵ���Լ�����ÿ�����ɶ��������£����ַ�
			    ʽ���Լ��ٶ���Ŀ���
	��ʼ����ʽ�ģ�ʵ����ʼ��
*/
import static tools.Print.print;
class Soap
{
	private String s;
	
	public Soap() {
		print("Soap()");
		s = "Constructed";  //��ʼ����ʽ�����ڹ������г�ʼ��
	}
	@Override
	public String toString() {
		return s;
	}
}
public class Bath {
	private String s1 ="zhou"; //��ʼ����ʽһ���ڶ���һ�������ǳ�ʼ��
	private String s2 ="jing";
	private String s3;
	private String s4;	
	private Soap castille;
	private int i;
	private float toy;
	public Bath() {
		print("(Inside Bath)");
		s3 = "Joy"; //��ʼ����ʽ�����ڹ������г�ʼ��
		toy = 3.14f;
		castille = new Soap();
	}
	{
		print("��Bath������������������");
		i = 47; //��ʼ����ʽ�ģ�ʵ����ʼ��
	}	
	@Override
	public String toString() {
		if(s4 == null)
			s4 = "Joy"; /*��ʼ����ʽ������ʹ��֮ǰ��ʼ����Ҳ��Ϊ���Գ�ʼ����
						�����ɶ���ֵ���Լ�����ÿ�����ɶ��������£����ַ�
						ʽ���Լ��ٶ���Ŀ���*/
		
		return "Bath [s1=" + s1 + ", s2=" + s2 + ", s3=" + s3 + ", s4=" + s4
				+ ", castille=" + castille + ", i=" + i + ", toy=" + toy + "]";
	}
	public static void main(String[] args) {
		Bath b = new Bath();
		print(b);
	}
}
