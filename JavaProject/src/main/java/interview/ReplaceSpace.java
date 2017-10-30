package interview;

/*请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
*/
public class ReplaceSpace {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer("wo zai zhe li");
		System.out.println(replaceSpace(sb));
		
	}
	public static String replaceSpace(StringBuffer str) {
		int index = 0;
		int spaceLocation = 0;
		while(true){
			spaceLocation = str.indexOf(" ",index);
			if(spaceLocation == -1)
				break;
			str.replace(spaceLocation, spaceLocation+1, "%20");
			index = spaceLocation+1;
		}
		return str.toString();
    }
}
