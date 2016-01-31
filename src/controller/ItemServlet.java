package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.ItemBuilder;
import model.VegBurger;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/***Input Format == JSON ****/
	/*
	{
		"name" : "pepsi",
		"price" : "50.0",
		"type" : "Softdrink"
	}
	
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Item Servlet");
		
		ItemBuilder item = new ItemBuilder();
		
		StringBuilder sb = new StringBuilder();
		String line = null;
		
		try {
			BufferedReader reader = request.getReader();
			
			while( (line =reader.readLine()) != null){
				sb.append(line);
			}
			
			JSONObject jobj = new JSONObject(sb.toString());
			
			System.out.println("JSON Object");
			
			item.addItem(jobj.getString("name"), (float)jobj.getDouble("price"), jobj.getString("type"));
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}

}
