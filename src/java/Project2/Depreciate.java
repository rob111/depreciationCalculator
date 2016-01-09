
package Project2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Depreciate extends HttpServlet {
  
   String tracking;
    
   double cost;
   double scrap;
   int years;
   String method;
   String redirectURL;
   Calculations calc = new Calculations();
   String [] units;
   Double [] convert_units;
   
   double total;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

   try {
       if (request.getParameter("cost") == null || request.getParameter("scrap") == null 
           || request.getParameter("years") == null) {out.println("<h2> Error: All Fields are required. Please Start Over.</h2>  ");

   }
  else {
      
           cost=Double.parseDouble(request.getParameter("cost")) ; 
           scrap=Double.parseDouble(request.getParameter("scrap")) ; 
           years=Integer.parseInt(request.getParameter("years")) ; 
           method= request.getParameter("method");
           tracking=request.getParameter("tracking");
    
    
       calc.setCost(cost);
       calc.setScrap(scrap);
       calc.setYears(years);
       calc.setMethod(method);
       calc.setTracking(tracking);
         
       HttpSession httpSession = request.getSession();
       httpSession.setAttribute("mybean", calc); 
        
       if (request.getParameter("method").equalsIgnoreCase("SL")){
       redirectURL = "/SL.jsp";
       } 
       else if (request.getParameter("method").equalsIgnoreCase("SYD")){
       redirectURL = "/SYD.jsp";
       } 
       else if (request.getParameter("method").equalsIgnoreCase("DDB")){
       redirectURL = "/DDB.jsp";
       } 
        else{
       redirectURL = "/Units.jsp";
       }
       RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(redirectURL);
       dispatcher.forward(request,response); 
       
   } }
    catch(Exception ex) {
  out.println("<h2> Error: All Fields are required. Please Start Over.</h2>  ");
    }  
   if ( "units".equals(request.getParameter("tracking")))
   { 
    double sum=0;
    
    total=Double.parseDouble(request.getParameter("total_miles")) ; 
    out.println(total);
    units=request.getParameterValues("units");
       
     for (int i = 0; i < units.length; i++) 
       { 
        sum+=Double.parseDouble(units[i]);
       }
    calc.setMiles_check(sum);
    if (total!=sum){out.println("<h2>Please check the amount of miles driven per year and the total. Amounts doesn't match.</h2>");}
    else{
    redirectURL = "/UP.jsp";
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(redirectURL);
    dispatcher.forward(request,response); }
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
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
 public static void main(String[] args) throws IOException {
 
 
 
 
 
 
 
 }
}
