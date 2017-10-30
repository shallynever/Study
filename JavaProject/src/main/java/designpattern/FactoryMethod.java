package designpattern;

/*
 * 用发邮件和短信的例子理解工厂模式
 * 总体来说，工厂模式适合：凡是出现了大量的产品需要创建，并且具有共同的接口时，
 * 可以通过工厂方法模式进行创建。在以上的三种模式中，第一种如果传入的字符串有误，
 * 不能正确创建对象，第三种相对于第二种，不需要实例化工厂类，所以，大多数情况下，
 * 我们会选用第三种——静态工厂方法模式。
 * 
 * */

interface Sender{  //产品接口
	public void Send();
}

class MailSender implements Sender{  //具体的产品类

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

/*============================普通工厂模式================================*/
/*普通工厂模式，就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建*/
class GeneralSendFactory{
	public Sender getSender(String type){
		if("mail".equals(type)){
			return new MailSender();
		}
		else if("sms".equals(type)){
			return new SmsSender();
		}
		else{
			System.out.println("请输入正确的类型");
			return null;
		}
	}
	
}

/*============================多方法工厂模式================================*/
/* 多个工厂方法模式，是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，
 * 而多个工厂方法模式是提供多个工厂方法，分别创建对象
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

/*============================静态方法工厂模式================================*/
/*静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可*/
class StaticMethodSendFactory {  
	
	public static Sender getSender(String type){  
		if("mail".equals(type)){
			return new MailSender();
		}
		else if("sms".equals(type)){
			return new SmsSender();
		}
		else{
			System.out.println("请输入正确的类型");
			return null;
		}
	}        	
}  


public class FactoryMethod {

	public static void main(String[] args) {
		
		//普通工厂模式
		GeneralSendFactory gsf = new GeneralSendFactory();
		Sender sender0 = gsf.getSender("mail");
		sender0.Send();
		
		//多方法工厂模式
		MultipleMethodSendFactory msf = new MultipleMethodSendFactory();
		Sender sender1 = msf.getMailSender();
		sender1.Send();
		
		//静态方法工厂模式
		Sender sender2 = StaticMethodSendFactory.getSender("mail");
		sender2.Send();
	
	}
	
}
