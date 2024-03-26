

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewDetails")
public class ViewDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewDetails() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			out.println("<a href='AddEmployee.jsp'><h4>Add New Employees</h4></a>");
			out.println("<h3>Employee Details</h3>");
			
			List<OrgBean> emplist=EmpInfo.getAllEmployees();
			out.println("<table border='1' width=100% >");
			out.println("<tr><th>EmpID</th>,"
					+ "<th>EmpName</th>"
					+ "<th>Password</th>"
					+ "<th>Gender</th>"
					+ "<th>Country</th>"
					+ "<th>E-mail</th>"
					+ "<th>MobileNumber</th>"
					+ "<th>Edit</th>"
					+ "<th>Delete</th></tr>");
			for(OrgBean emp:emplist)
			{
			out.println("<tr><td>"+emp.getEmpid()+"</td>"
					+ "<td>"+emp.getEmpname()+"</td>"
						+ "<td>"+emp.getPassword()+"</td>"
							+ "<td>"+emp.getGender()+"</td>"
								+ "<td>"+emp.getCountry()+"</td>"
									+ "<td>"+emp.getEmail()+"</td>"
										+ "<td>"+emp.getMobile()+"</td>"
											+ "<td><a href='EditServlet?Empid="+emp.getEmpid()+"'>Edit</a></td>"
												+ "<td><a href='DeleteServlet?Empid="+emp.getEmpid()+"'>Delete</a></td></tr>");
			}
			out.println("</table>");
			out.close();
			
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
	}

}
