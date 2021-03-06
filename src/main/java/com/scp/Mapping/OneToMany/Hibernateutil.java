package com.scp.Mapping.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Hibernateutil {
	public static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() throws MyException
	{
		try
		{
			if (null == sessionFactory) 
			{
				sessionFactory=new Configuration().configure().buildSessionFactory();
			}
		}
		catch (Exception e) 
		{
			throw new MyException("Session Factory Creation Error...!!!");
		}
		return sessionFactory;
	}

	public static void connectionClose(Session session, Transaction trans) {
		if (null != trans)
			trans.commit();
		if (null != session)
			session.close();
	}
}
