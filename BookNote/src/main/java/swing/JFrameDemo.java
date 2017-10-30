package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class JFrameDemo {

	public static void main(String[] args) {
		//JFrameDemo01();
		JFrameDemo02();
	}

	public static void JFrameDemo02() {
		JFrame f = new JFrame("第二个Swing窗口");
		
		f.setLayout(null);
		TextField tf = new TextField(50);
		tf.setBounds(300, 200, 10, 20);
		Dimension d = new Dimension();
		d.setSize(800,400);
		f.setSize(d);
		f.setBackground(Color.GRAY);
		Point p = new Point(300,200);
		f.add(tf);
		f.setLocation(p);
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("窗体关闭");
				super.windowClosed(e);
			}

			@Override
			public void windowIconified(WindowEvent e) {
				System.out.println("窗体最小化");
				super.windowIconified(e);
			}
			
		});
		f.setVisible(true);
		
	}

	public static void JFrameDemo01() {
		JFrame f = new JFrame("第一个Swing窗体");
		f.setSize(230,80);
		f.setBackground(Color.BLACK);
		f.setLocation(300,200);
		f.setVisible(true);
	}

}
