package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	private static Connection con = null;
	private ResultSet rs = null;
	private Statement st = null;
	private PreparedStatement pt = null;
	private CallableStatement d = null;
	private String puerto = "3306";
	private String esquema = "bdfinal";
	private String usuario = "root";
	private String password = "Soporte1";

	public Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:" + puerto + "/" + esquema;
			con = DriverManager.getConnection(url, usuario, password);
			System.out.println("Conectado");
		} catch (Exception e) {
			System.out.print("Error en la conexi�n : "+e.getMessage());
			e.printStackTrace();
		}
	}

	public Connection devolverConexion() throws SQLException {
		return con;
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		st = con.createStatement();
		rs = st.executeQuery(sql);
		return rs;
	}

	public int executeUpdate(String sql) throws SQLException {
		st = con.createStatement();
		return st.executeUpdate(sql);
	}

	public PreparedStatement executePreparedStatement(String sql) throws SQLException {
		pt = con.prepareStatement(sql);
		return pt;
	}

	public CallableStatement ejecutarProcedure(String sql) throws SQLException {
		d = con.prepareCall("call " + sql + " ");
		System.out.println("call " + sql + " ");
		return d;
	}

	public void cerrarConexion() throws SQLException {
		if (st != null) {
			st.close();
			st = null;
		}
		if (rs != null) {
			rs.close();
			rs = null;
		}
		if (pt != null) {
			pt.close();
			pt = null;
		}
		if (d != null) {
			d.close();
			d = null;
		}
		con.close();
	}
}

