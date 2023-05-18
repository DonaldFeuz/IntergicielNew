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
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String email = request.getParameter("email");
       String mdp = request.getParameter("mdp");
       String nom = request.getParameter("nom");
       String prenom = request.getParameter("prenom");
       String datnais = request.getParameter("datnais");
       String ville = request.getParameter("ville");
       String pays = request.getParameter("pays");

        RequestDispatcher dispatcher = null;
        Connection con = null;
        try {
        	        
            // Construire les données à envoyer
            String postData = "nom=" + nom + "&prenom=" + prenom + "&email=" + email + "&mdp=" + mdp + "&datnais=" + datnais + "&ville=" + ville + "&pays=" + pays;
            
            // Définir l'URL de destination
            String urlStr = "http://localhost:8070/user";
            
            // Établir une connexion HTTP avec l'URL
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            
            // Envoyer les données
            PrintWriter out = new PrintWriter(connection.getOutputStream());
            out.print(postData);
            out.close();
            
            // Lire la réponse
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder responseBuilder = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                responseBuilder.append(inputLine);
            }
            in.close(); 
            String res = responseBuilder.toString();

if (res != null){
    request.setAttribute("status", "success");
    dispatcher = request.getRequestDispatcher("login.jsp");
}else{
    request.setAttribute("status", "failed");
    dispatcher = request.getRequestDispatcher("registration.jsp");
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
