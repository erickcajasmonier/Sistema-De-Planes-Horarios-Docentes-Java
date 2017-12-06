package jdbc;

import java.sql.ResultSet;

import beans.Usuario;
import util.Conexion;

public class LoginJDBC {
	
	public Usuario validarUsuario(String usuario, String contraseña){
	
		Usuario bean=new Usuario();
		
		try{
			Conexion con = new Conexion();
			String sql = "Select a.idusuario,a.nombreUsu,a.Password,a.nombre,a.ape_Pat,a.ape_Mat,d.idPerfil,b.idEscuela from usuario a  "
					+ "inner join det_usu_esc b ON a.idusuario=b.idUsuario "
					+ "inner join perfil d ON d.idperfil=b.idPerfl "
					+ "where a.nombreUsu='"+usuario+"' and a.Password='"+contraseña+"' ";
			ResultSet rs = con.executeQuery(sql);
			System.out.print("query : " + sql);
			
			while(rs.next()){
				bean.setIdUsuario(rs.getString(1));
				bean.setNombreUsu(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setNombre(rs.getString(4));
				bean.setApe_Pat(rs.getString(5));
				bean.setApe_Mat(rs.getString(6));
				bean.setPerfil(rs.getInt(7));
				bean.setEscuela(rs.getInt(8));
			}		
		}catch(Exception e){
			e.getStackTrace();
		}		
		return bean;
	}
}
