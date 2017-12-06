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

public class ReportePC_Excel {
	public boolean generarReporte(String escuela, String año, String semestre) {
		File archivoXLS = null;
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
			System.out.println("Query " + query);

			String rutaArchivo = System.getProperty("user.home") + "/Desktop/ReportePlandeEstudio "+año+"-"+semestre+".xls";
			archivoXLS = new File(rutaArchivo);

			System.out.println("Entró al try, la ruta es " + rutaArchivo);

			if (archivoXLS.exists()) {
				archivoXLS.delete();
				archivoXLS.createNewFile();
			}

			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivo = new FileOutputStream(archivoXLS);
			Sheet hoja = libro.createSheet("Reporte Plan de Estudios");
			hoja.setDisplayGridlines(false);

			Row fila = hoja.createRow(1);

			System.out.println("Se están creando filas y columnas");

			HSSFFont fuente = (HSSFFont) libro.createFont();
			HSSFCellStyle estiloCelda = (HSSFCellStyle) libro.createCellStyle();
			HSSFCellStyle centrado = (HSSFCellStyle) libro.createCellStyle();
			HSSFCellStyle cabecera = (HSSFCellStyle) libro.createCellStyle();
			HSSFCellStyle titulo = (HSSFCellStyle) libro.createCellStyle();

			// Aunque no es necesario podemos establecer estilos a las celdas.
			// Primero, establecemos el tipo de fuente

			fuente.setFontHeightInPoints((short) 9);
			fuente.setFontName(fuente.FONT_ARIAL);
			fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			cabecera.setFont(fuente);
			cabecera.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			cabecera.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
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
			HSSFFont fuenteca = (HSSFFont) libro.createFont();
			fuenteca.setFontHeightInPoints((short) 11);
			fuenteca.setFontName(fuenteca.FONT_ARIAL);
			fuenteca.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			titulo.setFont(fuenteca);
			titulo.setAlignment(HSSFCellStyle.ALIGN_CENTER);

			/*
			 * // Luego creamos el objeto que se encargará de aplicar el estilo
			 * a la celda HSSFCellStyle estiloCelda = (HSSFCellStyle)
			 * libro.createCellStyle(); estiloCelda.setWrapText(true);
			 * estiloCelda.setAlignment(HSSFCellStyle. ALIGN_JUSTIFY);
			 * estiloCelda.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
			 * estiloCelda.setFont(fuente);
			 */

			hoja.setColumnWidth(5, 4500);
			hoja.setColumnWidth(6, 9000);
			hoja.setColumnWidth(7, 4000);
			hoja.setColumnWidth(8, 7000);
			// También, podemos establecer bordes...

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

			// Titulo

			hoja.addMergedRegion(CellRangeAddress.valueOf("F2:I2"));
			hoja.addMergedRegion(CellRangeAddress.valueOf("F3:I3"));
			hoja.addMergedRegion(CellRangeAddress.valueOf("F4:I4"));
			Cell celda01 = fila.createCell(5);
			celda01.setCellStyle(titulo);
			celda01.setCellValue("ESCUELA PROFESIONAL DE " + (escuela.toUpperCase()));
			fila = hoja.createRow(2);
			Cell celda02 = fila.createCell(5);
			celda02.setCellStyle(titulo);
			celda02.setCellValue("PLAN DE ESTUDIO");
			fila = hoja.createRow(3);
			Cell celda03 = fila.createCell(5);
			celda03.setCellStyle(titulo);
			celda03.setCellValue("SEMESTRE ACADÉMICO " + año + " - " + semestre);
			// Cabecera
			fila = hoja.createRow(5);
			Cell celda2 = fila.createCell(5);
			celda2.setCellStyle(cabecera);
			celda2.setCellValue("CÓDIGO");

			Cell celda3 = fila.createCell(6);
			celda3.setCellStyle(cabecera);
			celda3.setCellValue("CICLO");

			Cell celda4 = fila.createCell(7);
			celda4.setCellStyle(cabecera);
			celda4.setCellValue("CRÉDITOS");

			Cell celda5 = fila.createCell(8);
			celda5.setCellStyle(cabecera);
			celda5.setCellValue("PRE- REQUISITOS");

			fila = (HSSFRow) hoja.createRow(6);
			Cell ci4 = fila.createCell(5);
			ci4.setCellStyle(centrado);
			ci4.setCellValue("");
			Cell cic = fila.createCell(6);
			cic.setCellStyle(centrado);
			cic.setCellValue("I");
			Cell ci2 = fila.createCell(7);
			ci2.setCellStyle(centrado);
			ci2.setCellValue("");
			Cell ci3 = fila.createCell(8);
			ci3.setCellStyle(centrado);
			ci3.setCellValue("");

			int i = 7;
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

					ciclonu++;
					i++;
					toCre = 0;

				}

				fila = (HSSFRow) hoja.createRow(i);
				Cell celda1_2 = fila.createCell(5);
				celda1_2.setCellStyle(centrado);
				celda1_2.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_2.setCellValue(rs.getString(2));

				Cell celda1_3 = fila.createCell(6);
				celda1_3.setCellStyle(estiloCelda);
				celda1_3.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_3.setCellValue(rs.getString(3));

				Cell celda1_4 = fila.createCell(7);
				celda1_4.setCellStyle(centrado);
				celda1_4.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				celda1_4.setCellValue(rs.getInt(4));

				if (rs.getString(5) == "" || rs.getString(5) == null) {
					String prerequisito = "---";
					Cell celda1_5 = fila.createCell(8);
					celda1_5.setCellStyle(centrado);
					celda1_5.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
					celda1_5.setCellValue(prerequisito);
				} else {
					Cell celda1_5 = fila.createCell(8);
					celda1_5.setCellStyle(estiloCelda);
					celda1_5.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
					celda1_5.setCellValue(rs.getString(5));
				}

				toCre = rs.getInt(4) + toCre;
				i++;
			}

			fila = (HSSFRow) hoja.createRow(i);
			Cell celda1_4 = fila.createCell(7);
			celda1_4.setCellStyle(centrado);
			celda1_4.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			celda1_4.setCellValue(toCre);

			libro.write(archivo);
			archivo.close();
			Desktop.getDesktop().open(archivoXLS);

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return archivoXLS == null ? false : true;
	}
}
