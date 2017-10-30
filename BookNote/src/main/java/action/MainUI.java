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
	/**指定服务器端口*/
	//public static final int PORT=8765;
	/**声明文本编辑面板*/
	private JPanel jPanel1;
	/**声明日历控件面板*/
	private JPanel jPanel2;
	/**声明日历控件面板控制部分子面板*/
	private JPanel jPanel2_1;
	/**声明日历控件面板日期星期部分子面板*/
	private JPanel jPanel2_2;
	private JPanel jPanel2_21,jPanel2_20;
	/**声明菜单栏MenuBar对象*/
	private JMenuBar menubar;
	/**声明菜单栏的子项*/
	private JMenu FileMenu,EditMenu,HelpMenu;
	/**声明菜单栏的文件栏的子项*/
	private JMenuItem newitem,openitem,saveitem,saitem,printitem,exititem;
	/**声明菜单栏的编辑栏的子项*/
	private JMenuItem cancelitem,cutitem,copyitem,pasteitem,deleteitem;
	/**声明菜单栏的帮助栏的子项*/
	private JMenuItem topicitem,aboutitem;
	/**声明文本域对象*/
	public static JTextArea textArea;
	/**声明星期标签对象*/
	private JLabel[] jLabel=new JLabel[7];
	/**新建标签组存储月份日期*/
	private JButton[] days=new JButton[42];
	/**声明上一年按钮对象*/
	private JButton LastYearButton;
	/**声明下一年按钮对象*/
	private JButton NextYearButton;
	/**声明上一月按钮对象*/
	private JButton LastMonthButton;
	/**声明下一月按钮对象*/
	private JButton NextMonthButton;
	/**声明年份文本框*/
	public static JTextField yearField;
	/**声明月份下拉框*/
	public static JTextField monthField;
	/**指定月份数组*/
	private static final String[] months = { "01", "02", "03", "04","05", "06", "07", "08", "09", "10","11", "12",};
	/**指定星期数组*/
	private static final String[] weekdays={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
	/**文件存取路径*/
	private String path;
	/**保存文件对话框*/
	public static FileDialog fileSave;
	/**打开文件对话框*/
	public static FileDialog fileOpen;
	/**声明日历对象*/
	public static Calendar calendar;
	public static String temp,filename;
	/**声明时间对象*/
	private Date date;
	public String datex;
	public static final int persist=10000;
	/**声明记录存储路径的数组*/
	public static String[] paths=new String[persist];
	/**声明记录另存为文件名的数组*/
	public static String[] names=new String[persist];
	private int i=0;
	public MainUI(){
		super("备忘录管理器");
		init();
		this.setBackground(Color.CYAN);
		this.setLocation(300,300);
		this.pack();
	}
	public void init(){
		/**新建界面容器*/
		Container container=this.getContentPane();
		container.setLayout(new BorderLayout());
		/**设置界面字体*/
		Font f=new Font("Serif",Font.PLAIN,12);
		
		fileOpen=new FileDialog(this,"打开文件",FileDialog.LOAD);
		fileOpen.setBounds(200, 200, 400, 300);
		
		fileSave=new FileDialog(this,"保存文件",FileDialog.SAVE);  
		fileSave.setBounds(200, 200, 400, 300); 
		
		
		/**实例化文本编辑面板*/
		jPanel1=new JPanel();
		/**文本编辑面板布局方式--边框布局*/
		jPanel1.setLayout(new BorderLayout());
		/**实例化菜单栏*/
		menubar=new JMenuBar();
		/**实例化文件栏*/
		FileMenu=new JMenu("文件(F)");
    	FileMenu.setForeground(Color.BLACK);
		FileMenu.setFont(f);
		/**向文件栏添加新建项目*/
		newitem=new JMenuItem("新建(N)");
		newitem.setForeground(Color.BLACK);
		newitem.setFont(f);
		newitem.addActionListener(this);
		FileMenu.add(newitem);
		/**向文件栏添加打开项目*/
		openitem=new JMenuItem("打开(O)");
		openitem.setForeground(Color.BLACK);
		openitem.setFont(f);
		openitem.addActionListener(this);
		FileMenu.add(openitem);
		/**向文件栏添加保存项目*/
		saveitem=new JMenuItem("保存(S)");
		saveitem.setForeground(Color.BLACK);
		saveitem.setFont(f);
		saveitem.addActionListener(this);
		FileMenu.add(saveitem);
		/**向文件栏添加另存为项目*/
		saitem=new JMenuItem("另存为(A)");
		saitem.setForeground(Color.BLACK);
		saitem.setFont(f);
		saitem.addActionListener(this);
		FileMenu.add(saitem);
		/**添加分割线*/
		FileMenu.addSeparator();
		/**向文件栏添加打印项目*/
		printitem=new JMenuItem("打印(P)");
		printitem.setForeground(Color.BLACK);
		printitem.setFont(f);
		FileMenu.add(printitem);
		/**添加分割线*/
		FileMenu.addSeparator();
		/**向文件栏添加退出项目*/
		exititem=new JMenuItem("退出(E)");
		exititem.setForeground(Color.BLACK);
		exititem.setFont(f);
		exititem.addActionListener(this);
		FileMenu.add(exititem);

		/**把文件栏添加到菜单栏*/
		menubar.add(FileMenu);
		
		/**实例化编辑栏*/
		EditMenu=new JMenu("编辑(E)");
    	EditMenu.setForeground(Color.BLACK);
		EditMenu.setFont(f);
		/**向编辑栏添加撤销项目*/
		cancelitem=new JMenuItem("撤销(C)");
		cancelitem.setForeground(Color.BLACK);
		cancelitem.setFont(f);
		EditMenu.add(cancelitem);
		/**添加分割线*/
		EditMenu.addSeparator();
		/**向编辑栏添加剪切项目*/
		cutitem=new JMenuItem("剪切(C)");
		cutitem.setForeground(Color.BLACK);
		cutitem.setFont(f);
		cutitem.addActionListener(this);
		EditMenu.add(cutitem);
		/**向编辑栏添加复制项目*/
		copyitem=new JMenuItem("复制(C)");
		copyitem.setForeground(Color.BLACK);
		copyitem.setFont(f);
		copyitem.addActionListener(this);
		EditMenu.add(copyitem);
		/**向编辑栏添加粘贴项目*/
		pasteitem=new JMenuItem("粘贴(P)");
		pasteitem.setForeground(Color.BLACK);
		pasteitem.setFont(f);
		pasteitem.addActionListener(this);
		EditMenu.add(pasteitem);
		/**向编辑栏添加删除项目*/
		deleteitem=new JMenuItem("删除(D)");
		deleteitem.setForeground(Color.BLACK);
		deleteitem.setFont(f);
		deleteitem.addActionListener(this);
		EditMenu.add(deleteitem);
		/**把编辑栏添加到菜单栏*/
		menubar.add(EditMenu);
		
		/**实例化帮助栏*/
		HelpMenu=new JMenu("帮助(H)");
		HelpMenu.setForeground(Color.BLACK);
		HelpMenu.setFont(f);
		/**向帮助栏添加主题项目*/
		topicitem=new JMenuItem("帮助主题(H)");
		topicitem.setForeground(Color.BLACK);
		topicitem.setFont(f);
		HelpMenu.add(topicitem);
		/**添加分割线*/
		HelpMenu.addSeparator();
		/**向帮助栏添加关于软件项目*/
		aboutitem=new JMenuItem("关于软件(A)");
		aboutitem.setForeground(Color.BLACK);
		aboutitem.setFont(f);
		aboutitem.addActionListener(this);
		HelpMenu.add(aboutitem);
		/**把帮助栏添加到菜单栏*/
		menubar.add(HelpMenu);
		
		/**实例化文本域对象*/
		textArea=new JTextArea();
		textArea.setFont(new Font("serif",Font.PLAIN,14));
		textArea.setLineWrap(true);
	    textArea.setWrapStyleWord(true);
	    textArea.setBounds(300, 480, 450, 700);
	    /**向面板添加菜单栏和文本域*/
	    jPanel1.add(menubar,"North");
	    jPanel1.add(new JScrollPane(textArea),"Center");
	    /**把文本编辑面板添加进界面容易*/
	    container.add(jPanel1,"West");
	    
	    /**实例化日历控件面板*/
	    jPanel2=new JPanel();
		/**日历控件面板布局方式--边框布局*/
		jPanel2.setLayout(new BorderLayout());
		jPanel2.setBackground(Color.GREEN);
		jPanel2.setBounds(450, 300, 600, 480);
		/**实例化日历控件面板的子面板*/
		jPanel2_1=new JPanel();
		jPanel2_2=new JPanel();
		jPanel2_20=new JPanel();
		jPanel2_21=new JPanel();
		jPanel2_1.setLayout(new FlowLayout());
		jPanel2_2.setLayout(new BorderLayout()); 
		jPanel2_20.setLayout(new GridLayout(1, 7, 5, 5));
		jPanel2_21.setLayout(new GridLayout(6, 7, 5, 5));
		/**实例化控制按钮*/
		LastYearButton=new JButton("上一年");
		LastYearButton.addActionListener(this);
		NextYearButton=new JButton("下一年");
		NextYearButton.addActionListener(this);
		LastMonthButton=new JButton("上一月");
		LastMonthButton.addActionListener(this);
		NextMonthButton=new JButton("下一月");
		NextMonthButton.addActionListener(this);	
		/**实例化年份文本框*/
		yearField=new JTextField(4);
		yearField.setEditable(false);
		yearField.setHorizontalAlignment(JTextField.CENTER);
	    yearField.setFont(f);
	    
	    JLabel jLabel=new JLabel("---");
	    
		/**实例化月份文本框*/
		monthField=new JTextField(3);
		monthField.setEditable(false);
		monthField.setHorizontalAlignment(JTextField.CENTER);
		monthField.setFont(f);
       /**初始化年份与月份文本框*/
		Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR); //年
        int month = now.get(Calendar.MONTH)+1; //月
        yearField.setText(year+"");
        monthField.setText(months[month-1]); 
		
        /**把控制按钮和下拉框添加进子面板*/
		jPanel2_1.add(LastYearButton);
		jPanel2_1.add(LastMonthButton);
		jPanel2_1.add(yearField);
		jPanel2_1.add(jLabel);
		jPanel2_1.add(monthField);
		jPanel2_1.add(NextMonthButton);
		jPanel2_1.add(NextYearButton);
		/**把控制子面板添加进日历控件面板*/
		jPanel2.add(jPanel2_1,"North");
		
		/**实例化星期标签*/
		for(int i=0;i<weekdays.length;i++){
			this.jLabel[i]=new JLabel(weekdays[i]);
			this.jLabel[i].setBackground(Color.GREEN);
			this.jLabel[i].setForeground(Color.BLUE);
			jPanel2_20.add(this.jLabel[i]);
		}
		jPanel2_2.add(jPanel2_20,"North");

		/**显示日期*/
		displaydate();
		
		/**把日期子面板加入日历控件面板*/
		jPanel2.add("Center",jPanel2_2);
		container.add(jPanel2,"Center");
		
	}
	  /**
     * 得到指定年月的天数
     *
     * @param year
     *            年
     * @param month
     *            月(1-12)
     * @return 指定年月的天数，如：year=2008,month=1 就返回 2008年1月的天数：31
     */
    private int getDayCountOfMonth(int year, int month) {
    	calendar = Calendar.getInstance();
    	calendar.set(year, month - 1, 1); // 因为 Calendar中的 month 是 0-11，故month要减去1
        Calendar cal2 = (Calendar) calendar.clone();
        cal2.add(Calendar.MONTH, 1);
        cal2.add(Calendar.DAY_OF_MONTH, -1);
        return cal2.get(Calendar.DAY_OF_MONTH);
    }
    /**显示日期*/
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
		String time=Integer.toString(date.getHours())+"时"+Integer.toString(date.getMinutes())+"分";
		String str=e.getActionCommand();
		if(str.equals("上一年")){
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
		if(str.equals("下一年")){
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
		if(str.equals("上一月")){
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
		if(str.equals("下一月")){
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
		if(str.equals("复制(C)")){
			textArea.copy();
		}
		if(str.equals("粘贴(P)")){
			textArea.paste();
		}
		if(str.equals("剪切(C)")){
			textArea.cut();
		}
		if(str.equals("新建(N)")){
			textArea.setText("");
		}
		if(str.equals("打开(O)")){
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
		if(str.equals("保存(S)")){
			calendar = Calendar.getInstance();
			 try{  
				 	if(calendar.get(Calendar.DATE)<0){
				 		datex="0"+calendar.get(Calendar.DATE);
				 	}else
			 			datex=String.valueOf(calendar.get(Calendar.DATE));
				 	FileWriter file=new FileWriter("E:\\项目\\"+ yearField.getText()+ "-"
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
		if(str.equals("另存为(A)")){
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
		            	FileWriter file1=new FileWriter("E:\\项目\\文件另存储路径\\"+i+".txt");  
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
		if(str.equals("退出(E)")){
			System.exit(0);
		}
		if(str.equals("关于软件(A)")){
			JOptionPane.showMessageDialog(null, "<HTML><BODY>作者就是我了.<br>" +
					"该软件目的是辅助管理项目进程.<br>" +
					"该软件文本格式为txt，默认存储路径是E：\\项目\\...!<br>" +
					"文本读取可按日历中相应的日期，即可读取相应日期的备忘<br>" +
					"注意：文本若不是默认存储，重启软件后，点击日历相应日期，文本不会被找到！(因为我不想使用数据库)<br>" +
					"这个BUG，您有意向的话，欢迎更改，源码索要方式：发送邮件到819017686@qq.com，请注明索要源码！" +
					"</BODY></HTML>");
		}
	}
}
