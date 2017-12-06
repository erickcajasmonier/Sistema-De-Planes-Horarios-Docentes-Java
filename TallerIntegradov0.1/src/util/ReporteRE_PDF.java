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

public class ReporteRE_PDF {
	public boolean generarReporte(String escuela, String año, String semestre, OutputStream out) {
		Document documento = null;

		try {
			Conexion con = new Conexion();
			System.out.println("Conecto a la Base de Datos"+con);
			String query="SELECT curso.idcurso, "
					+ "CONCAT(det_curso_esc.ciclo , ' ' , curso.nombre), "
					+ "curso.creditos , "
					+ "curso.h_teo , "
					+ "(curso.h_pract + curso.h_lab), "
					+ "curso.h_lab,"
					+ "((curso.h_teo)*semestre.cant_sema), "
					+ "(curso.h_pract*semestre.cant_sema), "
					+ "(curso.h_lab*semestre.cant_sema), "
					+ "(curso.h_teo*semestre.cant_sema) + (curso.h_pract*semestre.cant_sema) + (curso.h_lab*semestre.cant_sema)  "
					+ "FROM det_curso_esc "
					+ "INNER JOIN curso ON curso.index_curso = det_curso_esc.index_curso "
					+ "INNER JOIN escuela  ON escuela.idescuela = det_curso_esc.codDce_escuela "
					+ "INNER JOIN semestre  ON semestre.idSemestre = det_curso_esc.codDce_sem "
					+ "WHERE escuela.descripcion ='"+escuela+"' "
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
//				Image imagenes = Image.getInstance(
//						"C://Users//Deng//Desktop//TALLER//Reportes//tallerDeProyectosFinal//WebContent//imagenes//logo_fia.png");
//
//				imagenes.scaleToFit(200, 200);
//				documento.add(imagenes);

				// ESTE ES EL TITULO
				Paragraph par1 = new Paragraph();
				Font fontitulo = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK);
				par1.add(new Phrase("ESCUELA PROFESIONAL DE " + escuela.toUpperCase(), fontitulo));
				par1.add(new Phrase(Chunk.NEWLINE));
				par1.add(new Phrase("REPORTE PARA RESUMEN EJECUTIVO", fontitulo));
				par1.add(new Phrase(Chunk.NEWLINE));
				par1.add(new Phrase("SEMESTRE ACADEMICO " + año + "-" + semestre, fontitulo));
				par1.setAlignment(Element.ALIGN_CENTER);
				par1.add(new Phrase(Chunk.NEWLINE));
				par1.add(new Phrase(Chunk.NEWLINE));
				documento.add(par1);
	
				
				//ESTA ES UNA TABLA
//				int bn = ;
//				for(int fl = 0;fl<rs.getFetchSize();fl++){
//					if()
//				}
				PdfPTable tabla = new PdfPTable(8);//con 4 columnas
				PdfPCell cell = new PdfPCell(new Paragraph(" "));
				tabla.setWidthPercentage(90);
				tabla.setWidths(new float[]{0.5f, 1f, 0.5f,0.3f,0.3f,0.3f,0.3f,0.3f});
				cell.setColspan(3);
				cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(cell);
				PdfPCell celda1 = new PdfPCell(new Paragraph("CODIGO",FontFactory.getFont("Arial",8, Font.BOLD, BaseColor.BLACK)));//nombre a las columnas iniciales
				celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell celda2 = new PdfPCell(new Paragraph("CICLO",FontFactory.getFont("Arial",8, Font.BOLD, BaseColor.BLACK)));//nombre a las columnas iniciales
				celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell celda3 = new PdfPCell(new Paragraph("CRE.",FontFactory.getFont("Arial",8, Font.BOLD, BaseColor.BLACK)));//nombre a las columnas iniciales
				celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
				/*AGREGO UNA CELDA PARA 3 COLUMNAS*/
				PdfPCell cell1 = new PdfPCell(new Paragraph("HORAS SEMANALES",FontFactory.getFont("Arial",9, Font.BOLD, BaseColor.BLACK)));
				cell1.setColspan(2);
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(cell1);
				PdfPCell celda4 = new PdfPCell(new Paragraph("HT",FontFactory.getFont("Arial",8, Font.BOLD, BaseColor.BLACK)));//nombre a las columnas iniciales
				celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell celda5 = new PdfPCell(new Paragraph("HP",FontFactory.getFont("Arial",8, Font.BOLD, BaseColor.BLACK)));//nombre a las columnas iniciales
				celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				/*AGREGO UNA CELDA PARA 3 COLUMNAS*/
				PdfPCell cell2 = new PdfPCell(new Paragraph("HORAS SEMESTRALES",FontFactory.getFont("Arial",9, Font.BOLD, BaseColor.BLACK)));
				cell2.setColspan(2);
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(cell2);
				PdfPCell celda7 = new PdfPCell(new Paragraph("HT",FontFactory.getFont("Arial",8, Font.BOLD, BaseColor.BLACK)));//nombre a las columnas iniciales
				celda7.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell celda8 = new PdfPCell(new Paragraph("HP",FontFactory.getFont("Arial",8, Font.BOLD, BaseColor.BLACK)));//nombre a las columnas iniciales
				celda8.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				/*AGREGO UNA CELDA PARA 1 COLUMNAS*/
				PdfPCell cell3 = new PdfPCell(new Paragraph(" ",FontFactory.getFont("Arial",9, Font.BOLD, BaseColor.BLACK)));
				cell3.setColspan(1);
				cell3.setBorder(Rectangle.NO_BORDER);
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(cell3);
				PdfPCell celda10 = new PdfPCell(new Paragraph("TOTAL",FontFactory.getFont("Arial",8, Font.BOLD, BaseColor.BLACK)));//nombre a las columnas iniciales
				celda10.setHorizontalAlignment(Element.ALIGN_CENTER);
				
					//AGREGAR CELDAS A LA TABLA
				tabla.addCell(celda1).setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(celda2).setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(celda3).setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(celda4).setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(celda5).setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(celda7).setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(celda8).setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(celda10).setHorizontalAlignment(Element.ALIGN_CENTER);
				
				tabla.setSpacingAfter(10f);
				
				Font fontcuerpo = new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK);
				int bnd=1,cnt=0;
				while(rs.next()){
					String separar = rs.getString(2);
					String[] partdo = separar.split(" ");
					String part1 = partdo[0];
					
					//int fl=Integer.parseInt(rs.getString(2).substring(0, 1));
					int fl=Integer.parseInt(part1);
					if(fl!=bnd){
						//tabla.addCell(tst);
						documento.add(tabla);
						tabla.setSpacingAfter(10f);
						bnd++;
						
						for (int j=0;j<cnt;j++){
							tabla.deleteLastRow();
						}
						cnt=0;
					}
					System.out.println(fl+" flag");
					PdfPCell uno = new PdfPCell(new Phrase(rs.getString(1), fontcuerpo));
					PdfPCell dos = new PdfPCell(new Phrase(rs.getString(2).substring(2), fontcuerpo));
					PdfPCell trs = new PdfPCell(new Phrase(rs.getString(3), fontcuerpo));
					PdfPCell ctr = new PdfPCell(new Phrase(rs.getString(4), fontcuerpo));
					PdfPCell cin = new PdfPCell(new Phrase(rs.getString(5), fontcuerpo));
					PdfPCell sie = new PdfPCell(new Phrase(rs.getString(7), fontcuerpo));
					PdfPCell och = new PdfPCell(new Phrase(rs.getString(8), fontcuerpo));
					PdfPCell die = new PdfPCell(new Phrase(rs.getString(10), fontcuerpo));
			        tabla.addCell(uno);
					tabla.addCell(dos);
					tabla.addCell(trs).setHorizontalAlignment(Element.ALIGN_CENTER);
					tabla.addCell(ctr).setHorizontalAlignment(Element.ALIGN_CENTER);
					tabla.addCell(cin).setHorizontalAlignment(Element.ALIGN_CENTER);
					tabla.addCell(sie).setHorizontalAlignment(Element.ALIGN_CENTER);
					tabla.addCell(och).setHorizontalAlignment(Element.ALIGN_CENTER);
					tabla.addCell(die).setHorizontalAlignment(Element.ALIGN_CENTER);
					cnt++;
				}
				//documento.add(tabla);
				documento.close();
				
	
				
			}
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}

		return documento == null ? false : true;
	}
}
