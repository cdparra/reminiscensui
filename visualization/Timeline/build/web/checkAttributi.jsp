<%-- 
    Document   : checkAttributi
    Created on : Nov 14, 2012, 11:49:28 AM
    Author     : J
--%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*"%>
<%@page import="java.sql.DriverManager"%>
<%
    String id1 = (String) request.getParameter("combobox1");
    String id2 = (String) request.getParameter("combobox2");

    if (!id1.equals(id2)) {
        /*Class.forName("com.mysql.jdbc.Driver");

        Connection db = null;
        try {
            db = DriverManager.getConnection("jdbc:mysql://test.lifeparticipation.org/reminiscens", "reminiscens", "timeline@lp2012");
            //out.println("Connection successful");
        } catch (Exception e) {
            out.println("Errore nel db");
        }

        Statement st = db.createStatement();
        //prelevo tutti gli elementi in ordine di data di partenza
        String query = "SELECT * FROM reminiscens.Person WHERE lastname = '" + id1 + "';";
        ResultSet rs = st.executeQuery(query);

        try {
            if (rs.next()) {
                query = "SELECT * FROM reminiscens.Person WHERE lastname = '" + id2 + "';";
                rs = st.executeQuery(query);
                if (rs.next()) {
                    response.sendRedirect("timeline.jsp?id1=" + id1 + "&id2=" + id2);
                } else {
                    response.sendRedirect("index.jsp");
                }
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        rs.close();     // Chiudo il ResultSet
        st.close();   // Chiudo lo Statement
        db.close();*/
        response.sendRedirect("timeline.jsp?id1=" + id1 + "&id2=" + id2);
    }
    else
               {
        response.sendRedirect("index.jsp");
    }
%>
