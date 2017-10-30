package io;

/*
 * 在进行压缩流操作时建议使用开源的类库org.apache.tools.zip.*，
 * 不要用java.util.zip.*类库，这个在实现上没有前面那个做的完善。
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.TreeSet;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

public class ZipArbitraryLayerFolder {
	
	
	public static TreeSet<String> ts = new TreeSet<String>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File sFolder = new File("F:"+File.separator+"features");		
		File zipFolder = new File("F:"+File.separator+"features.zip");

		ZipArbitraryLayerFolderMethod(sFolder,zipFolder);

	}
	public static void ZipArbitraryLayerFolderMethod(File sFoder,File zipFolder) throws IOException {

		ZipOutputStream zipoutFolder = new ZipOutputStream(new FileOutputStream(zipFolder));
		
		InputStream in = null;
			
		zipoutFolder.setEncoding("GBK");    //为解决注释乱码
		zipoutFolder.setComment("文件夹的压缩");
		
		//列出所有文件的路径，保存到集合中，在ListAllDirectory(sFoder)方法中用到递归
		TreeSet<String> pathTreeSet = ListAllDirectory(sFoder);
		String[] pathStr = pathTreeSet.toString().substring(1,pathTreeSet.toString().length()-1).split(",");
		
		for (int i = 0; i < pathStr.length; i++) {
			String filePath = pathStr[i].trim();
			StringBuffer pathURL = new StringBuffer();
			String[] tempStr = filePath.split("\\\\");  //这个地方需要注意，在Java中需要“\\\\”表示“\”字符串。
			for (int j = 1; j < tempStr.length-1; j++) {
				pathURL.append(tempStr[j]+File.separator);
			}
			String path = pathURL.append(tempStr[tempStr.length-1]).toString();
					
			in = new FileInputStream(new File(filePath));
			
			zipoutFolder.putNextEntry(new ZipEntry(path));
			
			int temp = 0;
			while((temp = in.read())!=-1){
				zipoutFolder.write(temp);
			}
				
			in.close();
		}	
		zipoutFolder.close();
	}
	public static TreeSet<String> ListAllDirectory(File sFolder) {
		if(sFolder != null){
			if(sFolder.isDirectory()){
				File f[] = sFolder.listFiles();
				if(f != null){
					for (int i = 0; i < f.length; i++) {
						ListAllDirectory(f[i]);						
					}
				}					
			}			
			else{
				ts.add(sFolder.toString());
			}					
		}
		return ts;		
	}
}
