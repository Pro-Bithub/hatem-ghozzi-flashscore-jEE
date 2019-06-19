package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connections {
private boolean trying;
private String msg;
public Connection conn ;
	public connections() {
		this.setTrying(tryconnection());
	}
	
  public boolean tryconnection(){

      try  {
    	  Class.forName("org.postgresql.Driver");
    	   conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/flashscore", "root", "root");
          if (conn != null) {
        	  setMsg("Connected to the database!");
      
              return true;
          } else {
        	  setMsg("Faileed to make connection!");
       
          }

      } catch (SQLException e) {
    	  setMsg("Failed to make connection!"+e.getSQLState()+"   "+ e.getMessage());
         
      } catch (Exception e) {
          e.printStackTrace();
      }
      return false;

 }

public boolean isTrying() {
	return trying;
}

private void setTrying(boolean trying) {
	this.trying = trying;
}

public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}


 
}