package Thread;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
	public static void main(String[] args){
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			queue.offer(i);
		}
		System.out.println(queue);
		for (Integer con : queue) {
			System.out.println(con);
		}
	}
}
