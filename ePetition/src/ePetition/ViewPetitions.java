package ePetition;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewPetitions")
public class ViewPetitions extends HttpServlet{
	
	//Initialize database information
	private static Connection connect = null;
	private static String host="mysql.mcscw3.le.ac.uk";
	private static String database="odo6";
	private static String username="odo6";
	private static String DBpassword="usaigaid";
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	res.getContentType();
	PrintWriter out = res.getWriter();
	res.setContentType("text/html");
	ArrayList<Petition> list = new ArrayList<Petition>();

		try{
			//Database connection
			Class.forName("com.mysql.jdbc.Driver");
			String conString="jdbc:mysql://"+host+"/"+database;
			connect=DriverManager.getConnection(conString, username, DBpassword);
			
			//Selects all petitions in the database
			String sql="SELECT * FROM PETITIONS";
			System.out.println(sql);
			
			PreparedStatement stmt = connect.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				int sign=rs.getInt("SIGN");
		    	String id=rs.getString("ID");
		    	String title=rs.getString("TITLE");
		    	String content=rs.getString("CONTENT");
		    	String date=rs.getString("DATE");
		    	String creator=rs.getString("CREATOR");
				Petition p = new Petition(sign, id, title, content, date, creator);
				list.add(p);
			}
		}catch(Exception ex){
			System.out.println(ex.toString());
			ex.getStackTrace();
		}
		out.close();
		
		res.sendRedirect("./ViewPetitions.jsp?list="+list);

	}

}
