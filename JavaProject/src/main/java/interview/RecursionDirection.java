package interview;

import java.io.File;

public class RecursionDirection {

	public static void main(String[] args) {
		
		File my = new File("F:"+File.separator+"Java");
		
		showDrection(my);
	}

	public static void showDrection(File file) 
	{
		if(file != null)
		{	
			if(file.isDirectory())
			{
				File f[] = file.listFiles();
				if(f != null)
				{
					for (int i = 0; i < f.length; i++) {
						showDrection(f[i]);
					}
				}
			}
			else
			{
				System.out.println(file);
			}		
		}
	}

}
