<%@page import="java.util.*" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet"%>
<%@page language="java" import="java.sql.*"%>
 <%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String username = request.getParameter("uid");
    String password = request.getParameter("password");
    ResultSet rs;
      
     
        Connection con = null;
            try{
              
              Class.forName("com.mysql.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tfi","root","password");
            String send="";
           
        Statement st = con.createStatement();
        String absstr="";
        String strQuery=null, strQuery1=null;
        
        
        strQuery = "select count(*) from userfti where userid='"+username+"' and pwd='"+password+"'";
        rs = st.executeQuery(strQuery);
        while(rs.next())
        {
             
              if(rs.getInt(1) > 0)
            {
                Statement st1 = con.createStatement();
               ResultSet rs2=st1.executeQuery("select * from teaching where fid='"+username+"'");
               rs2.next(); 
               String s=rs2.getString("cid");
                ResultSet rs4=st1.executeQuery("select * from student where cid like '"+s+"'");
                send="true#"+s;
                while(rs4.next())
                                       {
                    send+="#"+rs4.getString("sid");
                    send+="#"+rs4.getString("sname");
                }
             }

            else
            {
                out.print("false");
             }
              out.print(send);
        }
       
       }
            catch(Exception e)
            {
                           out.print("false");
                    }
    
%>