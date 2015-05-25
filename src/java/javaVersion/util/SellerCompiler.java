package javaVersion.util;

import Settings.GlobalSettings;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import Settings.GlobalSettings;

public class SellerCompiler {
	public static String generateInfo(String key, String descriptor, String code) {
		String packageInfo = "package javaVersion.info; ";
		
		String header = "public class " + key + " extends SellerInfo { ";
		String constructer = "public " + key + "() { super( \"" + descriptor + "\", \"" + key + "\");} ";
		String overider = "public int updateByUserInfo(UserInfo userInfo) { " + code + "} }";
		String sourceCode = packageInfo+header+constructer+overider;
		
		String path = GlobalSettings.store_path+key+".java";
          
        try {  
            File f = new File(path);  
              
            if(!f.exists()) {
                f.createNewFile();
            }  
              
            BufferedWriter output = new BufferedWriter(new FileWriter(f));  
            output.write(sourceCode);  
            output.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 	
		/*
		JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = jc.getStandardFileManager(null, null, null);
		Location location = StandardLocation.CLASS_OUTPUT;
		File[] outputs = new File[]{new File("bin/")};
		try {
			fileManager.setLocation(location, Arrays.asList(outputs));
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		
		JavaFileObject jfo = new JavaSourceFromString("javaVersion.info."+key+"class", sourceCode);
		JavaFileObject[] jfos = new JavaFileObject[]{jfo};
		Iterable compilationUnits = Arrays.asList(jfos);		
		boolean b = jc.getTask(null, fileManager, null, null, null, compilationUnits).call();
		*/
		
		/*
		public class WelcomeInfo extends SellerInfo {
			public WelcomeInfo() {
				super("Good #!", "WelcomeInfo");
			}
			
			@Override
			public int updateByUserInfo(UserInfo userInfo) {
				varList.set(0, "QY");
				return 0;
			}
		}
		*/
        return path;
	}
	public static String compileInfo(String key) {
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            int result;
            //result = compiler.run(null, null, null, "/usr/local/tomcat/webapps/QRcode/src/javaVersion/info/"+key+".java", "-d", "/usr/local/tomcat/webapps/QRcode/WEB-INF/classes", "-classpath", "/usr/local/tomcat/webapps/QRcode/WEB-INF/classes"); 
            String arg1=GlobalSettings.app_path+"\\src\\java\\javaVersion\\info\\"+key+".java";
            String arg2=GlobalSettings.app_path+"\\build\\web\\WEB-INF\\classes";
            String arg3=GlobalSettings.app_path+"\\build\\web\\WEB-INF\\classes";
            result = compiler.run(null, null, System.out,arg1 , "-d",arg2 , "-classpath",arg3 ); 
            System.out.println((result == 0)?"Success":"failure");
		//result = compiler.run(null, null, null, "-source", "1.6", "-target", "1.6", "-d", "/usr/local/tomcat/webapps/QRcode/transfer", "-classpath", "/usr/local/tomcat/webapps/QRcode/WEB-INF/classes", "/usr/local/tomcat/webapps/QRcode/src/javaVersion/info/"+key+".java"); 
            arg1=GlobalSettings.app_path+"\\transfer";
            arg2=GlobalSettings.app_path+"\\build\\web\\WEB-INF\\classes";
            arg3=GlobalSettings.app_path+"\\src\\java\\javaVersion\\info\\"+key+".java";
            result = compiler.run(null, null, null, "-source", "1.7", "-target", "1.7", "-d",arg1 , "-classpath", arg2, arg3); 
            //注意，用"-source", "1.8", "-target", "1.8"会在调用dx把class转为dex的时候失败，好像zxing库不支持jdk1.8，生成的1.8的class不能转为dex
            System.out.println((result == 0)?"Success":"failure");

        if(result == 0) return "0";
        else return key;
	}
}
