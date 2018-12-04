package com.cg.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.entity.Employee;

/**
 * Servlet implementation class EmployeeDisplayServlet
 */
@WebServlet("/EmployeeDisplayServlet")
public class EmployeeDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee=new Employee();
		Map<String , Employee> employees=new HashMap<String ,Employee>();
		PrintWriter out=response.getWriter();
		
		HttpSession session= request.getSession(); 
		employees=(Map<String, Employee>) session.getAttribute("Employees");
     
		out.println("***Employee Details***<br>");
		
		  for(Map.Entry<String , Employee> m:employees.entrySet()){    
	          out.println(m.getKey()+" "+m.getValue()); 
	          out.println("<br>");
	          }  
		
	      
		 
		
		
		
		
		
	}

}
