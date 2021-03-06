/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package craysystems;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author VitaKing
 */
public class login_validation extends HttpServlet {
RequestDispatcher dispatch;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");
        Map<String, String> messages = new HashMap<>();
        request.setAttribute("messages", messages);
      
        UserBean user = new UserBean();
        UserBean query = new UserBean();
        user.setUserName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        user = UserDAO.login(user);
        
        

            if (user.isValid())
            {     
                query = QueryDao.Queries(query);
                HttpSession session = request.getSession(true);	    
                session.setAttribute("currentSessionUser",user); 
                session.setAttribute("queries", query);
                messages.put("message", "Username and password incorrect");
//                session.setMaxInactiveInterval(20);
                response.sendRedirect("homepage.jsp");//logged-in page      		
            }

            else{
                   messages.put("message", "Username and password incorrect");
                   dispatch = request.getRequestDispatcher("login_page.jsp"); 
                   dispatch.forward(request, response);
            }
            
          
            
        } 
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        
            
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
