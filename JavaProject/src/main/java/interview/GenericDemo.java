package interview;

/**
 * @author jing
 *
 * 泛型：jdk1.5出现的安全机制。
 * 好处：
 * 1，将运行时期的问题ClassCastException转到了编译时期。
 * 2，避免了强制转换的麻烦。
 * 
 * 当操作的引用数据类型不确定时，我们就要使用到泛型
 *
 *
 */


/*将泛型定义在类上*/
public class GenericDemo<QQ>{
	
	private QQ q;

	public QQ getObject() {
		return q;
	}

	public void setObject(QQ object) {
		this.q = object;
	}
	
	/*将泛型定义在方法上。*/
	public <W> void show(W str){
		System.out.println("show : "+str.toString());
	}
	
	/*使用类上定义的泛型，来定义一般方法*/
	public void print(QQ q){
		System.out.println("print : "+q);
	}
	
	/*下面这种写法是不对的，因为静态是不需要对象，所以他不知道类上
	定义的泛型，当方法静态时，不能访问类上定义的泛型。如果静态方法
	使用泛型，只能将泛型定义在方法上。 因为静态的方法不需要类
	public static void method1(QQ q){
		System.out.println("method:"+obj);
	}*/
	
	/*正确的将泛型定义在静态方法上*/
	public static <Y> void method(Y obj){
		System.out.println("method:"+obj);
	}
		
}

/*泛型接口，将泛型定义在接口上。 */
interface Inter<T>{
	public void show(T t);
}

/*用两个类去实现上面带有泛型的接口，第一个类实现之后还是带有泛型，说明此类要操作的引用类型还是不确定的
第二个类是用具体类型实现的，指定此类操作的是String类型的引用*/

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