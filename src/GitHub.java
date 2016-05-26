
public class GitHub {
	public static String[] initLanguage(){
		String[] githubLanguages = {"Actionscript","Ada","Agda","Android","AppEngine","AppceleratorTitanium","ArchLinuxPackages",
                "Autotools","Bancha","C","C++","CFWheels","CMake","CUDA","CakePHP","ChefCookbook","Clojure",
                "CodeIgniter","CommonLisp","Composer","Concrete5","Coq","CraftCMS","D","DM","Dart","Delphi",
                "Drupal","EPiServer","Eagle","Elisp","Elixir","Elm","Erlang","ExpressionEngine","ExtJS-MVC",
                "ExtJs","Fancy","Finale","ForceDotCom","Fortran","FuelPHP","GWT","GitBook","Go","Gradle","Grails",
                "Haskell","IGORPro","Idris","Java","Jboss","Jekyll","Joomla","Jython","KiCAD","Kohana","LabVIEW",
                "Laravel","Leiningen","LemonStand","Lilypond","Lithium","Lua","Magento","Maven","Mercury","MetaProgrammingSystem",
                "Meteor","Nim","Node","OCaml","Objective-C","Opa","OracleForms","Packer","Perl","Phalcon","PlayFramework",
                "Plone","Prestashop","Processing","Python","Qooxdoo","Qt","R","ROS","Rails","RhodesRhomobile","Ruby",
                "Rust","SCons","Sass","Scala","Scrivener","Sdcc","SeamGen","SketchUp","SugarCRM","Swift","Symfony",
                "SymphonyCMS","Target3001","Tasm","TeX","Textpattern","TurboGears2","Typo3","Umbraco","Unity",
                "UnrealEngine","VVVV","VisualStudio","Waf","WordPress","Xojo","Yeoman","Yii","ZendFramework",
                "Zephir","gcov","nanoc","opencart","stella"};

		return githubLanguages;
	}
	
	public static int findLocationfromLanguages(String name,String[] languages){
		for(int i=1;i<=languages.length;i++){
			String lang = languages[i-1];
			if(lang.equals(name)){
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] langs = initLanguage();
        
        String find_1 = "stella";
        String find_2 = "dog";
        int location_1 = findLocationfromLanguages(find_1,langs);
        int location_2 = findLocationfromLanguages(find_2,langs);
        
        System.out.println("the number of languages is "+langs.length+".");
        System.out.println(find_1+" location is "+location_1+".");
        System.out.println(find_2+" location is "+location_2+".");
    }

}
