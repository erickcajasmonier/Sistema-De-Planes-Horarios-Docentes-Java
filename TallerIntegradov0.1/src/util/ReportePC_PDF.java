package util;

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
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ReportePC_PDF {

	public boolean generarReporte(String escuela, String año, String semestre, OutputStream out) {
		Document documento = null;

		try {
			Conexion con = new Conexion();
			String query = "SELECT det_curso_esc.ciclo, " + "curso.idcurso ," + " curso.nombre ," + " curso.creditos ,"
					+ " CONCAT(curso.req01 , '  ', curso.req02, '  ', curso.req03, ' ', curso.cooreq, curso.cred_req) "
					+ "FROM det_curso_esc " + "INNER JOIN curso  ON curso.idcurso = det_curso_esc.codDce_curso "
					+ "INNER JOIN escuela ON escuela.idescuela = det_curso_esc.codDce_escuela "
					+ "INNER JOIN semestre ON semestre.idSemestre = det_curso_esc.codDce_sem "
					+ "WHERE escuela.descripcion ='" + escuela + "'" + " AND semestre.ano ='" + año + "'"
					+ "AND semestre.semestre = '" + semestre + "'" + "ORDER BY det_curso_esc.ciclo ASC";

			ResultSet rs = con.executeQuery(query);

			System.out.println("El query  es : " + query);

			if (con != null) {
				documento = new Document();
				PdfWriter.getInstance(documento, out);

				documento.open();
				// ESTA ES UNA IMAGEN
				/*Image imagenes = Image.getInstance(
						"C://Users//Deng//Desktop//TALLER//Reportes//tallerDeProyectosFinal//WebContent//imagenes//logo_fia.png");

				imagenes.scaleToFit(200, 200);
				documento.add(imagenes);*/

				// ESTE ES EL TITULO
				Paragraph par1 = new Paragraph();
				Font fontitulo = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK);
				par1.add(new Phrase("ESCUELA PROFESIONAL DE " + escuela.toUpperCase(), fontitulo));
				par1.add(new Phrase(Chunk.NEWLINE));
				par1.add(new Phrase("PLAN DE ESTUDIO ", fontitulo));
				par1.add(new Phrase(Chunk.NEWLINE));
				par1.add(new Phrase("SEMESTRE ACADEMICO " + año + "-" + semestre, fontitulo));
				par1.setAlignment(Element.ALIGN_CENTER);
				par1.add(new Phrase(Chunk.NEWLINE));
				par1.add(new Phrase(Chunk.NEWLINE));
				documento.add(par1);

				// ESTA ES UNA TABLA
				PdfPTable tabla = new PdfPTable(4);// con 5 columnas
				tabla.setWidths(new float[] { 4, 6, 4, 4 });

				Font foncelda = new Font(FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));

				PdfPCell celda2 = new PdfPCell(new Paragraph("CÓDIGO", foncelda));// nombre
																					// a
																					// las
																					// columnas
																					// iniciales
				celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda2.setBackgroundColor(BaseColor.LIGHT_GRAY);
				PdfPCell celda3 = new PdfPCell(new Paragraph("CURSO", foncelda));// nombre
																					// a
																					// las
																					// columnas
																					// iniciales
				celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda3.setBackgroundColor(BaseColor.LIGHT_GRAY);
				PdfPCell celda4 = new PdfPCell(new Paragraph("CREDITOS", foncelda));// nombre
																					// a
																					// las
																					// columnas
																					// iniciales
				celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda4.setBackgroundColor(BaseColor.LIGHT_GRAY);
				PdfPCell celda5 = new PdfPCell(new Paragraph("PRE - REQUISITOS", foncelda));// nombre
																							// a
																							// las
																							// columnas
																							// iniciales
				celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda5.setBackgroundColor(BaseColor.LIGHT_GRAY);

				PdfPCell celdaciclo = new PdfPCell(new Paragraph("I", FontFactory.getFont("Arial", 10, Font.NORMAL)));// nombre
																														// a
																														// las
																														// columnas
																														// iniciales
				celdaciclo.setHorizontalAlignment(Element.ALIGN_CENTER);

				// AGREGAR CELDAS A LA TABLA

				tabla.addCell(celda2);
				tabla.addCell(celda3);
				tabla.addCell(celda4);
				tabla.addCell(celda5);

				// Se agrega el primer ciclo

				tabla.addCell(" ");
				tabla.addCell(celdaciclo);
				tabla.addCell(" ");
				tabla.addCell(" ");

				int ciclonu = 2;
				String rom = "";
				int toCre = 0;

				while (rs.next()) {

					int ciclovi = rs.getInt(1);

					if (ciclonu == ciclovi) {

						System.out.println("Nuevo : " + ciclonu);
						System.out.println("Viejo : " + ciclovi);

						PdfPCell celdatoCre = new PdfPCell(
								new Paragraph("" + toCre, FontFactory.getFont("Arial", 10, Font.NORMAL)));
						celdatoCre.setHorizontalAlignment(Element.ALIGN_CENTER);
						PdfPCell espacio = new PdfPCell(new Paragraph(" "));
						espacio.setHorizontalAlignment(Element.ALIGN_CENTER);
						espacio.setColspan(5);
						espacio.setUseBorderPadding(true);
						espacio.setBorderColor(BaseColor.WHITE);
						espacio.setBorderColorTop(BaseColor.BLACK);

						tabla.addCell(" ");
						tabla.addCell(" ");
						tabla.addCell(celdatoCre);
						tabla.addCell(" ");
						toCre = 0;

						tabla.addCell(espacio);

						switch (ciclonu) {
						case 2:
							rom = "II";
							break;
						case 3:
							rom = "III";
							break;
						case 4:
							rom = "IV";
							break;
						case 5:
							rom = "V";
							break;
						case 6:
							rom = "VI";
							break;
						case 7:
							rom = "VII";
							break;
						case 8:
							rom = "VIII";
							break;
						case 9:
							rom = "IX";
							break;
						case 10:
							rom = "X";
							break;
						case 11:
							rom = "E1";
							break;
						case 12:
							rom = "E2";
							break;
						case 13:
							rom = "E3";
							break;
						case 14:
							rom = "E4";
							break;

						}

						PdfPCell celdaciclorom = new PdfPCell(
								new Paragraph(rom, FontFactory.getFont("Arial", 9, Font.NORMAL)));
						celdaciclorom.setHorizontalAlignment(Element.ALIGN_CENTER);

						tabla.addCell(" ");
						tabla.addCell(celdaciclorom);
						tabla.addCell(" ");
						tabla.addCell(" ");

						ciclonu++;

					}

					PdfPCell celda1_2 = new PdfPCell(
							new Paragraph(rs.getString(2), FontFactory.getFont("Arial", 9, Font.NORMAL)));
					tabla.addCell(celda1_2).setHorizontalAlignment(Element.ALIGN_CENTER);

					PdfPCell celda1_3 = new PdfPCell(
							new Paragraph(rs.getString(3), FontFactory.getFont("Arial", 9, Font.NORMAL)));
					tabla.addCell(celda1_3);

					PdfPCell celda1_4 = new PdfPCell(
							new Paragraph(rs.getString(4), FontFactory.getFont("Arial", 9, Font.NORMAL)));
					tabla.addCell(celda1_4).setHorizontalAlignment(Element.ALIGN_CENTER);
					if (rs.getString(5) == "" || rs.getString(5) == null) {
						PdfPCell celda1_5 = new PdfPCell(
								new Paragraph("---", FontFactory.getFont("Arial", 9, Font.NORMAL)));
						tabla.addCell(celda1_5).setHorizontalAlignment(Element.ALIGN_CENTER);
					} else {
						PdfPCell celda1_5 = new PdfPCell(
								new Paragraph(rs.getString(5), FontFactory.getFont("Arial", 9, Font.NORMAL)));
						tabla.addCell(celda1_5).setHorizontalAlignment(Element.ALIGN_CENTER);
					}
					toCre = toCre + rs.getInt(4);
				}

				PdfPCell celdatoCre = new PdfPCell(
						new Paragraph("" + toCre, FontFactory.getFont("Arial", 9, Font.NORMAL)));
				celdatoCre.setHorizontalAlignment(Element.ALIGN_CENTER);
				tabla.addCell(" ");
				tabla.addCell(" ");
				tabla.addCell(celdatoCre);
				tabla.addCell(" ");

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
