package com.pojo;

import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Sreevani");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		
		Department d=new Department();
     	d.setDepid(1);
     	d.setDepname("LKM");
     	
         Employee e=new Employee();
         e.setEmpid(123);
         e.setEmpname("sree");
         em.persist(e);
         
         Employee e2=new Employee();
         e2.setEmpid(124);
         e2.setEmpname("vani");
         em.persist(e2);
     
     	HashSet<Employee> hs=new HashSet<>();
     	hs.add(e);
     	hs.add(e2);
     	d.setEmployees(hs);
	    em.persist(d);
	    em.getTransaction().commit();
        em.close();
        System.out.println("inserted");
	}

}
