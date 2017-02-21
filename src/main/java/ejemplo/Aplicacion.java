package ejemplo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class Aplicacion implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
<<<<<<< HEAD
		webApplicationContext.setConfigLocation("ejemplo.configuracion");
=======
		webApplicationContext.setConfigLocation("ejemplo.config");
>>>>>>> 89adaa286c8672b5b9c04ba1eb960eb48ef93b6c
		
		Dynamic appServlet = servletContext.addServlet("appServlet", new DispatcherServlet(webApplicationContext));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/");

		servletContext.addListener(new ContextLoaderListener(webApplicationContext));
	}
	
}
