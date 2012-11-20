/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdMemories;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

            HttpSession session = request.getSession();

            //setting media
            Media media = new Media();

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
                loc.setAddress(request.getParameter("indirizzo"));

                media.setLocation(loc);

            } else if (loctype.equals("text")) {
                loc.setLocation_textual(request.getParameter("description_loc"));

                media.setLocation(loc);
            }


            // setting fuzzu date

            Fuzzy_date fuzzy_date = new Fuzzy_date();

            String datetype = request.getParameter("datetype");
            Time_interval time = new Time_interval();
            Fuzzy_date date = new Fuzzy_date();

            if (datetype.equals("yes")) {
                date.setDate(request.getParameter("datepicker"));

                time.setIs_fuzzy(true);
                time.setFuzzy_startdate(date);
                media.setTime_interval(time);

            } else if (datetype.equals("almost")) {

                date.setDecade(request.getParameter("decade"));
                date.setYear(request.getParameter("year"));
                date.setMonth(request.getParameter("month"));
                date.setDay(request.getParameter("day"));
                date.setDay_name(request.getParameter("day_name"));
                date.setDay_part(request.getParameter("day_part"));
                date.setSeason(request.getParameter("season"));
                date.setHour(request.getParameter("hour"));
                date.setMinute(request.getParameter("minute"));
                date.setSecond(request.getParameter("second"));

                time.setIs_fuzzy(true);
                time.setFuzzy_startdate(date);
                media.setTime_interval(time);

            } else if (datetype.equals("no")) {

                date.setDescription_time(request.getParameter("description"));

                time.setIs_fuzzy(true);
                time.setFuzzy_startdate(date);
                media.setTime_interval(time);
            }


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
