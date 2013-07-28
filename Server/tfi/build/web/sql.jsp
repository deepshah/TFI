<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%! 
  Connection con = null;
  Statement state = null;
  ResultSet rs = null;
%>
<%
 try
 {
  Class.forName("com.mysql.jdbc.Driver").newInstance();
  out.print("done");
  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tfi","root","password");
  state = con.createStatement();
  rs=state.executeQuery("select * from userfti");
  while(rs.next()){
  String op=rs.getString("userid");
  String op1=rs.getString("pwd");
  String op2=rs.getString("usertype");
  out.print(op+"  "+op1+" "+op2);
   }
 }
 
 catch(SQLException e)
 {
  out.print(e.getMessage());
 }
 
%>
