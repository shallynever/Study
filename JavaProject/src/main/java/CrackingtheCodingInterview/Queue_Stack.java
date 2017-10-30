package CrackingtheCodingInterview;

/*题目描述

用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。*/

import java.util.Stack;

public class Queue_Stack {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	public static void main(String[] args) {
		Queue_Stack qs = new Queue_Stack();
		
		qs.push(1);
//		System.out.println(qs.pop());
		qs.push(2);
//		System.out.println(qs.pop());
		qs.push(3);
		System.out.println("=="+qs.pop());
		System.out.println("--"+qs.pop());
		qs.push(4);
		qs.push(5);
		
		System.out.println(qs.pop());
		
	}	    
    public void push(int node) {     
    	   stack1.push(node);
    }
    public int pop() {	
    	
    	if(stack2.isEmpty())
    	{
    		while(!stack1.isEmpty()){
    			stack2.push(stack1.pop());
    		}
    		return stack2.pop();
    	}   		
    	else
    		return stack2.pop();       	    		
   }    	    
}

