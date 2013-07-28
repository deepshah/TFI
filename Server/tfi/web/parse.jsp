<%-- 
    Document   : index
    Created on : Jul 27, 2013, 3:29:07 PM
    Author     : Administrator
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Date"%>

        <%
            Connection con = null;
            try
            {
              
              Class.forName("com.mysql.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tfi","root","password");
               if(con==null)
              {
                  out.print("connection error");
              }
              
            }
            catch(Exception e)
                {
                out.println(e.getMessage());
                }
            try
            {
            
                String str = request.getParameter("Body") ;
                //out.println(str);
                int l=str.length();
                String attendee= str.substring(11,l);
                String updateArray[]= attendee.split("#");
              //  for(int j=0;j<updateArray.length;j++)
                //    out.println(updateArray[j]);

            Date d=new Date();
            SimpleDateFormat p=new SimpleDateFormat("yyyy-MM-dd");
                    Date d1=new Date();
                    String d12=p.format(d);   
                    Statement st = con.createStatement();
       
                    ResultSet rs = st.executeQuery("select sid from student where cid='"+updateArray[0]+"'");
       
                    while(rs.next())    
                    {
                    
                    Statement gt=con.createStatement();
                    gt.execute("insert into attendance (sid,cid,studentstatus,dateid) values('"+rs.getString(1)+"','"+updateArray[0]+"','P','"+d12+"')");             
                  
                    }   
            for(int i=3; i<updateArray.length;i++)
            {
                Statement gt1=con.createStatement();
                try
                {
                    gt1.executeUpdate("update attendance set studentstatus='A' where sid='"+updateArray[i]+"'");             
                }
                catch(Exception e)
                {
                   out.println(e);
                }              


            }
            //out.println("updated");    
            }
            catch(Exception e)
            {
            out.println(e.getMessage());
            }
    %>
