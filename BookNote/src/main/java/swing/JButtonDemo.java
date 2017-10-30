package swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonDemo {

	public static void main(String[] args) {
//		JButtonDemo01();
	//	JButtonDemo02();
		JButtonDemo03();

	}

	public  void setIcon(String file,JButton iconButton){
		ImageIcon icon = new ImageIcon(file);
		icon.getImage();
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(), 
				iconButton.getHeight(), Image.SCALE_DEFAULT);
		icon  = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}
	
	public static void JButtonDemo03() {
		
		JFrame f = new JFrame("MyFrameTHREE");
		
		String picPath = "f:"+File.separator+"test.gif";
		ImageIcon icon = new ImageIcon(picPath);
		
		f.setBounds(400,200,500,400);
		f.setLayout(null);
		
		TextField tf = new TextField(35);
		tf.setBounds(100, 200, 200, 40);
		tf.setBackground(Color.WHITE);
		
		JButton but = new JButton(icon);

		but.setBounds(300, 200, 50,50);
		
		f.add(tf);
		f.add(but);
		
		
		//myEvent();
		
		
		f.setVisible(true);
		
	
	
	
	}

	public static void JButtonDemo02() {
		JFrame f = new JFrame("MyFrameTwo");
		
		
		f.setBounds(400,200,500,400);
		f.setLayout(new FlowLayout());
		
		TextField tf = new TextField(35);
		JButton but = new JButton("一个按钮");
		
		f.add(tf);
		f.add(but);
		
		
		//myEvent();
		
		
		f.setVisible(true);
	
	
	}

	public static void JButtonDemo01() {
	
		JFrame f = new JFrame("MyFrame");
		
		JButton but = new JButton("一个按键");
		
		Font font = new  Font("Serief", Font.BOLD, 25);
		
		but.setFont(font);
		
		
		
		f.add(but);
		
		f.setSize(300, 200);
		f.setLocation(300, 200);
	
		f.setVisible(true);
	}

}
