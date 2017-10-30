package interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LineEdit {
	public static void main(String[] args) throws IOException {
		StringBuffer sb = new StringBuffer();
		while(true){
			
			Stack<Character> stack = new Stack<Character>();
			String str = null;
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));		
			str = buf.readLine();
			if("over".equals(str)){
				break;
			}
			char[] inPutChar = str.toCharArray();			
			for (int i = 0; i < inPutChar.length; i++) {
				if(inPutChar[i] == '#'){
					stack.pop();
				}else if(inPutChar[i] == '@'){
					stack.clear();
				}else{
					stack.push(inPutChar[i]);
				}
			}
			for (Character tempCharacter : stack) {
				sb.append(tempCharacter);
			}
			sb.append("\r\n");
		}	
		System.out.println(sb.toString());
	}
}
