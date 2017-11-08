package chapter4;

import static tools.Print.print;
/*
 * continue和break跳转规则
	1) 一般的continue会跳转到本次循环的开始位置，并继续执行下一次循环。
	2) 带标签的continue会跳转到标签的位置，并重新进入紧接在该标签的后面的循环
	3) 一般的break会中断并跳出当前循环
	4) 带标签的break会中断并跳出标签所指的循环

	重点：在java中需要使用标签的唯一理由是因为有循环嵌套的存在，想从多重循环中break或continue
	*/
public class LabeledWhile {

	public static void main(String[] args) {
		int i = 0;
		outer:
			while(true)
			{
				print("Outer while loop");
				while(true)
				{
					i++;
					print("i="+i);
					if(i == 1){
						print("continue");
						continue;
					}
					if(i == 3){
						print("continue outer");
						continue outer;
					}
					if(i == 5){
						print("break");
						break;
					}
					if(i == 7){
						print("break outer");
						break outer;
					}
				}
			
			}
	}

}
