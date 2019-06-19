package db;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class modelmatch  {
	public connections cnx;
	public 	List<match> matchs;
	
	public match matchbyidmatch ;
	public  modelmatch() {
		cnx = new connections();
		
	
	}
	public Boolean updateMatch(String nameequipetow, String nameequipeone,int scoreequipetwo,int scoreequipeone,String statue,int idmatch) {
		try{
	    	
	   

			PreparedStatement ps = cnx.conn.prepareStatement("UPDATE  public.match SET statue=?, scoreequipeone=?, scoreequipetwo=?, nameequipeone=?, nameequipetow=? where idmatch="+idmatch+"");
			
			ps.setString(1, statue);
			ps.setInt(2, scoreequipeone);
			ps.setInt(3, scoreequipetwo);
			ps.setString(4, nameequipeone);
			ps.setString(5, nameequipetow);
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
	public void fetchmatchbyid(int idmatch) {
		
		try {
			String query = "SELECT * FROM match where idmatch="+idmatch+"";
			// create the java statement
		    Statement st = cnx.conn.createStatement();
		    
		    // execute the query
		      ResultSet rs = st.executeQuery(query);
		      
		      
		   // iterate through the java 
		      while (rs.next())
		      {
		    	  int idmatchs = rs.getInt("idmatch");
		   
		        String statue = rs.getString("statue");
		        int scoreequipeone = rs.getInt("scoreequipeone");
		        int scoreequipetwo = rs.getInt("scoreequipetwo");
		        String nameequipeone = rs.getString("nameequipeone");
		        String nameequipetow = rs.getString("nameequipetow");
	
		       
		        matchbyidmatch =new match(idmatchs,statue,scoreequipeone,scoreequipetwo,nameequipeone,nameequipetow) ;
		  
		        // print the results
		       // System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
		      }
		      st.close();
		      
		      
		      
		}catch (SQLException e) {
			cnx.setMsg(e.getMessage());
			 
		}
	}
	public Boolean insertMatch(String statue , String nameequipeone, String nameequipetow) {
		try{
	    	
	    	
			
			PreparedStatement ps = cnx.conn.prepareStatement("INSERT INTO public.match(statue, scoreequipeone, scoreequipetwo, nameequipeone, nameequipetow) VALUES (?,0, 0,?,?)");
			
			ps.setString(1, statue);
			ps.setString(2, nameequipeone);
			ps.setString(3, nameequipetow);
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
	
	public Boolean deletematch(int id){
		try{
	    	
	    	
			

			PreparedStatement ps = cnx.conn.prepareStatement("DELETE FROM public.match where idmatch=?");
			
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
	public void fetchallmatchbysearch(String search) {
		matchs= new ArrayList<>();
		try {	
			String query = "SELECT * FROM match where nameequipeone LIKE '%"+search+"%' or nameequipetow  LIKE '%"+search+"%' ";
			// create the java statement
		    Statement st = cnx.conn.createStatement();
		    
		    // execute the query
		      ResultSet rs = st.executeQuery(query);
		      
		      
		   // iterate through the java 
		      while (rs.next())
		      {
		    	
		    	  int idmatch = rs.getInt("idmatch");  
		        String statue = rs.getString("statue");
		        String nameequipeone = rs.getString("nameequipeone");
		        String nameequipetow = rs.getString("nameequipetow");
		        int scoreequipeone = rs.getInt("scoreequipeone");
		        int scoreequipetwo = rs.getInt("scoreequipetwo");
		        match match=new match(idmatch,statue,scoreequipeone,scoreequipetwo,nameequipeone,nameequipetow) ;
		        matchs.add(match);
		        // print the results
		       // System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
		      }
		      st.close();
		      
		      
		      
		}catch (SQLException e) {
			cnx.setMsg(e.getMessage());
			 
		}
	}
public void fetchallmatch() {
	matchs= new ArrayList<>();
	try {
		String query = "SELECT * FROM match ";
		// create the java statement
	    Statement st = cnx.conn.createStatement();
	    
	    // execute the query
	      ResultSet rs = st.executeQuery(query);
	      
	      
	   // iterate through the java 
	      while (rs.next())
	      {
	    	
	    	  int idmatch = rs.getInt("idmatch");  
	        String statue = rs.getString("statue");
	        String nameequipeone = rs.getString("nameequipeone");
	        String nameequipetow = rs.getString("nameequipetow");
	        int scoreequipeone = rs.getInt("scoreequipeone");
	        int scoreequipetwo = rs.getInt("scoreequipetwo");
	        match match=new match(idmatch,statue,scoreequipeone,scoreequipetwo,nameequipeone,nameequipetow) ;
	        matchs.add(match);
	        // print the results
	       // System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
	      }
	      st.close();
	      
	      
	      
	}catch (SQLException e) {
		cnx.setMsg(e.getMessage());
		 
	}
}
    
}
