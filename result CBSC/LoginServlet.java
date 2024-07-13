import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class LoginServlet extends HttpServlet
{
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
 {
res.setContentType("text/html");
  
  PrintWriter out = res.getWriter();
out.println("<html><body>");
out.println("<body  bgcolor='yellow' left=20>");
  String roll_no=req.getParameter("roll_no");
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
	
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca6");
Statement s = c.createStatement();
ResultSet rs=s.executeQuery("select * from emp101  where ROL_NO='"+roll_no+"'");
//out.println(rs);
ResultSetMetaData rsmd=rs.getMetaData();
out.print("<table  bgcolor='white' border=1 width=78% >");
out.print("<tr>");
for(int i=1; i<=rsmd.getColumnCount(); i++)
{
out.print("<th>"+rsmd.getColumnName(i)+"</th>");
}
out.print("</tr>");
while(rs.next())
{
out.print("<tr>");
out.print("<td>"+rs.getString(1)+"</td>");
out.print("<td>"+rs.getString(2)+"</td>");
out.print("<td>"+rs.getString(3)+"</td>");
out.print("<td>"+rs.getString(4)+"</td>");
out.print("<td>"+rs.getString(5)+"</td>");
out.print("<td>"+rs.getString(6)+"</td>");
out.print("<td>"+rs.getString(7)+"</td>");
out.print("<td>"+rs.getString(8)+"</td>");
out.print("</tr>");

int m1=Integer.parseInt(rs.getString(2));
int m2=Integer.parseInt(rs.getString(3));
int m3=Integer.parseInt(rs.getString(4));
int m4=Integer.parseInt(rs.getString(5));
int m5=Integer.parseInt(rs.getString(6));
int m6=Integer.parseInt(rs.getString(7));
int total=m1+m2+m3+m4+m5+m6;
out.println("<h2>Total Number = "+total+"</h2>");
int percent=total/6;
out.println("<h2>percent = "+percent+"</h2>"); 
}
}catch(Exception e){out.println(e);}     

out.println("</body></html>");
	
}

}






