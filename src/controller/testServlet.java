package controller;

import java.io.BufferedReader;
import java.io.IOException;
import org.json.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.List;
import dao.MealBuilder;
import dao.testDAO;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Class<Object> Object = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("1");
		testDAO t1 = new testDAO();
		//
		if (request.getParameter("addmealdetail") != null) {
		    
		}
		else if (request.getParameter("generatebill") != null) {
		    // Invoke action 2.
		}
		else if (request.getParameter("addmeal") != null) {
		    
		}

		else if (request.getParameter("displaymeal") != null) {
			MealBuilder mb = new MealBuilder();
			//doPost(request, response);
			mb.addNewMeal();
			
			//mb.getAllItem();
		}
		else if (request.getParameter("displayitems") != null) {
			String TextValue=t1.getAllItem();
			System.out.println(TextValue);
			request.setAttribute("TextValue",TextValue);
			RequestDispatcher rd=request.getRequestDispatcher("/NewFile.jsp");
			rd.forward(request,response);
		   

		
	}
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Called Servlet");
		//String val = (String)request.getParameter("items");
		
		MealBuilder mb = new MealBuilder();
		
		
		int mealId = mb.addNewMeal();
		
		StringBuilder jb = new StringBuilder();
	      String line = null;
	      try {

	    	  BufferedReader reader = request.getReader();
	    	  
	   while ((line = reader.readLine()) != null)
	          jb.append(line);

	        JSONArray jsonArray = new JSONArray(jb.toString());
	             
	        System.out.println(jsonArray);

			mb.addMealDetails(mealId, jsonArray);
	        
	      } catch (Exception e) { 
	          e.printStackTrace();        
	      }

		
	}

}
