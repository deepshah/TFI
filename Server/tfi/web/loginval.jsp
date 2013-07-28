<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
    try {
        ServletContext cont = config.getServletContext();
        String url = cont.getInitParameter("url");
        String username = cont.getInitParameter("username");
        String password = cont.getInitParameter("password");
        Class.forName(cont.getInitParameter("class")).newInstance();
        Connection con = DriverManager.getConnection(url, username, password);
        Statement state = con.createStatement();
        String id=request.getParameter("id");
        String pass=request.getParameter("passwd");
        if(id.matches("")==true || pass.matches(""))
        {
           RequestDispatcher rd=request.getRequestDispatcher("./index.jsp");
           String msg="Wrong ID or Password. Reenter it.";
           request.setAttribute("msg", msg);
           rd.forward(request, response);
        }else
        {
           String query="select * from userfti where userid like "+id; 
           ResultSet rs=state.executeQuery(query);
           if(!rs.next())
           {
               RequestDispatcher rd=request.getRequestDispatcher("./index.jsp");
                String msg="Wrong ID or Password. Reenter it.";
                request.setAttribute("msg", msg);
                rd.forward(request, response);
           }else if(id.matches(rs.getString("userid"))==true && pass.matches(rs.getString("pwd"))==true)
           {
               
               String temp=rs.getString("userid");
               session.setAttribute("uid",temp );
               RequestDispatcher rd=request.getRequestDispatcher("./home.jsp");
                String msg="Welcome "+temp;
                request.setAttribute("msg", msg);
                rd.forward(request, response);
           }
        }
    } catch (Exception ex) {
        out.print(ex.getMessage());
    }

%>