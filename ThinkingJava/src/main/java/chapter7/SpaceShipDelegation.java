package chapter7;

import static tools.Print.print;

/*代理关系
代理要解决的问题是：保护一个类中在被继承时，其中的方法不会完全暴露给了导出类（继承类）*/

class SpaceShipControls
{
	void up(int velocity){
		print("up(int velocity)");
	}
	void down(int velocity){
		print("down(int velocity)");
	}
	void left(int velocity){
		print("left(int velocity)");
	}
	void right(int velocity){
		print("right(int velocity)");
	}
	void forward(int velocity){
		print("forward("+velocity+")");
	}
	void back(int velocity){}
	void turboBoost(){}
}

public class SpaceShipDelegation {
	@SuppressWarnings("unused")
	private String name;
	private SpaceShipControls controls = new SpaceShipControls();
	public SpaceShipDelegation(String name){
		this.name = name;
	}
	
	
	//代理的实现的方法，这些方法可以是SpaceShipControls类提供的成员对象的方法的子集，也可以自己添加新的方法
	
	/*实现SpaceShipControls类中的四种方法*/
	public void up(int velocity){
		controls.up(velocity);
	}
	public void down(int velocity){
		controls.down(velocity);
	}
	public void back(int velocity){
		controls.back(velocity);
	}
	public void forward(int velocity){
		controls.forward(velocity);
	}
	
	/*添加新的方法*/
	public void closed(int velocity){
		print("SpaceShipControls.closed()");
	}
	
	public static void main(String[] args){
		SpaceShipDelegation protector = new SpaceShipDelegation("Detagation Protector");
		protector.forward(1000);
	}	
}
