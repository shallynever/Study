package io;

import io.bean.Student;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


/**
 * @author 天启 zhouj@dtdream.com
 * @since
 */
public class ExternalizeTest {

	@Test
	public void deserialize() throws Exception {
		File f = new File("f:"+File.separator+"test.txt");
		ObjectInputStream ois = null;
		InputStream input = new FileInputStream(f);
		ois = new ObjectInputStream(input);
		Object obj = ois.readObject();
		ois.close();
		System.out.println(obj);
	}

	@Test
	public void serialize() throws Exception {
		File f = new File("f:"+File.separator+"test.txt");		
		ObjectOutputStream oos = null;
		OutputStream out = new FileOutputStream(f);
		oos = new ObjectOutputStream(out);
		oos.writeObject(new Student("zhoujing",30));
		oos.close();
	}

}
