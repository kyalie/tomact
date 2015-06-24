/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Derek
 */
public class InsertUser {
    
    public static int insert(User user) throws SQLException{
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement ps = null;
      
        try
        {
        String query = "INSERT INTO USERS(Name, username, email, pass) VALUES(?,?,?,SHA(?))";
        ps = conn.prepareStatement(query);
        ps.setString(1, user.getFirstname()+ " " + user.getLastname());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getPassword());
       
        return ps.executeUpdate();
        
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DButil.closePreparedStatement(ps);
            pool.freeConnection(conn);
        }
        return 0;
    }
    
}
        
    
  
