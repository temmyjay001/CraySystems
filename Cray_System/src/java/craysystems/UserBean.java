/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package craysystems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VitaKing
 */
public class UserBean {
	
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    private List<String> Fullname;
    public boolean valid;
    public String description;
    public String  status;
    public String c_level;
    public String Ass;
    public String  Res;
    public String idescription;
    public String  istatus;
    public String ic_level;
    public String iAss;
    public String  iRes;
    public String  iqd;
    private ArrayList<String[]> aQueries;
	
	
      public String getFirstName() {
         return firstName;
	}

      public void setFirstName(String newFirstName) {
         firstName = newFirstName;
	}

	
      public String getLastName() {
         return lastName;
			}

      public void setLastName(String newLastName) {
         lastName = newLastName;
			}
			

      public String getPassword() {
         return password;
	}
      
      public void setRole(String newRole) {
         role = newRole;
        }
      
      public String getRole() {
         return role;
	}
      public void setFullName(List<String> newRole) {
         Fullname = newRole;
        }
      
      public List<String> getFullName() {
         return Fullname;
	}
      
    

      public void setPassword(String newPassword) {
         password = newPassword;
	}
	
			
      public String getUsername() {
         return username;
      }

      public void setUserName(String newUsername) {
         username = newUsername;
			}

				
      public boolean isValid() {
         return valid;
	}

      public void setValid(boolean newValid) {
         valid = newValid;
	}
      
      public void setStatus(String Nstatus){
          status = Nstatus;
      }
      public String getStatus(){
          return status;
      }
      public void setDescription(String Ndescription){
          description = Ndescription;
      }
      
      public String getDescription(){
          return description;
      }
      public void setClevel(String NcLevel){
          c_level = NcLevel;
      }
      public String getClevel(){
          return c_level;
      }
      public void setAssigned(String NewAss){
          Ass = NewAss;
      }
      
      public String getAssigned(){
          return Ass;
      }
      public void setResolution(String NewRes){
          Res = NewRes;
      }
      
      public String getResolution(){
          return Res;
      }
        public void isetStatus(String Nstatus){
          istatus = Nstatus;
      }
      public String igetStatus(){
          return istatus;
      }
      public void isetDescription(String Ndescription){
          idescription = Ndescription;
      }
      
      public String igetDescription(){
          return idescription;
      }
      public void isetClevel(String NcLevel){
          ic_level = NcLevel;
      }
      public String igetClevel(){
          return ic_level;
      }
      public void isetAssigned(String NewAss){
          iAss = NewAss;
      }
      
      public String igetAssigned(){
          return iAss;
      }
      public void isetResolution(String NewRes){
          iRes = NewRes;
      }
      
      public String igetResolution(){
          return iRes;
      }
      public void isetQueryId(String niqd){
          iqd = niqd;
      }
      
      public String igetQueryId(){
          return iqd;
      }
      
      public ArrayList<String[]> getQueries(){
          return aQueries;
      }
      public void setAqueries(ArrayList<String[]> aq){
          aQueries = aq;
      }
}
