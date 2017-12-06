package servlet;

import java.io.IOException;
import java.io.OutputStream;

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

import util.*;

@WebServlet("/Reportes")
public class Servlet_Reportes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		boolean dif = request.getParameter("repodiferencias") != null;
		
		
		if (dif) {
			reporteDiferencias_Excel(request, response);
		}
		if ("PDF".equals(action)) {
			try {
				switch (request.getParameter("accion")) {
				case "reportepc":
					reportePC_PDF(request, response);
					break;

				case "reportejecutivo":
					reporteEjecutivo_PDF(request, response);
					break;

				case "repoplanporhora":
					reportePH_PDF(request, response);
					break;

				case "reposunedu":
					reporteSUNEDU_PDF(request, response);
					break;
				}
			} catch (Exception e) {
				System.out.println("Error : " + e.getMessage());
				e.printStackTrace();
			}

		} else if ("EXCEL".equals(action)) {
			try {
				System.out.println("excel");
				switch (request.getParameter("accion")) {
				case "reportepc":
					reportePC_Excel(request, response);
					break;

				case "repoplanporhora":
					reportePH_Excel(request, response);
					break;

				case "reportejecutivo":
					 reporteEjecutivo_Excel(request,response);
					break;

				case "reposunedu":
					 reporteSUNEDU_Excel(request,response);
					break;
				}
			} catch (Exception e) {
				System.out.println("Error : " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	private void reporteSUNEDU_PDF(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String description = request.getParameter("cboEscuela");
		String year = request.getParameter("cboano");
		String semester = request.getParameter("cbosemestre");

		String flag = "-1";

		response.setContentType("application/pdf");
		OutputStream out = response.getOutputStream();
		
		try {
			ReporteSU_PDF reportePDF = new ReporteSU_PDF();

			flag = reportePDF.generarReporte(description, year, semester, out) == true ? "1" : "0";

			if (flag == "1") {
				System.out.println("Correcto");
			}

		} catch (Exception e) {
			System.out.println("Error :" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void reporteEjecutivo_PDF(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String description = request.getParameter("cboEscuela");
		String year = request.getParameter("cboano");
		String semester = request.getParameter("cbosemestre");

		String flag = "-1";

		response.setContentType("application/pdf");
		OutputStream out = response.getOutputStream();
		
		try {
			ReporteRE_PDF reportePDF = new ReporteRE_PDF();

			flag = reportePDF.generarReporte(description, year, semester, out) == true ? "1" : "0";

			if (flag == "1") {
				System.out.println("Correcto");
			}

		} catch (Exception e) {
			System.out.println("Error :" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void reportePH_PDF(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String description = request.getParameter("cboEscuela");
		String year = request.getParameter("cboano");
		String semester = request.getParameter("cbosemestre");

		String flag = "-1";

		response.setContentType("application/pdf");
		OutputStream out = response.getOutputStream();
		
		try {
			ReportePH_PDF reportePDF = new ReportePH_PDF();

			flag = reportePDF.generarReporte(description, year, semester, out) == true ? "1" : "0";

			if (flag == "1") {
				System.out.println("Correcto");
			}

		} catch (Exception e) {
			System.out.println("Error :" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void reporteSUNEDU_Excel(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String description = request.getParameter("cboEscuela");
		String year = request.getParameter("cboano");
		String semester = request.getParameter("cbosemestre");

		String flag = "-1";

		try {
			ReporteSU_Excel reporteExcel = new ReporteSU_Excel();

			flag = reporteExcel.generarReporte(description, year, semester) == true ? "1" : "0";

		} catch (Exception e) {
			System.out.println("Eror : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(flag);
		response.sendRedirect(request.getContextPath()+"/Planes/Reporte/generarReporte.jsp");
	}
	
	private void reporteEjecutivo_Excel(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String description = request.getParameter("cboEscuela");
		String year = request.getParameter("cboano");
		String semester = request.getParameter("cbosemestre");

		String flag = "-1";

		try {
			ReporteRE_Excel reporteExcel = new ReporteRE_Excel();

			flag = reporteExcel.generarReporte(description, year, semester) == true ? "1" : "0";

		} catch (Exception e) {
			System.out.println("Eror : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(flag);
		response.sendRedirect(request.getContextPath()+"/Planes/Reporte/generarReporte.jsp");
	}
	
	private void reporteDiferencias_Excel(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String description = request.getParameter("cboEscuela");
		String year = request.getParameter("cboano");
		String semester = request.getParameter("cbosemestre");

		String flag = "-1";

		try {
			ReporteDIF_Excel reporteExcel = new ReporteDIF_Excel();

			flag = reporteExcel.generarReporte(description, year, semester) == true ? "1" : "0";

		} catch (Exception e) {
			System.out.println("Eror : " + e.getMessage());
			e.printStackTrace();
		}
//		response.setContentType("text/plain");
//		response.getWriter().write(flag);
//		response.sendRedirect(request.getContextPath()+"/Planes/Reporte/generarReporte.jsp");
	}
	
	private void reportePH_Excel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String description = request.getParameter("cboEscuela");
		String year = request.getParameter("cboano");
		String semester = request.getParameter("cbosemestre");

		String flag = "-1";

		try {
			ReportePH_Excel reporteExcel = new ReportePH_Excel();

			flag = reporteExcel.generarReporte(description, year, semester) == true ? "1" : "0";

		} catch (Exception e) {
			System.out.println("Eror : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(flag);
		response.sendRedirect(request.getContextPath()+"/Planes/Reporte/generarReporte.jsp");
	}

	private void reportePC_PDF(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String description = request.getParameter("cboEscuela");
		String year = request.getParameter("cboano");
		String semester = request.getParameter("cbosemestre");

		String flag = "-1";

		response.setContentType("application/pdf");
		OutputStream out = response.getOutputStream();

		try {
			ReportePC_PDF reportePDF = new ReportePC_PDF();

			flag = reportePDF.generarReporte(description, year, semester, out) == true ? "1" : "0";

			if (flag == "1") {
				System.out.println("Correcto");
			}

		} catch (Exception e) {
			System.out.println("Error :" + e.getMessage());
			e.printStackTrace();
		}
	}

	private void reportePC_Excel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String description = request.getParameter("cboEscuela");
		String year = request.getParameter("cboano");
		String semester = request.getParameter("cbosemestre");

		String flag = "-1";

		try {
			ReportePC_Excel reporteExcel = new ReportePC_Excel();

			flag = reporteExcel.generarReporte(description, year, semester) == true ? "1" : "0";

		} catch (Exception e) {
			System.out.println("Eror : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(flag);
		response.sendRedirect(request.getContextPath()+"/Planes/Reporte/generarReporte.jsp");
	}
}
