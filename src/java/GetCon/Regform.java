/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GetCon;

import Bean.InsertUser;
import Bean.User;
import Bean.UserDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kyalie
 */
public class Regform extends HttpServlet {
   

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        //get parameter from the servlet
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        
        //Create the User Object
        
        User user = new User();
        
        user.setFirstname(fname);
        user.setLastname(lname);
        user.setUsername(uname);
        user.setPassword(pass);
        user.setEmail(email);
     
        
        String message="";
        String url="";
        
     
        try {
            if (UserDB.usernameexists(user.getUsername()))
            {
                message = "This Email Already exists<br>"+
                        "Please try another Email";
                url = "/index.jsp";
            }else
            {
                InsertUser.insert(user);
               
                url = "/success.jsp";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Regform.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          //stohe user and message in the session
         HttpSession session = request.getSession();
         session.setAttribute("user", user);
         request.setAttribute("message", message);
         
         
         ////forward the request and response to the view
         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
         dispatcher.forward(request, response);
        
    }
}

