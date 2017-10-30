package Thread;

class MyThreadStop implements Runnable{
	
	private boolean flag = true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while(this.flag){
			while(true){
				System.out.println(Thread.currentThread().getName()+"ÔËÐÐ");
			}
		}
	}
	
}


public class StopDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
