 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/transaction")
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String emetteur = request.getParameter("emetteur");
       String recepteur = request.getParameter("recepteur");
       String montant = request.getParameter("montant");
       String devise = request.getParameter("devise");
       

        RequestDispatcher dispatcher = null;
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CAMFINANCE?useSSL=false","root","P@ssw0rd123!");
            
            PreparedStatement pst = con.prepareStatement("insert into transactions( emetteur, recepteur, montant, devise,) values(?,?,?,?)");
            pst.setString(1, emetteur);
            pst.setString(2, recepteur);
            pst.setString(3, montant);
            pst.setString(4, devise);
            
            

int rowCount = pst.executeUpdate();  
dispatcher = request.getRequestDispatcher("transaction.jsp");
if (rowCount > 0){
    request.setAttribute("status", "success");
    
}else{
    request.setAttribute("status", "failed");

}

dispatcher.forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
           try {
               con.close();
           } catch (SQLException e) {
               e.printStackTrace();

           }
        }
    }
    

}
