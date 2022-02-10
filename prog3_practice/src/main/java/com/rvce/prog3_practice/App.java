package com.rvce.prog3_practice;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		SessionFactory ssnFactory = new Configuration().configure().buildSessionFactory();
		Session openSession = ssnFactory.openSession();
		Transaction txn = openSession.beginTransaction();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. add employee");
			System.out.println("2. get employee by id");
			System.out.println("3. get all employee");
			System.out.println("4. delete employee by id");

			System.out.println("enter choice");
			int ch = sc.nextInt();

			if (ch == 1) {
				System.out.println("Enter employee id");
				int id = sc.nextInt();

				System.out.println("Enter employee name");
				String name = sc.next();

				System.out.println("Enter employee salary");
				String sal = sc.next();

				System.out.println("Enter employee company");
				String comp = sc.next();

				Employee employee = new Employee(id, name, sal, comp);

				openSession.save(employee);
				  
			} else if (ch == 2) {
				System.out.println("enter id");
				int id = sc.nextInt();
				Employee find = openSession.find(Employee.class, id);

				if (find == null) {
					System.out.println("not found");
				} else {
					System.out.println(find);
				}
			} else if (ch == 3) {
				List list = openSession.createQuery("from Employee").list();
				if (list.size() == 0) {
					System.out.println("no record found");
				} else {
					System.out.println(list);
				}
			}
			else if(ch == 4) {
				System.out.println("enter id");
				int id = sc.nextInt();
				Employee find = openSession.find(Employee.class, id);
				
				if(find == null) {
					System.out.println(" no record found");
				}
				else {
					openSession.delete(find);
					System.out.println("employee deleted");
				}
			}
			else {
				System.out.println("EXIT");
				break;
			}
		}
	}
}
