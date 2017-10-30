package TestDemo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String url = "https://openapi.alipay.com/gateway.do?alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2017011805198982&biz_content=%7B%22body%22%3A%22%E8%B4%AD%E4%B9%B0%E6%B5%8B%E8%AF%95%E5%95%86%E5%93%810.01%E5%85%83%22%2C%22out_trade_no%22%3A%222017425173249597%22%2C%22product_code%22%3A%22QUICK_WAP_PAY%22%2C%22subject%22%3A%22%E6%89%8B%E6%9C%BA%E7%BD%91%E7%AB%99%E6%94%AF%E4%BB%98%E6%B5%8B%E8%AF%95%E5%95%86%E5%93%81%22%2C%22timeout_express%22%3A%222m%22%2C%22total_amount%22%3A%220.01%22%7D&charset=UTF-8&format=json&method=alipay.trade.wap.pay¬ify_url=https%3A%2F%2Fwww.alipay.com&return_url=https%3A%2F%2Fwww.alipay.com&sign=Og7UmbozfWBT%2BOpqv3lg12Xt0zLSq9fCjnr9CSROP%2FObns9xxAmj9Mqj7SDbjpUWC5yn5MZO2mVeBpE2tsncsqRIUM%2FFaI0uQFrsbL%2FY74jdJrjrZFVln31NN%2BsmC8wGjZihI181N7SwGrwg3Jx5Zy%2BNIlzl8rMrkiISPxJf6WazVs0rHy9nVy8NhRyzkU4%2FaeQnXAzPgcpOrcI70Akuvg7H8pb%2FXM4aNIPF7EUarHCCL38yOB0OvZ1wDlKpLcgHwxDddniwJCOYjCj3rjk5%2F42FnF9CxH8f63PzOLzhTlzTVmo%2FGm%2Fs0Jng%2Fz8C1B1NUtA7jSR4VPW9MWXRAg7%2BgQ%3D%3D&sign_type=RSA2×tamp=2017-04-25+17%3A33%3A20&version=1.0&sign=Og7UmbozfWBT%2BOpqv3lg12Xt0zLSq9fCjnr9CSROP%2FObns9xxAmj9Mqj7SDbjpUWC5yn5MZO2mVeBpE2tsncsqRIUM%2FFaI0uQFrsbL%2FY74jdJrjrZFVln31NN%2BsmC8wGjZihI181N7SwGrwg3Jx5Zy%2BNIlzl8rMrkiISPxJf6WazVs0rHy9nVy8NhRyzkU4%2FaeQnXAzPgcpOrcI70Akuvg7H8pb%2FXM4aNIPF7EUarHCCL38yOB0OvZ1wDlKpLcgHwxDddniwJCOYjCj3rjk5%2F42FnF9CxH8f63PzOLzhTlzTVmo%2FGm%2Fs0Jng%2Fz8C1B1NUtA7jSR4VPW9MWXRAg7%2BgQ%3D%3D";
		String str1 = URLDecoder.decode(url, "utf-8");  
		System.out.println(str1);
	
	}

}
