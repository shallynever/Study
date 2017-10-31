package collection;

import java.util.ArrayList;
import java.util.ListIterator;

import bean.Person;


public class ListDemo {

	/**
	 * List������(�����ȡ����˳��һ��),Ԫ�ض�������(�Ǳ�)��Ԫ�ؿ����ظ�
	 * 	Vector:�ڲ����������ݽṹ����ͬ���ġ���ɾ����ѯ��������
	 * 	ArrayList:�ڲ����������ݽṹ���ǲ�ͬ���ġ������Vector����ѯ���ٶȿ졣
	 * 	LinkedList:�ڲ����������ݽṹ���ǲ�ͬ���ġ���ɾԪ�ص��ٶȺܿ졣
	 *
	 * List:���еĳ�����������һ�������ص���Ƕ����Բ����Ǳꡣ
	 *	1�����
	 *		void add(index,element);// ���б��ָ��λ�ò���ָ��Ԫ��
	 *		void addAll(index,collection);// ��ָ�� collection �е�����Ԫ�ض����뵽�б��е�ָ��λ��
	 *	2��ɾ��
	 *		Object remove(index):// �Ƴ��б���ָ��λ�õ�Ԫ��
	 *	3���޸�
	 *		Object set(index,element);// ��ָ��Ԫ���滻�б���ָ��λ�õ�Ԫ��
	 *	4����ȡ��
	 *		Object get(index);// �����б���ָ��λ�õ�Ԫ��
	 *		int indexOf(object);// ���ش��б��е�һ�γ��ֵ�ָ��Ԫ�ص�������������б�������Ԫ�أ��򷵻� -1��
	 *		int lastIndexOf(object);// ���ش��б��������ֵ�ָ��Ԫ�ص�����������б�������Ԫ�أ��򷵻� -1��
	 *		List subList(from,to);// �����б���ָ���� fromIndex������ ���� toIndex����������֮��Ĳ�����ͼ��
	 *
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Person> aList = new ArrayList<Person>();
		
		aList.add(new Person("zhoujing",23));
		aList.add(new Person("zhoujing",23));
		aList.add(new Person("zhoujing",23));
		aList.add(new Person("zhangsan",23));
		aList.add(new Person("zhangsan",2222));
		
		aList.add(new Person("lisi",23));
		
		
		
		ListIterator<Person> it = aList.listIterator();
		
		while(it.hasNext()){
			Person p = it.next();
			if("zhangsan".equals(p.getName())){
				System.out.println(p.getName());
				it.remove();
			}	
		}
		
		System.out.println(aList);
		
		
		
	}

}
