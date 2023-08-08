package testMySQLconn2;
import java.util.Date;

import java.sql.*;
import java.util.Scanner;


public class MysqlConnect{
	static Connection conn ;
	

	 static void MethodIV() {
         
		//iv
	         int diff=0;
	         try
	         {
	             Statement st = MysqlConnect.conn.createStatement();
	             String query = "Select * from storage_bin";
	             ResultSet res = st.executeQuery(query);


	             while (res.next()) {
	                 //validation check of capacity
	                 do {
	                     if (diff>=0) {
	                     System.out.println("Insert the capacity you want:");
	                     Scanner sc0= new Scanner (System.in);
	                     int cap2=sc0.nextInt();
	                     diff=(res.getInt("capacity")) - cap2;
	                     }
	                     if (diff<0) {
	                         System.out.println("Insert the capacity you want again:");
	                         Scanner sc0= new Scanner (System.in);
	                         int cap2=sc0.nextInt();
	                         diff=(res.getInt("capacity")) - cap2;
	                     }

	                 }while (diff<0);
	                 System.out.println("The difference is");
	                 System.out.println(diff);
	             }
	         }catch(SQLException s)
	         {
	             System.out.println("SQL code does not execute iv.");
	         }

	         }
         
         
         
        
         

public static void main(String[] args) throws SQLException {
	
	
	System.out.println("MySQL Connect Exercise 4");
	conn = null;
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "exercise4";
	String driver = "com.mysql.jdbc.Driver";
	String userName = "root"; 
	String password = "";
	

	//Connect to database
	try{
		Class.forName(driver).newInstance();
		conn = DriverManager.getConnection(url+dbName,userName,password);
		System.out.println("Connected to database");
	}catch(Exception e) {
		e.printStackTrace();
	}
		
		
		int select=1;
		
		
		while (select==1) {

	
		Scanner sc= new Scanner (System.in);
		int choice;
		//loop if the choice is not accepted number
		do {
			//show menu
		System.out.println("0.Exit\n");
		System.out.println("1.Insert\n");
		System.out.println("2.Update\n");
		System.out.println("3.retrieve list of repositories\n");
		System.out.println("4.retrieve a list of components per receiving batch and per storage bin\n");
		System.out.println("5.Bin capacity recovery\n");
		System.out.println("6.Update of available and remaining capacity\n");
		System.out.println("7.Retrieval Manager List\n");
		System.out.println("8.Retrieval Name Manager List\n");
		System.out.println("9.Recovery of Component List\n");
		System.out.println("10.Retrieve List of new orders\n");
		System.out.println("11.Delete the manager\n");
		System.out.println("Select your choice:\n");
		//save the integer
		choice=sc.nextInt();
		
		switch (choice) {
		case 0: {
			
			select=0;
			MysqlConnect.conn.close();
			System.out.println("Disconnected from database");
			
		}
		break;
		
		
				case 1:{
				//show insert menu
				System.out.println("1.Insert the storage \n");
				System.out.println("2.Insert the storage bin\n");
				System.out.println("3.Insert the data base\n");
				System.out.println("4.Insert the peceipt batch\n");
				System.out.println("5.Insert the manager\n");
				System.out.println("6.Insert assembled\n");
				System.out.println("7.Insert the piece\n");
				System.out.println("8.Insert the accessories\n");
				System.out.println("9.Insert the employee\n");
				System.out.println("10.Insert the address\n");
				System.out.println("11.Insert the phone number\n");
				
				
				
				Scanner sc2= new Scanner (System.in);
				int choice2=0;
				System.out.println("Select the insert choice:");
				choice2=sc2.nextInt();
				
				
				switch(choice2) {
					
					case 1:{
						
						//Storage
				        try{
				            Statement st = MysqlConnect.conn.createStatement();
				            Scanner sc1= new Scanner (System.in);

				            System.out.println("New storage code");

				        	String code=sc1.nextLine();
				        	
				            int val = st.executeUpdate("INSERT INTO storage VALUES('"+code+"' )");
				            System.out.println("1 row affected");
				           
				           
				           

				        }catch(SQLException s){
				            System.out.println("SQL statement is not executed !");
				        }    
				        break;
					}
					
					
					
				case 2:{
						
					
				        //Storage Bin
				        try{
				            Statement st1 = MysqlConnect.conn.createStatement();
				            Scanner sc22= new Scanner (System.in);

				            System.out.println("New storage_bin code");

				        	 int code=sc22.nextInt();
				        	 Scanner sc3= new Scanner (System.in);

				             System.out.println("New capacity");

				         	int capacity=sc3.nextInt();
				         	
				         	Scanner sc4= new Scanner (System.in);

				            System.out.println("Take an unused storage code");

				         	String code_s=sc4.nextLine();
				        	
				         	
				         	int val = st1.executeUpdate("INSERT INTO storage_bin VALUES('"+code+"','"+capacity+"','"+code_s+"')");
				         	
				         	
				    
				            break;

				        }catch(SQLException s){
				            System.out.println("SQL statement is not executed!");
				        }
				        
				        break;
					}
					
					
					
					case 3:{
						

						 //Data Base
						try{
							  Statement st = MysqlConnect.conn.createStatement();
							  
							  	Scanner sc1= new Scanner (System.in);

							  	System.out.println("New data base code");

							  	String code=sc1.nextLine();
							  	
					        	Scanner sc3= new Scanner (System.in);

					            System.out.println("New portion");
					          	
					            int portion=sc3.nextInt();
					          
					            Scanner sc0= new Scanner (System.in);

						        System.out.println("Manager Name:");

						        String m_name=sc0.nextLine();
							
						        
					            Scanner sc4= new Scanner (System.in);
						        
						         System.out.println("Order date:");
						          	
						         String order_date=sc4.nextLine();
						         
						         Scanner sc5= new Scanner (System.in);

						         System.out.println("Order quantity:");
						          	
						          int or_quantity=sc5.nextInt();
						            
						          Scanner sc6= new Scanner (System.in);

							       System.out.println("Entry date:");
							          	
							      String en_date=sc6.nextLine();
					          	
							      Scanner sc7= new Scanner (System.in);

							       System.out.println("Quantity:");
							          	
							        int quantity=sc7.nextInt();
				        

							  
				int val = st.executeUpdate("INSERT INTO data_base VALUES('"+code+"','"+portion+"','"+m_name+"','"+order_date+"','"+or_quantity+"','"+en_date+"','"+quantity+"')");
							  
							  System.out.println("1 row affected");
							       	  
							  break;
							  
							}catch(SQLException s){
							  System.out.println("SQL statement is not executed!");
							}
							  		
					
				    break;
				        
					}
					case 4:{
						

				        //Peceipt Batch
				        try{
				             Statement st = MysqlConnect.conn.createStatement();
				             
				             Scanner sc1= new Scanner (System.in);

				             System.out.println("Peceipt Batch Code :");

				             int p_code=sc1.nextInt();
				             
				             Scanner sc32= new Scanner (System.in);

				             System.out.println("Entry date:");

				             String en1_date=sc32.nextLine();
				             
				             Scanner sc3= new Scanner (System.in);

				             System.out.println("Quantity:");

				             int quant=sc3.nextInt();
				             
				             
				             
				             
				             int val = st.executeUpdate("INSERT INTO peceipt_batch VALUES('"+p_code+"','"+en1_date+"','"+quant+"')");
				             System.out.println("1 row affected");

				             
				             
				           
				             break;
				             

				         }catch(SQLException s){
				             System.out.println("SQL statement is not executed!");
				         }

				        break;
					
					}
					
					case 5:{
						
						 //Manager
				        try{
				              Statement st = MysqlConnect.conn.createStatement();
				              
				              
				              Scanner sc6= new Scanner (System.in);

						      System.out.println("Enter the name:");
						          	
						      String name=sc6.nextLine();
				              
						      
						      Scanner sc7= new Scanner (System.in);

						      System.out.println("Check date:");
						          	
						      String ch_date=sc7.nextLine();
				              
						      Scanner sc8= new Scanner (System.in);

						      System.out.println("Data base code:");
						          	
						      String data_code=sc8.nextLine();
						      
						      Scanner sc9= new Scanner (System.in);

						      System.out.println("Peceipt code:");
						          	
						      String pe_code=sc9.nextLine();
						      
						      
				              int val = st.executeUpdate("INSERT INTO manager VALUES('"+name+"','"+ch_date+"','"+data_code+"','"+pe_code+"')");
				              System.out.println("1 row affected");
				              
				            break;
				            

				            }catch(SQLException s){
				              System.out.println("SQL statement is not executed!");
				            }

				      
				        
				        break;

					}
						
					
					case 6:{
						
						  //Assembled
				        try{
				            Statement st = MysqlConnect.conn.createStatement();
				            Scanner sc42= new Scanner (System.in);

				            System.out.println("New assembled code");
				            
				            int as_code=sc42.nextInt();
				            
				            Scanner sc3= new Scanner (System.in);

				            System.out.println("Find a peceipt code");
				            
				            int pec_code=sc3.nextInt();
				            
				            
				            Scanner sc4= new Scanner (System.in);

				            System.out.println("Find a data base code");
				            
				            int d_code=sc4.nextInt();

				            int val = st.executeUpdate("INSERT INTO assembled VALUES('"+as_code+"','"+pec_code+"','"+d_code+"')");
				            System.out.println("1 row affected");

				            
				            
				          break;
				        }catch(SQLException s){
				            System.out.println("SQL statement is not executed!");
				        }

						  break;

					
					}
					
					case 7:{
						
						   //Piece
				         try{
				             Statement st = MysqlConnect.conn.createStatement();
				             
				             Scanner sc1= new Scanner (System.in);

					         System.out.println("New piece code");

					         int code=sc1.nextInt();
				             
					         Scanner s1= new Scanner (System.in);

					         System.out.println("Peceipt code");

					         int pec_code=s1.nextInt();
				             
					         
				             int val = st.executeUpdate("INSERT INTO piece VALUES('"+code+"','"+pec_code+"')");
				             System.out.println("1 row affected");

				             
				           
				break;
					
					  }catch(SQLException s){
		                 System.out.println("SQL statement is not executed!");
		             }
				         
				         break;
				         
					}
					case 8:{
						
						   //Accessories
			              try{
			             Statement st = MysqlConnect.conn.createStatement();
			             
			             Scanner sc1= new Scanner (System.in);
				         System.out.println("New accessories code");
				         String code=sc1.nextLine();
				         
				         Scanner sc12= new Scanner (System.in);
				         System.out.println("New accessories code");
				         String ss_code=sc12.nextLine();
				         
				         
				         Scanner sc13= new Scanner (System.in);
				         System.out.println("New accessories code");
				         String ass_code=sc13.nextLine();
			             
				         
				         Scanner sc14= new Scanner (System.in);
				         System.out.println("New accessories code");
				         String ps_code=sc14.nextLine();
			             
				         
				         
			             int val = st.executeUpdate("INSERT INTO accessories VALUES('"+code+"','"+ss_code+"','"+ass_code+"','"+ps_code+"')");
			             System.out.println("1 row affected");
			             
			          break;  

			           }catch(SQLException s){
			             System.out.println("SQL statement is not executed!");
			           }

						break;
						
					}
					case 9:{
						
						   //Employee
				           try{
				                 Statement st = MysqlConnect.conn.createStatement();
				                 
				                 Scanner sc1= new Scanner (System.in);

				                 System.out.println("New employe code:");

				                 String code=sc1.nextLine();
				                 
				                 Scanner sc62= new Scanner (System.in);

				                 System.out.println("New employe name:");

				                 String name=sc62.nextLine();
				                 
				                 Scanner sc3= new Scanner (System.in);

				                 System.out.println("New employe surname:");

				                 String surname=sc3.nextLine();
				                 
				                 Scanner sc4= new Scanner (System.in);

				                 System.out.println("Fathers name:");

				                 String f_name=sc4.nextLine();
				                 
				                 Scanner sc90= new Scanner (System.in);

				                 System.out.println("Managers name:");

				                 String mn_name=sc90.nextLine();
				                 
				                
				               
				                 
				                 
				                 
				                 int val1 = st.executeUpdate("INSERT INTO employee VALUES('"+code+"','"+name+"','"+surname+"','"+f_name+"','"+mn_name+"')");
				                 System.out.println("1 row affected");

				            break;     
				                 
				               }catch(SQLException s){
				                 System.out.println("SQL statement is not executed!");
				               }

						break;
				           
					}
					
					case 10:{
						
						 //Address
			   			try{
			   				  Statement st = MysqlConnect.conn.createStatement();
			   				  
			   				  
			   			   Scanner sc1= new Scanner (System.in);

			               System.out.println("New city name:");

			               String cname=sc1.nextLine();
			               
			               Scanner sc52= new Scanner (System.in);

			               System.out.println("Address:");

			               String aname=sc52.nextLine();
			               
			               Scanner sc3= new Scanner (System.in);

			               System.out.println("address number:");

			               int num=sc3.nextInt();
			               
			               Scanner sc4= new Scanner (System.in);

			               System.out.println("Postal code:");

			               String pcode=sc4.nextLine();
			               
			               Scanner sc5= new Scanner (System.in);

			               System.out.println("A code:");

			               String a_code=sc5.nextLine();
			               
			               Scanner sc115= new Scanner (System.in);

			               System.out.println("A code:");

			               String empl_code=sc115.nextLine();
			               
			               
			               
			               
			               int val = st.executeUpdate("INSERT INTO address VALUES('"+cname+"','"+aname+"','"+num+"','"+pcode+"','"+a_code+"','"+empl_code+"')");
			   			   System.out.println("1 row affected");
			   			   
			   			   
			   				  
			   				  break;
			   				  
			   				}catch(SQLException s){
			   				  System.out.println("SQL statement is not executed!");
			   				}

			   				break;
						
					}
					
					case 11:{
						
						
			   			//phoneNumbers
			   		  
			            try{
			                  
			            		
			            	Statement st = MysqlConnect.conn.createStatement();
			                  
			                 
			                  
			                  Scanner sc5= new Scanner (System.in);

			                  System.out.println("New phone:");

			                  String phone=sc5.nextLine();
			                  
			                  
			                  Scanner sc6= new Scanner (System.in);

			                  System.out.println("New phone code:");

			                  String phonecode=sc6.nextLine();
			                  
			                  
			                  Scanner sc7= new Scanner (System.in);

			                  System.out.println("New employee  code:");

			                  String employee_code=sc7.nextLine();
			                  
			                  
			                  int val1 = st.executeUpdate("INSERT INTO phonenumbers VALUES('"+phone+"','"+phonecode+"','"+employee_code+"')");
			                  System.out.println("1 row affected");

			                  break;
			              
			                }catch(SQLException s){
			                  System.out.println("SQL statement is not executed!");
			                }
			            
			            break;
			            
						
					}

				}		
				break;
			}
			
			case 2:{
				//show update menu
				System.out.println("1.Update the storage \n");
				System.out.println("2.Update the storage bin\n");
				System.out.println("3.Update the data base\n");
				System.out.println("4.Update the peceipt batch\n");
				System.out.println("5.Update manager\n");
				System.out.println("6.Update assembled\n");
				System.out.println("7.Update the piece\n");
				System.out.println("8.Update the accessories\n");
				System.out.println("9.Update the employee\n");
				System.out.println("10.Update the employee\n");
				System.out.println("11.Update the phone numbers\n");

				
				Scanner sc3= new Scanner (System.in);
				int choice3=0;
				System.out.println("Select the update choice:");
				choice3=sc3.nextInt();
				
				
				switch(choice3) {
					
					case 1:{
						
						 try{
					            Statement st = MysqlConnect.conn.createStatement();
					            Scanner sc10= new Scanner (System.in);
					            System.out.println("New storage code");
					        	String code=sc10.nextLine();
					        	
					        	
					        	//update storage 
					            String query = " update storage set code = ? where code= ? " ;
					            Scanner sc6= new Scanner (System.in);
					            System.out.println("Update storage code");
					        	String code2=sc.nextLine();
					        	
					            
					            PreparedStatement preparedStmt = MysqlConnect.conn.prepareStatement(query);
					            preparedStmt.setString(1,code2);
					            preparedStmt.setString(2,code);
					            preparedStmt.executeUpdate();
					           
					            

					        }catch(SQLException s){
					            System.out.println("SQL statement is not executed !");
					        }
						 break;
						 
					}
			            
					case 2:{
						
						//Storage Bin
				        try{
				            Statement st1 = MysqlConnect.conn.createStatement();
				            Scanner sc2= new Scanner (System.in);

				            System.out.println("New storage_bin code");

				        	 int code=sc2.nextInt();
				        	 Scanner sc90= new Scanner (System.in);

				             System.out.println("New capacity");

				         	int capacity=sc90.nextInt();
				        	
				         	
				         	//update storage bin
				            String query = "update storage_bin set code = ? where code = ?";
				            Scanner sc101= new Scanner (System.in);
				            System.out.println("Update storage bin code");
				        	int code2=sc101.nextInt();
				            PreparedStatement preparedStmt = MysqlConnect.conn.prepareStatement(query);
				            preparedStmt.setInt (1,code2);
				            preparedStmt.setInt(2,code);
				            preparedStmt.executeUpdate();
				            
				            
				            String query2 = "update storage_bin set capacity = ? where capacity = ?";
				            Scanner sc4= new Scanner (System.in);
				            System.out.println("Update capacity");
				        	int capacity2=sc4.nextInt();
				       	    PreparedStatement preparedStmt2 = MysqlConnect.conn.prepareStatement(query2);
				            preparedStmt2.setInt (1,capacity2);
				            preparedStmt2.setInt(2,capacity);
				            preparedStmt2.executeUpdate();	
				            
				            break;
				            
				        }catch(SQLException s){
				            System.out.println("SQL statement is not executed!");
				        }

				        break;
						
					}
					
					
					case 3:{
						
						 //Data Base
						try{
							  Statement st = MysqlConnect.conn.createStatement();
							  
							  	Scanner sc1= new Scanner (System.in);

							  	System.out.println("New data base code");

							  	String code=sc1.nextLine();
							  	
					        	Scanner sc43= new Scanner (System.in);

					            System.out.println("New portion");
					          	
					            int portion=sc43.nextInt();
					          
					            Scanner sc0= new Scanner (System.in);

						        System.out.println("Manager Name:");

						        String m_name=sc0.nextLine();
							
						        
					            Scanner sc4= new Scanner (System.in);
						        
						         System.out.println("Order date:");
						          	
						         String order_date=sc4.nextLine();
						         
						         Scanner sc5= new Scanner (System.in);

						         System.out.println("Order quantity:");
						          	
						          int or_quantity=sc5.nextInt();
						            
						          Scanner sc6= new Scanner (System.in);

							       System.out.println("Entry date:");
							          	
							      String en_date=sc6.nextLine();
					          	
							      Scanner sc7= new Scanner (System.in);

							       System.out.println("Quantity:");
							          	
							        int quantity=sc7.nextInt();
				        	  
							  
							  //update data base
							  String query = "update data_base set code = ? where code = ?";
							  Scanner s= new Scanner (System.in);
							  System.out.println("Update data base code");
							  String code2=s.nextLine();
					          PreparedStatement preparedStmt =MysqlConnect.conn.prepareStatement(query);
					          preparedStmt.setString (1, code2);
					          preparedStmt.setString(2, code);
					          preparedStmt.executeUpdate();
					          
					          String query2 = "update data_base set portion = ? where portion = ?";
							  Scanner s2= new Scanner (System.in);
							  System.out.println("Update portion");
							  int portion2=s2.nextInt();
					          PreparedStatement preparedStmt2 =MysqlConnect.conn.prepareStatement(query2);
					          preparedStmt2.setInt (1, portion2);
					          preparedStmt2.setInt(2, portion);
					          preparedStmt2.executeUpdate();
					          
					          String query3 = "update data_base set manager = ? where manager = ?";
					          Scanner s3= new Scanner (System.in);
					          System.out.println("Update manager name");
					          String m_name2=s3.nextLine();
					     	  PreparedStatement preparedStmt3 =MysqlConnect.conn.prepareStatement(query3);
					     	  preparedStmt3.setString (1, m_name2);
					     	  preparedStmt3.setString (2, m_name);
					     	  preparedStmt3.executeUpdate();
					     	  
					     	  
					          String query4 = "update data_base set order_date = ? where order_date = ?";
					          Scanner s4= new Scanner (System.in);
					          System.out.println("Update order date");
					          String or_date2=s4.nextLine();
					     	  PreparedStatement preparedStmt4 =MysqlConnect.conn.prepareStatement(query4);
					     	  preparedStmt4.setString (1, or_date2);
					     	  preparedStmt4.setString (2, order_date);
					     	  preparedStmt4.executeUpdate();
					     	  
					     	  String query5 = "update data_base set order_quantiry = ? where order_quantiry = ?";
					          Scanner s5= new Scanner (System.in);
					          System.out.println("Update quantity");
					          int or_q2=s5.nextInt();
					     	  PreparedStatement preparedStmt5 =MysqlConnect.conn.prepareStatement(query5);
					     	  preparedStmt5.setInt (1, or_q2);
					     	  preparedStmt5.setInt (2, or_quantity);
					     	  preparedStmt5.executeUpdate();
					     	  
					     	  String query6 = "update data_base set entry_date = ? where entry_date = ?";
					          Scanner s6= new Scanner (System.in);
					          System.out.println("Update entry date");
					          String en_d2=s6.nextLine();
					     	  PreparedStatement preparedStmt6 =MysqlConnect.conn.prepareStatement(query6);
					     	  preparedStmt6.setString (1, en_d2);
					     	  preparedStmt6.setString (2, en_date);
					     	  preparedStmt6.executeUpdate();
					     	  
					     	 
					     	  String query7 = "update data_base set quantity = ? where quantity = ?";
					          Scanner s7= new Scanner (System.in);
					          System.out.println("Update quantity");
					          int q2=s7.nextInt();
					     	  PreparedStatement preparedStmt7 =MysqlConnect.conn.prepareStatement(query7);
					     	  preparedStmt7.setInt (1, q2);
					     	  preparedStmt7.setInt (2, quantity);
					     	  preparedStmt7.executeUpdate();
					     	  
					     	  
					     	  break;

							}catch(SQLException s){
							  System.out.println("SQL statement is not executed!");
							}
							  		
					
						break;
				     
					}
					
					case 4:{
						
						  //Peceipt Batch
				        try{
				             Statement st = MysqlConnect.conn.createStatement();
				             
				             Scanner sc1= new Scanner (System.in);

				             System.out.println("Peceipt Batch Code :");

				             int p_code=sc1.nextInt();
				             
				             Scanner sc2= new Scanner (System.in);

				             System.out.println("Entry date:");

				             String en1_date=sc2.nextLine();
				             
				             Scanner sc33= new Scanner (System.in);

				             System.out.println("Quantity:");

				             int quant=sc33.nextInt();
				             
				             
				             
				           

				             
				             
				             //update peceipt batch
				             String query = "update peceipt_batch set code = ? where code = ?";
				             Scanner s1= new Scanner (System.in);
				             System.out.println(" Update Peceipt Batch Code :");
				             int p_code2=s1.nextInt();
				             PreparedStatement preparedStmt = MysqlConnect.conn.prepareStatement(query);
				             preparedStmt.setInt   (1, p_code2);
				             preparedStmt.setInt (2, p_code);
				             preparedStmt.executeUpdate();
				             
				             String query2 = "update peceipt_batch set entry_date = ? where entry_date = ?";
				             Scanner s2= new Scanner (System.in);
				             System.out.println("Update Entry date :");
				             String en2_date=s2.nextLine();
				             PreparedStatement preparedStmt2 = MysqlConnect.conn.prepareStatement(query2);
				             preparedStmt2.setString (1, en2_date);
				             preparedStmt2.setString (2, en1_date);
				             preparedStmt2.executeUpdate();
				             
				             String query3 = "update peceipt_batch set quantiry = ? where quantiry = ?";
				             Scanner s3= new Scanner (System.in);
				             System.out.println("Update Quantity:");
				             int q2 =s3.nextInt();
				             PreparedStatement preparedStmt3 = MysqlConnect.conn.prepareStatement(query3);
				             preparedStmt3.setInt (1, q2);
				             preparedStmt3.setInt (2, quant);
				             preparedStmt3.executeUpdate();
				             
				             break;
				             

				         }catch(SQLException s){
				             System.out.println("SQL statement is not executed!");
				         }

					   
				        break;
						
					
					}
					
					case 5:{
						

				        //Manager
				        try{
				              Statement st = MysqlConnect.conn.createStatement();
				              
				              
				              Scanner sc6= new Scanner (System.in);

						      System.out.println("Enter the name:");
						          	
						      String name=sc6.nextLine();
				              
						      
						      Scanner sc7= new Scanner (System.in);

						      System.out.println("Check date:");
						          	
						      String ch_date=sc7.nextLine();
				              
						      Scanner sc8= new Scanner (System.in);

						      System.out.println("Data base code:");
						          	
						      String data_code=sc8.nextLine();
						      
						      Scanner sc9= new Scanner (System.in);

						      System.out.println("Peceipt code:");
						          	
						      String pe_code=sc9.nextLine();
						      
						     
				              //update manager
				              String query = "update manager set name = ? where name = ?";
				              Scanner sc5= new Scanner (System.in);
						      System.out.println("Update the name:");
						      String name2=sc5.nextLine();
				              PreparedStatement preparedStmt = MysqlConnect.conn.prepareStatement(query);
				              preparedStmt.setString (1, name2);
				              preparedStmt.setString(2, name);
				              preparedStmt.executeUpdate();
				              
				              
				              String query2 = "update manager set check_date = ? where check_date = ?";
				              Scanner s= new Scanner (System.in);
						      System.out.println("Update the check date:");
						      String ch_date2=s.nextLine();
				              PreparedStatement preparedStmt2 = MysqlConnect.conn.prepareStatement(query2);
				              preparedStmt2.setString (1, ch_date2);
				              preparedStmt2.setString(2, ch_date);
				              preparedStmt2.executeUpdate();
				              
				              break;

				            }catch(SQLException s){
				              System.out.println("SQL statement is not executed!");
				            }


				   
						
						break;

							
					}
					
					case 6:{
						
						  //Assembled
				        try{
				            Statement st = MysqlConnect.conn.createStatement();
				            Scanner sc2= new Scanner (System.in);

				            System.out.println("New assembled code");
				            
				            int as_code=sc2.nextInt();
				            
				            Scanner sc63= new Scanner (System.in);

				            System.out.println("Find a peceipt code");
				            
				            int pec_code=sc63.nextInt();
				            
				            
				            Scanner sc4= new Scanner (System.in);

				            System.out.println("Find a data base code");
				            
				            int d_code=sc4.nextInt();

				            int val = st.executeUpdate("INSERT INTO assembled VALUES('"+as_code+"','"+pec_code+"','"+d_code+"')");
				            System.out.println("1 row affected");

				            
				            
				            //update assembled
				            String query = "update assembled set code = ? where code = ?";
				            Scanner sc77= new Scanner (System.in);
				            System.out.println("Update assembled code");
				            int as_code2=sc77.nextInt();
				            PreparedStatement preparedStmt = MysqlConnect.conn.prepareStatement(query);
				            preparedStmt.setInt   (1, as_code2);
				            preparedStmt.setInt (2, as_code);
				            preparedStmt.executeUpdate();
				            
				            break;
				            
				        }catch(SQLException s){
				            System.out.println("SQL statement is not executed!");
				        }
						
				        break;
				        
					}
					
					case 7:{
						
						   //Piece
				         try{
				             Statement st = MysqlConnect.conn.createStatement();
				             
				             Scanner sc1= new Scanner (System.in);

					         System.out.println("New piece code");

					         int code=sc1.nextInt();
				             
					         Scanner s1= new Scanner (System.in);

					         System.out.println("Peceipt code");

					         int pec_code=s1.nextInt();
				             
					         
				             
				             //update piece
				             String query = "update piece set code = ? where code = ?";
				             Scanner s= new Scanner (System.in);
				             System.out.println("Update piece code:");
					         int code2=s.nextInt();
				             PreparedStatement preparedStmt = MysqlConnect.conn.prepareStatement(query);
				             preparedStmt.setInt   (1, code2);
				             preparedStmt.setInt (1, code);
				             preparedStmt.executeUpdate();

				             break;
				             
				             }catch(SQLException s){
				                 System.out.println("SQL statement is not executed!");
				             }

						break;
					
					
					}
					case 8:{
						
						
				         
				         //Accessories
				              try{
				             Statement st = MysqlConnect.conn.createStatement();
				             
				             Scanner sc1= new Scanner (System.in);
					         System.out.println("New accessories code");
					         String code=sc1.nextLine();
					         
					         Scanner sc12= new Scanner (System.in);
					         System.out.println("New accessories code");
					         String ss_code=sc12.nextLine();
					         
					         
					         Scanner sc13= new Scanner (System.in);
					         System.out.println("New accessories code");
					         String ass_code=sc13.nextLine();
				             
					         
					         Scanner sc14= new Scanner (System.in);
					         System.out.println("New accessories code");
					         String ps_code=sc14.nextLine();
				             
					               
				             
				             //update accessories
				             String query = "update accessories set code = ? where code = ?";
				             Scanner s= new Scanner (System.in);
					         System.out.println("Update accessories code");
					         String code2=s.nextLine();
				             PreparedStatement preparedStmt = MysqlConnect.conn.prepareStatement(query);
				             preparedStmt.setString (1, code2);
				             preparedStmt.setString(2, code);
				             preparedStmt.executeUpdate();

				             break;
				             
				           }catch(SQLException s){
				             System.out.println("SQL statement is not executed!");
				           }

				              break;
						
					}
					
					case 9:{
						
						 //Employee
				           try{
				                 Statement st = MysqlConnect.conn.createStatement();
				                 
				                 Scanner sc1= new Scanner (System.in);

				                 System.out.println("New employe code:");

				                 String code=sc1.nextLine();
				                 
				                 Scanner sc2= new Scanner (System.in);

				                 System.out.println("New employe name:");

				                 String name=sc2.nextLine();
				                 
				                 Scanner sc37= new Scanner (System.in);

				                 System.out.println("New employe surname:");

				                 String surname=sc37.nextLine();
				                 
				                 Scanner sc4= new Scanner (System.in);

				                 System.out.println("Fathers name:");

				                 String f_name=sc4.nextLine();
				                 
				                 Scanner sc90= new Scanner (System.in);

				                 System.out.println("Managers name:");

				                 String mn_name=sc90.nextLine();
				                 
				                
				               
				             
				                 
				                 //update employee
				                 String query = " update employee set code = ? where code= ? " ;
				                 Scanner s= new Scanner (System.in);
				                 System.out.println("Update employee code");
				                 String code2=s.nextLine();
				                 PreparedStatement preparedStmt = MysqlConnect.conn.prepareStatement(query);
				                 preparedStmt.setString(1, code2);
				                 preparedStmt.setString(2, code);
				                 preparedStmt.executeUpdate();
				                 
				                 String query2 = " update employee set name  = ? where name= ? " ;
				                 Scanner s2= new Scanner (System.in);
				                 System.out.println("Update employee name");
				                 String name2=s2.nextLine();
				                 PreparedStatement preparedStmt2 = MysqlConnect.conn.prepareStatement(query2);
				                 preparedStmt2.setString(1, name2);
				                 preparedStmt2.setString(2, name);
				                 preparedStmt2.executeUpdate();
				                
				                 String query3 = " update employee set surname  = ? where surname= ? " ;
				                 Scanner s3= new Scanner (System.in);
				                 System.out.println("Update employee surname");
				                 String surname2=s3.nextLine();
				                 PreparedStatement preparedStmt3 = MysqlConnect.conn.prepareStatement(query3);
				                 preparedStmt3.setString(1, surname2);
				                 preparedStmt3.setString(2, surname);
				                 preparedStmt3.executeUpdate();
				                
				                
				                 String query4 = " update employee set Father's_Name  = ? where Father's_Name= ? ";
				                 Scanner s4= new Scanner (System.in);
				                 System.out.println("Update employee father's name");
				                 String f_name2=s4.nextLine();
				                 PreparedStatement preparedStmt4 = MysqlConnect.conn.prepareStatement(query4);
				                 preparedStmt4.setString(1, f_name2);
				                 preparedStmt4.setString(2, f_name);
				                 preparedStmt4.executeUpdate();
				                
				                 break;
				 
				                 
				               }catch(SQLException s){
				                 System.out.println("SQL statement is not executed!");
				               }


						break;
				           
				           
					}
					
					case 10:{
						
						  //Address
			   			try{
			   				  Statement st = MysqlConnect.conn.createStatement();
			   				  
			   				  
			   			   Scanner sc1= new Scanner (System.in);

			               System.out.println("New city name:");

			               String cname=sc1.nextLine();
			               
			               Scanner sc2= new Scanner (System.in);

			               System.out.println("Address:");

			               String aname=sc2.nextLine();
			               
			               Scanner s7= new Scanner (System.in);

			               System.out.println("address number:");

			               int num=s7.nextInt();
			               
			               Scanner sc4= new Scanner (System.in);

			               System.out.println("Postal code:");

			               String pcode=sc4.nextLine();
			               
			               Scanner sc5= new Scanner (System.in);

			               System.out.println("A code:");

			               String a_code=sc5.nextLine();
			               
			               Scanner sc115= new Scanner (System.in);

			               System.out.println("A code:");

			               String empl_code=sc115.nextLine();
			               
			               
			               
			               
			   			   
			   			   
			   			   	  //update address
			      			  String query = "update address set city_name = ? where city_name = ?";
			      			  Scanner s= new Scanner (System.in);
			                  System.out.println("Update city name:");
			                  String cname2=s.nextLine();
			   				  PreparedStatement preparedStmt = MysqlConnect.conn.prepareStatement(query);
			   				  preparedStmt.setString (1, cname2);
			   				  preparedStmt.setString(2, cname);
			   				  preparedStmt.executeUpdate();
			   				  
			   				  String query2 = "update address set city_name = ? where city_name = ?";
			     			  Scanner s2= new Scanner (System.in);
			                  System.out.println("Update address name:");
			                  String aname2=s2.nextLine();
			  				  PreparedStatement preparedStmt2 = MysqlConnect.conn.prepareStatement(query2);
			  				  preparedStmt2.setString (1, aname2);
			  				  preparedStmt2.setString(2, aname);
			  				  preparedStmt2.executeUpdate();
			  				  
			  				  
			   				  String query3 = "update address set address_number = ? where address_number = ?";
			     			  Scanner s3= new Scanner (System.in);
			                  System.out.println("Update address number:");
			                  int num2=s3.nextInt();
			  				  PreparedStatement preparedStmt3 = MysqlConnect.conn.prepareStatement(query3);
			  				  preparedStmt3.setInt (1, num2);
			  				  preparedStmt3.setInt (2, num);
			  				  preparedStmt3.executeUpdate();
			   				  
			  				  String query4 = "update address set postal_code= ? where postal_code = ?";
			    			  Scanner s4= new Scanner (System.in);
			                  System.out.println("Update postal code:");
			                  String pcode2=s4.nextLine();
			 				  PreparedStatement preparedStmt4 = MysqlConnect.conn.prepareStatement(query4);
			 				  preparedStmt4.setString (1, pcode2);
			 				  preparedStmt4.setString(2, pcode);
			 				  preparedStmt4.executeUpdate();
			 				  
			 				  String query5 = "update address set a_code= ? where a_code = ?";
			    			  Scanner s5= new Scanner (System.in);
			                  System.out.println("Update a_code:");
			                  String a_code2=s5.nextLine();
			 				  PreparedStatement preparedStmt5 = MysqlConnect.conn.prepareStatement(query5);
			 				  preparedStmt5.setString (1, a_code2);
			 				  preparedStmt5.setString(2, a_code);
			 				  preparedStmt5.executeUpdate();
			   				  
			   				  
			   				  
			   				  break;
			   				  
			   				}catch(SQLException s){
			   				  System.out.println("SQL statement is not executed!");
			   				}

			   				
			   			break;
						
					}
					
					case 11:{
						
						//phoneNumbers
				   		  
			            try{
			                  
			            		
			            	Statement st = MysqlConnect.conn.createStatement();
			                  
			                 
			                  
			                  Scanner sc5= new Scanner (System.in);

			                  System.out.println("New phone:");

			                  String phone=sc5.nextLine();
			                  
			                  
			                  Scanner sc6= new Scanner (System.in);

			                  System.out.println("New phone code:");

			                  String phonecode=sc6.nextLine();
			                  
			                  
			                  Scanner sc7= new Scanner (System.in);

			                  System.out.println("New phone code:");

			                  String employee_code=sc7.nextLine();
			                  
			                  
			                  //update phonenumbers
			                  String query5 = " update phonenumbers set phone  = ? where phone = ? ";
			                  Scanner s5= new Scanner (System.in);
			                  System.out.println("Update phone number");
			                  String phone2=s5.nextLine();
			                  PreparedStatement preparedStmt5 = MysqlConnect.conn.prepareStatement(query5);
			                  preparedStmt5.setString(1, phone2);
			                  preparedStmt5.setString(2, phone);
			                  preparedStmt5.executeUpdate();
			                  
			                  
			                  String query6 = " update phonenumbers set phonecode  = ? where phonecode = ? ";
			                  Scanner s8= new Scanner (System.in);
			                  System.out.println("Update  phone code");
			                  String phonecode2=s8.nextLine();
			                  PreparedStatement preparedStmt4 = MysqlConnect.conn.prepareStatement(query6);
			                  preparedStmt4.setString(1, phonecode2);
			                  preparedStmt4.setString(2, phonecode);
			                  preparedStmt4.executeUpdate();
			                  
			                  break;
			                  
			                }catch(SQLException s){
			                  System.out.println("SQL statement is not executed!");
			                }
			            
			            break;
			            
					}
				
				}
			
			}
			
			case 3:{
				
				  //ii
		           try{
		               Statement st = MysqlConnect.conn.createStatement();
		               ResultSet res = st.executeQuery("SELECT * FROM storage");
		               while (res.next()) {
		            	   System.out.println("Code:");
		                   String i = res.getString("code");
		                   System.out.println(i);
		                   System.out.println("Entry date:");
		                   String b= res.getString("entry_date");
		                   System.out.println(b);
		               }
		               }catch(SQLException s){
		                   System.out.println("SQL code does not execute.");
		               }	
		           break;
			}	
			
			case 4: {
				   //iii
		           try
		           {
		               Statement st = MysqlConnect.conn.createStatement();
		               String query = "Select * from accessories";
		               ResultSet res = st.executeQuery(query);

		               while (res.next()) {
		            	
		            	   System.out.println("Storage Bin: \t" + res.getInt("storage_bin_code"));
		                   System.out.println("Peceipt Batch: \t" + res.getInt("peceipt_batch_code"));  
		                   System.out.println("Accessories code: \t" +res.getString("code"));
		                   System.out.println("Assembled code: \t" +res.getInt("assembled_code"));
		               }


		           }catch(SQLException s)
		           {
		        	   System.out.println("SQL code does not execute iii.");
		           }	
		           
		           break;
			}
			
			case 5:{
				
				//find the available capacity and left capacity
				MethodIV();
			break;
			
			}
			
			case 6:{
				
				 try
		           {
		               Statement st = MysqlConnect.conn.createStatement();
		               String query = "Select * from storage_bin";
		               ResultSet res = st.executeQuery(query);
		               
		               //find the capacity that you want to change
		               Scanner sc3= new Scanner (System.in);
		               System.out.println("New capacity");
		               int capacity=sc3.nextInt();
		           	
		              
		               //update the capacity 
		               String query2 = "update storage_bin set capacity = ? where capacity = ?";
		               Scanner sc4= new Scanner (System.in);
		               System.out.println("Update capacity");
		               int capacity2=sc4.nextInt();
		          	   PreparedStatement preparedStmt2 = MysqlConnect.conn.prepareStatement(query2);
		               preparedStmt2.setInt (1,capacity2);
		               preparedStmt2.setInt(2,capacity);
		               preparedStmt2.executeUpdate();
		               
		               //do the changes in iv
		               MethodIV();
		               
		           }catch(SQLException s)
		           {
		               System.out.println("SQL code does not execute v.");
		           }
		             
				break;
			}
			
			case 7:{
				
				 //vi
	   	          try
	   	          {
	   	              Statement st = MysqlConnect.conn.createStatement();
	   	              String query = "Select * from employee ORDER by manager_name";
	   	              ResultSet res = st.executeQuery(query);


	   	              while(res.next())
	   	              {
	   	                //Display values
	   	                  System.out.println("Code: " + res.getString("code"));
	   	                  System.out.println("Name: " + res.getString("name"));
	   	                  System.out.println("Surname: " + res.getString("surname"));
	   	                  System.out.println("Father's Name: " + res.getString("Father's_name"));

	   	            }
	   	              res.close();

	   	              Statement st2 = MysqlConnect.conn.createStatement();
	   	              ResultSet res2 = st2.executeQuery("SELECT * FROM address ORDER by employee_code ");

	   	              while(res2.next())
	   	              {
	   	                  System.out.println("City Name: " + res2.getString("city_name"));
	   	                  System.out.println("Address Name: " + res2.getString("address_name"));
	   	                  System.out.println("Address Number: " + res2.getInt("address_number"));
	   	                  System.out.println("Postal Code: " + res2.getString("postal_code"));
	   	              }
	   	              res2.close();
	   	          }catch(SQLException s){
	   	              System.out.println("SQL statement is not mplou !");
	   	        }
	   	          
	   	          break;
				
			}
			
			case 8:{
				
				//vii
	   	          try
	   	          {
	   	              Statement st = MysqlConnect.conn.createStatement();
	   	              String query = "Select * from manager ORDER by name";
	   	              ResultSet res = st.executeQuery(query);

	   	              while(res.next())
	   	              {
	   	                //Display values
	   	                  System.out.println("Name: " + res.getString("name"));
	   	            }
	   	              res.close();
	   	          }catch(SQLException s){
	   	              System.out.println("SQL statement is not mpla !");
	   	        }    
	   	          
	   	          break;
			}
			
			case 9:{
				
				//viii
	   	          try
	   	          {
	   	              Statement st = MysqlConnect.conn.createStatement();
	   	              String query = "Select * from accessories ORDER by assembled_code ";
	   	              ResultSet res = st.executeQuery(query);


	   	              while(res.next())
	   	              {
	   	                //Display values
	   	                  System.out.println("Code: " + res.getString("code"));
	   	                  System.out.println("Storage Bin Code: " + res.getString("storage_bin_code"));
	   	                  System.out.println("Assembled Code: " + res.getString("assembled_code"));


	   	            }
	   	              res.close();

	   	          }catch(SQLException s){
	   	              System.out.println("SQL statement is not mpli !");
	   	        }
	   	          
	   	          
	   	          break;
	   	         
				
			}
			
			case 10:{
				
				 //ix
	   	          try
	   	          {
	   	              Statement st = MysqlConnect.conn.createStatement();
	   	              String query = "Select * from data_base ORDER by manager";
	   	              ResultSet res = st.executeQuery(query);
	   	              
	   	              
	   	              
	   	              while(res.next())
	   	              {
	   	                //Display values
	   	                  System.out.print("Manager: " + res.getString("manager"));
	   	                  System.out.println("\tOrder: " + res.getString("order_quantiry"));


	   	            }
	   	              res.close();

	   	          }catch(SQLException s){
	   	              System.out.println("SQL statement is not ix !");
	   	        }
	   	          
	   	          break;
				
			}
			
			case 11:{
				
				
				   //x
	              int count2=0;
	              try
	              {
	                  Statement st = MysqlConnect.conn.createStatement();
	                  String query = "Select * from phonenumbers ";
	                  ResultSet res = st.executeQuery(query);
	                
	                  
	                  Scanner sc3= new Scanner (System.in);
	                  System.out.println("Give the telephone that you want to delete:");
	                  String telephone=sc3.nextLine();
	                  
	                  Scanner sc4= new Scanner (System.in);
	                  System.out.println("Give the employee code that you want to find:");
	                  String code=sc4.nextLine();
	  
	               
	                  

	                  while(res.next())
	                  {
	                	  
	                      if (res.getString("employee_code").equals(code) )
	                      {
	                          count2++;                     
	                      }
	                   
	                    }
	                  if(count2 > 1)
	                  {
	                	  String query2 = "Select * from phonenumbers ";
	                      ResultSet res2 = st.executeQuery(query2);
	                	  while (res2.next()) {
	                		  String telephone2=res2.getString("phone");
	                	  		if ((telephone).equals(telephone2)) {
	                	  		   String sql = "DELETE FROM phonenumbers WHERE phonenumbers.phone = '"+telephone+"'";
	                               st.executeUpdate(sql);
	                              System.out.println("The phone has been deleted");
	                           }
	                          else {
	                        	  System.out.println("The phone has not been found");
	                          }
	                      }
	                  }
	                  else {
	                	  System.out.println("There is only one telephone in data base");
	                  }          
	              }catch(SQLException s){
	                  System.out.println("");
	            }
	              break;
			}
		}		
		}while (choice<0 || choice>11); 
		}
}	
}




	
	
	




   	          
       


