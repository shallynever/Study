package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import bean.Person;


/**
 * @author ���� zhouj@dtdream.com
 * @since
 */
public class SetDemo {

	/**
	 * Set��Ԫ�ز����ظ�,����Ҳ����Ҫ�Ǳ꣩
	 *	Set�ӿ��еķ�����Collectionһ�¡�
	 *		|--HashSet: �ڲ����ݽṹ�ǹ�ϣ�� ���ǲ�ͬ���ġ�������ģ���Ԫ�ز����ظ�.
	 *		���ԾͲ���Ҫ�����Ԫ�ص�����ʵ��Comparable��Comparator�ӿڣ���ʹʵ����Ҳû����
	 *	��α�֤�ü��ϵ�Ԫ��Ψһ���أ�
	 *		��ͨ�������hashCode��equals��������ɶ���Ψһ�Եġ�
	 *		��������hashCodeֵ��ͬ����ô�����ж�equals��������ֱ�Ӵ洢����ϣ���С�
	 *		��������hashCodeֵ��ͬ����ôҪ�ٴ��ж϶����equals�����Ƿ�Ϊtrue��
	 *		���Ϊtrue����Ϊ��ͬԪ�أ����档���Ϊfalse����ô��Ϊ��ͬԪ�أ��ͽ��д洢��
	 *	ע�⣺���Ԫ��Ҫ�洢��HashSet�����У����븲��hashCode������equals������
	 *
	 *  һ������£����������������ܶ���󣬱����ˣ�ѧ�����飬ͨ������Ҫ����equals��hashCode������
	 *  ���������ж��Ƿ���ͬ�����ݡ�
	 *  	|--TreeSet:���Զ�Set�����е�Ԫ�ؽ��������ǲ�ͬ���ġ�
	 *  	�ж�Ԫ��Ψһ�Եķ�ʽ�����Ǹ��ݱȽϷ����ķ��ؽ���Ƿ���0����0��������ͬԪ�أ����档
	 *
	 *  	TreeSet��Ԫ�ؽ�������ķ�ʽһ��
	 *  	��Ԫ������߱��ȽϹ��ܣ�Ԫ�ؾ���Ҫʵ��Comparable�ӿڡ�����compareTo������
	 *  	this.compareTo(T o)�Ƚϴ˶�����ָ�������˳������ö���С�ڡ����ڻ����ָ������
	 *  	��ֱ𷵻ظ����������������,�ֱ𷵻� -1��0 �� 1 �е�һ��ֵ��
	 *
	 *   	�����Ҫ���ն����о߱�����Ȼ˳�����������������в��߱���Ȼ˳����ô�죿
	 *   	����ʹ��TreeSet���ϵڶ�������ʽ����
	 *   	�ü�������߱��ȽϹ��ܣ�����һ����ʵ��Comparator�ӿڣ�����compare������
	 *   	����ָ�����ַ���֮�󣬾Ͳ������Ԫ�ر����compareTo����
	 *   	�����������Ϊ�������ݸ�TreeSet���ϵĹ��캯����
	 *
	 *   	if(this.hashCode()== obj.hashCode() && this.equals(obj))
	 *   	��ϣ��ȷ��Ԫ���Ƿ���ͬ������
	 *   	1���жϵ�������Ԫ�صĹ�ϣֵ�Ƿ���ͬ��
	 *   	�����ͬ�����ж���������������Ƿ���ͬ��
	 *   	2���жϹ�ϣֵ��ͬ����ʵ�жϵ��Ƕ����hashCode�ķ������ж�������ͬ���õ���equals������
	 *   	ע�⣺�����ϣֵ��ͬ���ǲ���Ҫ�ж�equals��
	 *
 	 * */
	
	public static final String str = null;

	public static void main(String[] args) {
//		HashSetDemo();
		TreeSetDemo();
		

	}

	public static void TreeSetDemo() {
		TreeSet<Person> TSet = new TreeSet<Person>();
		TSet.add(new Person("zhoujing",26));
		TSet.add(new Person("zhoujin",26));
		System.out.println(TSet);
	}

	public static void HashSetDemo() {
		Set<Person> hashSet = new HashSet<Person>();
		/*��������������ͬ������Ϊͬһ������*/
		hashSet.add(new Person("zhoujing", 25));
		hashSet.add(new Person("zhoujing", 25));
		hashSet.add(new Person("zhoujie", 24));
		hashSet.add(new Person("zhoumin", 27));
		hashSet.add(new Person("zhouhui", 28));
		hashSet.add(new Person("zhoupei", 25));
		Iterator<Person> it =hashSet.iterator();
		while(it.hasNext()){
			Person p = it.next();
			if("zhoujie".equals(p.getName())){
				System.out.println(p.getName());
//				hashSet.remove(p);  //����
			}
		}
		System.out.println(hashSet);
	}
}
