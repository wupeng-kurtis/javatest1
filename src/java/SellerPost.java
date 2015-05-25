import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.*;
import javaVersion.*;
import javax.servlet.annotation.WebServlet;
@WebServlet(urlPatterns = {"/SellerPost"})
//WebServlet设置很关键，否则tomcat不会启动该Servlet,记得修改这里！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
public class SellerPost extends HttpServlet {
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
        String code = req.getParameter("code");
        String key = req.getParameter("key");
        String descriptor = req.getParameter("descriptor");

        String result = GeneratorMain.generateFromCode(key, descriptor, code);
        
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
    public static void main(String[] args) {
        System.out.println("hello");
    }
}
