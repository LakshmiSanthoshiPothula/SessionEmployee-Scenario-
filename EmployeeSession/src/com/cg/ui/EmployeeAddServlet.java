package com.cg.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.internal.dynalink.beans.StaticClass;

import org.apache.taglibs.standard.tag.rt.core.OutTag;

import com.cg.entity.Employee;

/**
 * Servlet implementation class EmployeeAddServlet
 */
@WebServlet("/EmployeeAddServlet")
public class EmployeeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	static Map<String, Employee> employees = new HashMap<String, Employee>();
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		try{
		String firstName =request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String panId = request.getParameter("panId");
		
		
		
		


		Employee employee = new Employee();
		
		if (firstName.matches("[a-zA-Z]{3,12}")) {
			employee.setFirstName(firstName);
		  } else {
				request.setAttribute("errorFname", "Invalid First Name");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Home.jsp");
				dispatcher.forward(request, response);

			}
		
		if (lastName.matches("[a-zA-Z]{3,12}")) {
			employee.setLastName(lastName);
		  } else {
				request.setAttribute("errorLname", "Invalid Last Name");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Home.jsp");
				dispatcher.forward(request, response);

			}
		
		
		if (email.matches("[a-zA-Z][a-zA-z0-9-.]*@[a-zA-Z0-9]+([.][a-zA-Z)]+)+")) {
			employee.setEmail(email);
		  } else {
				request.setAttribute("errorEmail", "Invalid Email");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Home.jsp");
				dispatcher.forward(request, response);

			}
		

		if (gender!=null) {
			employee.setGender(gender);
		  } else {
				request.setAttribute("errorGender", "Invalid Gender");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Home.jsp");
				dispatcher.forward(request, response);

			}
		

		if (phone.matches("^[6-9][0-9]{9}")) {
			employee.setPhone(phone);
		  } else {
				request.setAttribute("errorPhone", "Invalid Phone Number");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Home.jsp");
				dispatcher.forward(request, response);

			}
		
		

		if (panId.matches("^[A-Z][A-Z0-9]{9}")) {
			employee.setPanId(panId);
		  } else {
				request.setAttribute("errorPan", "Invalid PAN ID");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Home.jsp");
				dispatcher.forward(request, response);

			}
		
		

		HttpSession session = request.getSession(true);
		employees.put(employee.getPhone(), employee);

		session.setAttribute("Employees", employees);

		RequestDispatcher dispatcher = request.getRequestDispatcher("Success.jsp");
		dispatcher.forward(request, response);
		}catch(Exception e){
			
		}
	}

}
