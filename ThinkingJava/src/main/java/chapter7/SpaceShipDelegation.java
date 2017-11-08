package chapter7;

import static tools.Print.print;

/*�����ϵ
����Ҫ����������ǣ�����һ�������ڱ��̳�ʱ�����еķ���������ȫ��¶���˵����ࣨ�̳��ࣩ*/

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
	
	
	//�����ʵ�ֵķ�������Щ����������SpaceShipControls���ṩ�ĳ�Ա����ķ������Ӽ���Ҳ�����Լ�����µķ���
	
	/*ʵ��SpaceShipControls���е����ַ���*/
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
	
	/*����µķ���*/
	public void closed(int velocity){
		print("SpaceShipControls.closed()");
	}
	
	public static void main(String[] args){
		SpaceShipDelegation protector = new SpaceShipDelegation("Detagation Protector");
		protector.forward(1000);
	}	
}
