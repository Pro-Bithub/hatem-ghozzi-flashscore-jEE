package db;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class modeluser  {
	public connections cnx;
	public 	List<user> users;
	public user userbyuserid ;
	public  modeluser() {
		cnx = new connections();
		
	
	}
	public Boolean deleteuser(int id){
		try{
	    	
	    	
			

			PreparedStatement ps = cnx.conn.prepareStatement("DELETE FROM public.users where userid=?");
			
			ps.setInt(1, id);

			int rs = ps.executeUpdate();
			if(rs >0)
	          return true;
			else
				  return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public Boolean	updateUser(String name , String password,String type,int userid) {
		try{
	    	
	    	
		

			PreparedStatement ps = cnx.conn.prepareStatement("UPDATE  public.users SET name=?, password=?, type=? WHERE userid="+userid+"");
			
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, type);
			int rs = ps.executeUpdate();
			if(rs >0)
	          return true;
			else
				  return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
public Boolean insertUser(String name , String password) {
	try{
    	
    	
		

		PreparedStatement ps = cnx.conn.prepareStatement("INSERT INTO public.users(name, password) VALUES (?, ?)");
		
		ps.setString(1, name);
		ps.setString(2, password);
		int rs = ps.executeUpdate();
		if(rs >0)
          return true;
		else
			  return false;
	}catch(Exception e){
		e.printStackTrace();
		return false;
	}
}
	
public String FetchTypeUserByNameandPassword(String name , String password) {
		
		try {
			// String query = "SELECT * FROM users where name="+name+" and password="+password;
			String query = "SELECT * FROM users where name='"+name+"' and password='"+password+"'";
			// create the java statement
		    Statement st = cnx.conn.createStatement();
		    
		    //set this values using PreparedStatement
	        ResultSet results = st.executeQuery(query); //where ps is Object of PreparedStatement

	        if(!results.next()) {

	        	st.close();
	            return "NOUSER";
	        }
	        String type = results.getString("type");
	        st.close();
	        return type;
	        
		  
		      
		      
		      
		}catch (SQLException e) {
			cnx.setMsg(e.getMessage());
			   return "NOUSER";
		}
		
	}

	public Boolean FetchUserByNameandPassword(String name , String password) {
		
		try {
			// String query = "SELECT * FROM users where name="+name+" and password="+password;
			String query = "SELECT * FROM users where name='"+name+"' and password='"+password+"'";
			// create the java statement
		    Statement st = cnx.conn.createStatement();
		    
		    //set this values using PreparedStatement
	        ResultSet results = st.executeQuery(query); //where ps is Object of PreparedStatement

	        if(!results.next()) {

	        	st.close();
	            return false;
	        }
	        st.close();
	        return true;
	        
		  
		      
		      
		      
		}catch (SQLException e) {
			cnx.setMsg(e.getMessage());
			 return false; 
		}
		
	}
	public int fetchuserbyname(String name) {
		try {
			// String query = "SELECT * FROM users where name="+name+" and password="+password;
			String query = "SELECT userid FROM users where name='"+name+"' ";
			// create the java statement
		    Statement st = cnx.conn.createStatement();
		    
		    //set this values using PreparedStatement
	        ResultSet results = st.executeQuery(query); //where ps is Object of PreparedStatement

	        if(!results.next()) {

	        	st.close();
	            return 0;
	        }
	        int userid = results.getInt("userid");
	        st.close();
	        return userid;
	        
		  
		      
		      
		      
		}catch (SQLException e) {
			cnx.setMsg(e.getMessage());
			 return 0; 
		}
		
	}
	
	public void fetchuserbyid(int userid) {
		
		try {
			String query = "SELECT * FROM users where userid="+userid+"";
			// create the java statement
		    Statement st = cnx.conn.createStatement();
		    
		    // execute the query
		      ResultSet rs = st.executeQuery(query);
		      
		      
		   // iterate through the java 
		      while (rs.next())
		      {
		    	  int useridd = rs.getInt("userid");
		   
		        String name = rs.getString("name");
		        String password = rs.getString("password");
		        String type = rs.getString("type");
		       
		        userbyuserid=new user(name,password,type,useridd) ;
		  
		        // print the results
		       // System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
		      }
		      st.close();
		      
		      
		      
		}catch (SQLException e) {
			cnx.setMsg(e.getMessage());
			 
		}
	}
public void fetchalluser() {
	users= new ArrayList<>();
	try {
		String query = "SELECT * FROM users";
		// create the java statement
	    Statement st = cnx.conn.createStatement();
	    
	    // execute the query
	      ResultSet rs = st.executeQuery(query);
	      
	      
	   // iterate through the java 
	      while (rs.next())
	      {
	    	  int userid = rs.getInt("userid");
	   
	        String name = rs.getString("name");
	        String password = rs.getString("password");
	        String type = rs.getString("type");
	       
	        user user=new user(name,password,type,userid) ;
	        users.add(user);
	        // print the results
	       // System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
	      }
	      st.close();
	      
	      
	      
	}catch (SQLException e) {
		cnx.setMsg(e.getMessage());
		 
	}
}
    
}
