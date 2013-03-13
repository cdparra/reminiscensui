/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crowdMemories.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franz
 */
@WebServlet(name = "Album_check", urlPatterns = {"/Album_check"})
public class Album_check extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            //controllo se ho l'album id altrimenti proseguo senza
            String album_id = request.getParameter("album_id");

            if (album_id.equals("") || album_id == null) {

                System.out.println("non ho l'album id! ok proseguo senza");
                response.sendRedirect("upload.jsp");

            } else {

                //ok ce l'ho controllo sia vero
                System.out.println("ho un album id ora controllo che sia vero");

                Database db = new Database();
                db.getConnection();
                Statement st = db.CreateAndGetStatement();
               
                //se non riesco a connettermi mando la pagina di errore
                if (st == null) {

                    System.out.println("non riesco a connettermi mando la pagina di errore");
                    response.sendRedirect("errorPage.jsp");
                }

                String query = "SELECT * FROM reminiscens2.Album where album_id = '" + album_id + "'";
                ResultSet rs = st.executeQuery(query);
                if (rs.next()) {

                    //l'album esiste aggiungo l'album_id all'url
                    System.out.println("l'album esiste aggiungo l'album_id all'url");
                    response.sendRedirect("upload.jsp?album_id=" + album_id + "");
                } else {

                    //l'album non esiste torno alla home
                    System.out.println("l'album -> " + album_id + " <- non esiste torno alla home");
                    response.sendRedirect("index.jsp");

                }

                //chiudo tutte le connessioni
                rs.close();
                st.close();
                db.endConnection();
            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Album_check.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Album_check.class.getName()).log(Level.SEVERE, null, ex);
        }
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
