
<%@page import="java.text.NumberFormat"%>
<%@page import="Project2.Calculations"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Style/style.css">
        <title>Depreciation Table</title>
    </head>
   
    <body>
        <div id="units">
        <jsp:useBean id="mybean" scope="session" class="Project2.Calculations"> </jsp:useBean> 
        <p>Cost is <jsp:getProperty name="mybean" property="cost" /><br/>
        Scrap is <jsp:getProperty name="mybean" property="scrap" /><br/>
        Number of Years is <jsp:getProperty name="mybean" property="years" /><br/>
        Method: <jsp:getProperty name="mybean" property="method" /><br/><br/></p>

      
        <% 
        NumberFormat formatter = NumberFormat.getInstance(); 
        formatter.setMaximumFractionDigits(2);	
        formatter.setMinimumFractionDigits(2);	
        %>      
        <%
            
      double cost = mybean.getCost();
      double scrap = mybean.getScrap();
            
      double baseline=(cost-scrap);           
 
      String[] units=request.getParameterValues("units");  
      double total_miles=mybean.getMiles_check();
      
      double depr_per_miles = baseline/total_miles;
         %>  
     
        <h2>Depreciation Table:</h2>
    <center>
      <table BORDER="1">
                <TR>
                    <TH>YEAR</TH>
                    <TH>DEPRECIATION</TH>
                    <TH>ACCUM.DEPRECIATION</TH>
                </TR>  
     
      <%double accumulated=0;%>
  
      <%for (int i = 0; i < mybean.getYears(); i++) {%>  
          <% accumulated+=(Double.parseDouble(units[i])*depr_per_miles); %>
      <TR>
                    <TD> <%= i+1 %> </TD>
                    <TD> <%=formatter.format(Double.parseDouble(units[i])*depr_per_miles)%> </TD>
                     <TD><%=formatter.format(accumulated)%></TD>
                </TR>   
       
<%}%>           
      </table>   
    </center>
</div>
    </body>
</html>
