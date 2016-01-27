package dao;



import model.VegBurger;
import model.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


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
}
