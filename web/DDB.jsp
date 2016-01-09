

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
        Number of Years is <jsp:getProperty name="mybean" property="years" /><br/></p>
        <h2>Depreciation Method is Double Declining Balance</h2><br/>
<% 
NumberFormat formatter = NumberFormat.getInstance(); 
formatter.setMaximumFractionDigits(2);	
formatter.setMinimumFractionDigits(2);	
%>         
        <%double accumulated=0;%> 
       
        <h2>Depreciation Table:</h2>
        <center>
      <table border="1">
                <TR>
                    <TH>YEAR</TH>
                    <TH>DEPRECIATION</TH>
                    <TH> ACCUM.DEPRECIATION</TH>
                </TR>  
        
   
   <%double depreciation=0;%> 
   
      <%for (int i = 0; i < mybean.getYears(); i++) {    
              
               depreciation=mybean.getDDDepreciation();
               accumulated=depreciation + accumulated; 
      
               
               if (accumulated >((mybean.getCost())-mybean.getScrap()))
               {
               accumulated=(mybean.getCost())-mybean.getScrap();
               depreciation=mybean.getDDDepreciation()-(accumulated-((mybean.getCost())-mybean.getScrap()));
               }
      %> 
               
      
      <TR>
                    <TD> <%= i+1 %> </TD>
                    <TD> <%=formatter.format(depreciation)%> </TD>
                     <TD><%=formatter.format(accumulated)%></TD>
                </TR>     

<%}%>        
      </table>
        </center>
        </div>
    </body>
</html>

