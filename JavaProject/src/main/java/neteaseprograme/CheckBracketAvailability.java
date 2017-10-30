package neteaseprograme;

import java.util.Stack;

public class CheckBracketAvailability {
	public static void main(String[] args){
		String str = "()(){({})([])}";
		char[] bracketChar = str.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		stack.push(bracketChar[0]);
		for (int i = 1; i < bracketChar.length; i++) {
			char temp = bracketChar[i];
			if(stack.isEmpty()){
				stack.push(temp);
			}else{
				if(stack.peek() == temp-1 || stack.peek() == temp-2){
					stack.pop();
				}else{
					stack.push(temp);
				}
			}		
		}
		if(stack.isEmpty()){
			System.out.println("有效字符串");
		}else{
			System.out.println("无效字符串");
		}
	}
}
