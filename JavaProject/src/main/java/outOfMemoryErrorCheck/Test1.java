package outOfMemoryErrorCheck;

/*-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 */
import java.util.ArrayList;
import java.util.List;

public class Test1 {
	static class OOMObject{}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<OOMObject> list = new ArrayList<Test1.OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}

}
