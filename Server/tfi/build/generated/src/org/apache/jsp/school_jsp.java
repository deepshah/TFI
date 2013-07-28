package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

public final class school_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"[]>\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" dir=\"ltr\" lang=\"en-US\" xml:lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <!--\n");
      out.write("        Created by Artisteer v3.0.0.41778\n");
      out.write("        Base template (without user's data) checked by http://validator.w3.org : \"This page is valid XHTML 1.0 Transitional\"\n");
      out.write("        -->\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("        <title>New Page</title>\n");
      out.write("        <meta name=\"description\" content=\"Description\" />\n");
      out.write("        <meta name=\"keywords\" content=\"Keywords\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\" media=\"screen\" />\n");
      out.write("        <!--[if IE 6]><link rel=\"stylesheet\" href=\"style.ie6.css\" type=\"text/css\" media=\"screen\" /><![endif]-->\n");
      out.write("        <!--[if IE 7]><link rel=\"stylesheet\" href=\"style.ie7.css\" type=\"text/css\" media=\"screen\" /><![endif]-->\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" src=\"jquery.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"script.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"art-page-background-glare\">\n");
      out.write("            <div id=\"art-page-background-glare-image\"> </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"art-main\">\n");
      out.write("            <div class=\"cleared reset-box\"></div>\n");
      out.write("            <div class=\"art-sheet\">\n");
      out.write("                <div class=\"art-sheet-tl\"></div>\n");
      out.write("                <div class=\"art-sheet-tr\"></div>\n");
      out.write("                <div class=\"art-sheet-bl\"></div>\n");
      out.write("                <div class=\"art-sheet-br\"></div>\n");
      out.write("                <div class=\"art-sheet-tc\"></div>\n");
      out.write("                <div class=\"art-sheet-bc\"></div>\n");
      out.write("                <div class=\"art-sheet-cl\"></div>\n");
      out.write("                <div class=\"art-sheet-cr\"></div>\n");
      out.write("                <div class=\"art-sheet-cc\"></div>\n");
      out.write("                <div class=\"art-sheet-body\">\n");
      out.write("                    <div class=\"art-header\">\n");
      out.write("                        <div class=\"art-header-clip\">\n");
      out.write("                            <div class=\"art-header-center\">\n");
      out.write("                                <div class=\"art-header-jpeg\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"art-headerobject\"></div>\n");
      out.write("\n");
      out.write("                        <div class=\"art-logo\">\n");
      out.write("                            <table><tr><td><img src=\"images/TFI_Logo.jpg\" width=\"115\" hight=\"115\"></td><td width=\"100%\"><h1 class=\"art-logo-name\"><a href=\"./index.html\">sarva-vidya.edu</a></h1>\n");
      out.write("                                        <h2 class=\"art-logo-text\">Teach for india...</h2></td><td><img width=\"70\" hight=\"100\"></td><td></td><td><font size=\"2\" color=\"blue\"></font></td></tr></table>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"cleared reset-box\"></div>\n");
      out.write("                    <div class=\"art-nav\">\n");
      out.write("                        <div class=\"art-nav-l\"></div>\n");
      out.write("                        <div class=\"art-nav-r\"></div>\n");
      out.write("                        <div class=\"art-nav-outer\">\n");
      out.write("                            <ul class=\"art-hmenu\">\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"./mumbai.jsp\" class=\"active\"><span class=\"l\"></span><span class=\"r\"></span><span class=\"t\">Mumbai</span></a>\n");
      out.write("                                </li>\t\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"./delhi.jsp\" class=\"active\"><span class=\"l\"></span><span class=\"r\"></span><span class=\"t\">Delhi</span></a>\n");
      out.write("                                </li>\t\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"./chennai.jsp\" class=\"active\"><span class=\"l\"></span><span class=\"r\"></span><span class=\"t\">Chennai</span></a>\n");
      out.write("                                </li>\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"cleared reset-box\"></div>\n");
      out.write("                    <div class=\"art-content-layout\">\n");
      out.write("                        <div class=\"art-content-layout-row\">\n");
      out.write("                            <div class=\"art-layout-cell art-sidebar1\">\n");
      out.write("                               \n");
      out.write("                                <div class=\"cleared\"></div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"art-layout-cell art-content\">\n");
      out.write("                                <div class=\"art-post\">\n");
      out.write("                                    <div class=\"art-post-body\">\n");
      out.write("                                        <div class=\"art-post-inner art-article\">\n");
      out.write("                                            <h2 class=\"art-postheader\">  \n");
      out.write("                                                 Mumbai > ");
 out.print(request.getParameter("schid"));
      out.write("\n");
      out.write("                                                 \n");
      out.write("                                                <form  action =\"stats.jsp\">\n");
      out.write("                                                 <input type=\"hidden\" name=\"start\">   \n");
      out.write("                                                    <h3>Select Class</h3>\n");
      out.write("                                                  <table  width=\"100%\" border=\"0\" align=\"center\"><thead><tr><th>School ID</p></th><th>Class ID</th><th>Class</th><th></th></tr></thead><tbody>\n");
      out.write("                                                    ");

                                                        try {
                                                            ServletContext cont = config.getServletContext();
                                                            String url = cont.getInitParameter("url");
                                                            String username = cont.getInitParameter("username");
                                                            String password = cont.getInitParameter("password");
                                                            Class.forName(cont.getInitParameter("class")).newInstance();
                                                            Connection con = DriverManager.getConnection(url, username, password);
                                                            Statement state = con.createStatement();


                                                            String school_id = request.getParameter("schid");
                                                            
                                                            Statement st = con.createStatement();
                                                            String strQuery = null;
                                                            ResultSet rs;
                                                            
                                                            strQuery = "select * from class where schid like '" + school_id + "'";
                                                            rs = st.executeQuery(strQuery);
                                                            while (rs.next()) {
                                                                String str=rs.getString("cid");
                                                                out.print("<form action='stats.jsp' method='post'><tr><td>"+rs.getString(2) +"</td><td>"+str+"</td><td>"+rs.getString(3) +"</td><td><input type='hidden' name='cid' value='"+str+"'><input type='submit' name='view' value='View'></input></td></tr></form>");
                                                            }


                                                        } catch (Exception e) {
                                                            out.println(e.getMessage());
                                                        }




                                                        //retrieve data of particular school i.e all classes by using post parameter schoolname.
                                                        //display classes.
                                                        //same format of that of the previous form in radio button format onlick submit to stats.jsp
                                                    
      out.write("\n");
      out.write("                                                    </table>\n");
      out.write("                                                </form>\n");
      out.write("                                            </h2>\n");
      out.write("                                            <div class=\"cleared\"></div>\n");
      out.write("                                            <div class=\"art-postcontent\">\n");
      out.write("\n");
      out.write("                                                <table><tr><td></td></r></table>\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"cleared\"></div>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"cleared\"></div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"cleared\"></div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"cleared\"></div>\n");
      out.write("                    <div class=\"art-footer\">\n");
      out.write("                        <div class=\"art-footer-t\"></div>\n");
      out.write("                        <div class=\"art-footer-body\">\n");
      out.write("                            <a href=\"#\" class=\"art-rss-tag-icon\" title=\"RSS\"></a>\n");
      out.write("                            <div class=\"art-footer-text\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <p>Copyright © 2011. All Rights Reserved.</p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"cleared\"></div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"cleared\"></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"cleared\"></div>\n");
      out.write("           \n");
      out.write("            <div class=\"cleared\"></div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
