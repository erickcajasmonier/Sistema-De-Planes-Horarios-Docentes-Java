package util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class ReporteDocentexInteres_Excel {
	
	public boolean generarExcel(String idcurso, String idsem, String curso, String sem) {
		File archivoXLS = null;
		try {
			Conexion con = new Conexion();
			
			String query = "select distinct i.codDocente, d.nombre, d.apepat,d.apemat, d.telefono, d.email from"
					+ " intereses_docente as i inner join docente as d on "
					+ " i.codDocente=d.numdoc "
					+ " where i.idCurso= '" + idcurso +"'"
					+ " and i.cod_semestre= '" + idsem +"'";
			
			
			ResultSet rs = con.executeQuery(query);
			System.out.println("Query " + query);


			String rutaArchivo = System.getProperty("user.home") + "/Desktop/Reporte_DocentesxInteres_"+curso+"_"+sem+".xls";		
			archivoXLS = new File(rutaArchivo);

			System.out.println("Entró al try, la ruta es " + rutaArchivo);

			if (archivoXLS.exists()) {
				archivoXLS.delete();
				archivoXLS.createNewFile();
			}

			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivo = new FileOutputStream(archivoXLS);
			Sheet hoja = libro.createSheet(curso);
			hoja.setDisplayGridlines(false);

			Row fila = hoja.createRow(1);

			System.out.println("Se están creando filas y columnas");

			HSSFFont fuente = (HSSFFont) libro.createFont();
			HSSFCellStyle estiloCelda = (HSSFCellStyle) libro.createCellStyle();
			HSSFCellStyle centrado = (HSSFCellStyle) libro.createCellStyle();
			HSSFCellStyle cabecera = (HSSFCellStyle) libro.createCellStyle();
			HSSFCellStyle titulo = (HSSFCellStyle) libro.createCellStyle();

			// Aunque no es necesario podemos establecer estil<s<sos a las celdas.
			// Primero, establecemos el tipo de fuente

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
			HSSFFont fuenteca = (HSSFFont) libro.createFont();
			fuenteca.setFontHeightInPoints((short) 11);
			fuenteca.setFontName(fuenteca.FONT_ARIAL);
			fuenteca.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			titulo.setFont(fuenteca);
			titulo.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		
			//AGREGA COLUMNAS CTMRE
			
			hoja.setColumnWidth(1, 5000);
			hoja.setColumnWidth(2, 5000);
			hoja.setColumnWidth(3, 5000);
			hoja.setColumnWidth(4, 5000);
			hoja.setColumnWidth(5, 5000);
			hoja.setColumnWidth(6, 5000);

			
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

			// TItulo9

			hoja.addMergedRegion(CellRangeAddress.valueOf("C2:F2"));
			hoja.addMergedRegion(CellRangeAddress.valueOf("C3:F3"));
			hoja.addMergedRegion(CellRangeAddress.valueOf("C4:F4"));
			
			Cell celda01 = fila.createCell(2);
			celda01.setCellStyle(titulo);
			celda01.setCellValue("FACULTAD DE INGENIERIA Y ARQUITECTURA - FIA");
			fila = hoja.createRow(2);
			Cell celda02 = fila.createCell(2);
			celda02.setCellStyle(titulo);
			celda02.setCellValue("REPORTE DE DOCENTES POR CURSO - "+ curso);
			fila = hoja.createRow(3);
			Cell celda03 = fila.createCell(2);
			celda03.setCellStyle(titulo);
			celda03.setCellValue("SEMESTRE ACADÉMICO "+sem );
			// Cabecera
			
			fila = hoja.createRow(5);
			Cell celda2 = fila.createCell(1);
			celda2.setCellStyle(cabecera);
			celda2.setCellValue("DNI");

			Cell celda3 = fila.createCell(2);
			celda3.setCellStyle(cabecera);
			celda3.setCellValue("Nombres");

			Cell celda4 = fila.createCell(3);
			celda4.setCellStyle(cabecera);
			celda4.setCellValue("Apellido Paterno");

			Cell celda5 = fila.createCell(4);
			celda5.setCellStyle(cabecera);
			celda5.setCellValue("Apellido Materno");
			
			Cell celda6 = fila.createCell(5);
			celda6.setCellStyle(cabecera);
			celda6.setCellValue("Telefono");
			
			Cell celda7 = fila.createCell(6);
			celda7.setCellStyle(cabecera);
			celda7.setCellValue("Correo");

			int i = 7;
			
			while (rs.next()) {

				
				fila = (HSSFRow) hoja.createRow(i);
				
				
				Cell celda1_1 = fila.createCell(1);
				celda1_1.setCellStyle(estiloCelda);
				celda1_1.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_1.setCellValue(rs.getString(1));

				Cell celda1_2 = fila.createCell(2);
				celda1_2.setCellStyle(estiloCelda);
				celda1_2.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_2.setCellValue(rs.getString(2));
				
				Cell celda1_3 = fila.createCell(3);
				celda1_3.setCellStyle(estiloCelda);
				celda1_3.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_3.setCellValue(rs.getString(3));
				
				Cell celda1_4 = fila.createCell(4);
				celda1_4.setCellStyle(estiloCelda);
				celda1_4.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_4.setCellValue(rs.getString(4));

				Cell celda1_5 = fila.createCell(5);
				celda1_5.setCellStyle(estiloCelda);
				celda1_5.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_5.setCellValue(rs.getString(5));
				
				Cell celda1_6 = fila.createCell(6);
				celda1_6.setCellStyle(estiloCelda);
				celda1_6.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_6.setCellValue(rs.getString(6));
				
				
				i++;
			}

			

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
