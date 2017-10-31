package io.tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author 天启 zhouj@dtdream.com
 * @since
 */
public class InputDate {
	private BufferedReader bufr = null;
	public InputDate(){
		this.bufr = new BufferedReader(new InputStreamReader(System.in));
	}
	public String getString (String info){
		String temp = null;
		System.out.println(info);	
		try {
			temp = this.bufr.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
		
	}
	public int getInt(String info,String err){
		int temp = 0;
		String str = null;
		boolean flag = true;
		while(flag){
			str = this.getString(info);
			if(str.matches("^\\d+$")){
				temp = Integer.parseInt(str);
				flag = false;
			}else{
				System.out.println(err);
			}
			
		}
			return temp;
				
	}
	public float getFloat(String info,String err){
		float temp = 0;
		String str = null;
		boolean flag = true;
		while(flag){
			str = this.getString(info);
			if(str.matches("^\\d+.?\\d+$")){
				temp = Float.parseFloat(str);
				flag = false;
			}else{
				System.out.println(err);
			}
			
		}
			return temp;
	}
	public Date getDate(String info,String err){
		Date d = null;
		String str = null;
		boolean flag = true;
		while(flag){
			str = this.getString(info);
			if(str.matches("^\\d{4}-\\d{2}-\\d{2}$")){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					d=sdf.parse(str);
				} catch (Exception e) {
					e.printStackTrace();
				}
				flag = false;
			}else{
				System.out.println(err);
			}
		}
		return d;
	}
	public static void main(String[] args) {
		InputDate input = new InputDate();
		int i=0;
		int j=0;
		i = input.getInt("请输入第一个数字:", "输入数据有误，请重新输入");
		j = input.getInt("请输入第二个数字:", "输入数据有误，请重新输入");
		System.out.println("i+j="+(i+j));
	}

}
