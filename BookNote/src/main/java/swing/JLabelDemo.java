package swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JLabelDemo {

	public static void main(String[] args) {
//		JLabelDemo01();
//		JLabelDemo02();
		JLabelDemo03();
		
	}

	public static void JLabelDemo03() {
		JFrame frame = new JFrame("zhoujing first");
		String picPath = "f:"+File.separator+"test.gif";
		Icon icon = new ImageIcon(picPath);
		JLabel lab = null;
		lab = new JLabel(icon,JLabel.CENTER);
		
		lab.setBackground(Color.YELLOW);
		lab.setForeground(Color.RED);
		frame.add(lab);
		frame.setSize(800,320);
		frame.setBackground(Color.WHITE);
		frame.setLocation(300, 200);
		frame.setVisible(true);
		
		
		
		
		
	}

	public static void JLabelDemo02() {
		JFrame frame = new JFrame("zhejianggongshangdaxue");
		JLabel lab = new JLabel("zheshiyige yanredexiatian",JLabel.CENTER);
		
		Font fnt = new Font("Serief",Font.ITALIC+Font.BOLD,28);
		
		lab.setFont(fnt);
		lab.setForeground(Color.BLUE);
		frame.add(lab);
		Dimension dim = new Dimension();
		
		dim.setSize(400,140);
		frame.setSize(dim);
		Point p = new Point(300,200);
		frame.setLocation(p);
		frame.setVisible(true);
		
		
	}

	public static void JLabelDemo01() {
		JFrame f= new JFrame("Welcome to mldn");
		JLabel lab = new JLabel("zhoujing",JLabel.CENTER);
		
		Container cont = f.getContentPane();
		cont.add(lab);
		//f.add(lab);
		Dimension dim = new Dimension();
		
		dim.setSize(400,140);
		f.setSize(dim);
		f.setBackground(Color.BLUE);
		Point p = new Point(300,200);
		f.setLocation(p);
		f.setVisible(true);
		
		
	
	}

}
