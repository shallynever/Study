package memoryManagement;

class FinalGuarder{
	private Object fg = new Object(){
		public void finalize() throws Throwable{
			System.out.println("FinalGuarder");
		}
	};
}
class FinalGuarderSon extends FinalGuarder{

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("FinalGuarderSon");
	}
}

public class FinalGuarderDemo {
	public static void main(String[] args){
		new FinalGuarderSon();
		System.gc();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
