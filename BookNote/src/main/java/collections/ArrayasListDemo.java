package collections;

import java.util.Arrays;
import java.util.List;

public class ArrayasListDemo {
	public static void main(String[] args){
		String[] arrayName = {"zhoujing","zhangge","huangzhou","xishui"};
		List<String> al = Arrays.asList(arrayName);
		System.out.println(al);
	}
}
