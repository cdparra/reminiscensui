/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import crowdMemories.Fuzzy_date;
import crowdMemories.Location;
import crowdMemories.Media;
import crowdMemories.NewHibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author francesco
 */
public class Submit extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            out.print(" <%@page errorPage=\"errorPage.jsp\"%> \n"
                    + "<%@page contentType=\"text/html\" pageEncoding=\"UTF-8\"%>\n"
                    + "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <title>Error!</title>\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "    </body>\n"
                    + "</html>\n"
                    + "");

            // HttpSession session = request.getSession();
            //setting media
            Media media = new Media();

            //String album_id = request.getParameter("album_id");
            String url = request.getParameter("url");
            String title = request.getParameter("title");

            media.setUrl(url);
            media.setTitle(title);
            media.setSource_url(url);

            //setting location
            String loctype = request.getParameter("loctype");

            Location loc = new Location();
            if (loctype.equals("map")) {
                loc.setLatitude(request.getParameter("lat"));
                loc.setLongitude(request.getParameter("lng"));
                loc.setRadius(request.getParameter("radius"));

                //inutile perchè poi non lo inserisco nel database
                //loc.setAddress(request.getParameter("indirizzo"));

                media.setLocation(loc);

            } else if (loctype.equals("text")) {
                loc.setLocation_textual(request.getParameter("description_loc"));

                media.setLocation(loc);
            }

            // setting fuzzy date         
            String datetype = request.getParameter("datetype");
            Fuzzy_date fuzzy_date = new Fuzzy_date();
            if (datetype.equals("yes")) {

                String date = request.getParameter("date");
                fuzzy_date.setExact_date(date);
                media.setFuzzy_startdate(fuzzy_date);

            } else if (datetype.equals("almost")) {

                fuzzy_date.setDecade(request.getParameter("decade"));
                fuzzy_date.setYear(request.getParameter("year"));
                fuzzy_date.setMonth(request.getParameter("month"));
                fuzzy_date.setDay(request.getParameter("day"));
                fuzzy_date.setDay_name(request.getParameter("day_name"));
                fuzzy_date.setDay_part(request.getParameter("day_part"));
                fuzzy_date.setSeason(request.getParameter("season"));
                fuzzy_date.setHour(request.getParameter("hour"));
                fuzzy_date.setMinute(request.getParameter("minute"));
                fuzzy_date.setSecond(request.getParameter("second"));

                media.setFuzzy_startdate(fuzzy_date);

            } else if (datetype.equals("no")) {

                fuzzy_date.setTextual_date(request.getParameter("description"));

                media.setFuzzy_startdate(fuzzy_date);
            }

            //inserisco il media
            NewHibernateUtil hb = new NewHibernateUtil();
            hb.addMedia(media);

            
            response.sendRedirect("index.jsp");

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
            