package interview;

/*��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
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
