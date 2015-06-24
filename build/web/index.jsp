<%-- 
    Document   : index
    Created on : Jun 8, 2015, 2:09:37 PM
    Author     : Derek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p style="color:red"><center><i>${message}</i></center></p>
        <form action="Regform" method="post">
            
            <table align="center">
                <tr>
                    <td>FirstName</td>
                    <td><input type="text" name="fname" placeholder="First Name"</td>
                </tr>
                <tr>
                    <td>LastName</td>
                    <td><input type="text" name="lname" placeholder="Last Name"</td>
                </tr>
               <tr>
                    <td>UserName</td>
                    <td><input type="text" name="uname" placeholder="User Name" required=""</td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type= "password" name="pass" placeholder="Password" required=""</td>
                </tr>
                <tr>
                    <td>Email Address</td>

                    <td><input type="email" name="email" placeholder="Email" required=""</td>
                </tr>               
                <tr>
                    <TD><button type="submit" >Submit</button></td>
            </tr>
            </table>
        </form>
    </body>
</html>
