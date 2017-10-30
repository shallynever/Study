package designpattern;

/*
 * �÷��ʼ��Ͷ��ŵ�������⹤��ģʽ
 * ������˵������ģʽ�ʺϣ����ǳ����˴����Ĳ�Ʒ��Ҫ���������Ҿ��й�ͬ�Ľӿ�ʱ��
 * ����ͨ����������ģʽ���д����������ϵ�����ģʽ�У���һ�����������ַ�������
 * ������ȷ�������󣬵���������ڵڶ��֣�����Ҫʵ���������࣬���ԣ����������£�
 * ���ǻ�ѡ�õ����֡�����̬��������ģʽ��
 * 
 * */

interface Sender{  //��Ʒ�ӿ�
	public void Send();
}

class MailSender implements Sender{  //����Ĳ�Ʒ��

	@Override
	public void Send() {
		System.out.println("this is mailsender");
	}
} 
class SmsSender implements Sender{
	
	@Override
	public void Send() {
		System.out.println("this is SmsSender");
	}
} 

/*============================��ͨ����ģʽ================================*/
/*��ͨ����ģʽ�����ǽ���һ�������࣬��ʵ����ͬһ�ӿڵ�һЩ�����ʵ���Ĵ���*/
class GeneralSendFactory{
	public Sender getSender(String type){
		if("mail".equals(type)){
			return new MailSender();
		}
		else if("sms".equals(type)){
			return new SmsSender();
		}
		else{
			System.out.println("��������ȷ������");
			return null;
		}
	}
	
}

/*============================�෽������ģʽ================================*/
/* �����������ģʽ���Ƕ���ͨ��������ģʽ�ĸĽ�������ͨ��������ģʽ�У�������ݵ��ַ�������������ȷ��������
 * �������������ģʽ���ṩ��������������ֱ𴴽�����
 * 
 * */
class MultipleMethodSendFactory {  
	
   public Sender getMailSender(){  
	   return new MailSender();  
   }        
   public Sender getSmsSender(){  
	   return new SmsSender();  
   }  
}  

/*============================��̬��������ģʽ================================*/
/*��̬��������ģʽ��������Ķ����������ģʽ��ķ�����Ϊ��̬�ģ�����Ҫ����ʵ����ֱ�ӵ��ü���*/
class StaticMethodSendFactory {  
	
	public static Sender getSender(String type){  
		if("mail".equals(type)){
			return new MailSender();
		}
		else if("sms".equals(type)){
			return new SmsSender();
		}
		else{
			System.out.println("��������ȷ������");
			return null;
		}
	}        	
}  


public class FactoryMethod {

	public static void main(String[] args) {
		
		//��ͨ����ģʽ
		GeneralSendFactory gsf = new GeneralSendFactory();
		Sender sender0 = gsf.getSender("mail");
		sender0.Send();
		
		//�෽������ģʽ
		MultipleMethodSendFactory msf = new MultipleMethodSendFactory();
		Sender sender1 = msf.getMailSender();
		sender1.Send();
		
		//��̬��������ģʽ
		Sender sender2 = StaticMethodSendFactory.getSender("mail");
		sender2.Send();
	
	}
	
}
