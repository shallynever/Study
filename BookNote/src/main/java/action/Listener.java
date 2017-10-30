package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class Listener implements ActionListener {

	public String str1,str2,str;
	public int i;
	public boolean flag=true;
	public StringBuffer sb,sb1;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MainUI.calendar = Calendar.getInstance();
		str=e.getActionCommand();
		str1=MainUI.yearField.getText();
		str2=MainUI.monthField.getText();
		System.out.println(str1+" "+str2+" "+str);
		int dateflag=Integer.parseInt(str)-MainUI.calendar.get(Calendar.DATE);
		int yearflag=Integer.parseInt(str1)-MainUI.calendar.get(Calendar.YEAR);
		int monthflag=Integer.parseInt(str2)-MainUI.calendar.get(Calendar.MONTH)-1;
//		System.out.println(MainUI.paths[0]+" "+MainUI.paths[1]);
		if(yearflag>0 || monthflag>0){
			JOptionPane.showMessageDialog(null, "这是未来的时间");
		}
		if(yearflag==0 && monthflag==0 && dateflag>0){
			JOptionPane.showMessageDialog(null, "这是未来的时间");
		}
		if(yearflag==0 && monthflag==0 && dateflag==0){
			fileopen();
		}
		if(yearflag==0 && monthflag==0 && dateflag<0){
			fileopen();
		}
		if(yearflag==0 && monthflag<0){
			fileopen();
		}
		if(yearflag<0){
			fileopen();
		}
	}

	private void fileopen()  {
		// TODO Auto-generated method stub
		try {   
			MainUI.filename="E:\\项目\\"+str1+"-"+str2+"-"+str+ ".txt";
            FileReader file=new FileReader(MainUI.filename);
            BufferedReader read=new BufferedReader(file);      
            sb=new StringBuffer();      
            while((MainUI.temp=read.readLine())!=null)    
                sb.append(MainUI.temp+'\n');      
            MainUI.textArea.setText(sb.toString());      
            file.close();      
            read.close();      
            } catch (Exception ex) {  
            	fileopenx();	
    		}
        }      
	 private void fileopenx(){
		 try{
			 for(int i=0;i<MainUI.persist;i++){
				 FileReader file1=new FileReader("E:\\项目\\文件另存储路径\\"+i+".txt");
				 BufferedReader read=new BufferedReader(file1);      
				 sb1=new StringBuffer();
				 while((MainUI.temp=read.readLine())!=null)    
	                sb1.append(MainUI.temp+'\n');
				 System.out.println(sb1); 
				 if(sb1!=null){
		 			 String s=sb1.substring(sb1.length()-7, sb1.length()-5);
		 			 //System.out.println(s+"00x");
		 			 int x=Integer.parseInt(str);
		 			// System.out.println(x);
		 			 int y=Integer.parseInt(s);
		 			// System.out.println(y);
		 			 if(y==x){
					 try {   
							//String filex=read.readLine();
							//System.out.println(MainUI.temp);
						 	sb1.replace(1, 3, ":\\");
						 	String myfile=sb1.toString();
				            System.out.println(myfile+"  "+"jxl");
				            FileReader filex=new FileReader(myfile);
				            BufferedReader read1=new BufferedReader(filex);      
				            StringBuffer sb2=new StringBuffer();      
				            while((MainUI.temp=read1.readLine())!=null)    
				                sb2.append(MainUI.temp+'\n'+"-"+str1+"-"+str2+"-"+str+'\n');      
				            MainUI.textArea.setText(sb2.toString());      
				            filex.close();      
				            read.close(); 
				            //continue;
				            } catch (Exception ex) {  
				            	ex.printStackTrace();	
				    	}
				 }
			 }
		 }
		 }catch(Exception es){
			 es.printStackTrace();
		 }
     }
}
