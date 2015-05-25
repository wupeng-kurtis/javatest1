/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javaVersion.GeneratorMain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kant
 */
@WebServlet(urlPatterns = {"/TicketPost"})
//WebServlet设置很关键，否则tomcat不会启动该Servlet
public class TicketPost extends HttpServlet {
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
        String descriptor = req.getParameter("descriptor");
        Vector<String> ticket_list = new Vector<String>(50);
        ticket_list.setSize(24);
        for(Integer i = 0; i < 24; ++i) {
            ticket_list.setElementAt(req.getParameter("t"+i.toString()), i);
        }

        String code = translateToCode(ticket_list);

        String result = GeneratorMain.generateFromCode(key, descriptor, code);
        //String result = GeneratorMain.generateFromCode(key, descriptor, code);
        
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
