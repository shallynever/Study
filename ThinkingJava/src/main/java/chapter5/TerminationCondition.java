package chapter5;

import static tools.Print.print;


class Book
{
	boolean checkedOut = false;
	Book(boolean checkout){
		checkedOut = checkout;
	}
	void checkIn(){
		checkedOut = false;
	}
	@Override
	protected void finalize() throws Throwable {
		if(checkedOut)
			print("Error: checked out");
		super.finalize();
	}	
}

public class TerminationCondition {

	public static void main(String[] args) throws InterruptedException {
		Book b1 = new Book(true);
			b1.checkIn();
		new Book(true);
//		new Book(true);
//		new Book(true);
//		new Book(true);
		
		System.gc();
		
		
		Thread.sleep(1000);		
	}

}
