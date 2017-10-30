package collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import bean.Person;


/*
 * Map���õ����ࣺ
	|--Hashtable :�ڲ��ṹ�ǹ�ϣ����ͬ���ġ�������null��Ϊ����null��Ϊֵ��
		|--Properties�������洢��ֵ���͵������ļ�����Ϣ�����Ժ�io�������ϡ�
	|--HashMap : �ڲ��ṹ�ǹ�ϣ������ͬ���ġ�����null��Ϊ����null��Ϊֵ��
	|--TreeMap : �ڲ��ṹ�Ƕ�����������ͬ���ġ����Զ�Map�����еļ���������,������Ϊnull,ֵ����Ϊnull
		treeMap.put(2, null);
		hashMap.put(null, null);
		tableMap.put(2, 1);
	
	Map��
		һ�����һ��Ԫ�ء�Collection һ�����һ��Ԫ�ء�
		MapҲ��Ϊ˫�м��ϣ�Collection���ϳ�Ϊ���м��ϡ�
		��ʵmap�����д洢�ľ��Ǽ�ֵ�ԡ� 
		map�����б��뱣֤����Ψһ�ԡ� 
		
		���÷�����
		1����ӡ�
			value put(key,value):����ǰһ����key������ֵ�����û�з���null.
		2��ɾ����
			void  clear():���map���ϡ�
			value remove(key):����ָ����key�Ƴ������ֵ�ԡ� 
		3���жϡ�
			boolean containsKey(key): //�����ӳ�����ָ������ӳ���ϵ���򷵻� true
			boolean containsValue(value):// �����ӳ�佫һ��������ӳ�䵽ָ��ֵ���򷵻� true��
			boolean isEmpty();
		4����ȡ�� 
			value get(key):ͨ������ȡֵ�����û�иü�����null��
							��Ȼ����ͨ������null�����ж��Ƿ����ָ������ 
			int size(): ��ȡ��ֵ�Եĸ����� 
*
*
*/


public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> map = new TreeMap<Integer, String>();
		map.put(1, "������");
		map.put(2, "����");
		map.put(3, "������");
		map.put(4, "���߳�");
		
//		MapOutputMethodOne(map);
//		MapOutputMethodTwo(map);
		
		
		Map<Person, String> mapPerson = new HashMap<Person, String>();
		/*
		 * �����������TreeMap,��ô��Person���о�Ҫʵ��Compareable��Comparator
		 * ��HashMap������Ҫ��Person���и���hashCode��equals����
		 * */
		
		
		mapPerson.put(new Person("�ܾ�",26), "zhoujing");
//		System.out.println(mapPerson.get(new Person("�ܾ�",26)));
		
		
		
		Map treeMap = new TreeMap();
		Map hashMap = new HashMap();
		Map tableMap = new Hashtable();
		
		treeMap.put(2, null);
		hashMap.put(null, null);
		tableMap.put(2, 1);
		
		
		

	}

	public static void MapOutputMethodTwo(Map<Integer, String> map) {
		// TODO Auto-generated method stub
		for (Map.Entry<Integer, String> me : map.entrySet()) {
			System.out.println(me.getKey()+":"+me.getValue());
		}
	}

	public static void MapOutputMethodOne(Map<Integer, String> map) {
		// TODO Auto-generated method stub

		Set<Map.Entry<Integer, String>> mapSet = map.entrySet();
		
		Iterator<Map.Entry<Integer, String>> it = mapSet.iterator();
		
		while(it.hasNext()){
			Map.Entry<Integer, String> me = it.next();
			System.out.println(me.getKey()+":"+me.getValue());
		}	
	}

}
