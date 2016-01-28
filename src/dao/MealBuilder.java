package dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import model.Meal;
import model.MealDetails;
import model.VegBurger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;

import daoInterface.Item;

public class MealBuilder {
	
	int totalAmount = 0;
	
	public int addNewMeal(){
		
		System.out.println("MealBuilder addnewMeal");
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		 
	          Session session = sf.openSession();
	          System.out.println("New Session ");
	          
	          Transaction tx = session.beginTransaction();

	          Meal meal = new Meal();
	          
	          java.util.Date date= new java.util.Date();
	          
	          
	          meal.setTotalPrice(0);
	          meal.setMealTime(new Timestamp(date.getTime()));
	          //int currentMealId = getMealID();
	          
	          
	          int id = (Integer)session.save(meal);
	          System.out.println("Meal id k = " + id);
	          
	          tx.commit();
	          
	          //return currentMealId;
	          return id;
	}
	
	public void updateTotalAmount(int mealId){
		
		System.out.println("MealBuilder UpdateTotalAmount");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		System.out.println("New Session");
		
		Query query = session.createQuery("from Meal where id = "+mealId+"");
		
		
		Meal m = (Meal) query.uniqueResult();
		m.setTotalPrice(totalAmount);
		
		Transaction tx = session.beginTransaction();
      	session.saveOrUpdate(m);
      	  tx.commit();
     
		
	}
	
	public void addMealDetails(int mealId, JSONArray array) throws JSONException{
		
		MealDetails[] m2 = getItemDetails(array, mealId);
		
		System.out.println("Add Meal Details");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("from MealDetails");
		
		for (MealDetails mealDetails : m2) {
			
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(mealDetails);
			tx.commit();
			
		}
		
		updateTotalAmount(mealId);
		
	}
	
	public MealDetails[] getItemDetails(JSONArray array,int mealId) throws JSONException{
		
		System.out.println("Get item details");
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		 
	          Session session = sf.openSession();
	     
	          //Transaction tx = session.beginTransaction();

	          Query query=session.createQuery("from VegBurger");//here persistent class name is Emp  
	          List<VegBurger> l = query.list();
	          
	          
	          MealDetails[] m1=new MealDetails[array.length()];
	          
				
	        	  for (int i = 0; i < array.length(); i++) {
	        		  
	        			org.json.JSONObject rec = array.getJSONObject(i);
	        		    int id = rec.getInt("id");
	        		    int qty = rec.getInt("qty");
	        		    
	        		  for (VegBurger item : l) {
	        			  
	        		    if(id == item.getId()){
	        		    	
	        		    	totalAmount += item.getPrice()*qty;
	        		    	m1[i] = new MealDetails();
	        		    	m1[i].setItemId(id);
	        		    	m1[i].setMealId(mealId);
	        		    	m1[i].setPrice(item.getPrice());
	        		    	m1[i].setQty(qty);
	        		    	
	        		    }
				}
	        	  
	        	 
			}
	          System.out.println("total amount : " + totalAmount);
	        	  return m1;
	          
	}

	
	
}
