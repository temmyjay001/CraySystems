/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package craysystems;

/**
 *
 * @author VitaKing
 */

import java.text.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

   public class UserDAO 	
   {
      static Connection currentCon = null;
      
      static Connection UsercurrentCon = null;
      
      static Connection InsertCon = null;
      
      static ResultSet UserRs = null;
      
      static ResultSet rs = null;  
      
      static ResultSet InsertRs = null;
      
      static String Allrole;
      
      
      
	
      public static UserBean login(UserBean bean) {
	
         //preparing some objects for connection 
         Statement stmt = null;    
         
         Statement Userstmt = null;
         
         Statement InsertStmt = null;
         
	 String[] array = null;
         String username = bean.getUsername();    
         String password = bean.getPassword(); 
         
         
	    
         String searchQuery =
               "select * from users where username='"
                        + username
                        + "' AND password='"
                        + password
                        + "'";
        
         String UserQuery = "select * from users";
         
         String QueryCheck = "SELECT * FROM SCOTT.QUERY FETCH FIRST 100 ROWS ONLY";
         
      // "System.out.println" prints in the console; Normally used to trace the process
      System.out.println("Your user name is " + username);          
      System.out.println("Your password is " + password);
      System.out.println("Query: "+searchQuery);
      
        
      try 
      {
         //connect to DB 
         currentCon = ConnectionManager.getConnection(); 
         stmt=currentCon.createStatement();
         rs = stmt.executeQuery(searchQuery);	
         
         UsercurrentCon = ConnectionManager.getConnection();
         Userstmt=UsercurrentCon.createStatement();
         UserRs = Userstmt.executeQuery(UserQuery);
         
         InsertCon = ConnectionManager.getConnection();
         InsertStmt = InsertCon.createStatement();
         InsertRs = InsertStmt.executeQuery(QueryCheck);
         boolean more = rs.next(); 
         
	 
         List<String> list = new ArrayList<>();
         while(UserRs.next()) {
               String UfirstName = UserRs.getString("FirstName") +" "+ UserRs.getString("LastName") ;
               
               list.add(UfirstName);

        }
         
       
            List<UserBean> users=new ArrayList<>();
            while(InsertRs.next()){
               UserBean beans = new UserBean() ;
                beans.isetQueryId(String.valueOf(InsertRs.getInt("Id")));
                beans.isetStatus(InsertRs.getString("status"));
                beans.isetDescription(InsertRs.getString("description"));
                beans.isetClevel(InsertRs.getString("critical_level"));
                beans.isetAssigned(InsertRs.getString("assigned_to"));
                beans.isetResolution(InsertRs.getString("resolution"));
                
                users.add(beans);
            }
        
//        

         // if user does not exist set the isValid variable to false
         if (!more) 
         {
            System.out.println("Sorry, you are not a registered user! Please sign up first");
            bean.setValid(false);
         } 
	     
         //if user exists set the isValid variable to true
         else if (more) 
         {
            
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            String role = rs.getString("Role");
	     	
            System.out.println("Welcome " + username);
            
            bean.setFirstName(firstName);
            bean.setLastName(lastName);
            bean.setRole(role);
            bean.setFullName(list);
            bean.setValid(true);
            
            
            
            
            
            
//            bean.setAqueries(q);
//            System.out.println(bean.igetQueryId());
//            System.out.println(bean.getFullName());
//            System.out.println(q);
//            System.out.println(bean.getQueries());
            
         }
      } 

      catch (SQLException ex) 
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      }  
      //some exception handling
      finally 
      {
         if (rs != null)	{
            try {
               rs.close();
            } catch (Exception e) {}
               rs = null;
            }
	
         if (stmt != null) {
            try {
               stmt.close();
            } catch (Exception e) {}
               stmt = null;
            }
	
         if (currentCon != null) {
            try {
               currentCon.close();
            } catch (Exception e) {
            }

            currentCon = null;
         }
         
         
         
         
      }
      

return bean;
	
      }
      
     
   }
