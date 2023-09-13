package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCDemo {

	public static void main(String[] args) throws SQLException {
	
		String url, uname, pass;
		url = "jdbc:mysql://localhost:3306/";
		uname = "root";
		pass = "Your_Password";
		Database db = null;
		
		Scanner sc = new Scanner(System.in);
		String table = null;
		
		while(true) {
			System.out.println("1.Create Database\n2.Create Table\n3.Insert\n4.Delete\n5.Update\n6.Retreive\n7.Exit");
			
			int action = sc.nextInt();
			
			switch(action) {
			
//			Create Database
			
			case 1:
				db = new Database(url, uname, pass);
				System.out.println("Database Name: ");
				db.createDatabase(sc.next());
				break;
				
//			Create table
				
			case 2:
				try {
					System.out.println("Table Name: ");
					table = sc.next();
					db.createTable(table);
					}
					catch(NullPointerException e) {
						System.out.println("Database not created");
					}
					break;
				
//			Insert values	
					
					
			case 3:
				if(table.equals(null)) {
					System.out.println("Table not exist");
					break;
					
				}
				
					@SuppressWarnings("unused") Connection con = DriverManager.getConnection(url, uname, pass);
		   
		            Scanner Scanner = new Scanner(System.in);
		            System.out.print("Enter employee ID: ");
		            int Em_Id = Scanner.nextInt();
		            Scanner.nextLine();
		            
		            System.out.print("Enter employee name: ");
		            String Em_name = Scanner.nextLine();
		            
		            System.out.print("Enter employee salary: ");
		            Double Salary = Scanner.nextDouble();
				
				
				db.insertVar(table, new Employee( Em_Id, Em_name, Salary));
				break;
				
				
//				Delete option
			case 4:
				if(table.equals(null)) {
					System.out.println("Table not exist");
					break;
				}	
				
				Scanner Scanner_d = new Scanner(System.in);
				System.out.print("Enter employee ID You want to delete : ");
				
	            int Em_Id_d = Scanner_d.nextInt();
	            Scanner_d.nextLine();
	            
				db.delete(table, Em_Id_d);
				break;
				
				
//			Update values
				
				
			case 5:
				if(table.equals(null)) {
					System.out.println("Table not exist");
					break;
				}	
				
				Scanner Scanneru = new Scanner(System.in);
				System.out.print("Enter Which employee ID You want to update : ");
	            int Em_Id_u = Scanneru.nextInt();
	            Scanneru.nextLine();
	            
	            System.out.print("Enter employee salary You want to update : ");
	            Double Salary_u = Scanneru.nextDouble();
				
				db.update(table, Em_Id_u, Salary_u);
				break;
				
//			select or retrieve values/table
				
				
			case 6:
				if(table.equals(null)) {
					System.out.println("Table not exist");
					break;
				}	
				db.retreive(table);
				break;
				
//			exit
				
				
			case 7:
				System.out.println(" Thank you !");
				System.exit(0);
				
			}
			
		}
		
	

	}

}
