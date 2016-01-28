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

public class MealBuilder {

	public void add(){
		System.out.println("1");
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		 System.out.println("1");
	          Session session = sf.openSession();
	          System.out.println("1");
	          Transaction tx = session.beginTransaction();

	          Meal m1 = new Meal();
	          
	          java.util.Date date= new java.util.Date();
	     	  
	     	 
	          m1.setMealId(2);
	          m1.setTotalPrice(0);
	          int id=0;
	          m1.setMealTime(new Timestamp(date.getTime()));
	          id=(Integer)session.save(m1);
	          tx.commit();
	          System.out.println("ID ADDED :"+id);	
	}
	
	public void getAllItem(){
		System.out.println("1");
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		 System.out.println("1");
	          Session session = sf.openSession();
	          System.out.println("1");
	          //Transaction tx = session.beginTransaction();

	          Query query=session.createQuery("from Meal");//here persistent class name is Emp  
	          System.out.println(query.list().toString());
	}

	
	
}
