
<%@ page import="java.io.*,java.util.*" %>
<%@page import="Project2.Calculations"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Style/style.css">
        <title>Units/Amount of miles driven</title>
    </head>
    <body>
        <jsp:useBean id="mybean" scope="session" class="Project2.Calculations"></jsp:useBean>
        <jsp:setProperty name="mybean" property="tracking" value ="units" />
        <div id="units">
       <h2> Please enter total miles/units you anticipate to consume in  <jsp:getProperty name="mybean" property="years" /> years:</h2>
     
       <form action="Depreciate" method="get">
        <input type ="text" name = "total_miles" /><br/><br/>
          <h2>Amount per year:</h2> 
           <input type="hidden" name="tracking" value="units">
           <center>
           <table BORDER="">
               <center>
                <TR>
                    <TH>Year</TH>
                    <TH>Amount</TH>
                </TR> 
             
             <%for (int i = 0; i < Integer.parseInt(request.getParameter("years")); i++) {%> 
           
                <TR>
                    <TD> <%= i+1 %> </TD>
                    <TD><input type ="text" name = "units" /></TD>
                </TR>   
       
             <%}%>
             
           </table> 
          </center>

    <p><input type = "submit" name = "Submit" value = "Compute Depreciation" /> 
    <input type = "reset" value = "Reset" /></p>            
      </form>  
      </div>
    </body>
</html>

