package util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

public class ReportePH_Excel {
	public boolean generarReporte(String escuela, String año, String semestre) {
		boolean flag = false;
		File archivoXLS = null;
		try {
			Conexion con = new Conexion();
			String query="SELECT det_curso_esc.ciclo,curso.idcurso, "
					+ "curso.nombre, "
					+ "curso.creditos , "
					+ "curso.h_teo , "
					+ "(curso.h_pract + curso.h_lab), "
					+ "curso.h_lab,"
					+ "((curso.h_teo)*semestre.cant_sema), "
					+ "(curso.h_pract*semestre.cant_sema), "
					+ "(curso.h_lab*semestre.cant_sema), "
					+ "(curso.h_teo*semestre.cant_sema) + (curso.h_pract*semestre.cant_sema) + (curso.h_lab*semestre.cant_sema)  "
					+ "FROM det_curso_esc "
					+ "INNER JOIN curso ON curso.idcurso = det_curso_esc.codDce_curso "
					+ "INNER JOIN escuela  ON escuela.idescuela = det_curso_esc.codDce_escuela "
					+ "INNER JOIN semestre  ON semestre.idSemestre = det_curso_esc.codDce_sem "
					+ "WHERE escuela.descripcion = '"+escuela+"' "
					+ "AND semestre.ano = '"+año+"' "
					+ "AND semestre.semestre = '"+semestre+"' "
					+ "ORDER BY det_curso_esc.ciclo ASC";
			ResultSet rs = con.executeQuery(query);
			System.out.println("Query " + query);

			String rutaArchivo = System.getProperty("user.home") + "/Desktop/ReportePlanConHoras "+año+"-"+semestre+".xls";
			archivoXLS = new File(rutaArchivo);

			System.out.println("Entr al try, la ruta es " + rutaArchivo);

			if (archivoXLS.exists()) {
				archivoXLS.delete();
				archivoXLS.createNewFile();
			}

			Workbook libro1 = new HSSFWorkbook();
			FileOutputStream archivo = new FileOutputStream(archivoXLS);
			Sheet hoja = libro1.createSheet("Reporte de Plan con Horas");
			hoja.setDisplayGridlines(false);

			Row fila = hoja.createRow(1);

			System.out.println("Se estn creando filas y columnas");

			HSSFFont fuente = (HSSFFont) libro1.createFont();
			HSSFCellStyle estiloCelda = (HSSFCellStyle) libro1.createCellStyle();
			HSSFCellStyle centrado = (HSSFCellStyle) libro1.createCellStyle();
			HSSFCellStyle cabecera = (HSSFCellStyle) libro1.createCellStyle();
			HSSFCellStyle titulo = (HSSFCellStyle) libro1.createCellStyle();

			// Aunque no es necesario podemos establecer estilos a las celdas.
			// Primero, establecemos el tipo de fuente
			cabecera.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			cabecera.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
			fuente.setFontHeightInPoints((short) 9);
			fuente.setFontName(fuente.FONT_ARIAL);
			fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			cabecera.setFont(fuente);
			cabecera.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cabecera.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cabecera.setBottomBorderColor((short) 0);
			cabecera.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cabecera.setLeftBorderColor((short) 0);
			cabecera.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cabecera.setRightBorderColor((short) 0);
			cabecera.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cabecera.setTopBorderColor((short) 0);

			// Estilo de titulo
			HSSFFont fuenteca = (HSSFFont) libro1.createFont();
			fuenteca.setFontHeightInPoints((short) 11);
			fuenteca.setFontName(fuenteca.FONT_ARIAL);
			fuenteca.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			titulo.setFont(fuenteca);
			titulo.setAlignment(HSSFCellStyle.ALIGN_CENTER);


			hoja.setColumnWidth(5, 4500);
			hoja.setColumnWidth(6, 9000);
			hoja.setColumnWidth(7, 2000);
			hoja.setColumnWidth(8, 2000);
			hoja.setColumnWidth(9, 2000);
			hoja.setColumnWidth(10, 2000);
			hoja.setColumnWidth(11, 2000);
			hoja.setColumnWidth(12, 2000);
			hoja.setColumnWidth(13, 2000);
			hoja.setColumnWidth(14, 2000);
			
			// Tambin, podemos establecer bordes...

			centrado.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			centrado.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			centrado.setBottomBorderColor((short) 0);
			centrado.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			centrado.setLeftBorderColor((short) 0);
			centrado.setBorderRight(HSSFCellStyle.BORDER_THIN);
			centrado.setRightBorderColor((short) 0);
			centrado.setBorderTop(HSSFCellStyle.BORDER_THIN);
			centrado.setTopBorderColor((short) 0);

			estiloCelda.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			estiloCelda.setBottomBorderColor((short) 0);
			estiloCelda.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			estiloCelda.setLeftBorderColor((short) 0);
			estiloCelda.setBorderRight(HSSFCellStyle.BORDER_THIN);
			estiloCelda.setRightBorderColor((short) 0);
			estiloCelda.setBorderTop(HSSFCellStyle.BORDER_THIN);
			estiloCelda.setTopBorderColor((short) 0);

			// TItulo
			
			hoja.addMergedRegion(CellRangeAddress.valueOf("F2:O2"));
			hoja.addMergedRegion(CellRangeAddress.valueOf("F3:O3"));
			hoja.addMergedRegion(CellRangeAddress.valueOf("F4:O4"));
			
			
			Cell celda01 = fila.createCell(5);
			celda01.setCellStyle(titulo);
			celda01.setCellValue("ESCUELA PROFESIONAL DE " + (escuela.toUpperCase()));
			fila = hoja.createRow(2);
			Cell celda02 = fila.createCell(5);
			celda02.setCellStyle(titulo);
			celda02.setCellValue("PLAN DE ESTUDIOS CON HORAS");
			fila = hoja.createRow(3);
			Cell celda03 = fila.createCell(5);
			celda03.setCellStyle(titulo);
			celda03.setCellValue("SEMESTRE ACADMICO " + año + " - " + semestre);
			// Cabecera
			
			fila = hoja.createRow(5);
			Cell primeracelda1 = fila.createCell(8);
			primeracelda1.setCellStyle(cabecera);
			Cell primeracelda2 = fila.createCell(9);
			primeracelda2.setCellStyle(cabecera);
			primeracelda2.setCellValue("HORAS SEMANALES");
			Cell primeracelda3 = fila.createCell(10);
			primeracelda3.setCellStyle(cabecera);
			Cell primeracelda4 = fila.createCell(11);
			primeracelda4.setCellStyle(cabecera);
			Cell primeracelda5 = fila.createCell(12);
			primeracelda5.setCellStyle(cabecera);
			primeracelda5.setCellValue("HORAS SEMESTRALES");
			Cell primeracelda6 = fila.createCell(13);
			primeracelda6.setCellStyle(cabecera);
			
			
			
			fila = hoja.createRow(6);
			Cell celda2 = fila.createCell(5);
			celda2.setCellStyle(cabecera);
			celda2.setCellValue("CDIGO");

			Cell celda3 = fila.createCell(6);
			celda3.setCellStyle(cabecera);
			celda3.setCellValue("CICLO");

			Cell celda4 = fila.createCell(7);
			celda4.setCellStyle(cabecera);
			celda4.setCellValue("CRED.");

			Cell celda5 = fila.createCell(8);
			celda5.setCellStyle(cabecera);
			celda5.setCellValue("HT");
			Cell celda6 = fila.createCell(9);
			celda6.setCellStyle(cabecera);
			celda6.setCellValue("HP");
			Cell celda7 = fila.createCell(10);
			celda7.setCellStyle(cabecera);
			celda7.setCellValue("HL");
			Cell celda8 = fila.createCell(11);
			celda8.setCellStyle(cabecera);
			celda8.setCellValue("HT");
			Cell celda9 = fila.createCell(12);
			celda9.setCellStyle(cabecera);
			celda9.setCellValue("HP");
			Cell celda10 = fila.createCell(13);
			celda10.setCellStyle(cabecera);
			celda10.setCellValue("HL");
			Cell celda11 = fila.createCell(14);
			celda11.setCellStyle(cabecera);
			celda11.setCellValue("TOTAL");

			fila = (HSSFRow) hoja.createRow(7);
			Cell ci1 = fila.createCell(5);
			ci1.setCellStyle(centrado);
			ci1.setCellValue("");
			Cell cic = fila.createCell(6);
			cic.setCellStyle(centrado);
			cic.setCellValue("I");
			Cell ci2 = fila.createCell(7);
			ci2.setCellStyle(centrado);
			ci2.setCellValue("");
			Cell ci3 = fila.createCell(8);
			ci3.setCellStyle(centrado);
			ci3.setCellValue("");
			Cell ci4 = fila.createCell(9);
			ci4.setCellStyle(centrado);
			ci4.setCellValue("");
			Cell ci5 = fila.createCell(10);
			ci5.setCellStyle(centrado);
			ci5.setCellValue("");
			Cell ci6 = fila.createCell(11);
			ci6.setCellStyle(centrado);
			ci6.setCellValue("");
			Cell ci7 = fila.createCell(12);
			ci7.setCellStyle(centrado);
			ci7.setCellValue("");
			Cell ci8 = fila.createCell(13);
			ci8.setCellStyle(centrado);
			ci8.setCellValue("");
			Cell ci9 = fila.createCell(14);
			ci9.setCellStyle(centrado);
			ci9.setCellValue("");
			

			int i = 8;
			int ciclonu = 2;
			String rom = "";
			int toCre = 0;
			while (rs.next()) {

				int ciclovi = rs.getInt(1);

				if (ciclonu == ciclovi) {

					fila = (HSSFRow) hoja.createRow(i);
					Cell celdat = fila.createCell(7);
					celdat.setCellStyle(centrado);
					celdat.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
					celdat.setCellValue(toCre);

					fila = (HSSFRow) hoja.createRow(i + 1);
					Cell celda1_2 = fila.createCell(5);
					celda1_2.setCellValue("");
					Cell celda1_3 = fila.createCell(6);
					celda1_3.setCellValue("");
					Cell celda1_4 = fila.createCell(7);
					celda1_4.setCellValue("");
					Cell celda1_5 = fila.createCell(8);
					celda1_5.setCellValue("");
					Cell celda1_6 = fila.createCell(9);
					celda1_6.setCellValue("");
					Cell celda1_7 = fila.createCell(10);
					celda1_7.setCellValue("");
					Cell celda1_8 = fila.createCell(11);
					celda1_8.setCellValue("");
					Cell celda1_9 = fila.createCell(12);
					celda1_9.setCellValue("");
					Cell celda1_10 = fila.createCell(13);
					celda1_10.setCellValue("");
					Cell celda1_11 = fila.createCell(14);
					celda1_11.setCellValue("");
					

					i = i + 2;

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
					case 112:
						rom = "E2";
						break;
					case 13:
						rom = "E3";
						break;
					case 14:
						rom = "E4";
						break;

					}
					fila = (HSSFRow) hoja.createRow(i);
					Cell cicl = fila.createCell(6);
					cicl.setCellStyle(centrado);
					cicl.setCellValue(rom);

					Cell cic2 = fila.createCell(5);
					cic2.setCellStyle(centrado);
					cic2.setCellValue("");
					Cell cic4 = fila.createCell(7);
					cic4.setCellStyle(centrado);
					cic4.setCellValue("");
					Cell cic5 = fila.createCell(8);
					cic5.setCellStyle(centrado);
					cic5.setCellValue("");
					Cell cic6 = fila.createCell(9);
					cic6.setCellStyle(centrado);
					cic6.setCellValue("");
					Cell cic7 = fila.createCell(10);
					cic7.setCellStyle(centrado);
					cic7.setCellValue("");
					Cell cic8 = fila.createCell(11);
					cic8.setCellStyle(centrado);
					cic8.setCellValue("");
					Cell cic9 = fila.createCell(12);
					cic9.setCellStyle(centrado);
					cic9.setCellValue("");
					Cell cic10 = fila.createCell(13);
					cic10.setCellStyle(centrado);
					cic10.setCellValue("");
					Cell cic11 = fila.createCell(14);
					cic11.setCellStyle(centrado);
					cic11.setCellValue("");

					ciclonu++;
					i++;
					toCre = 0;

				}

				fila = (HSSFRow) hoja.createRow(i);
				Cell celda1_2 = fila.createCell(5);
				celda1_2.setCellStyle(centrado);
				celda1_2.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				celda1_2.setCellValue(rs.getString(2));

				Cell celda1_3 = fila.createCell(6);
				celda1_3.setCellStyle(estiloCelda);
				celda1_3.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_3.setCellValue(rs.getString(3));

				Cell celda1_4 = fila.createCell(7);
				celda1_4.setCellStyle(centrado);
				celda1_4.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				celda1_4.setCellValue(rs.getInt(4));

			    Cell celda1_5 = fila.createCell(8);
				celda1_5.setCellStyle(centrado);
				celda1_5.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				celda1_5.setCellValue(rs.getInt(5));
				
				Cell celda1_6 = fila.createCell(9);
				celda1_6.setCellStyle(centrado);
				celda1_6.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				celda1_6.setCellValue(rs.getInt(6));
				
				Cell celda1_7 = fila.createCell(10);
				celda1_7.setCellStyle(centrado);
				celda1_7.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				celda1_7.setCellValue(rs.getInt(7));
				
				Cell celda1_8 = fila.createCell(11);
				celda1_8.setCellStyle(centrado);
				celda1_8.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				celda1_8.setCellValue(rs.getInt(8));
				
				Cell celda1_9 = fila.createCell(12);
				celda1_9.setCellStyle(centrado);
				celda1_9.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				celda1_9.setCellValue(rs.getInt(9));
				
				Cell celda1_10 = fila.createCell(13);
				celda1_10.setCellStyle(centrado);
				celda1_10.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				celda1_10.setCellValue(rs.getInt(10));
				
				Cell celda1_11 = fila.createCell(14);
				celda1_11.setCellStyle(centrado);
				celda1_11.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				celda1_11.setCellValue(rs.getInt(11));
				
				

				toCre = rs.getInt(4) + toCre;
				i++;
			}

			fila = (HSSFRow) hoja.createRow(i);
			Cell celda1_4 = fila.createCell(7);
			celda1_4.setCellStyle(centrado);
			celda1_4.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			celda1_4.setCellValue(toCre);

			libro1.write(archivo);
			archivo.close();
			Desktop.getDesktop().open(archivoXLS);

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return archivoXLS == null ? false : true;
	}
}
