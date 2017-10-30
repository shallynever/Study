package designpattern;

/* 
 * ��������ģʽ��һ��������ǣ���Ĵ������������࣬Ҳ����˵�������Ҫ��չ���򣬱���Թ���������޸ģ�
 * ��Υ���˱հ�ԭ�����ԣ�����ƽǶȿ��ǣ���һ�������⣬��ν�������õ����󹤳�ģʽ�������������
 * �࣬����һ����Ҫ�����µĹ��ܣ�ֱ�������µĹ�����Ϳ����ˣ�����Ҫ�޸�֮ǰ�Ĵ��롣
 * 
 * 
 * �빤��ģʽ�Աȣ���ʵ���ģʽ�ĺô����ǣ����������������һ�����ܣ���������Ϣ����ֻ����һ��ʵ���࣬ʵ��Sender�ӿڣ�
 * ͬʱ��һ�������࣬ʵ��Provider�ӿڣ���OK�ˣ�����ȥ�Ķ��ֳɵĴ��롣����������չ�ԽϺã�
 * 
 * ���󹤳������˼�����Ϊÿһ��������һ������������Щ�������ϳ�ȡ������һ��������ȡ��Ӧ�����Ķ�Ӧ����
 * 
 * */

interface Provider {
	public Sender produce();
}
//��ӹ�����
class VoiceMessage implements Sender {  
    @Override  
    public void Send() {  
        System.out.println("this is Voicemessagesender!");  
    }  
}  

class SendMailFactory implements Provider {  
    
    @Override  
    public Sender produce(){  
        return new MailSender();  
    }  
}  

class SendSmsFactory implements Provider{  
	  
    @Override  
    public Sender produce() {  
        return new SmsSender();  
    }  
}  

//��һ������
class VoiceMessageFactory implements Provider{

	@Override
	public Sender produce() {
		
		return new VoiceMessage();
	}
	
}


public class AbstractFactory {

	public static void main(String[] args) {
		Provider provider = new VoiceMessageFactory();
		Sender sender = provider.produce();
		sender.Send();
		
	}

}
