package collections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class OPNode{
	char op;
	int level;
	public OPNode(String op){
		this.op = op.charAt(0);
		if(op.equals("+")||op.equals("-")){
			this.level = 1;
		}else if(op.equals("*")||op.equals("/")){
			this.level = 2;
		}else if(op.equals("(")){
			this.level = -3;
		}else{
			this.level = -1;
		}
	}
}

public class ComputeMathExpression {
	public static void main(){
		String expression = "";
		Pattern entryofExpreesion = Pattern.compile("[0-9]+(\\.[0-9]+)?|\\(|\\)|\\+|-|\\*|/");
		Deque stack = new LinkedList();
		List list = new LinkedList();
		Matcher m = entryofExpreesion.matcher(expression);
		while(m.find()){
			String nodeString = expression.substring(m.start(),m.end());
			if(nodeString.matches("[0-9].*")){
				list.add(Double.valueOf(nodeString));
			}else{
				OPNode opn = new OPNode(nodeString);
				int peekLevel = (stack.peek() == null)?0:((OPNode)stack.peek()).level;
				if(opn.level>peekLevel){
					stack.push(opn);
				}else{
					if(opn.level==-1){
						
					}
				}
			}
		}
	}
}
