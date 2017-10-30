package java_study;
class Demo{						// 定义Demo类
	private int temp  = 30 ;	// 声明temp属性并封装
	public void fun(Demo d2){	// 接收本类的引用
		d2.temp = 50 ;			// 直接通过对象调用本类的私有属性
	}
	public int getTemp(){		// getter
		return temp ;
	}
	public void setTemp(int t){	// setter
		temp = t ;
	}
};
public class RefDemo04{
	public static void main(String args[]){
		Demo d1 = new Demo() ;	// 实例化Demo对象
		d1.setTemp(2) ;		// 只能通过setter方法修改内容
		d1.fun(d1) ;			// 此处把Demo的对象传回到自己的类中
		System.out.println("temp = " + d1.getTemp()) ;
	}
};