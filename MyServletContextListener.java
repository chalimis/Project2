import javax.servlet.*;

public class MyServletContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) 
	{
		ServletContext sc = event.getServletContext();

		String newurl = sc.getInitParameter("url");
		Redirect_info url = new Redirect_info(newurl);
		sc.setAttribute("redirect",url);
	}

	public void contextDestroyed(ServletContextEvent event) {}
}
