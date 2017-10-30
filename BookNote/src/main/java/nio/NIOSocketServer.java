package nio;

import java.net.*;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class NIOSocketServer{
	public static final int PORT = 8080;
	public static void main(String[] args)throws IOException{
	//nio��ͨ��channel�����ݶ�ȡ���ֽڻ�����ByteBufferʱ���ֽڷ�ʽ�洢�ģ�
	//�������ַ���ʽ��ȡ�ʹ�������ݱ���Ҫ�����ַ�������ͽ���
	String encoding = System.getProperty("file.encoding");
	//�����ֽڱ��뼯
	Charset cs = Charset.forName(encoding);
	//���������ֽڴ�С���ֽڻ�����
	ByteBuffer buffer = ByteBuffer.allocate(16);
	SocketChannel ch = null;
	//�򿪷���˵��׽���ͨ��
	ServerSocketChannel ssc = ServerSocketChannel.open();
	//��ͨ��ѡ����
	Selector sel = Selector.open();
	try{
		//��������׽���ͨ�����ӷ�ʽ����Ϊ������ģʽ
	ssc.configureBlocking(false);
	//��������׽���ͨ���󶨵���������˶˿�
	ssc.socket().bind(new InetSocketAddress(PORT));
	//��������׽���ͨ��OP_ACCEP�¼�ע�ᵽͨ��ѡ������
	@SuppressWarnings("unused")
	SelectionKey key = ssc.register(sel, SelectionKey.OP_ACCEPT);
	System.out.println("Server on port:" + PORT);
	while(true){
		//ͨ��ѡ������ʼ��ѯͨ���¼�
	sel.select();
	Iterator<?> it = sel.selectedKeys().iterator();
	while(it.hasNext()){
		//��ȡͨ��ѡ�����¼���
	SelectionKey skey = (SelectionKey)it.next();
	it.remove();
//������׽���ͨ�����Ϳͻ��������¼����ͻ����׽���ͨ����δ����
	if(skey.isAcceptable()){
		//��ȡ������׽���ͨ�������ӵĿͻ����׽���ͨ��
	ch = ssc.accept();
	System.out.println("Accepted connection from:" + ch.socket());
	//���ͻ����׽���ͨ������ģʽ����Ϊ������ģʽ
	ch.configureBlocking(false);
	//���ͻ����׽���ͨ��OP_READ�¼�ע�ᵽͨ��ѡ������
	ch.register(sel, SelectionKey.OP_READ);
}
//�ͻ����׽���ͨ���Ѿ�����
else{
	//��ȡ������ͨ��ѡ�����¼������׽���ͨ��
	ch = (SocketChannel)skey.channel();
	//���ͻ����׽���ͨ�����ݶ�ȡ���ֽڻ�������
	ch.read(buffer);
	//ʹ���ַ��������ֽڻ���������
	CharBuffer cb = cs.decode((ByteBuffer)buffer.flip());
	String response = cb.toString();
	System.out.println("Echoing:" + response) ;
	//�����ֽڻ�������������ȡ�ͻ����׽���ͨ������
	ch.write((ByteBuffer)buffer.rewind());
	if(response.indexOf("END") != -1) ch.close();
	buffer.clear();
}
}
}
}finally{
	if(ch != null) ch.close();
	ssc.close();
	sel.close();
}
}
}
