package com.mysuperscore.configuration;

//public class HelloWorldInitializer implements WebApplicationInitializer {
//
//	public void onStartup(ServletContext container) throws ServletException {
//
//		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//		ctx.register(HelloWorldConfiguration.class);
//		ctx.setServletContext(container);
//
//		ServletRegistration.Dynamic servlet = container.addServlet(
//				"dispatcher", new DispatcherServlet(ctx));
//
//		servlet.setLoadOnStartup(1);
//		servlet.addMapping("/");
//	}
//
//}

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class HelloWorldInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { HelloWorldConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}