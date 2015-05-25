/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Settings.GlobalSettings;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javaVersion.GeneratorMain;
import javaVersion.info.SellerInfo;
import javaVersion.util.Generator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 *
 * @author Kant
 */
@WebServlet(urlPatterns = {"/RuleInfoPost"})
//WebServlet设置很关键，否则tomcat不会启动该Servlet,记得修改这里！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
public class RuleInfoPost extends HttpServlet {
    @Override protected void doGet(HttpServletRequest req, 
            HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter out = resp.getWriter();
     //   FileOutputStream fos = null;
     //   BufferedWriter bw = null;
     //   try {
     //       File file = new File("output.txt");
     //       fos = new FileOutputStream(file);
     //       bw = new BufferedWriter(new OutputStreamWriter(fos));
     //       bw.write("here");
     //   } catch (FileNotFoundException fnfe) {
     //       fnfe.printStackTrace();
     //   } catch (IOException ioe) {
     //       ioe.printStackTrace();
     //   } finally {
     //       if(bw != null) bw.close();
     //       if(fos != null) fos.close();
     //   }
        String key = req.getParameter("key");
        String descriptor=req.getParameter("descriptor");
        String rules_cnt_str=req.getParameter("rules_cnt");
        int rules_cnt=Integer.valueOf(rules_cnt_str);
        String code="";
        code+="\n";
//        code+="String tmp_key1;\n";
//        code+="String tmp_val1;\n";
        //code+="TreeMap<Integer,String> tmp1;\n";
        for(Integer i=1;i<=rules_cnt;i++)
        {
            String tmp_str1=req.getParameter("rule"+i.toString());
            String cur_rule=new String(tmp_str1.getBytes("iso-8859-1"),"utf-8");
            
            code+="varList.add("+"\""+cur_rule+"\""+");\n";
            //String [] cur_rule_group=cur_rule.split("&");
            
    //        code+="userData=new TreeMap<>();\n";
//            code+="tmp_key1=\""+"time_start"+"\";\n";
//            code+="tmp_val1="+"\""+cur_rule_group[0]+"\""+";\n";
//            code+="tmp1=new TreeMap<>();\n";
//            code+="tmp1.put("+(i).toString()+", tmp_val1);\n";
//            code+="sellerData.put(tmp_key1, tmp1);\n";
//            
//            code+="tmp_key1=\""+"time_end"+"\";\n";
//            code+="tmp_val1="+"\""+cur_rule_group[1]+"\""+";\n";
//            code+="tmp1=new TreeMap<>();\n";
//            code+="tmp1.put("+(i).toString()+", tmp_val1);\n";
//            code+="sellerData.put(tmp_key1, tmp1);\n";
//            
//            code+="tmp_key1=\""+"altitude"+"\";\n";
//            code+="tmp_val1="+"\""+cur_rule_group[2]+"\""+";\n";
//            code+="tmp1=new TreeMap<>();\n";
//            code+="tmp1.put("+(i).toString()+", tmp_val1);\n";
//            code+="sellerData.put(tmp_key1, tmp1);\n";
//            
//            code+="tmp_key1=\""+"light_intensity"+"\";\n";
//            code+="tmp_val1="+"\""+cur_rule_group[3]+"\""+";\n";
//            code+="tmp1=new TreeMap<>();\n";
//            code+="tmp1.put("+(i).toString()+", tmp_val1);\n";
//            code+="sellerData.put(tmp_key1, tmp1);\n";
//            
//            code+="tmp_key1=\""+"temperature"+"\";\n";
//            code+="tmp_val1="+"\""+cur_rule_group[4]+"\""+";\n";
//            code+="tmp1=new TreeMap<>();\n";
//            code+="tmp1.put("+(i).toString()+", tmp_val1);\n";
//            code+="sellerData.put(tmp_key1, tmp1);\n";
//            
//            code+="tmp_key1=\""+"location"+"\";\n";
//            code+="tmp_val1="+"\""+cur_rule_group[5]+"\""+";\n";
//            code+="tmp1=new TreeMap<>();\n";
//            code+="tmp1.put("+(i).toString()+", tmp_val1);\n";
//            code+="sellerData.put(tmp_key1, tmp1);\n";
            
//            code+="tmp_key1=\""+"values"+"\";\n";
//            code+="tmp_val1="+"\""+cur_rule_group[6]+"\""+";\n";
//            code+="tmp1=new TreeMap<>();\n";
//            code+="tmp1.put("+(i).toString()+", tmp_val1);\n";
//            code+="sellerData.put(tmp_key1, tmp1);\n";
            
            
            
        }
        code+="return 0;\n";
//        String timefromval1 = req.getParameter("timefromval1");
//        String timetoval1 = req.getParameter("timetoval1");
//        String altival1 = req.getParameter("altival1");
//        String lightval1 = req.getParameter("lightval1");
//        String tempval1 = req.getParameter("tempval1");
//        String locaval1 = req.getParameter("locaval1");
        

        //String shit=req.toString();
        //timefromval1=asd&timetoval1=asd&altival1=4&lightval1=2&tempval1=2&locaval1=undefined
        Vector<String> ticket_list = new Vector<String>(50);
        ticket_list.setSize(24);
        for(Integer i = 0; i < 24; ++i) {
            ticket_list.setElementAt(req.getParameter("t"+i.toString()), i);
        }
        String func_set="";
//        String code="return 0;";

        //String code = translateToCode(ticket_list);
//        func_set+="String timefromval="+"\""+timefromval1+"\""+";"+"\n";
//        func_set+="String timetoval1="+"\""+timetoval1+"\""+";"+"\n";
//        func_set+="String altival1="+"\""+altival1+"\""+";"+"\n";
//        func_set+="String lightval1="+"\""+lightval1+"\""+";"+"\n";
//        func_set+="String tempval1="+"\""+tempval1+"\""+";"+"\n";
//        func_set+="String locaval1="+"\""+locaval1+"\""+";"+"\n";
        
//        func_set+="\n public String "+"timefromval1"+"(){return "+"\""+timefromval1+"\""+";}\n";
        RuleInfoCompiler.generateInfo(key, descriptor, code, func_set);
        RuleInfoCompiler.compileInfo(key);
        //String result = GeneratorMain.generateFromCode(key, descriptor, code);
        Object obj=null;
        try
        {
            Class ownClass = Class.forName("javaVersion.info."+key);//报告Uncompilable source code,经过替换文件发现反复尝试，只要是生成的aaa.java就不行
            //最后发现只要在SellerInfo里是forName（String arg)会默认调用初始化newInstance(),但是
            //Class ownClass = Class.forName("javaVersion.info.myblank");//可以通过
            //Class ownClass = Class.forName("shit"); //报告ClassNotFound
            //Class ownClass = Class.forName("java.lang.Thread");
            obj= ownClass.newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("---------------------------\n");
            System.out.print(e);
        }
        SellerInfo sellerInfo=null;
        if(obj==null)
        {
        }
        else
        {
             sellerInfo= (SellerInfo) obj;
        }
        Generator.generate(sellerInfo, GlobalSettings.app_path+"\\web\\"+key+".jpg");
        // to Dex
        Runtime run = Runtime.getRuntime();
        //String cmd = "/usr/local/tomcat/webapps/QRcode/build-tools/android-4.4.2/dx --dex --output=/usr/local/tomcat/webapps/QRcode/AllSellerInfo.dex /usr/local/tomcat/webapps/QRcode/transfer/";
        String cmd = "E:\\softwares\\Android\\sdk\\build-tools\\22.0.1\\dx.bat --dex --output=E:\\mywebcode\\mytest\\RuleInfo.dex E:\\mywebcode\\mytest\\transfer\\";
        try {
            Process p = run.exec(cmd);
            if(p.waitFor() != 0) {
                if(p.exitValue() == 1) {
                    System.err.println("Fail!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //result = req.getRealPath("test.txt");
        //GeneratorMain.f();
        //out.println(code);
        //out.println(key);
        //out.println(descriptor);

     //   out.println(result + "finished!");

        resp.setContentType("text/html");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>QR code></title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p><img src=\""+key+".jpg\" /></p>");
     //   out.println("<p> sdsd" + result + "</p>");
        out.println("</body>");
        out.println("</html>");


    }
    
    @Override protected void doPost(HttpServletRequest req, 
            HttpServletResponse resp) throws ServletException, IOException {
        //PrintWriter out = resp.getWriter();
        //out.write("hello");
        doGet(req, resp);
    }

    private String translateToCode(Vector<String> list) {
        String code = "int hour = userInfo.getHour();\n";
        for(int i = 0; i < 24; ++i) {
            code += "if (hour == " + i + ") varList.set(0, \"" + list.elementAt(i) + "\");\n";
        }
        code += "return 0;\n";
        return code;
    }
    
    public static void main(String[] args) {
        System.out.println("hello");
    }
}
class RuleInfoCompiler {
	public static String generateInfo(String key, String descriptor, String code,String func_set) {
		String packageInfo = "package javaVersion.info; \n";
		packageInfo+="import java.util.TreeMap;\n";
		String header = "public class " + key + " extends SellerInfo { ";
		String constructer = "public " + key + "() { super( \"" + descriptor + "\", \"" + key + "\");} ";
		String overider = "public int updateByUserInfo(UserInfo userInfo) { " + code + "} ";
		String sourceCode = packageInfo+header+constructer+overider;
		sourceCode+=func_set+"\n}";
                
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
