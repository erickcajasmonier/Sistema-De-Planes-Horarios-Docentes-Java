package util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.CallableStatement;
import java.sql.ResultSet;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

public class ReporteDIF_Excel {
	public boolean generarReporte(String escuela, String año, String semestre){
		File archivoXLS = null;
		try{
			System.out.println(escuela);
			Conexion con = new Conexion();
			Conexion con1 = new Conexion();	
			String query1 ="diferenciasPlanes("+año+","+semestre+",'"+escuela+"')";
			String query2="SELECT * FROM semestre WHERE idSemestre = (SELECT idSemestre -1 FROM semestre WHERE ano='"+año+"' AND semestre='"+semestre+"')";
			
			CallableStatement cl = con.ejecutarProcedure(query1);
			
			ResultSet rs1 = cl.executeQuery();
						
			ResultSet rs2 = con1.executeQuery(query2);

			String rutaArchivo = System.getProperty("user.home") + "/Desktop/ReporteDiferencias "+año+"-"+semestre+".xls";
			archivoXLS = new File(rutaArchivo);
			
			if (archivoXLS.exists()) {
				archivoXLS.delete();
				archivoXLS.createNewFile();
			}
			
			Workbook libro1 = new HSSFWorkbook();
			FileOutputStream archivo = new FileOutputStream(archivoXLS);
			Sheet hoja = libro1.createSheet("Reporte de Diferencias");
			hoja.setDisplayGridlines(false);
			
			//Estilos
				//FUENTES
					HSSFFont fuente = (HSSFFont) libro1.createFont();
					HSSFFont fuenteca = (HSSFFont) libro1.createFont();
					HSSFFont fuenteIns = (HSSFFont) libro1.createFont();
					
					fuente.setFontHeightInPoints((short) 9);
					fuente.setFontName(fuente.FONT_ARIAL);
					fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				
					fuenteca.setFontHeightInPoints((short) 11);
					fuenteca.setFontName(fuenteca.FONT_ARIAL);
					fuenteca.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
					
					fuenteIns.setFontHeightInPoints((short) 9);
					fuenteIns.setFontName(fuenteca.FONT_ARIAL);
					fuenteIns.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				//TITULO
					HSSFCellStyle titulo = (HSSFCellStyle) libro1.createCellStyle();
					titulo.setFont(fuenteca);
					titulo.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				//INTRUCCIONES
					HSSFCellStyle instrucciones = (HSSFCellStyle) libro1.createCellStyle();
					instrucciones.setFont(fuenteIns);
				//CABECERA
					HSSFCellStyle cabecera = (HSSFCellStyle) libro1.createCellStyle();
					cabecera.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
					cabecera.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
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
				//CELDAS
					HSSFCellStyle estiloCelda = (HSSFCellStyle) libro1.createCellStyle();
					estiloCelda.setBorderBottom(HSSFCellStyle.BORDER_THIN);
					estiloCelda.setBottomBorderColor((short) 0);
					estiloCelda.setBorderLeft(HSSFCellStyle.BORDER_THIN);
					estiloCelda.setLeftBorderColor((short) 0);
					estiloCelda.setBorderRight(HSSFCellStyle.BORDER_THIN);
					estiloCelda.setRightBorderColor((short) 0);
					estiloCelda.setBorderTop(HSSFCellStyle.BORDER_THIN);
					estiloCelda.setTopBorderColor((short) 0);
					

					HSSFCellStyle centrado = (HSSFCellStyle) libro1.createCellStyle();
					centrado.setAlignment(HSSFCellStyle.ALIGN_CENTER);
					centrado.setBorderBottom(HSSFCellStyle.BORDER_THIN);
					centrado.setBottomBorderColor((short) 0);
					centrado.setBorderLeft(HSSFCellStyle.BORDER_THIN);
					centrado.setLeftBorderColor((short) 0);
					centrado.setBorderRight(HSSFCellStyle.BORDER_THIN);
					centrado.setRightBorderColor((short) 0);
					centrado.setBorderTop(HSSFCellStyle.BORDER_THIN);
					centrado.setTopBorderColor((short) 0);
					
					
			
			/*----------------------------------------------------------------------------------------------------------------------------------------------*/
			
			//MERGE DE CELDAS
					hoja.addMergedRegion(CellRangeAddress.valueOf("G2:Q2"));
					hoja.addMergedRegion(CellRangeAddress.valueOf("G3:Q3"));
					hoja.addMergedRegion(CellRangeAddress.valueOf("G4:Q4"));
					
					hoja.setColumnWidth(6,  8500);
					hoja.setColumnWidth(7,  3050);
					hoja.setColumnWidth(8,  3500);
					hoja.setColumnWidth(9,  2000);
					hoja.setColumnWidth(10, 2300);
					hoja.setColumnWidth(11, 3000);
					hoja.setColumnWidth(12, 3700);
					hoja.setColumnWidth(13, 3000);
					hoja.setColumnWidth(14, 5500);
					hoja.setColumnWidth(15, 7000);
					hoja.setColumnWidth(16, 7000);
					
					
			//Cursor en en la fila 1
			Row fila = hoja.createRow(1);
			//TITULO
			Cell linea1 = fila.createCell(6);
			linea1.setCellStyle(titulo);
			linea1.setCellValue("ESCUELA PROFESIONAL DE " + (escuela.toUpperCase()));
			
			Cell ht = fila.createCell(1);
			ht.setCellStyle(instrucciones);
			ht.setCellValue("HT : HORAS DE TEORÍA");
			
			//Cursor en en la fila 2
			fila = hoja.createRow(2);
			Cell celda02 = fila.createCell(6);
			celda02.setCellStyle(titulo);
			celda02.setCellValue("REPORTE DE DIFERENCIAS");
			
			Cell hl = fila.createCell(1);
			hl.setCellStyle(instrucciones);
			hl.setCellValue("HL : HORAS DE LABORATORIO");
			
			//Cursor en en la fila 3
			fila = hoja.createRow(3);
			Cell celda03 = fila.createCell(6);
			celda03.setCellStyle(titulo);
			
			Cell hp = fila.createCell(1);
			hp.setCellStyle(instrucciones);
			hp.setCellValue("HP : HORAS DE PRÁCTICA");
			
			String sem = null;
			String nuevo = null;
			while(rs2.next()){
			sem=rs2.getString(3);
			nuevo=rs2.getString(2);
			System.out.println(nuevo +" &"+ sem);
			}
			celda03.setCellValue("SEMESTRE ACADÉMICO " + año + "-" + semestre+" Y "+nuevo+"-"+sem);
			
					
			//CABECERAS

			fila = hoja.createRow(5);
			Cell celda1 = fila.createCell(6);
			celda1.setCellStyle(cabecera);
			celda1.setCellValue("CURSO");

			Cell celda2 = fila.createCell(7);
			celda2.setCellStyle(cabecera);
			celda2.setCellValue("CÓDIGO SAP");

			Cell celda3 = fila.createCell(8);
			celda3.setCellStyle(cabecera);
			celda3.setCellValue("CÓDIGO SICAT");
			
			Cell celda4 = fila.createCell(9);
			celda4.setCellStyle(cabecera);
			celda4.setCellValue("CICLO");
			
			Cell celda5 = fila.createCell(10);
			celda5.setCellStyle(cabecera);
			celda5.setCellValue("CRÉDITOS");
			
			Cell celda6 = fila.createCell(11);
			celda6.setCellStyle(cabecera);
			celda6.setCellValue("H. TEORIA");
			
			Cell celda7 = fila.createCell(12);
			celda7.setCellStyle(cabecera);
			celda7.setCellValue("H. LABORATORIO");
			
			Cell celda8 = fila.createCell(13);
			celda8.setCellStyle(cabecera);
			celda8.setCellValue("H. PRÁCTICA");

			Cell celda9 = fila.createCell(14);
			celda9.setCellStyle(cabecera);
			celda9.setCellValue("ESTADO");
			
			Cell celda10 = fila.createCell(15);
			celda10.setCellStyle(cabecera);
			celda10.setCellValue("ANTES");
			
			Cell celda11 = fila.createCell(16);
			celda11.setCellStyle(cabecera);
			celda11.setCellValue("AHORA");
			
			//-----------------------------------------------------------------------------------------------------------------------------------------------
			
			int i=6;
			while(rs1.next()){
				//Cursor en en la fila 1
			 fila = hoja.createRow(i);
			 
			 	Cell celda1_1 = fila.createCell(6);
				celda1_1.setCellStyle(estiloCelda);
				celda1_1.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_1.setCellValue(rs1.getString(1));
				
				Cell celda1_2 = fila.createCell(7);
				celda1_2.setCellStyle(estiloCelda);
				celda1_2.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_2.setCellValue(rs1.getString(2));
				
				Cell celda1_3 = fila.createCell(8);
				celda1_3.setCellStyle(centrado);
				celda1_3.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				celda1_3.setCellValue(rs1.getInt(3));
				
				Cell celda1_4 = fila.createCell(9);
				celda1_4.setCellStyle(centrado);
				celda1_4.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				celda1_4.setCellValue(rs1.getInt(4));
				
				Cell celda1_5 = fila.createCell(10);
				celda1_5.setCellStyle(centrado);
				celda1_5.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				celda1_5.setCellValue(rs1.getInt(6));
				
				Cell celda1_6 = fila.createCell(11);
				celda1_6.setCellStyle(centrado);
				celda1_6.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				celda1_6.setCellValue(rs1.getInt(7));
				
				Cell celda1_7 = fila.createCell(12);
				celda1_7.setCellStyle(centrado);
				celda1_7.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				celda1_7.setCellValue(rs1.getInt(8));
				
				Cell celda1_8 = fila.createCell(13);
				celda1_8.setCellStyle(centrado);
				celda1_8.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				celda1_8.setCellValue(rs1.getInt(9));
				
				Cell celda1_9 = fila.createCell(14);
				celda1_9.setCellStyle(estiloCelda);
				celda1_9.setCellType(HSSFCell.CELL_TYPE_STRING);
				celda1_9.setCellValue(rs1.getString(11));
				
				
				if((rs1.getString(12) == "") || (rs1.getString(12) == null) || (rs1.getString(12) == "n") ){
					Cell celda1_11 = fila.createCell(15);
					celda1_11.setCellStyle(centrado);
					celda1_11.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
					celda1_11.setCellValue("-");
				}else{
					Cell celda1_10 = fila.createCell(15);
					celda1_10.setCellStyle(centrado);
					celda1_10.setCellType(HSSFCell.CELL_TYPE_STRING);
					celda1_10.setCellValue(rs1.getString(12));
				}
				
				if((rs1.getString(13) == "null") || (rs1.getString(13) == null) || (rs1.getString(13) == "n") ){
					Cell celda1_11 = fila.createCell(16);
					celda1_11.setCellStyle(centrado);
					celda1_11.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
					celda1_11.setCellValue("-");
				}else{
					Cell celda1_11 = fila.createCell(16);
					celda1_11.setCellStyle(centrado);
					celda1_11.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
					celda1_11.setCellValue(rs1.getString(13));
				}
				//CAMBIO DE FILA
				i++;				
			}
			
			libro1.write(archivo);
			archivo.close();
			Desktop.getDesktop().open(archivoXLS);
						
		}catch(Exception e){
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		};
		return archivoXLS == null ? false : true;
	}

}
