package interview;

/*一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。*/

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
