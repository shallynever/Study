package temp;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author 天启 zhouj@dtdream.com
 */
public class Test {
    public static void main(String[] args) {
        /*如果移动的位数超过了该类型的最大位数，那么编译器会对移动的位数取模*/
        System.out.println(1 << 32);
        System.out.println(1 << 33);  // 左移1位
        System.out.println(Integer.toBinaryString(-1 >> 33));
        System.out.println(Integer.toBinaryString(-1 << 31)+":"+(-1 << 31)+"MIN_VALUE="+Integer.MIN_VALUE);
        System.out.println(Integer.toBinaryString(-1 << 32));
        System.out.println(CronTimeType.ALIPAY_CRON_TIME.name());
    }
}
