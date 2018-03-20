/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebApp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nitin
 */
@WebServlet(name = "options", urlPatterns = {"/chooseOptions"})
public class options extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet options</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet options at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String model = request.getParameter("model");
        String audio = request.getParameter("audio");
        String bluetooth = request.getParameter("bluetooth");
        String navigation = request.getParameter("navigation");
        
        MercedesStore mercedes = new MercedesStore();
        if ((audio.equals(null)) && (bluetooth.equals(null)) && (navigation.equals(null))){
            mercedes.makeOne(model);   
        }
        if ((audio != null) && (bluetooth.equals(null)) && (navigation.equals(null))){
            mercedes.makeOneBonus(model,"Audio");
        }
        if ((bluetooth != null) && (audio.equals(null)) && (navigation.equals(null))){
            mercedes.makeOneBonus(model,"Bluetooth");
        }
         if ((navigation != null) && (audio.equals(null)) && (bluetooth.equals(null))){
            mercedes.makeOneBonus(model,"Navigation");
        }
         if ((navigation != null) && ((audio != null)) && (bluetooth.equals(null))){
            mercedes.makeTwoBonus(model,"Navigation","Audio");
         }
         if ((navigation != null) && ((bluetooth != null)) && (audio.equals(null))){
            mercedes.makeTwoBonus(model,"Navigation","Bluetooth");
        }
          if ((bluetooth != null) && ((audio != null)) && (navigation.equals(null))){
            mercedes.makeTwoBonus(model,"Bluetooth","Audio");
        }
          if ((navigation != null) && ((audio != null)) && (bluetooth !=null)){
            mercedes.makeThreeBonus(model);
        } 
            
         
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
