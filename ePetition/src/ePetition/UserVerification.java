package ePetition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.mysql.jdbc.PreparedStatement;

public class UserVerification {
		//Initialize database information
		private static Connection connect = null;
		private static String host="mysql.mcscw3.le.ac.uk";
		private static String database="odo6";
		private static String username="odo6";
		private static String DBpassword="usaigaid";

		//Database Connection
		public static Connection getConnection(){
			if(connect == null){
				try{
					Class.forName("com.mysql.jdbc.Driver");
					String conString="jdbc:mysql://"+host+"/"+database;
					Connection connect = DriverManager.getConnection(conString, username, DBpassword);
					return connect;
				}catch(Exception ex){
					return null;
				}
			}else{
				return connect;
			}

		}
		
		//Method that gets NIC
		public static int getNic(String Nic){
			int taken = 0;
			String sql = "SELECT * FROM NIC_RECORDS WHERE NIC=?";
			
			try(Connection connect= getConnection();
				PreparedStatement stmt = (PreparedStatement) connect.prepareStatement(sql);
				){
				stmt.setString(1, Nic);
				try(ResultSet rs = stmt.executeQuery();){
					while(rs.next()){
						taken=rs.getInt("USED");
					}
				}
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			return taken;
		}

		//Method that gets a list of all Petitions
		public static List<Petition> getAllPetitions(){
			ArrayList<Petition> list = new ArrayList<Petition>();

			try{
				Class.forName("com.mysql.jdbc.Driver");
				String conString="jdbc:mysql://"+host+"/"+database;
				connect=DriverManager.getConnection(conString, username, DBpassword);
				
				String sql="SELECT * FROM PETITIONS ";
				
				System.out.println(sql);
				
				PreparedStatement stmt = (PreparedStatement) connect.prepareStatement(sql);
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
			return list;
		}
		
		//Method that gets just one particular petition with parsed "id"
		public static Petition getPetition(String id){
			Petition p = null;

			try{
				Class.forName("com.mysql.jdbc.Driver");
				String conString="jdbc:mysql://"+host+"/"+database;
				connect=DriverManager.getConnection(conString, username, DBpassword);
				
				String sql="SELECT * FROM PETITIONS WHERE ID = ?";

				PreparedStatement stmt = (PreparedStatement) connect.prepareStatement(sql);
				stmt.setString(1, id);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()){
					int sign=rs.getInt("SIGN");
			    	String title=rs.getString("TITLE");
			    	String content=rs.getString("CONTENT");
			    	String date=rs.getString("DATE");
			    	String creator=rs.getString("CREATOR");
					p = new Petition(sign, id, title, content, date, creator);
				}
			}catch(Exception ex){
				System.out.println(ex.toString());
				ex.getStackTrace();
			}
			return p;
		}

		//Method to verify user is in database
		public User checkUser(String user, String password){
			String sql="SELECT * from USER WHERE Email=? AND PasswordHash=?";
			User u=null;
			try(Connection connect = getConnection();
				PreparedStatement pstmt = (PreparedStatement) connect.prepareStatement(sql);
				){
				pstmt.setString(1, user);
				pstmt.setString(2, HashGenerator.getSHA256((password)));
				
					try(ResultSet rs = pstmt.executeQuery();){
						while(rs.next()){
							String uname=rs.getString("Email");
							int position = rs.getInt("Position");
					    	String fname=rs.getString("FullName");
					    	String pass=rs.getString("PasswordHash");
							u = new User(position, uname, pass, fname);
							break;
						}
					}
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			return u;
		}

		public static void main(String [] args){
			UserVerification dbOperator=new UserVerification();
			System.out.println(dbOperator.checkUser("A1", "123"));
		}
		
		
}
