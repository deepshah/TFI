<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Connection" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"[]>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US" xml:lang="en">
    <head>
        <!--
        Created by Artisteer v3.0.0.41778
        Base template (without user's data) checked by http://validator.w3.org : "This page is valid XHTML 1.0 Transitional"
        -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Chennai</title>
        <meta name="description" content="Description" />
        <meta name="keywords" content="Keywords" />


        <link rel="stylesheet" href="style.css" type="text/css" media="screen" />
        <!--[if IE 6]><link rel="stylesheet" href="style.ie6.css" type="text/css" media="screen" /><![endif]-->
        <!--[if IE 7]><link rel="stylesheet" href="style.ie7.css" type="text/css" media="screen" /><![endif]-->

        <script type="text/javascript" src="jquery.js"></script>
        <script type="text/javascript" src="script.js"></script>
    </head>
    <body>
        <div id="art-page-background-glare">
            <div id="art-page-background-glare-image"> </div>
        </div>
        <div id="art-main">
            <div class="cleared reset-box"></div>
            <div class="art-sheet">
                <div class="art-sheet-tl"></div>
                <div class="art-sheet-tr"></div>
                <div class="art-sheet-bl"></div>
                <div class="art-sheet-br"></div>
                <div class="art-sheet-tc"></div>
                <div class="art-sheet-bc"></div>
                <div class="art-sheet-cl"></div>
                <div class="art-sheet-cr"></div>
                <div class="art-sheet-cc"></div>
                <div class="art-sheet-body">
                    <div class="art-header">
                        <div class="art-header-clip">
                            <div class="art-header-center">
                                <div class="art-header-jpeg"></div>
                            </div>
                        </div>
                        <div class="art-headerobject"></div>

                        <div class="art-logo">
                           <table><tr><td><img src="images/TFI_Logo.jpg" width="115" hight="115"></td><td width="100%"><h1 class="art-logo-name"><a href="./index.html">sarva-vidya.edu</a></h1>
                                        <h2 class="art-logo-text">Teach for india...</h2></td><td><img width="70" hight="100"></td><td></td><td><font size="2" color="blue"></font></td></tr></table>

                        </div>
                    </div>
                    <div class="cleared reset-box"></div>
                    <div class="art-nav">
                        <div class="art-nav-l"></div>
                        <div class="art-nav-r"></div>
                        <div class="art-nav-outer">
                            <ul class="art-hmenu">
                                <li>
                                    <a href="./mumbai.jsp" class="active"><span class="l"></span><span class="r"></span><span class="t">Mumbai</span></a>
                                </li>	
                                <li>
                                    <a href="./delhi.jsp" class="active"><span class="l"></span><span class="r"></span><span class="t">Delhi</span></a>
                                </li>	
                                <li>
                                    <a href="./chennai.jsp" class="active"><span class="l"></span><span class="r"></span><span class="t">Chennai</span></a>
                                </li>
                                <li>
                                    <a href="./index.jsp" class="active"><span class="l"></span><span class="r"></span><span class="t">Logout</span></a>
                                </li>


                            </ul>
                        </div>
                    </div>
                    <div class="cleared reset-box"></div>
                    <div class="art-content-layout">
                        <div class="art-content-layout-row">
                            <div class="art-layout-cell art-sidebar1">

                                <div class="cleared"></div>
                            </div>
                            <div class="art-layout-cell art-content">
                                <div class="art-post">
                                    <div class="art-post-body">
                                        <div class="art-post-inner art-article">
                                            <h2 class="art-postheader">
Chennai >
                                            </h2>
                                            <div class="cleared"></div>
                                              <div class="art-postcontent">
                                                  <h3>Select School</h3>
                                                  <table  width="100%" border="0" align="left"><thead><tr><th>School ID</p></th><th>School Name</th><th>City</th><th></th></tr></thead><tbody>
                                                <%
                                                try {
                                                        ServletContext cont = config.getServletContext();
                                                        String url = cont.getInitParameter("url");
                                                        String username = cont.getInitParameter("username");
                                                        String password = cont.getInitParameter("password");
                                                        Class.forName(cont.getInitParameter("class")).newInstance();
                                                        Connection con = DriverManager.getConnection(url, username, password);
                                                        Statement state = con.createStatement();
                                                        String query = "select * from school where city like 'Chennai' and userid like "+session.getAttribute("uid").toString();
                                                        ResultSet rs=state.executeQuery(query);
                                                        String school="",schname="",city="";
                                                        while(rs.next()){
                                                            school=rs.getString("schid");
                                                            schname=rs.getString("schname");
                                                            city=rs.getString("city");
                                                            out.print("<form action='school.jsp' method='post'><tr><td><p align='center'>"+school+"</p></td><td><p align='center'>"+schname+"</p></td><td><p align='center'>"+city+"</p></td><td><p align='center'><input type='hidden' name='schid' value='"+school+"'><input type='hidden' name='start0' value='Chennai >'><input type='submit' name='view' value='View'/></input></p></td></tr></form>");
                                                        }
                                                    } catch (Exception e) {
                                                    }%>
                                                
                                                            
                                                

                                                
                                                </tbody>
                                                </table>
                                            </div>
                                            <div class="cleared"></div>
                                        </div>

                                        <div class="cleared"></div>
                                    </div>
                                </div>

                                <div class="cleared"></div>
                            </div>
                        </div>
                    </div>
                    <div class="cleared"></div>
                    <div class="art-footer">
                        <div class="art-footer-t"></div>
                        <div class="art-footer-body">
                            <a href="#" class="art-rss-tag-icon" title="RSS"></a>
                            <div class="art-footer-text">


                                <p>Copyright © 2011. All Rights Reserved.</p>


                            </div>
                            <div class="cleared"></div>
                        </div>
                    </div>
                    <div class="cleared"></div>
                </div>
            </div>
            <div class="cleared"></div>
            
            <div class="cleared"></div>
        </div>

    </body>
</html>