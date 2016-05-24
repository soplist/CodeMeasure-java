import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Get {
	public static int fileCount=0;
    public static void main(String[] args) {
		int count = 0;
		
		String path = "D:/test";
		//String path = "D:/wangkang/mis_20160510/mis/src/com/jingrui/action";
		//String path = "D:/test";
		File file = new File(path);
		count = getCodecount(file);
		
		System.out.println("code count:"+count);
		System.out.println("file count:"+fileCount);
	}
    
    public static int getCodecount(File dir){
    	int count = 0;
    	File[] f = dir.listFiles();
    	for(int i=0;i<f.length;i++){
    		if(f[i].isFile()){
    		    //System.out.println(f[i].getAbsolutePath());
    			boolean condition = f[i].getName().endsWith(".java")||f[i].getName().endsWith(".properties")
    					||f[i].getName().endsWith(".xml")||f[i].getName().endsWith(".jsp")||f[i].getName().endsWith(".css");
    			if(condition){
    				fileCount++;
    		        try {
    				    InputStream input = new FileInputStream(f[i]);
    				    BufferedReader b = new BufferedReader(new InputStreamReader(input));
    			        String value = b.readLine();
    			        if(value != null)
    			    	    while(value != null){
    			    		    value = b.readLine();
    			    		    count++;
    			    	    }
    			        b.close();
    			        input.close();
    			    } catch (FileNotFoundException e) {
    				    // TODO Auto-generated catch block
    				    e.printStackTrace();
    			    } catch (IOException e) {
    				    // TODO Auto-generated catch block
    				    e.printStackTrace();
    			    }
    			}
    		}
    		if(f[i].isDirectory()){
    			count+=getCodecount(f[i]);
    		}
    	}
    	
    	return count;
    }
}
