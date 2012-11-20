package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pagina2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    public static String codificaTagHtml(String tag) {
        if (tag == null) {
            return null;
        }
        int nCaratteri = tag.length();
        StringBuffer tagCodificato = new StringBuffer(2 * nCaratteri);
        for (int i = 0; i < nCaratteri; i++) {
            char c = tag.charAt(i);
            switch (c) {
                case '<':
                    tagCodificato.append("&lt;");
                    break;
                case '>':
                    tagCodificato.append("&gt;");
                    break;
                case '&':
                    tagCodificato.append("&amp;");
                    break;
                case '"':
                    tagCodificato.append("&quot;");
                    break;
                case ' ':
                    tagCodificato.append("&nbsp;");
                    break;
                default:
                    tagCodificato.append(c);
            }
        }
        return tagCodificato.toString();
    }

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"IT\">\n");
      out.write("    <head>\n");
      out.write("        <title>Oggetto response - Codifica tag HTML</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 align='center'>Esempio 4.10 - Oggetto response</h1><br/>\n");
      out.write("        <p>Codifica dei tag HTML</p>\n");
      out.write("        <form method=\"post\">\n");
      out.write("            <fieldset>\n");
      out.write("                <legend>Inserimento testo</legend>\n");
      out.write("                <label for=\"testo\">Testo: </label>\n");
      out.write("                <textarea rows=\"5\" cols=\"40\" name=\"testo\" id=\"testo\">\n");
      out.write("<h1> Ho inserito\n");
      out.write("dei tag di formattazione e uno script</h1>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("                        alert('Simulazione di uno Scriptpericoloso')\n");
      out.write("                    </script>\n");
      out.write("     \n");
      out.write("                </textarea>\n");
      out.write("                <br/><br/>\n");
      out.write("                <input type=\"submit\" value=\"Invia dati\" name=\"invia\"/>\n");
      out.write("            </fieldset>\n");
      out.write("        </form>\n");
      out.write("        ");

            if (request.getParameter("invia") != null) {
                out.write("<h2>Visualizzo i dati inviati senza trattare i caratteri speciali</h2>");
                out.write(request.getParameter("testo"));
                out.write("<h2>Rendo innocui eventuali script pericolosi</h2>");
                out.write(codificaTagHtml(request.getParameter("testo")));
            }
        
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
