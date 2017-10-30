package action;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;

@SuppressWarnings("unused")
public class MainUI extends JFrame  implements ActionListener{
	
	/**
	 * author JXL
	 * version 1.0
	 *  @param args
	 */
	private static final long serialVersionUID = 1L;
	/**ָ���������˿�*/
	//public static final int PORT=8765;
	/**�����ı��༭���*/
	private JPanel jPanel1;
	/**���������ؼ����*/
	private JPanel jPanel2;
	/**���������ؼ������Ʋ��������*/
	private JPanel jPanel2_1;
	/**���������ؼ�����������ڲ��������*/
	private JPanel jPanel2_2;
	private JPanel jPanel2_21,jPanel2_20;
	/**�����˵���MenuBar����*/
	private JMenuBar menubar;
	/**�����˵���������*/
	private JMenu FileMenu,EditMenu,HelpMenu;
	/**�����˵������ļ���������*/
	private JMenuItem newitem,openitem,saveitem,saitem,printitem,exititem;
	/**�����˵����ı༭��������*/
	private JMenuItem cancelitem,cutitem,copyitem,pasteitem,deleteitem;
	/**�����˵����İ�����������*/
	private JMenuItem topicitem,aboutitem;
	/**�����ı������*/
	public static JTextArea textArea;
	/**�������ڱ�ǩ����*/
	private JLabel[] jLabel=new JLabel[7];
	/**�½���ǩ��洢�·�����*/
	private JButton[] days=new JButton[42];
	/**������һ�갴ť����*/
	private JButton LastYearButton;
	/**������һ�갴ť����*/
	private JButton NextYearButton;
	/**������һ�°�ť����*/
	private JButton LastMonthButton;
	/**������һ�°�ť����*/
	private JButton NextMonthButton;
	/**��������ı���*/
	public static JTextField yearField;
	/**�����·�������*/
	public static JTextField monthField;
	/**ָ���·�����*/
	private static final String[] months = { "01", "02", "03", "04","05", "06", "07", "08", "09", "10","11", "12",};
	/**ָ����������*/
	private static final String[] weekdays={"������","����һ","���ڶ�","������","������","������","������"};
	/**�ļ���ȡ·��*/
	private String path;
	/**�����ļ��Ի���*/
	public static FileDialog fileSave;
	/**���ļ��Ի���*/
	public static FileDialog fileOpen;
	/**������������*/
	public static Calendar calendar;
	public static String temp,filename;
	/**����ʱ�����*/
	private Date date;
	public String datex;
	public static final int persist=10000;
	/**������¼�洢·��������*/
	public static String[] paths=new String[persist];
	/**������¼���Ϊ�ļ���������*/
	public static String[] names=new String[persist];
	private int i=0;
	public MainUI(){
		super("����¼������");
		init();
		this.setBackground(Color.CYAN);
		this.setLocation(300,300);
		this.pack();
	}
	public void init(){
		/**�½���������*/
		Container container=this.getContentPane();
		container.setLayout(new BorderLayout());
		/**���ý�������*/
		Font f=new Font("Serif",Font.PLAIN,12);
		
		fileOpen=new FileDialog(this,"���ļ�",FileDialog.LOAD);
		fileOpen.setBounds(200, 200, 400, 300);
		
		fileSave=new FileDialog(this,"�����ļ�",FileDialog.SAVE);  
		fileSave.setBounds(200, 200, 400, 300); 
		
		
		/**ʵ�����ı��༭���*/
		jPanel1=new JPanel();
		/**�ı��༭��岼�ַ�ʽ--�߿򲼾�*/
		jPanel1.setLayout(new BorderLayout());
		/**ʵ�����˵���*/
		menubar=new JMenuBar();
		/**ʵ�����ļ���*/
		FileMenu=new JMenu("�ļ�(F)");
    	FileMenu.setForeground(Color.BLACK);
		FileMenu.setFont(f);
		/**���ļ�������½���Ŀ*/
		newitem=new JMenuItem("�½�(N)");
		newitem.setForeground(Color.BLACK);
		newitem.setFont(f);
		newitem.addActionListener(this);
		FileMenu.add(newitem);
		/**���ļ�����Ӵ���Ŀ*/
		openitem=new JMenuItem("��(O)");
		openitem.setForeground(Color.BLACK);
		openitem.setFont(f);
		openitem.addActionListener(this);
		FileMenu.add(openitem);
		/**���ļ�����ӱ�����Ŀ*/
		saveitem=new JMenuItem("����(S)");
		saveitem.setForeground(Color.BLACK);
		saveitem.setFont(f);
		saveitem.addActionListener(this);
		FileMenu.add(saveitem);
		/**���ļ���������Ϊ��Ŀ*/
		saitem=new JMenuItem("���Ϊ(A)");
		saitem.setForeground(Color.BLACK);
		saitem.setFont(f);
		saitem.addActionListener(this);
		FileMenu.add(saitem);
		/**��ӷָ���*/
		FileMenu.addSeparator();
		/**���ļ�����Ӵ�ӡ��Ŀ*/
		printitem=new JMenuItem("��ӡ(P)");
		printitem.setForeground(Color.BLACK);
		printitem.setFont(f);
		FileMenu.add(printitem);
		/**��ӷָ���*/
		FileMenu.addSeparator();
		/**���ļ�������˳���Ŀ*/
		exititem=new JMenuItem("�˳�(E)");
		exititem.setForeground(Color.BLACK);
		exititem.setFont(f);
		exititem.addActionListener(this);
		FileMenu.add(exititem);

		/**���ļ�����ӵ��˵���*/
		menubar.add(FileMenu);
		
		/**ʵ�����༭��*/
		EditMenu=new JMenu("�༭(E)");
    	EditMenu.setForeground(Color.BLACK);
		EditMenu.setFont(f);
		/**��༭����ӳ�����Ŀ*/
		cancelitem=new JMenuItem("����(C)");
		cancelitem.setForeground(Color.BLACK);
		cancelitem.setFont(f);
		EditMenu.add(cancelitem);
		/**��ӷָ���*/
		EditMenu.addSeparator();
		/**��༭����Ӽ�����Ŀ*/
		cutitem=new JMenuItem("����(C)");
		cutitem.setForeground(Color.BLACK);
		cutitem.setFont(f);
		cutitem.addActionListener(this);
		EditMenu.add(cutitem);
		/**��༭����Ӹ�����Ŀ*/
		copyitem=new JMenuItem("����(C)");
		copyitem.setForeground(Color.BLACK);
		copyitem.setFont(f);
		copyitem.addActionListener(this);
		EditMenu.add(copyitem);
		/**��༭�����ճ����Ŀ*/
		pasteitem=new JMenuItem("ճ��(P)");
		pasteitem.setForeground(Color.BLACK);
		pasteitem.setFont(f);
		pasteitem.addActionListener(this);
		EditMenu.add(pasteitem);
		/**��༭�����ɾ����Ŀ*/
		deleteitem=new JMenuItem("ɾ��(D)");
		deleteitem.setForeground(Color.BLACK);
		deleteitem.setFont(f);
		deleteitem.addActionListener(this);
		EditMenu.add(deleteitem);
		/**�ѱ༭����ӵ��˵���*/
		menubar.add(EditMenu);
		
		/**ʵ����������*/
		HelpMenu=new JMenu("����(H)");
		HelpMenu.setForeground(Color.BLACK);
		HelpMenu.setFont(f);
		/**����������������Ŀ*/
		topicitem=new JMenuItem("��������(H)");
		topicitem.setForeground(Color.BLACK);
		topicitem.setFont(f);
		HelpMenu.add(topicitem);
		/**��ӷָ���*/
		HelpMenu.addSeparator();
		/**���������ӹ��������Ŀ*/
		aboutitem=new JMenuItem("�������(A)");
		aboutitem.setForeground(Color.BLACK);
		aboutitem.setFont(f);
		aboutitem.addActionListener(this);
		HelpMenu.add(aboutitem);
		/**�Ѱ�������ӵ��˵���*/
		menubar.add(HelpMenu);
		
		/**ʵ�����ı������*/
		textArea=new JTextArea();
		textArea.setFont(new Font("serif",Font.PLAIN,14));
		textArea.setLineWrap(true);
	    textArea.setWrapStyleWord(true);
	    textArea.setBounds(300, 480, 450, 700);
	    /**�������Ӳ˵������ı���*/
	    jPanel1.add(menubar,"North");
	    jPanel1.add(new JScrollPane(textArea),"Center");
	    /**���ı��༭�����ӽ���������*/
	    container.add(jPanel1,"West");
	    
	    /**ʵ���������ؼ����*/
	    jPanel2=new JPanel();
		/**�����ؼ���岼�ַ�ʽ--�߿򲼾�*/
		jPanel2.setLayout(new BorderLayout());
		jPanel2.setBackground(Color.GREEN);
		jPanel2.setBounds(450, 300, 600, 480);
		/**ʵ���������ؼ����������*/
		jPanel2_1=new JPanel();
		jPanel2_2=new JPanel();
		jPanel2_20=new JPanel();
		jPanel2_21=new JPanel();
		jPanel2_1.setLayout(new FlowLayout());
		jPanel2_2.setLayout(new BorderLayout()); 
		jPanel2_20.setLayout(new GridLayout(1, 7, 5, 5));
		jPanel2_21.setLayout(new GridLayout(6, 7, 5, 5));
		/**ʵ�������ư�ť*/
		LastYearButton=new JButton("��һ��");
		LastYearButton.addActionListener(this);
		NextYearButton=new JButton("��һ��");
		NextYearButton.addActionListener(this);
		LastMonthButton=new JButton("��һ��");
		LastMonthButton.addActionListener(this);
		NextMonthButton=new JButton("��һ��");
		NextMonthButton.addActionListener(this);	
		/**ʵ��������ı���*/
		yearField=new JTextField(4);
		yearField.setEditable(false);
		yearField.setHorizontalAlignment(JTextField.CENTER);
	    yearField.setFont(f);
	    
	    JLabel jLabel=new JLabel("---");
	    
		/**ʵ�����·��ı���*/
		monthField=new JTextField(3);
		monthField.setEditable(false);
		monthField.setHorizontalAlignment(JTextField.CENTER);
		monthField.setFont(f);
       /**��ʼ��������·��ı���*/
		Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR); //��
        int month = now.get(Calendar.MONTH)+1; //��
        yearField.setText(year+"");
        monthField.setText(months[month-1]); 
		
