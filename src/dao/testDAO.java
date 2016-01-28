package dao;



import java.util.List;

import model.MealDetails;
import model.VegBurger;
import model.test;
import model.Meal;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import daoInterface.Item;




public class testDAO{
	
public void add(){
	System.out.println("1");
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	 System.out.println("1");
          Session session = sf.openSession();
          System.out.println("1");
          Transaction tx = session.beginTransaction();

          VegBurger t1=new VegBurger();  
          
          t1.setName("Item1");
          t1.setPrice(100);

          session.save(t1);
          tx.commit();
}

public String getAllItem(){
	System.out.println("1");
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	 System.out.println("1");
          Session session = sf.openSession();
          System.out.println("1");
          //Transaction tx = session.beginTransaction();

          Query query=session.createQuery("from VegBurger");//here persistent class name is Emp  
          List<Item> l1=query.list();
          String t1="ID"+"&nbsp;&nbsp;&nbsp;"+"NAME"+"<br>",t2="";
          for(Item a: l1){
        	  Transaction tx = session.beginTransaction();
        	  session.saveOrUpdate(a);
        	  tx.commit();
        	  t2=a.getId()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
        	  a.getName()+"<br>";
        	  //System.out.println(t2);
        	  t1=t1+t2;

   	       
          }
          
          //tx.commit();
         // System.out.println(t1);
          return t1;
}
public String getAllItemMeal(){
	System.out.println("1");
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	 System.out.println("1");
          Session session = sf.openSession();
          System.out.println("1");
          //Transaction tx = session.beginTransaction();

          Query query=session.createQuery("from MealDetails");//here persistent class name is Emp  
          List<MealDetails> l1=query.list();
          String t1="MLDID"+"&nbsp;&nbsp;"+"MLID"+"&nbsp;&nbsp;"+"ITEMID"+"&nbsp;&nbsp;"+"AMT"+"&nbsp;&nbsp;"+"Quantity"+"<br>",t2="";
          for(MealDetails a: l1){
        	  Transaction tx = session.beginTransaction();
        	  session.saveOrUpdate(a);
        	  tx.commit();      
              t2=a.getMealDetailsId()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
        	  a.getMealId()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
        	  a.getItemId()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;"+
        	  a.getPrice()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;"+
        	  a.getQty()+"<br>";
              t1=t1+t2;
       
          }
          return t1;
	}

public String getAllMeal(){
	System.out.println("1");
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	 System.out.println("1");
          Session session = sf.openSession();
          System.out.println("1");
          //Transaction tx = session.beginTransaction();

          Query query=session.createQuery("from Meal");//here persistent class name is Emp  
          List<Meal> l1=query.list();
          String t1="MEAL_ID"+"&nbsp;&nbsp;"+"TOT_PRICE"+"<br>",t2="";
          for(Meal a: l1){
        	  Transaction tx = session.beginTransaction();
        	  session.saveOrUpdate(a);
        	  tx.commit();      
              t2=a.getMealId()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
        	  a.getTotalPrice()+"<br>";
              t1=t1+t2;
       
          }
          return t1;
	}
}

