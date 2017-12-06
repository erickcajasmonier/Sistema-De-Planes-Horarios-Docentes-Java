package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Statement;

import util.*;

@WebServlet("/ReporteC9Excel")

public class Servlet_reportec9 extends HttpServlet{
	private static  final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		try {
			switch(request.getServletPath()) {
			case "/ReporteC9Excel":
				reporteC9_Excel(request, response);		
				break;
			}
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}


	private void reporteC9_Excel(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	String var = request.getParameter("fecha");
	
	String flag = "-1";
	
	try {
		ReporteExcelC9 reporteExcel = new ReporteExcelC9();

		flag = reporteExcel.generarExcel(var) == true ? "1" : "0";

	} catch (Exception e) {
		System.out.println("Eror : " + e.getMessage());
		e.printStackTrace();
	}
	response.setContentType("text/plain");
	response.getWriter().write(flag);
//	response.sendRedirect(request.getContextPath()+"/Docentes/Main/DocenteC9.jsp");
	}

}
