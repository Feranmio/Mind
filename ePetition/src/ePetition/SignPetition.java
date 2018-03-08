package ePetition;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignPetition")
public class SignPetition extends HttpServlet{

	//Initialize database information
	private static Connection connect = null;
	private static String host="mysql.mcscw3.le.ac.uk";
	private static String database="odo6";
	private static String username="odo6";
	private static String DBpassword="usaigaid";

	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		res.getContentType();
		PrintWriter out = res.getWriter();
	
		//Retrieve user and petition from front-end
		String signer=req.getParameter("user");
		String petition=req.getParameter("petition");

		try{
			//Database Connection
			Class.forName("com.mysql.jdbc.Driver");
			String conString="jdbc:mysql://"+host+"/"+database;
			connect=DriverManager.getConnection(conString, username, DBpassword);

			//Checks if user has already signed
			String sql2 = "SELECT * FROM SIGNED_PETITION WHERE SIGNER=? AND PETITION=?";
			PreparedStatement ps = connect.prepareStatement(sql2);
			ps.setString(1, signer);
			ps.setString(2, petition);
			ResultSet rs=ps.executeQuery();
			
			//Allows a user to sign Petition if they haven't already signed
			if(!rs.next()){
			String sql= "INSERT INTO SIGNED_PETITION (PETITION, SIGNER) values (?,?)";
			PreparedStatement stmt = connect.prepareStatement(sql);
			stmt.setString(1, petition);
			stmt.setString(2, signer);
			stmt.executeUpdate();
			
			//Updates the table for signed petitions
			sql = "UPDATE PETITIONS SET Sign=Sign+1 WHERE TITLE=?";
			stmt = connect.prepareStatement(sql);
			stmt.setString(1, petition);
			stmt.executeUpdate();

			}
		}catch(Exception ex){
				System.out.println(ex.toString());
				ex.getStackTrace();
		}
			res.sendRedirect("./ViewPetitions.jsp");
	}
}
