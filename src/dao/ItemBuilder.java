package dao;

import model.VegBurger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ItemBuilder {

	
	public void addItem(String itemName, float itemPrice, String itemType){
		
		System.out.println("Itm Builder : Add new item");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("from VegBurger");		
		
		VegBurger item = new VegBurger();
		item.setItemType(itemType);
		item.setName(itemName);
		item.setPrice(itemPrice);
		
		
			
			Transaction tx = session.beginTransaction();
			session.save(item);
			tx.commit();
			
		
		
		
	}
}
