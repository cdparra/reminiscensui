package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Timestamp;
import crowdMemories.Database;

public final class submit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

/*
    int date_accurancy() {

        boolean exact_date = false, decade = false, year = false, month = false, season = false, day = false, day_name = false, day_part = false;
        int conta = 0;

        if (!(immagine.getDescriptionTime()).equals(" ")) {
            return 1;
        }
        if (!(immagine.getDate().equals(null))) {
            return 8;
        }
        if (!(immagine.getDecade().equals(null))) {
            decade = true;
            conta++;
        }
        if (!(immagine.getYear().equals(null))) {
            year = true;
            conta++;
        }
        if (!(immagine.getSeason().equals(null))) {
            season = true;
            conta++;
        }
        if (!(immagine.getMonth().equals(null))) {
            month = true;
            conta++;
        }
        if (!(immagine.getDay().equals(null))) {
            day = true;
            conta++;
        }
        if (!(immagine.getDayName().equals(null))) {
            day_name = true;
            conta++;
        }
        if (!(immagine.getDayPart().equals(null))) {
            day_part = true;
            conta++;
        }

        if (conta == 1) {
            return 2;
        }

        if (year && month && day && day_name && day_part) {
            return 10;
        }
        if (year && month && day && day_name) {
            return 9;
        }
        if (year && month && day) {
            return 8;
        }
        if (year && month) {
            return 6;
        }
        if (month && day) {
            return 7;
        }
        if (year && season) {
            return 5;
        }
        if (year) {
            return 4;
        }
        if ((decade && month) || (decade && season)) {
            return 3;
        }
        return 0;
    }
*/

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
      out.write("\n");
      out.write("\n");
      crowdMemories.Image immagine = null;
      synchronized (session) {
        immagine = (crowdMemories.Image) _jspx_page_context.getAttribute("immagine", PageContext.SESSION_SCOPE);
        if (immagine == null){
          immagine = new crowdMemories.Image();
          _jspx_page_context.setAttribute("immagine", immagine, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');

// public void addLocation(int location_id, String location_textual, int location_accuracy, String name, String description, String environment, String continent, String country, String city, String neighborhood, int location_type_id, float lat, float lon) {
// public void addMedia(int media_id, String media_url, String media_type, String caption, String text, String source, String source_url, Timestamp last_update, boolean is_public, int location_id, int time_interval_id) throws SQLException {
// public void addTime_Interval(int time_interval_id, String duration_unit, String duration_amount, Timestamp startdate, Timestamp enddate, boolean is_fuzzy, int fuzzy_startdate, int fuzzy_enddate) {
// public void addFuzzyDate(int fuzzy_date_id, String textual_date, Timestamp exact_date, int decade, int year, String season, int month, int day, String day_name, String day_part, int hour, int minute, int second, int accuracy) {

/*
    Database d = new Database();

    String media_type = "PHOTO";
    String source = "CROWD";
    boolean is_public = true;
    int media_id, location_id, time_interval_id;
*/
/*
    d.addaddMedia(media_id, immagine.getUrl(), media_type, immagine.getTitle(), description, source, source_url, new Timestamp(System.currentTimeMillis()), is_public, location_id, time_interval_id);
    d.addLocation(location_id, location_textual, location_accuracy, name, description, environment, continent, country, city, neighborhood, location_type_id, lat, lon);
    d.addFuzzyDate(fuzzy_date_id, textual_date, exact_date, decade, year, season, month, day, day_name, day_part, hour, minute, second, accuracy);
    d.addTime_Interval(time_interval_id, duration_unit, duration_amount, startdate, enddate, is_fuzzy, fuzzy_startdate, fuzzy_enddate);
*/


      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
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
