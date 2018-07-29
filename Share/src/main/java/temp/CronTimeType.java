package temp;

/**
 * @author 天启 zhouj@dtdream.com
 */
public enum CronTimeType {
    ALIPAY_CRON_TIME(1, "alipayCronTime"),
    UNIONPAY_CRON_TIME(2, "unionpayCronTime"),
    WXPAY_CRON_TIME(3, "wxpayCronTime");

    CronTimeType(int value, String typeCN) {
        this.value = value;
        this.typeCN = typeCN;
    }

    private int value;
    private String typeCN;
}
