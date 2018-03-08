package labMVC;

//import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DbConfig {
		//information about accessing the Departmental MySQL server
		//https://campus.cs.le.ac.uk/labsupport/usinglinux/mysqlaccountdetails
		private String USERNAME = "odo6";
		private String PASSWORD = "usaigaid"; // in ~/.my.cnf
		
		//from campus
		//private String HOST = "mysql.mcscw3.le.ac.uk";
		//private int PORT = 3306;
		
		//off-campus: after executing 
		//ssh -fNg -L 3307:mysql.mcscw3.le.ac.uk:3306 odo6@xanthus.mcscw3.le.ac.uk
		private String HOST = "127.0.0.1";
		private int PORT = 3307;
					
	    @Bean
	    public DriverManagerDataSource dataSource() {		
	        DriverManagerDataSource ds = new DriverManagerDataSource();
	        ds.setDriverClassName("com.mysql.jdbc.Driver");
	        // jdbc:mysql://host:port/db
	        ds.setUrl("jdbc:mysql://" + HOST + ":" + PORT + "/" + USERNAME );
	        ds.setUsername(USERNAME);
	        ds.setPassword(PASSWORD);
	        return ds;
	    }
}