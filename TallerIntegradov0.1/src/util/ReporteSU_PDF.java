package util;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ReporteSU_PDF {
	
	public boolean generarReporte(String escuela, String año, String semestre, OutputStream out) {

	Document documento = null;

	try {
		Conexion con = new Conexion();
		System.out.println("Conecto a la Base de Datos"+con);
		String query="SELECT det_curso_esc.ciclo  , "
				+ "curso.nombre , "
				+ "IF (det_curso_esc.tipo_sunedu = 'general', 'S', 'N') , "
				+ "IF (det_curso_esc.tipo_pres_virt = 'virtual', 'S', 'N') , "
				+ "curso.h_teo*semestre.cant_sema  , "
				+ "(curso.h_pract + curso.h_lab)*semestre.cant_sema , "
				+ "curso.h_teo , "
				+ "(curso.h_pract + curso.h_lab)/2.00  "
				+ "FROM det_curso_esc  "
				+ "INNER JOIN curso  ON curso.idcurso = det_curso_esc.codDce_curso "
				+ "INNER JOIN escuela  ON escuela.idescuela = det_curso_esc.codDce_escuela "
				+ "INNER JOIN semestre  ON semestre.idSemestre = det_curso_esc.codDce_sem "
				+ "WHERE escuela.descripcion = '"+escuela+"' "
				+ "AND semestre.ano = '"+año+"' "
				+ "AND semestre.semestre = '"+semestre+"' "
				+ "ORDER BY det_curso_esc.ciclo ASC";
		
		
		ResultSet rs = con.executeQuery(query);

		System.out.println("El query  es : " + query);

		if (con != null) {
			documento = new Document();
			PdfWriter.getInstance(documento, out);

			documento.open();
			// ESTA ES UNA IMAGEN
//			Image imagenes = Image.getInstance(
//					"C://Users//Deng//Desktop//TALLER//Reportes//tallerDeProyectosFinal//WebContent//imagenes//logo_fia.png");
//
//			imagenes.scaleToFit(200, 200);
//			documento.add(imagenes);

			// ESTE ES EL TITULO
			Paragraph par1 = new Paragraph();
			Font fontitulo = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK);
			par1.add(new Phrase("ESCUELA PROFESIONAL DE " + escuela.toUpperCase(), fontitulo));
			par1.add(new Phrase(Chunk.NEWLINE));
			par1.add(new Phrase("PLAN DE ESTUDIOS ", fontitulo));
			par1.add(new Phrase(Chunk.NEWLINE));
			par1.add(new Phrase("SEMESTRE ACADEMICO " + año + "-" + semestre, fontitulo));
			par1.setAlignment(Element.ALIGN_CENTER);
			par1.add(new Phrase(Chunk.NEWLINE));
			par1.add(new Phrase(Chunk.NEWLINE));
			documento.add(par1);

			GrayColor gray = new GrayColor(0.8f); // no alpha
			//ESTA ES UNA TABLA
//			int bn = ;
//			for(int fl = 0;fl<rs.getFetchSize();fl++){
//				if()
//			}
			PdfPTable tabla = new PdfPTable(6);//con 4 columnas

			tabla.setWidthPercentage(100);
			tabla.setWidths(new float[]{0.5f, 0.9f, 0.5f,0.5f,0.3f,0.3f});
			
			/*AGREGO UNA CELDA PARA 4 COLUMNAS*/
			PdfPCell cell = new PdfPCell(new Paragraph(" "));
			cell.setColspan(4);
			cell.setBorder(Rectangle.NO_BORDER);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabla.addCell(cell);
			PdfPCell celda1 = new PdfPCell(new Paragraph("PERIODO ACADEMICO",FontFactory.getFont("Arial",9, Font.BOLD, BaseColor.BLACK)));//nombre a las columnas iniciales
			celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda1.setBackgroundColor(gray);
			PdfPCell celda2 = new PdfPCell(new Paragraph("NOMBRE DEL CURSO",FontFactory.getFont("Arial",9, Font.BOLD, BaseColor.BLACK)));//nombre a las columnas iniciales
			celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda2.setBackgroundColor(gray);
			PdfPCell celda3 = new PdfPCell(new Paragraph("CURSO GENERAL S/N",FontFactory.getFont("Arial",9, Font.BOLD, BaseColor.BLACK)));//nombre a las columnas iniciales
			celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda3.setBackgroundColor(gray);
			PdfPCell celda4 = new PdfPCell(new Paragraph("EDUCACION A DISTANCIA S/N",FontFactory.getFont("Arial",9, Font.BOLD, BaseColor.BLACK)));//nombre a las columnas iniciales
			celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda4.setBackgroundColor(gray);
			/*AGREGO UNA CELDA PARA 2 COLUMNAS*/
			PdfPCell cell1 = new PdfPCell(new Paragraph("HORAS LECTIVAS",FontFactory.getFont("Arial",11, Font.BOLD, BaseColor.BLACK)));
			cell1.setColspan(2);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBackgroundColor(gray);
			tabla.addCell(cell1);
			PdfPCell celda5 = new PdfPCell(new Paragraph("TEORIA",FontFactory.getFont("Arial",9, Font.BOLD, BaseColor.BLACK)));//nombre a las columnas iniciales
			celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda5.setBackgroundColor(gray);
			PdfPCell celda6 = new PdfPCell(new Paragraph("PRACTICA",FontFactory.getFont("Arial",9, Font.BOLD, BaseColor.BLACK)));//nombre a las columnas iniciales
			celda6.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda6.setBackgroundColor(gray);
//			/*AGREGO UNA CELDA PARA 2 COLUMNAS*/
//			PdfPCell cell2 = new PdfPCell(new Paragraph("CREDITOS ACADEMICOS",FontFactory.getFont("Arial",9, Font.BOLD, BaseColor.BLACK)));
//			cell2.setColspan(2);
//			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
//			tabla.addCell(cell2);
//			PdfPCell celda7 = new PdfPCell(new Paragraph("TEORIA(5)",FontFactory.getFont("Arial",9, Font.BOLD, BaseColor.BLACK)));//nombre a las columnas iniciales
//			celda7.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell celda8 = new PdfPCell(new Paragraph("PRACTICA(6)",FontFactory.getFont("Arial",9, Font.BOLD, BaseColor.BLACK)));//nombre a las columnas iniciales
//			celda8.setHorizontalAlignment(Element.ALIGN_CENTER);
			
				//AGREGAR CELDAS A LA TABLA
			tabla.addCell(celda1).setHorizontalAlignment(Element.ALIGN_CENTER);
			tabla.addCell(celda2).setHorizontalAlignment(Element.ALIGN_CENTER);
			tabla.addCell(celda3).setHorizontalAlignment(Element.ALIGN_CENTER);
			tabla.addCell(celda4).setHorizontalAlignment(Element.ALIGN_CENTER);
			tabla.addCell(celda5).setHorizontalAlignment(Element.ALIGN_CENTER);
			tabla.addCell(celda6).setHorizontalAlignment(Element.ALIGN_CENTER);
//			tabla.addCell(celda7).setHorizontalAlignment(Element.ALIGN_CENTER);
//			tabla.addCell(celda8).setHorizontalAlignment(Element.ALIGN_CENTER);
			
			Font fontcuerpo = new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK);
			int bnd=1;
			while(rs.next()){
				int fl=Integer.parseInt(rs.getString(1));
				if(fl!=bnd){
					//tabla.addCell(tst);
					PdfPCell separador = new PdfPCell(new Paragraph(" "));
					separador.setColspan(6);
					separador.setBorder(Rectangle.NO_BORDER);
					tabla.addCell(separador);
					tabla.addCell(separador);
					bnd++;
					System.out.println("lol");
				}
				PdfPCell uno = new PdfPCell(new Phrase(rs.getString(1), fontcuerpo));
				PdfPCell dos = new PdfPCell(new Phrase(rs.getString(2), fontcuerpo));
				PdfPCell trs = new PdfPCell(new Phrase(rs.getString(3), fontcuerpo));
				PdfPCell ctr = new PdfPCell(new Phrase(rs.getString(4), fontcuerpo));
				PdfPCell cin = new PdfPCell(new Phrase(rs.getString(5), fontcuerpo));
				PdfPCell sei = new PdfPCell(new Phrase(rs.getString(6), fontcuerpo));
//				PdfPCell sie = new PdfPCell(new Phrase(rs.getString(7), fontcuerpo));
//				PdfPCell och = new PdfPCell(new Phrase(rs.getString(8), fontcuerpo));
		        tabla.addCell(uno).setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(dos);
				tabla.addCell(trs).setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(ctr).setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(cin).setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(sei).setHorizontalAlignment(Element.ALIGN_CENTER);
//				tabla.addCell(sie).setHorizontalAlignment(Element.ALIGN_CENTER);
//				tabla.addCell(och).setHorizontalAlignment(Element.ALIGN_CENTER);
				
	
			}
			documento.add(tabla);
			documento.close();
			

			
		}
	} catch (Exception e) {
		System.out.println("Error : " + e.getMessage());
		e.printStackTrace();
	}

	return documento == null ? false : true;
}
}
