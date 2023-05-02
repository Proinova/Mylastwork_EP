import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String r = """
                <!DOCTYPE html>
                <html>
                 <head>
                 <meta charset="UTF-8">
                  <title>Регистрация</title>
                 </head>
                 <body>
                  <p>Registration successful.</p>
   		 </body>
               </html>
               """;
        
        String db = "jdbc:mariadb://localhost/spain";
        String reqName = request.getParameter("name");
        String reqPass = request.getParameter("pass");
        String reqMail = request.getParameter("mail");
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conn = DriverManager.getConnection(db);
            Statement stmt = conn.createStatement();
            String query = """
                    SELECT * FROM 
                          potrebiteli;
                           """;
            ResultSet rs = stmt.executeQuery(query);
            conn.close();
            
            while(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                String mail = rs.getString(4);
                if (reqName.equals(name) && reqPass.equals(pass) && reqMail.equals(mail))
                {
                    response.getWriter().println("login success");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    

       
    }
}