        /**�ѿ��ư�ť����������ӽ������*/
		jPanel2_1.add(LastYearButton);
		jPanel2_1.add(LastMonthButton);
		jPanel2_1.add(yearField);
		jPanel2_1.add(jLabel);
		jPanel2_1.add(monthField);
		jPanel2_1.add(NextMonthButton);
		jPanel2_1.add(NextYearButton);
		/**�ѿ����������ӽ������ؼ����*/
		jPanel2.add(jPanel2_1,"North");
		
		/**ʵ�������ڱ�ǩ*/
		for(int i=0;i<weekdays.length;i++){
			this.jLabel[i]=new JLabel(weekdays[i]);
			this.jLabel[i].setBackground(Color.GREEN);
			this.jLabel[i].setForeground(Color.BLUE);
			jPanel2_20.add(this.jLabel[i]);
		}
		jPanel2_2.add(jPanel2_20,"North");

		/**��ʾ����*/
		displaydate();
		
		/**�������������������ؼ����*/
		jPanel2.add("Center",jPanel2_2);
		container.add(jPanel2,"Center");
		
	}
	  /**
     * �õ�ָ�����µ�����
     *
     * @param year
     *            ��
     * @param month
     *            ��(1-12)
     * @return ָ�����µ��������磺year=2008,month=1 �ͷ��� 2008��1�µ�������31
     */
    private int getDayCountOfMonth(int year, int month) {
    	calendar = Calendar.getInstance();
    	calendar.set(year, month - 1, 1); // ��Ϊ Calendar�е� month �� 0-11����monthҪ��ȥ1
        Calendar cal2 = (Calendar) calendar.clone();
        cal2.add(Calendar.MONTH, 1);
        cal2.add(Calendar.DAY_OF_MONTH, -1);
        return cal2.get(Calendar.DAY_OF_MONTH);
    }
    /**��ʾ����*/
    public void displaydate(){
		calendar = Calendar.getInstance();
		int currentDate = calendar.get(Calendar.DATE);
		int year=Integer.parseInt(yearField.getText());
		int month=Integer.parseInt(monthField.getText());
		calendar.set(year,month-1,1);
		int beginIndex = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		int endIndex = beginIndex + getDayCountOfMonth(year, month) - 1;
		int day=1;
		for (int i = 0; i < days.length; i++) {
			days[i]=new JButton();
			days[i].setBackground(Color.WHITE);
	        if (i >= beginIndex && i <= endIndex) {
	        	 if(day<10){
	        		 days[i].setText("0"+day + "");
	             }
	        	 if(day>=10){
	        		 days[i].setText(day + "");
	        	 }
	             days[i].setToolTipText(year + "-" + month+"-"+day);
	             if (day == currentDate)
	                days[i].setBackground(Color.GREEN);
	             else
	                days[i].setForeground(Color.BLUE);
	             day++;
	 	     days[i].addActionListener(new Listener());
	         } 
	        if (i <= beginIndex && i >= endIndex) {
	             days[i].setText("");
	             days[i].setToolTipText("");
	             days[i].setBackground(Color.RED);
	            }
	        jPanel2_21.add(days[i]);
	        }
		day=1;
		jPanel2_2.add(jPanel2_21,"Center");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MainUI ui=new MainUI();
        ui.setSize(880, 480);
        ui.setVisible(true);
	    ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		date=new Date();
		String time=Integer.toString(date.getHours())+"ʱ"+Integer.toString(date.getMinutes())+"��";
		String str=e.getActionCommand();
		if(str.equals("��һ��")){
			int x=Integer.parseInt(yearField.getText());
			x -=1;
			yearField.setText(x+"");
			jPanel2_2.remove(jPanel2_21);
			this.setVisible(false);
			jPanel2_21=new JPanel();
			jPanel2_21.setLayout(new GridLayout(6, 7, 5, 5));
			displaydate();
			this.setVisible(true);
		}
		if(str.equals("��һ��")){
			int x=Integer.parseInt(yearField.getText());
			x +=1;
			yearField.setText(x+"");
			jPanel2_2.remove(jPanel2_21);
			this.setVisible(false);
			jPanel2_21=new JPanel();
			jPanel2_21.setLayout(new GridLayout(6, 7, 5, 5));
			displaydate();
			
			this.setVisible(true);
		}
		if(str.equals("��һ��")){
			int x=Integer.parseInt(monthField.getText());
			if(x<13&&x>=1){
			x -=1;
			if(x>0)
			monthField.setText(months[x-1]);
			if(x==0)
			monthField.setText("01");
			}
			if(x<1){
				int y=Integer.parseInt(yearField.getText());
				y -=1;
				yearField.setText(y+"");
				monthField.setText(months[11]);
			}
			jPanel2_2.remove(jPanel2_21);
			this.setVisible(false);
			jPanel2_21=new JPanel();
			jPanel2_21.setLayout(new GridLayout(6, 7, 5, 5));
			displaydate();
			this.setVisible(true);
		}
		if(str.equals("��һ��")){
			int x=Integer.parseInt(monthField.getText());
			if(x<13&&x>=1){
			x +=1;
			if(x<12)
			monthField.setText(months[x-1]);
			if(x==12)
			monthField.setText("12");
			}
			if(x>12){
				int y=Integer.parseInt(yearField.getText());
				y +=1;
				yearField.setText(y+"");
				monthField.setText(months[0]);
			}
			jPanel2_2.remove(jPanel2_21);
			this.setVisible(false);
			jPanel2_21=new JPanel();
			jPanel2_21.setLayout(new GridLayout(6, 7, 5, 5));
			displaydate();
			this.setVisible(true);
		}
		if(str.equals("����(C)")){
			textArea.copy();
		}
		if(str.equals("ճ��(P)")){
			textArea.paste();
		}
		if(str.equals("����(C)")){
			textArea.cut();
		}
		if(str.equals("�½�(N)")){
			textArea.setText("");
		}
		if(str.equals("��(O)")){
			fileOpen.setVisible(true);
			try {   
				filename=fileOpen.getDirectory()+"\\"+fileOpen.getFile(); 
	            FileReader file=new FileReader(filename);      
	            BufferedReader read=new BufferedReader(file);      
	            StringBuffer sb=new StringBuffer();      
	            while((temp=read.readLine())!=null)    
	                sb.append(temp+'\n');      
	            textArea.setText(sb.toString());      
	            file.close();      
	            read.close();      
	            } catch (Exception ex) {      
	        }      
		}
		if(str.equals("����(S)")){
			calendar = Calendar.getInstance();
			 try{  
				 	if(calendar.get(Calendar.DATE)<0){
				 		datex="0"+calendar.get(Calendar.DATE);
				 	}else
			 			datex=String.valueOf(calendar.get(Calendar.DATE));
				 	FileWriter file=new FileWriter("E:\\��Ŀ\\"+ yearField.getText()+ "-"
				 			+monthField.getText()+"-" +datex+".txt");      
		            BufferedWriter bw=new BufferedWriter(file);      
		            bw.write(textArea.getText());      
		            bw.close();      
		        }      
		        catch(Exception exs)      
		        {      
		        	exs.printStackTrace();
		        }      
		}
		if(str.equals("���Ϊ(A)")){
			fileSave.setVisible(true);
			calendar = Calendar.getInstance();
			try{  
					if(calendar.get(Calendar.DATE)<10){
						datex="0"+calendar.get(Calendar.DATE);
			 		}else
			 			datex=String.valueOf((calendar.get(Calendar.DATE)));
				    filename=fileSave.getDirectory()+"\\"+fileSave.getFile()+"-"+yearField.getText()+"-"+
		 			monthField.getText()+"-" +datex+".txt";
		            FileWriter file=new FileWriter(filename);  
		            BufferedWriter bw=new BufferedWriter(file);      
		            bw.write(textArea.getText());      
		            bw.close();
		            if(i<persist){
		            	paths[i]=filename;
	//	            	names[i]=fileSave.getFile();
		            	System.out.println(paths[i]);
		            	FileWriter file1=new FileWriter("E:\\��Ŀ\\�ļ���洢·��\\"+i+".txt");  
		            	BufferedWriter bw1=new BufferedWriter(file1);      
		            	bw1.write(paths[i]);  
		            	bw1.close();
		            }
		            i +=1;
		       System.out.println(i);
			  }catch(Exception exs){      
		        	exs.printStackTrace();
		      }      
		        
		    }
		if(str.equals("�˳�(E)")){
			System.exit(0);
		}
		if(str.equals("�������(A)")){
			JOptionPane.showMessageDialog(null, "<HTML><BODY>���߾�������.<br>" +
					"�����Ŀ���Ǹ���������Ŀ����.<br>" +
					"������ı���ʽΪtxt��Ĭ�ϴ洢·����E��\\��Ŀ\\...!<br>" +
					"�ı���ȡ�ɰ���������Ӧ�����ڣ����ɶ�ȡ��Ӧ���ڵı���<br>" +
					"ע�⣺�ı�������Ĭ�ϴ洢����������󣬵��������Ӧ���ڣ��ı����ᱻ�ҵ���(��Ϊ�Ҳ���ʹ�����ݿ�)<br>" +
					"���BUG����������Ļ�����ӭ���ģ�Դ����Ҫ��ʽ�������ʼ���819017686@qq.com����ע����ҪԴ�룡" +
					"</BODY></HTML>");
		}
	}
}
