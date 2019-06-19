package db;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
public class modelfavori {
	public connections cnx;
	public 	List<match> matchfavoris;
	public  modelfavori() {
		cnx = new connections();
		
	
	}
	public Boolean deletematchbyiduser(int idmatch, int iduser) {
	try{

		
    		PreparedStatement ps = cnx.conn.prepareStatement(" DELETE FROM public.favori WHERE idmatch=? and iduser=? ");
    		
    		ps.setInt(1, idmatch);
    		ps.setInt(2, iduser);
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
	public Boolean insertmatchbyiduser(int idmatch, int iduser) {
		if(!fetchmatchbyidmatch(idmatch,iduser))
			return false;
		try{
    	
    	
    		

    		PreparedStatement ps = cnx.conn.prepareStatement("INSERT INTO public.favori(idmatch, iduser) VALUES (?, ?)");
    		
    		ps.setInt(1, idmatch);
    		ps.setInt(2, iduser);
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
	
	public void fetchallfavori(int iduser) {
		matchfavoris= new ArrayList<>();
		
		try {
			String query = "SELECT * FROM match  INNER JOIN favori ON match.idmatch = favori.idmatch and favori.iduser="+iduser+"";
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
		        matchfavoris.add(match);
		        // print the results
		       // System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
		      }
		      st.close();
		      
		      
		      
		}catch (SQLException e) {
			cnx.setMsg(e.getMessage());
			 
		}
		
	}
	
	public Boolean fetchmatchbyidmatch(int idmatch, int iduser) {
		try {
			// String query = "SELECT * FROM users where name="+name+" and password="+password;
			String query = "SELECT * FROM favori where idmatch='"+idmatch+"'  and  iduser='"+idmatch+"' ";
			// create the java statement
		    Statement st = cnx.conn.createStatement();
		    
		    //set this values using PreparedStatement
	        ResultSet results = st.executeQuery(query); //where ps is Object of PreparedStatement

	        if(!results.next()) {

	        	st.close();
	            return true;
	        }
	 
	        st.close();
	        return false;
	        
		  
		      
		      
		      
		}catch (SQLException e) {
			cnx.setMsg(e.getMessage());
			 return false; 
		}
	}
}
