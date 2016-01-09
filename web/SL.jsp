

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
   <div id="units">
    <body>
        <jsp:useBean id="mybean" scope="session" class="Project2.Calculations"> </jsp:useBean> 
        <p>Cost is <jsp:getProperty name="mybean" property="cost" /><br/>
        Scrap is <jsp:getProperty name="mybean" property="scrap" /><br/>
        Number of Years is <jsp:getProperty name="mybean" property="years" /><br/>
        Tracking <jsp:getProperty name="mybean" property="tracking" /><br/></p>
        <h2>Depreciation Method is Straight-Line</h2><br/>
      
        <%=mybean.getTracking()%>
 <% 
NumberFormat formatter = NumberFormat.getInstance(); 
formatter.setMaximumFractionDigits(2);	
formatter.setMinimumFractionDigits(2);	
%>     

        <h2>Depreciation Table:</h2>
    <center>
      <table BORDER="1">
                <TR>
                    <TH>YEAR</TH>
                    <TH>DEPRECIATION</TH>
                    <TH> ACCUM.DEPRECIATION</TH>
                </TR>  
        
        <%double accumulated=mybean.getSLDepreciation();%>
  
      <%for (int i = 0; i < mybean.getYears(); i++) {%>    
                <TR>
                    <TD> <%= i+1 %> </TD>
                    <TD> <%=formatter.format(mybean.getSLDepreciation())%> </TD>
                     <TD><%=accumulated%></TD>
                </TR>
          <% accumulated=mybean.getSLDepreciation() + accumulated; %>      

<%}%>        
      </table> 
      </center>
   </div>
    </body>
</html>
