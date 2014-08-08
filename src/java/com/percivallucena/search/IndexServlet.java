/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.percivallucena.search;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author percivallucena
 */
public class IndexServlet extends HttpServlet {

       
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
              ServletContext servletContext = this.getServletContext();
              if(servletContext.getAttribute("index") == null){
                 Index index = new Index();
                 servletContext.setAttribute("index", index);
                 response.getWriter().print("INDEX CREATED ");
             } 
             else
                 response.getWriter().print("INDEX  ALREADY CREATED");
                    
    }

     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "INDEX SERVLET";
    }// </editor-fold>

}
