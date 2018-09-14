

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sp")
public class db extends HttpServlet {

   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String url="jdbc:mysql://localhost:3306/placementdata";
        String user="root";
        String password="root";
            PrintWriter out = response.getWriter();
          String no=request.getParameter("t1");
            out.println("<html>");
             out.println("<body>");
            try{
       Class.forName("com.mysql.jdbc.Driver");
       Connection conn=DriverManager.getConnection(url, user, password);
       PreparedStatement st=conn.prepareStatement("select * from stud_info where Roll=?");
      st.setString(1,no);
   
      out.print("<table>");
      
       ResultSet rs=st.executeQuery();
     ResultSetMetaData me=rs.getMetaData();
   
        out.print("<thead>");
      out.print("<tr>");
    out.print("<th>"+me.getColumnName(1)+"</th>");
        out.print("<th>"+me.getColumnName(2)+"</th>");
       out.print("<th>"+me.getColumnName(7)+"</th>");
     out.print("<th>"+me.getColumnName(8)+"</th>");
           out.print("<th>"+me.getColumnName(9)+"</th>");
   out.print("<th>"+me.getColumnName(10)+"</th>");
   out.print("<th>"+me.getColumnName(11)+"</th>");
                           
      out.print("</tr>");
       out.print("</thead>");
          out.print("<tbody>");
       while(rs.next())
       {
           out.print("<tr>");
             out.print("<td>"+rs.getString(1)+"</td>");
              out.print("<td>"+rs.getString(2)+"</td>");
            
                   out.print("<td>"+rs.getString(7)+"</td>");
                    out.print("<td>"+rs.getString(8)+"</td>");
                     out.print("<td>"+rs.getString(9)+"</td>");
                      out.print("<td>"+rs.getString(10)+"</td>");
                       out.print("<td>"+rs.getString(11)+"</td>");
          
           out.print("</tr>");
       }
           out.print("</tbody>");   
            out.print("</table>");
          
            }
        catch(Exception e)
        {
            System.out.print(e);
        }
            out.println("</body>");
            out.println("</html>");
        
    }
}

   



