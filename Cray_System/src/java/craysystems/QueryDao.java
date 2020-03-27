/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package craysystems;

import java.text.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author VitaKing
 */
public class QueryDao {
    static Connection InsertCon = null;
    
    static ResultSet InsertRs = null;
    
    
     public static UserBean Queries(UserBean queries){
        
        Statement InsertStmt = null;

        String status = queries.getStatus();
        String description = queries.getDescription();
        String assignedTo = queries.getAssigned();
        String c_level = queries.getClevel();
        String resolution = queries.getResolution();
         
      
        String QueryCheck = "SELECT * FROM SCOTT.QUERY FETCH FIRST 100 ROWS ONLY";
        String InsertQuery = "INSERT INTO SCOTT.QUERY (STATUS, DESCRIPTION, CRITICAL_LEVEL, ASSIGNED_TO, RESOLUTION) VALUES ('"+status +"','" + description + "','" + c_level + "','" + assignedTo + "','" +resolution+"')";
        System.out.println("Query: "+InsertQuery);
        
        try{
//            
            InsertCon = ConnectionManager.getConnection();
//            
            InsertStmt = InsertCon.createStatement();
//            
            InsertRs = InsertStmt.executeQuery(QueryCheck);
             List<String> qlist1 = new ArrayList<>();
             List<String> qlist2= new ArrayList<>();
             List<String> qlist3 = new ArrayList<>();
             List<String> qlist4 = new ArrayList<>();
             List<String> qlist5 = new ArrayList<>();
             List<String> qlist6 = new ArrayList<>();
             
//            while(InsertRs.next()){
//                String queryId = String.valueOf(InsertRs.getInt("Id"));
//                String istatus = InsertRs.getString("status");
//                String idescription = InsertRs.getString("description");
//                String ic_level = InsertRs.getString("critical_level");
//                String iassignedTo = InsertRs.getString("assigned_to");
//                String iresolution = InsertRs.getString("resolution");
//                
//                qlist1.add(queryId);
//                qlist2.add(istatus);
//                qlist3.add(idescription);
//                qlist4.add(ic_level);
//                qlist5.add(iassignedTo);
//                qlist6.add(iresolution);
//                
//                queries.isetQueryId(qlist1);
//                queries.isetStatus(qlist2);
//                queries.isetDescription(qlist3);
//                queries.isetClevel(qlist4);
//                queries.isetAssigned(qlist5);
//                queries.isetResolution(qlist6);
//                
//                
//        }
            
            if(queries.getAssigned()!= null){
             boolean InRs = InsertStmt.execute(InsertQuery);
            }
            
           
            
            
        } catch (SQLException ex) {
              Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            if (InsertRs != null)	{
               try {
                 InsertRs.close();
               } catch (Exception e) {}
                  InsertRs = null;
               }

            if (InsertStmt != null) {
               try {
                  InsertStmt.close();
               } catch (Exception e) {}
                  InsertStmt = null;
               }

            if (InsertCon != null) {
               try {
                  InsertCon.close();
               } catch (Exception e) {
               }

               InsertCon = null;
            }
        }
        
          
          return queries;
      }
}
