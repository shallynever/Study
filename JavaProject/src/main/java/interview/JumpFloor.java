package interview;

/*һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������*/

public class JumpFloor {

	public static void main(String[] args) {
		System.out.println(CountStep(10));
	}

	public static int CountStep(int target) {
		
        if (target == 1) {
            return 1;
        } else if (target ==2) {
            return 2;
        } else {
            return  CountStep(target-1)+CountStep(target-2);
        }
	}

}
