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

public class ReporteExcelC9 {
	public boolean generarExcel(String fecha) {
		boolean flag = false;
		File archivoXLS = null;
		try {
			Conexion con = new Conexion();
			String query = "select apepat, apemat, nombre, pais, numdoc, fecini, ley30220, mayorgrado, menciongrado, univ, paisuniv, pregrado, maestria, doctorado, categoria, regimen, horaclase, horaactiv, totalhoras, investigador, dina, codD_sem, escuela, email, telefono, observaciones, licenciamiento, sl01, sl02, sl03 , max(fecha) from docente_audi where fecha <= '" + fecha + "' group by id_doc";
			
			ResultSet rs = con.executeQuery(query);
			System.out.println("Query " + query);

			String rutaArchivo = System.getProperty("user.home") + "/Desktop/ReporteC9.xls";		
			archivoXLS = new File(rutaArchivo);

			System.out.println("Entró al try, la ruta es " + rutaArchivo);

			if (archivoXLS.exists()) {
				archivoXLS.delete();
				archivoXLS.createNewFile();
			}

			Workbook libro = new HSSFWorkbook();
			FileOutputStream archivo = new FileOutputStream(archivoXLS);
			Sheet hoja = libro.createSheet("Reporte C9 - Licenciamiento");
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
			hoja.setColumnWidth(7, 5000);
			hoja.setColumnWidth(8, 5000);
			hoja.setColumnWidth(9, 5000);
			hoja.setColumnWidth(10, 5000);
			hoja.setColumnWidth(11, 5000);
			hoja.setColumnWidth(12, 5000);
			hoja.setColumnWidth(13, 5000);
			hoja.setColumnWidth(14, 5000);
			hoja.setColumnWidth(15, 5000);
			hoja.setColumnWidth(16, 5000);
			hoja.setColumnWidth(17, 5000);
			hoja.setColumnWidth(18, 5000);
			hoja.setColumnWidth(19, 5000);
			hoja.setColumnWidth(20, 5000);
			hoja.setColumnWidth(21, 5000);
			hoja.setColumnWidth(22, 5000);
			hoja.setColumnWidth(23, 5000);
			hoja.setColumnWidth(24, 5000);
			hoja.setColumnWidth(25, 5000);
			hoja.setColumnWidth(26, 5000);
			hoja.setColumnWidth(27, 5000);
			hoja.setColumnWidth(28, 5000);
			hoja.setColumnWidth(29, 5000);
			hoja.setColumnWidth(30, 5000);
			
			
		

			
			
			
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

			// TItulo

			hoja.addMergedRegion(CellRangeAddress.valueOf("F2:I2"));
			hoja.addMergedRegion(CellRangeAddress.valueOf("F3:I3"));
			hoja.addMergedRegion(CellRangeAddress.valueOf("F4:I4"));
			
			Cell celda01 = fila.createCell(5);
			celda01.setCellStyle(titulo);
			celda01.setCellValue("FACULTAD DE INGENIERIA Y ARQUITECTURA - FIA");
			fila = hoja.createRow(2);
			Cell celda02 = fila.createCell(5);
			celda02.setCellStyle(titulo);
			celda02.setCellValue("REPORTE DE LICENCIAMIENTO - C9");
			fila = hoja.createRow(3);
			Cell celda03 = fila.createCell(5);
			celda03.setCellStyle(titulo);
			celda03.setCellValue("SUNEDU");
			// Cabecera
			
			fila = hoja.createRow(5);
			Cell celda2 = fila.createCell(1);
			celda2.setCellStyle(cabecera);
			celda2.setCellValue("Apellido Paterno");

			Cell celda3 = fila.createCell(2);
			celda3.setCellStyle(cabecera);
			celda3.setCellValue("Apellido Materno");

			Cell celda4 = fila.createCell(3);
			celda4.setCellStyle(cabecera);
			celda4.setCellValue("Nombres");

			Cell celda5 = fila.createCell(4);
			celda5.setCellStyle(cabecera);
			celda5.setCellValue("Nacionalidad (Pais)");

			Cell celda6 = fila.createCell(5);
			celda6.setCellStyle(cabecera);
			celda6.setCellValue("N° de DNI / Carnet de extranjeria");
			
			Cell celda7 = fila.createCell(6);
			celda7.setCellStyle(cabecera);
			celda7.setCellValue("Fecha de ingreso como docente en la universidad");
			
			
			Cell celda8 = fila.createCell(7);
			celda8.setCellStyle(cabecera);
			celda8.setCellValue("Era docente universitario a la entrega en la vigencia de la lay 30220, LU? Sí/No");
			
			Cell celda9 = fila.createCell(8);
			celda9.setCellStyle(cabecera);
			celda9.setCellValue("Mayor grado académico del docente");
			
			Cell celda11 = fila.createCell(9);
			celda11.setCellStyle(cabecera);
			celda11.setCellValue("Mención del mayor grado docente");
			
			Cell celda12 = fila.createCell(10);
			celda12.setCellStyle(cabecera);
			celda12.setCellValue("Universidad que otorgó el mayor grado docente");
			
			Cell celda13 = fila.createCell(11);
			celda13.setCellStyle(cabecera);
			celda13.setCellValue("País / Universidad que otorgó el mayor grado del docente");
			
			Cell celda14 = fila.createCell(12);
			celda14.setCellStyle(cabecera);
			celda14.setCellValue("Pregrado Sí/No");
			
			Cell celda15 = fila.createCell(13);
			celda15.setCellStyle(cabecera);
			celda15.setCellValue("Maestría Sí/No");
			
			Cell celda16= fila.createCell(14);
			celda16.setCellStyle(cabecera);
			celda16.setCellValue("Doctorado Sí/No");
			
			Cell celda18= fila.createCell(15);
			celda18.setCellStyle(cabecera);
			celda18.setCellValue("Categoría docente");
			
			Cell celda19 = fila.createCell(16);
			celda19.setCellStyle(cabecera);
			celda19.setCellValue("Régimen de dedicación");
			
			Cell celda20 = fila.createCell(17);
			celda20.setCellStyle(cabecera);
			celda20.setCellValue("Clases");
			
			Cell celda21 = fila.createCell(18);
			celda21.setCellStyle(cabecera);
			celda21.setCellValue("Otras actividades");
			
			Cell celda22 = fila.createCell(19);
			celda22.setCellStyle(cabecera);
			celda22.setCellValue("Total horas semanales");
			
			Cell celda23 = fila.createCell(20);
			celda23.setCellStyle(cabecera);
			celda23.setCellValue("Docente realiza investigación Sí/No");
			
			Cell celda24 = fila.createCell(21);
			celda24.setCellStyle(cabecera);
			celda24.setCellValue("DINA Sí/No");
			
			Cell celda25 = fila.createCell(22);
			celda25.setCellStyle(cabecera);
			celda25.setCellValue("Periodo Académico");
			
			Cell celda26 = fila.createCell(23);
			celda26.setCellStyle(cabecera);
			celda26.setCellValue("Escuelas");
			
			Cell celda27 = fila.createCell(24);
			celda27.setCellStyle(cabecera);
			celda27.setCellValue("E-Mail");
			
			Cell celda28 = fila.createCell(25);
			celda28.setCellStyle(cabecera);
			celda28.setCellValue("Telefono");
			
			Cell celda29 = fila.createCell(26);
			celda29.setCellStyle(cabecera);
			celda29.setCellValue("Comentarios");
			
			Cell celda30 = fila.createCell(27);
			celda30.setCellStyle(cabecera);
			celda30.setCellValue("El docente fue incorporado despues de la obtencion de la licencia de funcionamiento institucional? Sí/No");

			Cell celda31 = fila.createCell(28);
			celda31.setCellStyle(cabecera);
			celda31.setCellValue("SL01");
			
			Cell celda32 = fila.createCell(29);
			celda32.setCellStyle(cabecera);
			celda32.setCellValue("SL02");
			
			Cell celda33 = fila.createCell(30);
			celda33.setCellStyle(cabecera);
			celda33.setCellValue("SL03");
			

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
				
				if(rs.getInt(7)==1) {
					Cell celda1_7 = fila.createCell(7);
					celda1_7.setCellStyle(estiloCelda);
					celda1_7.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_7.setCellValue("Sí");
				}else {
					Cell celda1_7 = fila.createCell(7);
					celda1_7.setCellStyle(estiloCelda);
					celda1_7.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_7.setCellValue("No");
				}
//				
//				Cell celda1_7 = fila.createCell(7);
//				celda1_7.setCellStyle(estiloCelda);
//				celda1_7.setCellType(HSSFCell.CELL_TYPE_STRING);
//				celda1_7.setCellValue(rs.getString(7));
					
				
//				if(rs.getInt(8) == 1) {
//					Cell celda1_8 = fila.createCell(8);
//					celda1_8.setCellStyle(estiloCelda);
//					celda1_8.setCellType(HSSFCell.CELL_TYPE_STRING);
//					celda1_8.setCellValue("Sí");
////				}
////				else {
////					Cell celda1_8 = fila.createCell(8);
////					celda1_8.setCellStyle(estiloCelda);
////					celda1_8.setCellType(HSSFCell.CELL_TYPE_STRING);
////					celda1_8.setCellValue("No");
////				}
				
				Cell celda1_8 = fila.createCell(8);
				celda1_8.setCellStyle(estiloCelda);
				celda1_8.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_8.setCellValue(rs.getString(8));
				
			
				
				Cell celda1_9 = fila.createCell(9);
				celda1_9.setCellStyle(estiloCelda);
				celda1_9.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_9.setCellValue(rs.getString(9));
				
				Cell celda1_10 = fila.createCell(10);
				celda1_10.setCellStyle(estiloCelda);
				celda1_10.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_10.setCellValue(rs.getString(10));

				Cell celda1_11 = fila.createCell(11);
				celda1_11.setCellStyle(estiloCelda);
				celda1_11.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_11.setCellValue(rs.getString(11));
				
				if(rs.getInt(12) == 1) {
					Cell celda1_12 = fila.createCell(12);
					celda1_12.setCellStyle(estiloCelda);
					celda1_12.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_12.setCellValue("Sí");
				}
				else {
					Cell celda1_12 = fila.createCell(12);
					celda1_12.setCellStyle(estiloCelda);
					celda1_12.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_12.setCellValue("No");
				}
//				Cell celda1_12 = fila.createCell(12);
//				celda1_12.setCellStyle(estiloCelda);
//				celda1_12.setCellType(HSSFCell.CELL_TYPE_STRING);
//				celda1_12.setCellValue(rs.getString(12));
				
				if(rs.getInt(13) == 1) {
					Cell celda1_13 = fila.createCell(13);
					celda1_13.setCellStyle(estiloCelda);
					celda1_13.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_13.setCellValue("Sí");
				}
				else {
					Cell celda1_13 = fila.createCell(13);
					celda1_13.setCellStyle(estiloCelda);
					celda1_13.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_13.setCellValue("No");
				}
//				
//				Cell celda1_13 = fila.createCell(13);
//				celda1_13.setCellStyle(estiloCelda);
//				celda1_13.setCellType(HSSFCell.CELL_TYPE_STRING);
//				celda1_13.setCellValue(rs.getString(13));
				
				if(rs.getInt(14) == 1) {
					Cell celda1_14 = fila.createCell(14);
					celda1_14.setCellStyle(estiloCelda);
					celda1_14.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_14.setCellValue("Sí");
				}
				else {
					Cell celda1_14 = fila.createCell(14);
					celda1_14.setCellStyle(estiloCelda);
					celda1_14.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_14.setCellValue("No");
				}
				
//				Cell celda1_14 = fila.createCell(14);
//				celda1_14.setCellStyle(estiloCelda);
//				celda1_14.setCellType(HSSFCell.CELL_TYPE_STRING);
//				celda1_14.setCellValue(rs.getString(14));
				
//				if(rs.getInt(15) == 1 ) {
//					Cell celda1_15 = fila.createCell(15);
//					celda1_15.setCellStyle(estiloCelda);
//					celda1_15.setCellType(HSSFCell.CELL_TYPE_STRING);
//					celda1_15.setCellValue("Sí");
//				}
//				else {
//					Cell celda1_15 = fila.createCell(15);
//					celda1_15.setCellStyle(estiloCelda);
//					celda1_15.setCellType(HSSFCell.CELL_TYPE_STRING);
//					celda1_15.setCellValue("No");
//					
//				}
				Cell celda1_15 = fila.createCell(15);
				celda1_15.setCellStyle(estiloCelda);
				celda1_15.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_15.setCellValue(rs.getString(15));
				
				
				
				Cell celda1_16 = fila.createCell(16);
				celda1_16.setCellStyle(estiloCelda);
				celda1_16.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_16.setCellValue(rs.getString(16));
				
				
				Cell celda1_17 = fila.createCell(17);
				celda1_17.setCellStyle(estiloCelda);
				celda1_17.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_17.setCellValue(rs.getString(17));
				
				Cell celda1_18 = fila.createCell(18);
				celda1_18.setCellStyle(estiloCelda);
				celda1_18.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_18.setCellValue(rs.getString(18));
				
				
				Cell celda1_19 = fila.createCell(19);
				celda1_19.setCellStyle(estiloCelda);
				celda1_19.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_19.setCellValue(rs.getString(19));
				
				if(rs.getInt(20) == 1 ) {
					Cell celda1_20 = fila.createCell(20);
					celda1_20.setCellStyle(estiloCelda);
					celda1_20.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_20.setCellValue("Sí");
				}
				else {
					Cell celda1_20 = fila.createCell(20);
					celda1_20.setCellStyle(estiloCelda);
					celda1_20.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_20.setCellValue("No");
				}
					
//				Cell celda1_20 = fila.createCell(20);
//				celda1_20.setCellStyle(estiloCelda);
//				celda1_20.setCellType(HSSFCell.CELL_TYPE_STRING);
//				celda1_20.setCellValue(rs.getString(20));
				
				if(rs.getInt(21) == 1 ) {
					Cell celda1_21 = fila.createCell(21);
					celda1_21.setCellStyle(estiloCelda);
					celda1_21.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_21.setCellValue("Sí");
				}
				else {
					Cell celda1_21 = fila.createCell(21);
					celda1_21.setCellStyle(estiloCelda);
					celda1_21.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_21.setCellValue("No");
				}
				
//				Cell celda1_21 = fila.createCell(21);
//				celda1_21.setCellStyle(estiloCelda);
//				celda1_21.setCellType(HSSFCell.CELL_TYPE_STRING);
//				celda1_21.setCellValue(rs.getString(21));
				
				Cell celda1_22 = fila.createCell(22);
				celda1_22.setCellStyle(estiloCelda);
				celda1_22.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_22.setCellValue(rs.getString(22));
				
				Cell celda1_23 = fila.createCell(23);
				celda1_23.setCellStyle(estiloCelda);
				celda1_23.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_23.setCellValue(rs.getString(23));
				
				Cell celda1_24 = fila.createCell(24);
				celda1_24.setCellStyle(estiloCelda);
				celda1_24.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_24.setCellValue(rs.getString(24));
				
				Cell celda1_25 = fila.createCell(25);
				celda1_25.setCellStyle(estiloCelda);
				celda1_25.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_25.setCellValue(rs.getString(25));
				
				Cell celda1_26 = fila.createCell(26);
				celda1_26.setCellStyle(estiloCelda);
				celda1_26.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_26.setCellValue(rs.getString(26));
				
				if(rs.getInt(27) == 1 ) {
					Cell celda1_27 = fila.createCell(27);
					celda1_27.setCellStyle(estiloCelda);
					celda1_27.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_27.setCellValue("Sí");
				}else {
					Cell celda1_27 = fila.createCell(27);
					celda1_27.setCellStyle(estiloCelda);
					celda1_27.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_27.setCellValue("No");
				}
//				Cell celda1_27 = fila.createCell(27);
//				celda1_27.setCellStyle(estiloCelda);
//				celda1_27.setCellType(HSSFCell.CELL_TYPE_STRING);
//				celda1_27.setCellValue(rs.getString(27));
				
				
				if(rs.getInt(28) == 1 ) {
					Cell celda1_28 = fila.createCell(28);
					celda1_28.setCellStyle(estiloCelda);
					celda1_28.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_28.setCellValue("Sí");
				}else {
					Cell celda1_28 = fila.createCell(28);
					celda1_28.setCellStyle(estiloCelda);
					celda1_28.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_28.setCellValue("No");
				}
				
				if(rs.getInt(29) == 1) {
					Cell celda1_29 = fila.createCell(29);
					celda1_29.setCellStyle(estiloCelda);
					celda1_29.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_29.setCellValue("Sí");
				}
				else {
					Cell celda1_29 = fila.createCell(29);
					celda1_29.setCellStyle(estiloCelda);
					celda1_29.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_29.setCellValue("No");
				}
				
				if(rs.getInt(30) == 1) {
					Cell celda1_30 = fila.createCell(30);
					celda1_30.setCellStyle(estiloCelda);
					celda1_30.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_30.setCellValue("Sí");
				}else {
					Cell celda1_30 = fila.createCell(30);
					celda1_30.setCellStyle(estiloCelda);
					celda1_30.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_30.setCellValue("No");
				}
//				Cell celda1_28 = fila.createCell(28);
//				celda1_28.setCellStyle(estiloCelda);
//				celda1_28.setCellType(HSSFCell.CELL_TYPE_STRING);
//				celda1_28.setCellValue(rs.getString(28));
				
//				Cell celda1_29 = fila.createCell(29);
//				celda1_29.setCellStyle(estiloCelda);
//				celda1_29.setCellType(HSSFCell.CELL_TYPE_STRING);
//				celda1_29.setCellValue(rs.getString(29));

//				Cell celda1_30 = fila.createCell(30);
//				celda1_30.setCellStyle(estiloCelda);
//				celda1_30.setCellType(HSSFCell.CELL_TYPE_STRING);
//				celda1_30.setCellValue(rs.getString(30));
////				
//				
//				Cell celda1_24 = fila.createCell(24);
//				celda1_24.setCellStyle(estiloCelda);
//				celda1_24.setCellType(HSSFCell.CELL_TYPE_STRING);
//				celda1_24.setCellValue(rs.getString(24));
				
	
				
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
