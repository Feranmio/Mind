package ePetition;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Comment")
public class Comment extends HttpServlet{

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
				
				//retrieve "id", "comment" and "mp" from front-end
				String id=req.getParameter("id");
				String comment=req.getParameter("comment");
				String by_mp=req.getParameter("mp");


					try{
						//Database Connection
						Class.forName("com.mysql.jdbc.Driver");
						String conString="jdbc:mysql://"+host+"/"+database;
						connect=DriverManager.getConnection(conString, username, DBpassword);

						//Inserts an MP's comment into the Comments table
						String sql="INSERT IGNORE INTO COMMENTS (ID, COMMENT, BY_MP) values(?,?,?)";
						System.out.println(sql);
						PreparedStatement stmt = connect.prepareStatement(sql);
						stmt.setString(1, id);
						stmt.setString(2, comment);
						stmt.setString(3, by_mp);
						stmt.executeUpdate();
					}catch(Exception ex){
						System.out.println(ex.toString());
						ex.getStackTrace();
					}
					res.sendRedirect("./ViewPetitions.jsp");
				}
		
		//Method to get all comments of a particualar petition with parsed "id" 
		public static List<CommentInfo> getComments(String id){
			ArrayList<CommentInfo> list = new ArrayList<CommentInfo>();

			try{
				//Database connection
				Class.forName("com.mysql.jdbc.Driver");
				String conString="jdbc:mysql://"+host+"/"+database;
				connect=DriverManager.getConnection(conString, username, DBpassword);

				//display all the comments of a particular petition
				String sql="SELECT * FROM COMMENTS WHERE ID = ?";

				PreparedStatement stmt = (PreparedStatement) connect.prepareStatement(sql);
				stmt.setString(1, id);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()){
					String comment =rs.getString("COMMENT");
			    	String by_mp=rs.getString("BY_MP");
					CommentInfo com = new CommentInfo(id, comment, by_mp);
					list.add(com);
				}
			}catch(Exception ex){
				System.out.println(ex.toString());
				ex.getStackTrace();
			}
			return list;
		}
}
