package dao;



import java.util.List;

import model.VegBurger;
import model.test;

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

public void getAllItem(){
	System.out.println("1");
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	 System.out.println("1");
          Session session = sf.openSession();
          System.out.println("1");
          //Transaction tx = session.beginTransaction();

          Query query=session.createQuery("from VegBurger");//here persistent class name is Emp  
          List<Item> l1=query.list();
          for(Item a: l1){
        	  System.out.println(a.getId()+" "+a.getName()+" ");
        	  a.setPrice(99);
        	  Transaction tx = session.beginTransaction();
        	  session.saveOrUpdate(a);
        	  tx.commit();
          }
          
          //tx.commit();
          
}
}
