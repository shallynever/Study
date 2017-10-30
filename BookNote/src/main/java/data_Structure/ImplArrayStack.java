package data_Structure;

public class ImplArrayStack {
	private int arrayStack[];
	private int stackSize;
	private int top;
	
	public void iniStack(int size){
		stackSize = size;
		arrayStack = new int[size];
		top = -1;
	}
	
	public boolean isEmpty(){
		if(top == -1){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isFull(){
		if(top == stackSize-1){
			return true;
		}else{
			return false;
		}
	}
	
	public void pushStack(int data){
		top ++;
		arrayStack[top] = data;
	}
	
	public int popStack(){
		int popData = arrayStack[top];
		top--;
		return popData;
	}
	
	public int topStack(){
		return arrayStack[top];
	}
	
	public void destroyStack(){
		arrayStack = null;
	}
	
	public static void main(String[] args){
		ImplArrayStack stack = new ImplArrayStack();
		
		stack.iniStack(5);
		
		System.out.println("初始化后，判断栈是否为空"+stack.isEmpty());
		stack.pushStack(1);
		stack.pushStack(2);
		stack.pushStack(3);
		stack.pushStack(4);
		System.out.println("判断栈是否满"+stack.isFull());
		stack.pushStack(5);
		System.out.println("判断栈是否满"+stack.isFull());
		
		while(!stack.isEmpty()){
			System.out.println("出栈的数据为"+stack.popStack());
		}
		System.out.println(stack.isEmpty());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
