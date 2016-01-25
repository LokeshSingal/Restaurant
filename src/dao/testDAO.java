package dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojo.test;

public class testDAO{
	
public void add(){
	System.out.println("1");
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	 System.out.println("1");
          Session session = sf.openSession();
          System.out.println("1");
          Transaction tx = session.beginTransaction();

          test t1=new test();  
          t1.setId(115);  
          t1.setName("Hello");

          session.save(t1);
          tx.commit();
}
}
