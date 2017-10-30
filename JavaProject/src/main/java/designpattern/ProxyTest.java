package designpattern;

/* 代理模式就是多一个代理类出来，替原对象进行一些操作，比如我们在租房子的时候会去找中介，
 * 为什么呢？因为你对该地区房屋的信息掌握的不够全面，希望找一个更熟悉的人去帮你做，此处
 * 的代理就是这个意思。再如我们有的时候打官司，我们需要请律师，因为律师在法律方面有专长，
 * 可以替我们进行操作，表达我们的想法
 */

interface Network{
	public void browse();
}

class Real implements Network{

	@Override
	public void browse() {
		System.out.println("上网浏览信息");
	}
}

class Proxy implements Network{

	private Network network;
	public Proxy(Network network){
		this.network = network;
	}
	public void check(){
		System.out.println("检查用户是否合法");
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


/*如果已有的方法在使用的时候需要对原有的方法进行改进，此时有两种办法：

1、修改原有的方法来适应。这样违反了“对扩展开放，对修改关闭”的原则。

2、就是采用一个代理类调用原有的方法，且对产生的结果进行控制。这种方法就是代理模式。

使用代理模式，可以将功能划分的更加清晰，有助于后期维护！*/


