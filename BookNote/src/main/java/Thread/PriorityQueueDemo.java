package Thread;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;

class MyElement implements Comparable<Object>{
	int priority;
	String content;
	public MyElement(String content,int priority) {
		// TODO Auto-generated constructor stub
		this.priority = priority;
		this.content = content;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub		
		return this.priority-((MyElement)o).priority;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[���ȼ�Ϊ"+priority+"����Ϊ��"+content+"]";
	}
}
class MyComparator implements Comparator<Object>{
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return ((MyElement)o2).priority-((MyElement)o1).priority;
	}
}
public class PriorityQueueDemo {
	
	public static void scanQueue(Queue<MyElement> queue){
		Object o = queue.poll();
		while(o != null){
			System.out.println(o);
			o = queue.poll();
		}
		System.out.println();
	}
	public static void main(String[] args){
		SortedSet<MyElement> ss = new TreeSet<MyElement>();
		for (int i = 0; i < 10; i++) {
			ss.add(new MyElement("��"+i+"��", (int)Math.round(Math.random()*100)));
		}
		Queue<MyElement> pq1 = new PriorityQueue<MyElement>(ss);
		System.out.println("�Ե�һ�����ȼ����з���");
		scanQueue(pq1);
		
		Queue<MyElement> pq2 = new PriorityQueue<MyElement>(10,new MyComparator());
		for (int i = 0; i < 10; i++) {
			pq2.offer(new MyElement("��"+i+"��", (int)Math.round(Math.random()*100)));
		}
		System.out.println("�Եڶ������ȼ����з���");
		scanQueue(pq2);		
	}
}
