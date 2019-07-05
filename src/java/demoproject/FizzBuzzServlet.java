/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ed Armstrong
 */
@WebServlet(name = "FizzBuzz", urlPatterns = {"/FizzBuzz"})
public class FizzBuzzServlet extends HttpServlet {
    PrintWriter out;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet NewServlet</title>");
        out.println("</head>");
        out.println("<body>");
        this.run();
        out.println("</body>");
        out.println("</html>");
    }

    public void run() {
        Random r = new Random();
        for (int i = 0; i < 45; i++) {
            this.eval(r.nextInt(100));
        }
    }

    private void eval(int nextInt) {
        if (nextInt % 15 == 0) {
            this.fizzBuzz(nextInt);
        } else if (nextInt % 3 == 0) {
            this.fizz(nextInt);
        } else if (nextInt % 5 == 0) {
            this.buzz(nextInt);
        }
    }

    public void fizz(int nextInt){
        out.println("<div>fizz " + nextInt + "</div>");
    }
    
    public void buzz(int nextInt){
        out.println("<div>buzz " + nextInt + "</div>");
    }
    
    public void fizzBuzz(int nextInt){
        out.println("<div>fizzBuzz " + nextInt + "</div>");
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
