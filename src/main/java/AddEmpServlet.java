

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddEmpServlet")
public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddEmpServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String empid=request.getParameter("Empid");
		String empname=request.getParameter("EmpName");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String country=request.getParameter("country");
		
		OrgBean bean=new OrgBean();
		
		bean.setEmpid(empid);
		bean.setEmpname(empname);
		bean.setPassword(password);
		bean.setGender(gender);
		bean.setEmail(email);
		bean.setMobile(mobile);
		bean.setCountry(country);
		
		int status=EmpInfo.savedetails(bean);
		if(status>0)
		{
			out.println("<h3 style='color:green';'background-color:yellow'>Your Record Saved Successfully</h3>");
			request.getRequestDispatcher("AddEmployee.jsp").include(request, response);
		}
		else
		{
			out.println("Sorry ,unable save the data");
		}
		out.close();
	
	}

}
