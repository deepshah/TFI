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


        String date = request.getParameter("theDate");
        
        String c_id=request.getParameter("cid");
        //out.println(date+c_id);
        Statement stmt = con.createStatement();
        String q = "select count(*) from attendance where cid = '" + c_id + "'" + "  and studentstatus='P' and dateid='" + date + "'";
        out.print(c_id+date);
        ResultSet rs = stmt.executeQuery(q);
        while (rs.next()) {
            RequestDispatcher rd = request.getRequestDispatcher("stats.jsp");
            out.print("   "+rs.getString(1));
            request.setAttribute("count", rs.getString(1));
            request.setAttribute("dtt", date);
            rd.forward(request, response);
        }

    } catch (Exception e) {
        out.println(e.getMessage());
    }

%>