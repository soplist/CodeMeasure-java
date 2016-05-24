import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class MinorityComputerLanguagesGet {
    public static void main(String[] args) {
		
		String path = "D:/wangkang/file/LocalRepository";
		//String path = "D:/wangkang/mis_20160510/mis/src/com/jingrui/action";
		//String path = "D:/test";
		File file = new File(path);
		ArrayList<HashMap<String,Integer>> res = getCodeAndFilecount(file);
		printRes(res);
	}
    
    public static void printRes(ArrayList<HashMap<String,Integer>> res){
    	HashMap<String,Integer> res1 = res.get(0);
    	HashMap<String,Integer> res2 =res.get(1);
    	
    	Iterator iter1 = res1.entrySet().iterator();
    	Iterator iter2 = res2.entrySet().iterator();
    	int i=0;
    	int j=0;
    	while (iter1.hasNext()) {
    		i++;
    	    Map.Entry entry = (Map.Entry) iter1.next();
    	    Object key = entry.getKey();
    	    Object val = entry.getValue();
    	    System.out.println(i+".file num:"+key+":"+val);
    	}
    	while (iter2.hasNext()) {
    		j++;
    	    Map.Entry entry = (Map.Entry) iter2.next();
    	    Object key = entry.getKey();
    	    Object val = entry.getValue();
    	    System.out.println(j+".code num:"+key+":"+val);
    	}
    }
    
    public static HashMap<String,Integer> initMsp(){
    	HashMap<String,Integer> hm = new HashMap<String,Integer>();
    	hm.put("pascal", 0);
    	hm.put("ruby", 0);
    	hm.put("python", 0);
    	hm.put("scala", 0);
    	hm.put("perl", 0);
    	hm.put("lua", 0);
    	hm.put("php", 0);
    	hm.put("R", 0);
    	return hm;
    }
    
    public static void operator(HashMap<String,Integer> hm1,HashMap<String,Integer> hm2,String key,File f){
    	Integer f1 = hm1.get(key);
    	hm1.put(key, f1+1);
		
		Integer c1 = hm2.get(key);
        try {
		    InputStream input = new FileInputStream(f);
		    BufferedReader b = new BufferedReader(new InputStreamReader(input));
	        String value = b.readLine();
	        if(value != null)
	    	    while(value != null){
	    		    value = b.readLine();
	    		    c1++;
	    	    }
	        hm2.put(key, c1);
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
    
    public static ArrayList<HashMap<String,Integer>> getCodeAndFilecount(File dir){
    	ArrayList<HashMap<String,Integer>> list2 = new ArrayList<HashMap<String,Integer>>();
    	
    	HashMap<String,Integer> hmFileCountPerLanguage = initMsp();
    	HashMap<String,Integer> hmCodeCountPerLanguage = initMsp();
    	
    	File[] f = dir.listFiles();
    	for(int i=0;i<f.length;i++){
    		if(f[i].isFile()){
    			
                if(f[i].getName().endsWith(".pas")){
                	operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"pascal",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".rb")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"ruby",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".py")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"python",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".scala")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"scala",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".perl")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"perl",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".lua")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"lua",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".php")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"php",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".Rhistory")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"R",f[i]);
    			}
    		}
    		if(f[i].isDirectory()){
    			ArrayList<HashMap<String,Integer>> l1 = getCodeAndFilecount(f[i]);
    			
    			HashMap<String,Integer> hm1 = l1.get(0);
    			hmFileCountPerLanguage.put("pascal",hmFileCountPerLanguage.get("pascal")+hm1.get("pascal"));
    			hmFileCountPerLanguage.put("ruby",hmFileCountPerLanguage.get("ruby")+hm1.get("ruby"));
    			hmFileCountPerLanguage.put("python",hmFileCountPerLanguage.get("python")+hm1.get("python"));
    			hmFileCountPerLanguage.put("scala",hmFileCountPerLanguage.get("scala")+hm1.get("scala"));
    			hmFileCountPerLanguage.put("perl",hmFileCountPerLanguage.get("perl")+hm1.get("perl"));
    			hmFileCountPerLanguage.put("lua",hmFileCountPerLanguage.get("lua")+hm1.get("lua"));
    			hmFileCountPerLanguage.put("php",hmFileCountPerLanguage.get("php")+hm1.get("php"));
    			hmFileCountPerLanguage.put("R",hmFileCountPerLanguage.get("R")+hm1.get("R"));
    			
    	    	HashMap<String,Integer> hm2 = l1.get(1);
    	    	hmCodeCountPerLanguage.put("pascal",hmCodeCountPerLanguage.get("pascal")+hm2.get("pascal"));
    	    	hmCodeCountPerLanguage.put("ruby",hmCodeCountPerLanguage.get("ruby")+hm2.get("ruby"));
    	    	hmCodeCountPerLanguage.put("python",hmCodeCountPerLanguage.get("python")+hm2.get("python"));
    	    	hmCodeCountPerLanguage.put("scala",hmCodeCountPerLanguage.get("scala")+hm2.get("scala"));
    	    	hmCodeCountPerLanguage.put("perl",hmCodeCountPerLanguage.get("perl")+hm2.get("perl"));
    	    	hmCodeCountPerLanguage.put("lua",hmCodeCountPerLanguage.get("lua")+hm2.get("lua"));
    	    	hmCodeCountPerLanguage.put("php",hmCodeCountPerLanguage.get("php")+hm2.get("php"));
    	    	hmCodeCountPerLanguage.put("R",hmCodeCountPerLanguage.get("R")+hm2.get("R"));
    		}
    	}
    	
    	list2.add(hmFileCountPerLanguage);
    	list2.add(hmCodeCountPerLanguage);
    	return list2;
    }
}

