package java_study;

class Outer
{
	void method()
	{
		@SuppressWarnings("unused")
		Object obj = new Object()
		{
			public void show()
			{
				System.out.println("show run");
			}

		};
		//obj.show();//��Ϊ�����ڲ�����������������ת��Ϊ��Object���͡������Ͳ�����ʹ���������еķ����ˡ�


	}
}

class InnerClassDemo 
{
	public static void main(String[] args) 
	{
		new Outer().method();
	}
}
