package com.registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;

try {
	
	// Construire les données à envoyer
    String postData = "email=" + email + "&mdp=" + mdp;
    
    // Définir l'URL de destination
    String urlStr = "http://localhost:8070/user/exist";
    
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
    String rs = responseBuilder.toString();  
    if(rs!=null) {
    	session.setAttribute("name", rs);
    	dispatcher = request.getRequestDispatcher("index.jsp");

    }else {
        request.setAttribute("status", "failed");
    	dispatcher = request.getRequestDispatcher("login.jsp");
    }
    dispatcher.forward(request, response);

    
} catch (Exception e) {
    e.printStackTrace();
}
	}
}
