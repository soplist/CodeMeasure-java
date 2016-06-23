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
    	hm.put("matlab", 0);
    	hm.put("fortran", 0);
    	hm.put("vbscript", 0);
    	hm.put("ada", 0);
    	hm.put("smalltalk", 0);
    	hm.put("lisp", 0);
    	hm.put("erlang", 0);
    	hm.put("haskell", 0);
    	hm.put("prolog", 0);
    	hm.put("rust", 0);
    	hm.put("scheme", 0);
    	hm.put("cobol", 0);
    	hm.put("D", 0);
    	hm.put("Go", 0);
    	hm.put("ActionScript", 0);
    	hm.put("ABAP", 0);//sap
    	hm.put("ML", 0);
    	hm.put("f#", 0);
    	hm.put("RPG", 0);//ibm os/400
    	hm.put("awk", 0);//linux
    	hm.put("cl", 0);//ibm os/400,control language
    	hm.put("dart", 0);//like javascript failed
    	hm.put("groovy", 0);
    	hm.put("foxpro", 0);//fox software,db product,microsoft
    	
    	/*will study*/
    	hm.put("labView", 0);//ni
    	hm.put("PostScript", 0);//print,interpress language,Forth language
    	hm.put("z shell", 0);//linux
    	hm.put("ladder logic", 0);//plc
    	hm.put("lo", 0);
    	hm.put("openEdge abl", 0);//progress,flow language
    	hm.put("assembly", 0);//MOV DS,AX
    	hm.put("scratch", 0);//MIT
    	hm.put("SAS", 0);//statistical analysis system
    	hm.put("logo", 0);//MIT,drawing
    	hm.put("inform", 0);
    	hm.put("cT", 0);
    	hm.put("max/msp", 0);//audio media
    	hm.put("PL/I", 0);//programming language one,ibm,like pascal
    	hm.put("javaFX script", 0);//sun
    	hm.put("boume shell", 0);
    	hm.put("s-lang", 0);//linux
    	hm.put("alice", 0);//AI
    	hm.put("Tcl/Tk", 0);//tool control language,linux
    	hm.put("NXT-G", 0);//graphical programming language for mindstorms NXT
    	hm.put("Caml/F#", 0);
    	hm.put("VHDL", 0);//Very-High-Speed Integrated Circuit Hardware Description Language
    	hm.put("natural", 0);
    	hm.put("icon", 0);//process string and structure
    	hm.put("prowerBasic", 0);//basic compiler,like QBasic and QuickBasic
    	hm.put("c shell", 0);
    	hm.put("AD", 0);
    	hm.put("clean", 0);//concurrent clean,functional programming language,like haskell
    	hm.put("progress 4gl", 0);
    	hm.put("apl", 0);//Array Processing Language
    	
    	//(Visual) FoxPro,4th Dimension/4D,ABC,Alice,Apex,Automator,
    	//Awk,Bash,bc,BlitzMax,Bourne shell,C shell,C-Omega,cg,CL(OS/400),
    	//Clean,Clojure,DiBOL,Emacs Lisp,Erlang,Factor,Forth,Icon,IDL,
    	//Inform,Ioke,J,Korn shell,Ladder Logic,M4,Mathematica,Monkey,Moto,
    	//NATURAL,NXT-G,OpenCL,Oxygene,Oz,PILOT,Programming Without Coding Technology,
    	//Pure Data,Rust,S,SIGNAL,SPARK,Standard ML,Tcl,TOM,VHDL,Z shell
    	
    	
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
    			
    			if(f[i].getName().endsWith(".m")||f[i].getName().endsWith(".mat")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"matlab",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".f90")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"fortran",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".vbs")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"vbscript",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".adb")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"ada",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".lisp")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"lisp",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".erl")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"erlang",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".hs")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"haskell",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".pl")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"prolog",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".rs")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"rust",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".scm")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"scheme",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".cbl")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"cobol",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".d")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"D",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".go")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"Go",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".fs")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"f#",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".dart")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"dart",f[i]);
    			}
    			
    			if(f[i].getName().endsWith(".groovy")){
    				operator(hmFileCountPerLanguage,hmCodeCountPerLanguage,"groovy",f[i]);
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
    			hmFileCountPerLanguage.put("matlab",hmFileCountPerLanguage.get("matlab")+hm1.get("matlab"));
    			hmFileCountPerLanguage.put("fortran",hmFileCountPerLanguage.get("fortran")+hm1.get("fortran"));
    			hmFileCountPerLanguage.put("vbscript",hmFileCountPerLanguage.get("vbscript")+hm1.get("vbscript"));
    			hmFileCountPerLanguage.put("ada",hmFileCountPerLanguage.get("ada")+hm1.get("ada"));
    			hmFileCountPerLanguage.put("smalltalk",hmFileCountPerLanguage.get("smalltalk")+hm1.get("smalltalk"));
    			hmFileCountPerLanguage.put("lisp",hmFileCountPerLanguage.get("lisp")+hm1.get("lisp"));
    			hmFileCountPerLanguage.put("erlang",hmFileCountPerLanguage.get("erlang")+hm1.get("erlang"));
    			hmFileCountPerLanguage.put("haskell",hmFileCountPerLanguage.get("haskell")+hm1.get("haskell"));
    			hmFileCountPerLanguage.put("prolog",hmFileCountPerLanguage.get("prolog")+hm1.get("prolog"));
    			hmFileCountPerLanguage.put("rust",hmFileCountPerLanguage.get("rust")+hm1.get("rust"));
    			hmFileCountPerLanguage.put("scheme",hmFileCountPerLanguage.get("scheme")+hm1.get("scheme"));
    			hmFileCountPerLanguage.put("cobol",hmFileCountPerLanguage.get("cobol")+hm1.get("cobol"));
    			hmFileCountPerLanguage.put("D",hmFileCountPerLanguage.get("D")+hm1.get("D"));
    			hmFileCountPerLanguage.put("Go",hmFileCountPerLanguage.get("Go")+hm1.get("Go"));
    			hmFileCountPerLanguage.put("f#",hmFileCountPerLanguage.get("f#")+hm1.get("f#"));
    			hmFileCountPerLanguage.put("dart",hmFileCountPerLanguage.get("dart")+hm1.get("dart"));
    			hmFileCountPerLanguage.put("groovy",hmFileCountPerLanguage.get("groovy")+hm1.get("groovy"));
    			
    	    	HashMap<String,Integer> hm2 = l1.get(1);
    	    	hmCodeCountPerLanguage.put("pascal",hmCodeCountPerLanguage.get("pascal")+hm2.get("pascal"));
    	    	hmCodeCountPerLanguage.put("ruby",hmCodeCountPerLanguage.get("ruby")+hm2.get("ruby"));
    	    	hmCodeCountPerLanguage.put("python",hmCodeCountPerLanguage.get("python")+hm2.get("python"));
    	    	hmCodeCountPerLanguage.put("scala",hmCodeCountPerLanguage.get("scala")+hm2.get("scala"));
    	    	hmCodeCountPerLanguage.put("perl",hmCodeCountPerLanguage.get("perl")+hm2.get("perl"));
    	    	hmCodeCountPerLanguage.put("lua",hmCodeCountPerLanguage.get("lua")+hm2.get("lua"));
    	    	hmCodeCountPerLanguage.put("php",hmCodeCountPerLanguage.get("php")+hm2.get("php"));
    	    	hmCodeCountPerLanguage.put("R",hmCodeCountPerLanguage.get("R")+hm2.get("R"));
    	    	hmCodeCountPerLanguage.put("matlab",hmCodeCountPerLanguage.get("matlab")+hm2.get("matlab"));
    	    	hmCodeCountPerLanguage.put("fortran",hmCodeCountPerLanguage.get("fortran")+hm2.get("fortran"));
    	    	hmCodeCountPerLanguage.put("vbscript",hmCodeCountPerLanguage.get("vbscript")+hm2.get("vbscript"));
    	    	hmCodeCountPerLanguage.put("ada",hmCodeCountPerLanguage.get("ada")+hm2.get("ada"));
    	    	hmCodeCountPerLanguage.put("smalltalk",hmCodeCountPerLanguage.get("smalltalk")+hm2.get("smalltalk"));
    	    	hmCodeCountPerLanguage.put("lisp",hmCodeCountPerLanguage.get("lisp")+hm2.get("lisp"));
    	    	hmCodeCountPerLanguage.put("erlang",hmCodeCountPerLanguage.get("erlang")+hm2.get("erlang"));
    	    	hmCodeCountPerLanguage.put("haskell",hmCodeCountPerLanguage.get("haskell")+hm2.get("haskell"));
    	    	hmCodeCountPerLanguage.put("prolog",hmCodeCountPerLanguage.get("prolog")+hm2.get("prolog"));
    	    	hmCodeCountPerLanguage.put("rust",hmCodeCountPerLanguage.get("rust")+hm2.get("rust"));
    	    	hmCodeCountPerLanguage.put("scheme",hmCodeCountPerLanguage.get("scheme")+hm2.get("scheme"));
    	    	hmCodeCountPerLanguage.put("cobol",hmCodeCountPerLanguage.get("cobol")+hm2.get("cobol"));
    	    	hmCodeCountPerLanguage.put("D",hmCodeCountPerLanguage.get("D")+hm2.get("D"));
    	    	hmCodeCountPerLanguage.put("Go",hmCodeCountPerLanguage.get("Go")+hm2.get("Go"));
    	    	hmCodeCountPerLanguage.put("f#",hmCodeCountPerLanguage.get("f#")+hm2.get("f#"));
    	    	hmCodeCountPerLanguage.put("dart",hmCodeCountPerLanguage.get("dart")+hm2.get("dart"));
    	    	hmCodeCountPerLanguage.put("groovy",hmCodeCountPerLanguage.get("groovy")+hm2.get("groovy"));
    		}
    	}
    	
    	list2.add(hmFileCountPerLanguage);
    	list2.add(hmCodeCountPerLanguage);
    	return list2;
    }
}

