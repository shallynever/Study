package designpattern;

import java.util.ArrayList;
import java.util.List;

/*
 * ������ģʽ�ṩ���Ǵ����������ģʽ����������ģʽ���ǽ����ֲ�Ʒ�����������й���
 * �����������϶�����ν���϶������ָĳ������в�ͬ�����ԣ���ʵ������ģʽ����ǰ
 * ����󹤳�ģʽ������Test��������õ��ġ����ǿ�һ�´��룺
 * ����ǰ��һ����һ��Sender�ӿڣ�����ʵ����MailSender��SmsSender����󣬽����������£�
 */

public class Builder {
	
	private List<Sender> list = new ArrayList<Sender>();
	
	
	
	public void produceMailSender(int count){
		for (int i = 0; i < count; i++) {
			list.add(new MailSender());
		}
	}
	public void produceSmsSender(int count){
		for (int i = 0; i < count; i++) {
			list.add(new SmsSender());
		}
	}
	
	public static void main(String[] args) {
		Builder builder = new  Builder();
		builder.produceMailSender(5);
	}

}


/* ����㿴����������ģʽ���ܶ๦�ܼ��ɵ�һ������������Դ�����Ƚϸ��ӵĶ�����
 * �����빤��ģʽ��������ǣ�����ģʽ��ע���Ǵ���������Ʒ����������ģʽ���ע����
 * ���϶��󣬶�����֡���ˣ���ѡ�񹤳�ģʽ���ǽ�����ģʽ����ʵ�����������
 * 
 **/
