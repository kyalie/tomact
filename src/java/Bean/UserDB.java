/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Derek
 */
public class UserDB {
    
    public static boolean usernameexists(String username) throws SQLException{
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
        String query = "SELECT username FROM users WHERE username = ?";
        ps = conn.prepareStatement(query);
        ps.setString(2, username);
        rs = ps.executeQuery();
        return rs.next();
        
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DButil.closeResultSet(rs);
            DButil.closePreparedStatement(ps);
            DButil.closeStatement(ps);
        }
        return false;
        
    }
    
}
