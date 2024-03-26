

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public EditServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		
		out.println("<h2>Update Employee Details</h2>");
		
		String empid=request.getParameter("Empid");
	
		OrgBean bean=EmpInfo.getEmpById(empid);
		
		out.println("<html><head><style> body{text-align:center;background-color:lavenderblush;} form{ padding:0px 330px 0px 350px;} input{width:200px;} td{padding:0px 0px 0px 30px;} table{background-color:lightblue;margin-left:20px; width:430px;hieght:400px;  border-radius: 10px; box-shadow: 3px 3px 3px black;}</style></head>");
		out.println("<body>");
		out.println("<form action='UpdateEmpServlet' method='post'>");
		out.println("<table>");
		out.println("<tr><td>Employee Name</td><td><input type='text' name='EmpName' id='' value='"+bean.getEmpname()+"' placeholder='Enter Employee Name'></td></tr>");
		
		out.println("<tr><td></td><td><input type='hidden' name='Empid' value='"+bean.getEmpid()+"' placeholder='Enter Employee ID'></td></tr>"); 
		out.println ("<tr><td>Password</td><td><input type='password' name='password' value='"+bean.getPassword()+"' placeholder='Enter Password'></td></tr>");
		out.println("<tr><td>Gender</td> <td><input type='text' name='gender' value='"+bean.getGender()+"'  placeholder='Enter Gender (M/F/O)'> </td></tr>");
		out.println ("<tr><td>E-mail</td><td><input type='email' name='email' value='"+bean.getEmail()+"' placeholder='Enter Employee Email'></td></tr>"); 
		out.println("<tr><td>Mobile</td><td><input type='text' name='mobile' value='"+bean.getMobile()+"' placeholder='Enter Employee Mobile Number'></td></tr>");
		out.println("<tr><td>Country</td><td><select name='country' id=''>"
				+ "<option value='India'>India</option>"
				+ "<option value='USA'>USA</option>"
				+ "<option value='UK'>UK</option>"
				+ "<option value='Russia'>Russia</option>"
				+ "<option value='NewZeeland'>NewZeeland</option>"
				+ "<option value='UAE'>UAE</option></select></td></tr>");
		out.println (" <tr><td></td><td><input width=30px; type='submit' value='Edit & Save' ></td></tr>");
		//out.println(" <tr><td><a href='ViewDetails'>View Details</a></td></tr>");
		out.println("</table>");
		out.println("</form></body></html>");
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		
		
		
		
	}

}
