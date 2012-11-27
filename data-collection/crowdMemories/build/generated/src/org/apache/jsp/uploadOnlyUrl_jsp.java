package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import crowdMemories.Media;

public final class uploadOnlyUrl_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			"errorPage.jsp", true, 8192, true);
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Upload Page</title>\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\"/>\n");
      out.write("        <script src=\"bootstrap/js/jquery-1.8.2.min.js\"></script>\n");
      out.write("        <script src=\"bootstrap/js/bootstrap.js\"></script>\n");
      out.write("        <script src=\"uploadscriptOnlyUrl.js\"></script>\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            #sfondo { \n");
      out.write("                width: 940px;\n");
      out.write("                margin-top: 40px;\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("                padding-bottom: 30px\n");
      out.write("            }\n");
      out.write("            #url{\n");
      out.write("                width: 550px;\n");
      out.write("            }\n");
      out.write("            #img{\n");
      out.write("\n");
      out.write("                display: none; \n");
      out.write("                margin-top: 20px;\n");
      out.write("            }\n");
      out.write("            #next{\n");
      out.write("                display: none;\n");
      out.write("                padding: 30px;\n");
      out.write("                padding-bottom: 0px\n");
      out.write("            }\n");
      out.write("            #title{\n");
      out.write("                width: 350px; \n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .modal p{\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 20px\n");
      out.write("            }\n");
      out.write("            form{\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            p {\n");
      out.write("                margin-top: 40px\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #fileInput{\n");
      out.write("                display: none;\n");
      out.write("            }\n");
      out.write("            #modal-body-uploaded{\n");
      out.write("                display: none\n");
      out.write("            }\n");
      out.write("            #myModalInfo p{\n");
      out.write("                font-size: 26px;\n");
      out.write("                line-height: 1.5;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div id=\"sfondo\" class=\"hero-unit\">\n");
      out.write("\n");
      out.write("                <form name=\"upload\" method=\"get\" action=\"mappacerchio.jsp\">\n");
      out.write("                    <h1> Upload your Photo </h1>      \n");
      out.write("                    <p id=\"text\"><i class=\"icon-arrow-right\"></i> Select a photo from your library or just Copy the URL of the image in the following bar </p>\n");
      out.write("                    <input id=\"submit\" type=\"submit\" style=\"display:none\">\n");
      out.write("                    <input id=\"fileInput\" type=\"file\" onchange=\"displayImage(this.files[0])\">\n");
      out.write("\n");
      out.write("                    <button class=\"btn btn-primary\" type=\"button\" onclick=\"document.getElementById('fileInput').click()\">Click here to upload from your library</button>                    \n");
      out.write("\n");
      out.write("                    <input id=\"url\" name=\"url\" autofocus=\"autofocus\" type=\"text\" class=\"search-query\" placeholder=\"Copy URL here\" onchange=\"readURL();\" onblur=\"readURL();\"/>\n");
      out.write("\n");
      out.write("                    <p> <i class=\"icon-arrow-right\"></i>  And remember to Insert a Title \n");
      out.write("                        <input id=\"title\" name=\"title\" type=\"text\" class=\"search-query\" placeholder=\"Insert Title Here\"/>\n");
      out.write("                    </p>\n");
      out.write("\n");
      out.write("                    <img id=\"img\" src=\"#\" alt=\"image not found\"/>\n");
      out.write("                    <div id=\"next\">\n");
      out.write("                        <button class=\"btn btn-primary btn-large btn-block\" type=\"button\" onclick=\"return checkOrUpload()\"> Submit url</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"myModalUrl\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">×</button>\n");
      out.write("                    <h3 id=\"myModalLabel\">Attention</h3>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <p>Please check what you entered because only  jpg, jpeg, png or gif extension ere supported!</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button class=\"btn btn-primary\" data-dismiss=\"modal\" aria-hidden=\"true\">Close</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"myModalSubmit\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">×</button>\n");
      out.write("                    <h3 id=\"myModalLabel\">Attention</h3>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <p>You forgot to enter something. Please check before submit!</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button class=\"btn btn-primary\" data-dismiss=\"modal\" aria-hidden=\"true\">Close</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"myModalUpload\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\" >\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h3 id=\"myModalLabel\">Uploading your photo to <strong>Imgur.com</strong></h3>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"modal-body-uploading\" class=\"modal-body\">\n");
      out.write("                    <p>I'm uploading your photo please wait!</p>\n");
      out.write("                    <div class=\"progress progress-striped active\">\n");
      out.write("                        <div class=\"bar\" style=\"width: 100%;\"></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"modal-body-uploaded\" class=\"modal-body\">\n");
      out.write("                    <p>The photo was succesfully uploaded!<br> Now please continue and help us adding some details to your photo!</p>\n");
      out.write("                    <div class=\"alert alert-info\">\n");
      out.write("                        This is the link of your photo on Imgur.com: <a id=\"link\" target=\"_blank\"></a>\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-primary btn-large btn-block\" onclick=\"submit()\"> Continue </button>               \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"myModalInfo\" class=\"modal hide fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">×</button>\n");
      out.write("                    <h3 id=\"myModalLabel\">Hello and welcome!</h3>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <p>\n");
      out.write("                        We would need photos or images of the world as it was years ago. <br>\n");
      out.write("                        We kindly ask you to upload a photo and then, \n");
      out.write("                        based on what you remember to add some simple information such as the date\n");
      out.write("                        or the place where it was taken! <br>\n");
      out.write("                        Thank you for your help! \n");
      out.write("                    </p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button class=\"btn btn-primary\" data-dismiss=\"modal\" aria-hidden=\"true\">Close this ad</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
