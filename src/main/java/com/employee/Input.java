package com.employee;

import java.io.*;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
public class Input extends HttpServlet {

       public void doPost(HttpServletRequest request, HttpServletResponse response)

                     throws ServletException, IOException {        

              String id=request.getParameter("id");   
              String job=request.getParameter("job");
              String salary=request.getParameter("salary");
              String bonus=request.getParameter("bonus");
              

              try{

                     Class.forName("com.mysql.jdbc.Driver");

                     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","rohitreddy");               

                     PreparedStatement ps=con.prepareStatement("insert into rohit_111915059_salary values(?,?,?,?)");

                     ps.setString(1,id);    
                     ps.setString(2,job);
                     ps.setString(3,salary);
                     ps.setString(4,bonus);
                     ps.executeUpdate();           
                     ps.close();                                   
                     con.close();
                     response.sendRedirect("report.jsp");


              }catch (Exception e2)

                {

                    e2.printStackTrace();

                }
       }

}
