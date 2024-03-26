

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateEmpServlet
 */
@WebServlet("/UpdateEmpServlet")
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmpServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String Empname=request.getParameter("EmpName");
		String Empid=request.getParameter("Empid");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String country=request.getParameter("country");
		
		OrgBean bean=new OrgBean();
		
		bean.setEmpname(Empname);
		bean.setEmpid(Empid);
		bean.setPassword(password);
		bean.setGender(gender);
		bean.setEmail(email);
		bean.setMobile(mobile);
		bean.setCountry(country);
		
		int status=EmpInfo.editDetails(bean);
		
		if(status>0)
		{
			out.println("<h2>Your Data Updated Successfully</h2>");
//			request.getRequestDispatcher("EditServlet.java").include(request, response);
			response.sendRedirect("ViewDetails");
		}
		else
		{
			out.println("Sorry ,Unable to Update Your Data");
			request.getRequestDispatcher("EditServlet.java").include(request, response);
		}
		
		
	}

}
