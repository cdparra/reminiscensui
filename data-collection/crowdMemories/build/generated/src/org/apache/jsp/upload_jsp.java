package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class upload_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
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
      crowdMemories.Media media = null;
      synchronized (session) {
        media = (crowdMemories.Media) _jspx_page_context.getAttribute("media", PageContext.SESSION_SCOPE);
        if (media == null){
          media = new crowdMemories.Media();
          _jspx_page_context.setAttribute("media", media, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');

    session.setAttribute("user_name", "user");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Upload Page</title>\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\"/>\n");
      out.write("        <script src=\"bootstrap/js/jquery-1.8.2.min.js\"></script>\n");
      out.write("        <script src=\"./bootstrap/js/bootstrap.js\"></script>\n");
      out.write("        <script src=\"uploadscript.js\"></script>\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            #next { \n");
      out.write("                position: relative;\n");
      out.write("                margin-top: 60px;\n");
      out.write("            }\n");
      out.write("            #sfondo { \n");
      out.write("                width: 940px;\n");
      out.write("                height: 500px ; \n");
      out.write("                margin-top: 40px;\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("            }\n");
      out.write("            #left{\n");
      out.write("                margin-top: 20px;\n");
      out.write("            }\n");
      out.write("            #right{\n");
      out.write("                margin-top: 20px;\n");
      out.write("            }\n");
      out.write("            #url{\n");
      out.write("                width: 550px;\n");
      out.write("            }\n");
      out.write("            #inputbar{\n");
      out.write("                margin-top: 30px;\n");
      out.write("            }\n");
      out.write("            #img{\n");
      out.write("                display: none; \n");
      out.write("                max-height: 360px;\n");
      out.write("                margin-top: 20px\n");
      out.write("            }\n");
      out.write("            #label{\n");
      out.write("                display: block;\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 22px;\n");
      out.write("                padding: 8px 5px 8px;\n");
      out.write("                margin-top: 50px\n");
      out.write("            }\n");
      out.write("            #title{\n");
      out.write("                margin-top: 10px;\n");
      out.write("                width: 272px   \n");
      out.write("            }\n");
      out.write("            #myModal p{\n");
      out.write("                text-align: center\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div id=\"sfondo\" class=\"hero-unit\">\n");
      out.write("\n");
      out.write("                <form name=\"upload\" method=\"post\">\n");
      out.write("                    <h1> Upload your Photo </h1>\n");
      out.write("                    <div id=\"inputbar\" class=\"dropdown\">\n");
      out.write("                        <a id=\"upl-button\" class=\"btn btn-primary dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" style=\"width: 300px\">Upload photo from your library</a>\n");
      out.write("                        <ul class=\"dropdown-menu\" role=\"menu\" aria-labelledby=\"dLabel\" style=\"background-color: #eeeeee; width: 327px\">\n");
      out.write("                            <li>\n");
      out.write("                                <input id=\"filepath\" name=\"filepath\" type=\"file\" onchange=\"getURL(this);\" style=\"margin-left: 10px\">\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <input id=\"url\" name=\"url\" type=\"text\" class=\"search-query pull-right\" placeholder=\"or paste URL here and press enter\" onchange=\"readURL();\" />\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"left\" class=\"span7\"> \n");
      out.write("                        <img id=\"img\" src=\"#\" alt=\"image not found\" />\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"right\" class=\"span4\"> \n");
      out.write("                        <span id=\"label\" class=\"label label-important\">Insert title here</span>\n");
      out.write("                        <input id=\"title\" name=\"title\" type=\"text\" class=\"search-query\" placeholder=\"Insert Title Here\"/>\n");
      out.write("                        <button id=\"next\" class=\"btn btn-success btn-large pull-left\" type=\"submit\"> Submit url</button>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"myModal\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">×</button>\n");
      out.write("                    <h3 id=\"myModalLabel\">Attention</h3>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                   \n");
      out.write("                    <p>Please check the url you entered because only  jpg, jpeg or png extension ere supported!</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button class=\"btn btn-primary\" data-dismiss=\"modal\" aria-hidden=\"true\">Close</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");


            String url = request.getParameter("url");
            String title = request.getParameter("title");

            try {

                boolean check = true;

                if (url.equals("")) {
                    check = false;
                } else {
                    media.setUrl(url);
                }

                if (title.equals("")) {
                    check = false;
                } else {
                    media.setTitle(title);
                }

                if (check) {
                    response.sendRedirect("mappacerchio.jsp");
                } else {
        
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            alert(\"You forgot to enter something. Please check before submit!\");      \n");
      out.write("        </script>\n");
      out.write("        ");
                    }
            } catch (Exception e) {
            }

        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
