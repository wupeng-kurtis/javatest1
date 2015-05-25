package javaVersion;

import Settings.GlobalSettings;
import java.io.*;

import javaVersion.info.*;
import javaVersion.util.Generator;
import javaVersion.util.SellerCompiler;

public class GeneratorMain {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
     //   String s = null;  
     //   StringBuffer sb = new StringBuffer();  
     //   File f = new File("src/javaVersion/info/WelcomeInfo2.java");  
     //   if (f.exists()) {  
     //       try {  
     //           BufferedReader br =  
     //               new BufferedReader(new InputStreamReader(new FileInputStream(f)));  
     //           while ((s = br.readLine()) != null) {  
     //               sb.append(s);  
     //           }  
     //           System.out.println(sb);  
     //       } catch (Exception e) {  
     //           e.printStackTrace();  
     //       }  
     //   } else {  
     //   } 
		String key = "TestInfo";
		String descriptor = "welcome # # # #";
		String code = "varList.set(0, userInfo.getTime());\n";
        code += "varList.set(1, userInfo.getPhoneOS());\n";
        code += "varList.set(2, userInfo.getPhoneModel());\n";
        code += "varList.set(3, userInfo.getLocation());\n";
        code += "return 0;\n";
        SellerCompiler.compileInfo(key);
        SellerCompiler.generateInfo(key, descriptor, code);
		Class<?> ownClass = Class.forName("javaVersion.info."+key);
		Object obj = ownClass.newInstance();
		SellerInfo sellerInfo = (SellerInfo) obj;
		Generator.generate(sellerInfo,"/usr/local/tomcat/webapps/QRcode/"+key+".jpg");
	}
    public static String generateFromCode(String key, String descriptor, String code){
//        try {
            SellerCompiler.generateInfo(key, descriptor, code);
            SellerCompiler.compileInfo(key);
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
            SellerInfo sellerInfo;
            if(obj==null)
            {
                return "Class.forName Failed";
            }
            else
            {
                 sellerInfo= (SellerInfo) obj;
            }
            Generator.generate(sellerInfo, GlobalSettings.app_path+"\\web\\"+key+".jpg");
            // to Dex
            Runtime run = Runtime.getRuntime();
            //String cmd = "/usr/local/tomcat/webapps/QRcode/build-tools/android-4.4.2/dx --dex --output=/usr/local/tomcat/webapps/QRcode/AllSellerInfo.dex /usr/local/tomcat/webapps/QRcode/transfer/";
            String cmd = "E:\\softwares\\Android\\sdk\\build-tools\\22.0.1\\dx.bat --dex --output=E:\\mywebcode\\mytest\\AllSellerInfo.dex E:\\mywebcode\\mytest\\transfer\\";
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
            return "tohere";
//        } catch (InstantiationException inser) {
//            inser.printStackTrace();
//        } catch (ClassNotFoundException cner) {
//            cner.printStackTrace();
//        } catch (IllegalAccessException iler) {
//            iler.printStackTrace();
//        }
        //return "noresult";
    }
    public static void f() {
        return;
    }
}
