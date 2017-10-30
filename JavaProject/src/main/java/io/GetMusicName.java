package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class GetMusicName {
	public static Map<String, String> map = new HashMap<String, String>();
	public static void  main(String[] args) throws FileNotFoundException, ParseException{
		String pathName = "H:"+File.separator+"Share"+File.separator;
		File sourceFile = new File(pathName+"KuGou");
		File saveFile = new File(pathName+"MusicName.txt");
		if(saveFile.exists()){
			saveFile.delete();
		}
		PrintStream ps = new PrintStream(new FileOutputStream(saveFile, true));
		File[] fileName = sourceFile.listFiles();
		for (int i = 0; i < fileName.length; i++) {
			if(fileName[i].isFile()){
				 String[] Name = fileName[i].getName().split("-");
				 Calendar cal = Calendar.getInstance();  
			     long time = fileName[i].lastModified(); 
			     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");         
			     cal.setTimeInMillis(time); 
			     String newData = formatter.format(cal.getTime());
			     if(map.containsKey(Name[0].trim()+"-"+Name[1].trim())){
			    	 String oldDate = map.get(Name[0].trim()+"-"+Name[1].trim());
			    	 Date time1 = formatter.parse(newData);
			    	 Date time2 = formatter.parse(oldDate);
			    	 if(time1.getTime() > time2.getTime()){
			    		 map.put(Name[0].trim()+"-"+Name[1].trim(),newData);
			    	 }
			     }else{
			    	 map.put(Name[0].trim()+"-"+Name[1].trim(),newData);
			     }		    
			}
		}
		Set<Map.Entry<String, String>> allSet =  map.entrySet();
		Iterator<Map.Entry<String, String>> it = allSet.iterator();
		while(it.hasNext()){
			Map.Entry<String, String> me = it.next();
			ps.print(me.getValue()+me.getKey()+"\r\n");
		}
		ps.close();
	}
}
