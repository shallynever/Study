package data_Structure;




public class ImplArrayQueue {

	private int queue[];
	private int front;
	private int rear;
	private int queueSize;
	private int eleNum;
	
	public void iniQueue(int size){
		queue = new int[size];
		queueSize = size;
		front = 0;
		rear = -1;
		eleNum = 0;
	}
	
	public void insert(int data){
		if(eleNum == queueSize){
			System.out.println("队列已满");
		}else{
			rear++;
			queue[rear] = data;
			eleNum++;
		}	
	}
	
	public int remove(){
		int remoData = queue[rear];
		front++;
		if(front == queueSize){
			front = 0;
			rear = -1;
		}
		eleNum--;
		return remoData;
	}
	
	public int frontData(){
		return queue[front];
	}
	
	public boolean isEmpty(){
		if(eleNum == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public  boolean isFull(){
		if(eleNum == queueSize){
			return true;
		}else{
			return false;
		}
	}
	
	public int size(){
		return eleNum;
	}
	
	public static void main(String[] args) {
		ImplArrayQueue queue = new ImplArrayQueue();
		queue.iniQueue(4);
		
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);

		System.out.println("队头"+queue.front+"队尾"+queue.rear);
		queue.remove();
		queue.remove();
		System.out.println("队头"+queue.front+"队尾"+queue.rear);
		queue.remove();
		queue.remove();
		System.out.println("队头"+queue.front+"队尾"+queue.rear);
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		System.out.println("队头"+queue.front+"队尾"+queue.rear);
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		System.out.println("队头"+queue.front+"队尾"+queue.rear);
		

	}

}
