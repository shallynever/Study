package chapter4;

import static tools.Print.print;
/*
 * continue��break��ת����
	1) һ���continue����ת������ѭ���Ŀ�ʼλ�ã�������ִ����һ��ѭ����
	2) ����ǩ��continue����ת����ǩ��λ�ã������½�������ڸñ�ǩ�ĺ����ѭ��
	3) һ���break���жϲ�������ǰѭ��
	4) ����ǩ��break���жϲ�������ǩ��ָ��ѭ��

	�ص㣺��java����Ҫʹ�ñ�ǩ��Ψһ��������Ϊ��ѭ��Ƕ�׵Ĵ��ڣ���Ӷ���ѭ����break��continue
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
