<link rel='stylesheet' href='web/swiss.css'/>

# (:star:) Spring MVC: Exercise 01

In this exercise, we are going to build a Java web application from scratch using Spring MVC and Spring Boot.

In constrast to Pluralsight videos, we are using Gradle and Java configuration for bootstrapping the web application, which reduces the configuration effort.

In this exercise, you are offered two paths to solve it: 
* the direct way, in which the project is already configured for you on GitHub, you only have to fetch it, explore its structure and complete the code; and
* the hard way, in which you can follow all the steps in the tutorial and build your first web application from scratch.

For the hard way, jump to section [Setting the MVC infrastructure (the hard way)](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint2/SpringMvc_ex01#setting-the-mvc-infrastructure-the-hard-way). Otherwise, keep on reading.

## Setting the MVC infrastructure (the direct way)
* Pull the last commit from the main repository on GitHub and import the project `sprint2/SpringMvc_ex01` as an **Eclipse project** in the STS.
* From the terminal console (either in the STS or from a terminal) run the gradle command `./gradlew eclipse`
* In the STS, select the project in the package explorer (Java perspective), right click and refresh.

The application has the following structure:

		├── build.gradle
		├── src
		    ├── main
		        ├── java
		        │   └── labMVC
		        │       ├── IndexController.java : needs code (exercise)
		        │       ├── LabMvcApplication.java
		        │       └── WebConfig.java
		        ├── resources
		        │   └── application.properties : needs code (exercise)
		        └── webapp
		            └── WEB-INF
		                └── views
		                    └── hello.jsp

where:
* `src/main/java/labMVC/LabMvcApplication.java`: main entry point of your Java web application
* `src/main/java/labMVC/WebConfig.java`: substitutes the XML configuration using beans, indicates what view technology to use and where static resources (HTML pages) can be found
* `src/main/java/labMVC/IndexController.java`: the heart and soul of your application, handles requests
* `src/main/resources/application.properties`: configuration parameters (e.g. the server port)
* `src/main/webapp/WEB-INF/views/`: folder where your views are stored (in this case JSP files)

In this exercise, you only need to configure the controller and the port. In order to find out more about specific details of the other files please keep on reading the section on the hard way.

### Controller: responding to requests

The controller defines what to do when a request is defined and it does so by using:

* a request mapping, mapping a url to a method. For example, to define that we want to intercept the request `http://localhost/hello` we could add the following code: 

		@RequestMapping("/hello")
	
* a method implementing what to do when the request is received. For example, we could add an attribute `name` to the model and display it in the view `hello.jsp` as follows:

	    public String hello(Model model) {
	        model.addAttribute("name", "World");
	        return "hello";
	    }   


### Setting up the port 

The file `src/main/resources/application.properties` is used to configure parameters of your Spring Boot application. Let's start by configuring the port at which HTTP requests should be received. Add the following line in this file:

		server.port=8090
		

### Running the web application

* Run the application from a terminal console with

		./gradlew bootRun
		
* In a browser go to [http://localhost:8090/hello](http://localhost:8090/hello)
* Terminate the web application graciously with `CTRL-C` in the terminal console



## Setting the MVC infrastructure (the hard way) 

### Configuring your application

* Create a New Spring Starter Project: give it a name; select the option `Gradle`; select the dependency `Web` (from section `Web`).
* Since we are using JSPs to render views we have to use a JSP processor. Add [Jasper](https://en.wikipedia.org/wiki/Apache_Tomcat#Jasper) and [JSP Standard Tag Library (JSTL)](https://jstl.java.net) dependencies to the gradle build file `build.gradle`:

		compile("org.apache.tomcat.embed:tomcat-embed-jasper:9.0.0.M11")
		compile("javax.servlet:jstl:1.2")
		
* Create a folder `src/main/webapp`, which is the root folder for the resources of your web application. Create the following subfolders `WEB-INF/views/` in it.
* In folder `src/main/java/yourpackage/`, create a class `WebConfig.java`: define it as a configuration class by tagging it with the annotation `@Configuration` and define it as a specialized class of the class `WebMvcConfigurerAdapter` by adding `extends WebMvcConfigurerAdapter` to the class declaration and add the following code to the application class 

		package labMVC;
		
		import org.springframework.context.annotation.Bean;
		import org.springframework.context.annotation.Configuration;
		import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
		import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
		import org.springframework.web.servlet.view.InternalResourceViewResolver;
		import org.springframework.web.servlet.view.JstlView;
		
		@Configuration
		public class WebConfig extends WebMvcConfigurerAdapter {
			// Handles HTTP GET requests for /resources/** by efficiently serving up static 
				// resources in the ${webappRoot}/resources/ directory
				@Override
				public void addResourceHandlers(ResourceHandlerRegistry registry) {
					registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
				}
				  
				//Resolves views selected for rendering by @Controllers to .jsp resources in the 
				// /WEB-INF/views directory
				@Bean
				public InternalResourceViewResolver viewResolver() {
					InternalResourceViewResolver viewResolver = 
			                        new InternalResourceViewResolver();
					viewResolver.setViewClass(JstlView.class);
					viewResolver.setPrefix("/WEB-INF/views/");
					viewResolver.setSuffix(".jsp");
					viewResolver.setOrder(2);
					return viewResolver;
				}
		}
			
* Configure the port, say 8090 for example, where your application will listen HTTP requests, by adding `server.port=8090` (by default this is 8080) to file `src/main/resources/application.properties`.

### Developing a web controller

In folder `src/main/java/yourpackage/`, create a Java class for your web controller with the following contents:

		@Controller
		public class IndexController {
		    @RequestMapping("/hello")
		    public String hello(Model model) {
		        model.addAttribute("name", "World");
		        return "hello";
		    }
		}

Resolve any import clauses with the help of your IDE (with `CTRL+SHIFT+O`). In the code above:
* `@RequestMapping("/hello")` maps an HTTP request `/hello` to the method `hello()`;
* The parameter `Model model` (always to be put at the end of the parameter list in case there are more parameters) allows the controller to send information to the view;
* `model.addAttribute("name", "World");` sets the attribute `name` in the model;
* `return "hello";` indicates that the JSP that produces the resulting view is `hello`.

### Developing a simple view in JSP

In this step we are going to create a simple view with [Java Server Pages (JSP)](https://en.wikipedia.org/wiki/JavaServer_Pages). Create a file `hello.jsp` in folder `src/main/webapp/WEB-INF/views/` with the following contents:

		<!DOCTYPE HTML>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<html lang="en">
		<head> 
		    <title>JSP output</title> 
		    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		</head>
		<body>
			<p>Hello, ${name} !</p>
		</body>
		</html>

In the example above, the directive `&lt;%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"% &gt;` says that this HTML page contains JSP code. The only non-HTML code is the expression `${name}` that is used to fetch the value of the attribute `name` in the model as set by our web controller.

That's it! Your application is ready!

### Running the web application

* Run the application from a terminal console with

		./gradle bootRun
		
* In a browser go to [http://localhost:8090/hello](http://localhost:8090/hello)
* Terminate the web application graciously with `CTRL-C` in the terminal console

### Deploying the web application

Build an executable jar with the following command on the terminal console

		./gradle bootRepackage
		
The resulting jar file is a fat jar that contains all the libraries that are needed to execute the application. This file is produced in folder */build/libs* and can be copied and distributed how you prefer (e.g. by using a cloud platform). To execute the application using the jar file, just use the typical command

		java -jar <your project name>.jar 

## Additional Resources

* [MVC Framework tutorial](http://www.tutorialspoint.com/spring/spring_web_mvc_framework.htm)

***
&copy; Artur Boronat, 2016
