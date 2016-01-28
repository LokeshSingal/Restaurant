package dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import model.Meal;
import model.VegBurger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import daoInterface.Item;

public class MealBuilder {

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
	
	public void updateTotalAmount(int amount,int mealId){
		
		System.out.println("MealBuilder UpdateTotalAmount");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		System.out.println("New Session");
		
		Query query = session.createQuery("from Meal where id = "+mealId+"");
		
		
		Meal m = (Meal) query.uniqueResult();
		m.setTotalPrice(amount);
		
		Transaction tx = session.beginTransaction();
      	session.saveOrUpdate(m);
      	  tx.commit();
     
		
		
	}
	
	public void addMealDetails(){
		
	}
	public void getAllItemDetails(){
		
		System.out.println("Get all item details");
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		 System.out.println("1");
	          Session session = sf.openSession();
	          System.out.println("1");
	          //Transaction tx = session.beginTransaction();

	          Query query=session.createQuery("from Meal");//here persistent class name is Emp  
	          List<Meal> l = query.list();
	          System.out.println(l);
	}

	public int getMealID(){
		
		System.out.println("Get meal id");
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		 
	          Session session = sf.openSession();
	     
	     

	          Query query=session.createQuery("from Meal order by mealId DESC");//here persistent class name is Emp
	          query.setMaxResults(1);
	          Meal m = (Meal) query.uniqueResult();
	          
	          
	          System.out.println(m.getMealId());
		
		return m.getMealId();
	}
	
	
}
