package com.hibernate.hib.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.hib.dto.StudentDto;

public class StudentDao
{

	public void save(StudentDto dto)
	{
		Transaction tx = null;
		try 
		{
			Configuration cfg = new Configuration();
			cfg.configure();
			SessionFactory factory= cfg.buildSessionFactory();
			Session session = factory.openSession();
			 tx = session.beginTransaction();
			session.save(dto);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
		
	}
	
	public void delete(int i){
		Transaction tx = null;
		try {
			Configuration cfg = new Configuration();
			cfg.configure();
			SessionFactory factory= cfg.buildSessionFactory();
			Session session = factory.openSession();
			StudentDto dto = session.get(StudentDto.class, new Integer(i));
			 tx = session.beginTransaction();
			session.delete(dto);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	public void update(int i){
		Transaction tx = null;
		try {
			Configuration cfg = new Configuration();
			cfg.configure();
			SessionFactory factory= cfg.buildSessionFactory();
			Session session = factory.openSession();
			StudentDto dto = session.get(StudentDto.class, new Integer(i));
			dto.setPercentage(80);
			 tx = session.beginTransaction();
			session.update(dto);
			
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
	}
	
	public StudentDto read(int i){
		StudentDto dto=null;
		try {
			Configuration cfg = new Configuration();
			cfg.configure();
			SessionFactory factory= cfg.buildSessionFactory();
			Session session = factory.openSession();
			 dto = session.get(StudentDto.class, new Integer(i));
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		return dto;	
	}
}
