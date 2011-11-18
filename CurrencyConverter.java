import java.io.*;
import java.lang.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;

public class CurrencyConverter extends HttpServlet {    
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        int i,j;
        String amount = req.getParameter("amount");
        String from = req.getParameter("from");
        String to = req.getParameter("to");
        String ch = req.getParameter("choice");
        String answer,answer1,answer2,answer3;

        if ("INFO".equals(ch)) {
		Redirect_info newurl = (Redirect_info) getServletContext().getAttribute("redirect");
		res.sendRedirect(newurl.getUrl());
	}
        else { 
		out.println("<html>");
		out.println("<title>Currency Converter</title>");
		String addr = "http://www.google.com/ig/calculator?hl=en&q="+amount+from+"=?"+to;
		URL convert = new URL(addr);
		BufferedReader in = new BufferedReader(new InputStreamReader(convert.openStream()));
		answer = in.readLine();
		answer = new String(answer.getBytes("ISO-8859-1"), "ISO-8859-7");
		from = new String(from.getBytes("ISO-8859-1"), "ISO-8859-7");
		to = new String(to.getBytes("ISO-8859-1"), "ISO-8859-7");
		amount = new String(amount.getBytes("ISO-8859-1"), "ISO-8859-7");
		
		in.close();
		i=answer.indexOf('"');
		answer=answer.substring(i+1);
		i=answer.indexOf('"');
		answer=answer.substring(i+1);
		i=answer.indexOf('"');
		answer=answer.substring(i+1);
		i=answer.indexOf('"');
		answer=answer.substring(0,i);
		out.println("<p ALIGN=CENTER>" + amount + " " + from +" == " + answer + "(" + to +")</p>");
		out.println("</body>");
		out.println("</html>");
           }
    }
}
