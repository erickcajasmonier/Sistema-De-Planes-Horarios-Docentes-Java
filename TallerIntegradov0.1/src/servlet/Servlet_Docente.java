package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import beans.Det_Docente_Curso;
import beans.Docente;

import jdbc.Det_Docente_CursoJDBC;
import jdbc.DocenteJDBC;

@WebServlet({ "/BuscarDocente", "/RegistrarDocente", "/EditarDocente", "/RegistrarCursosDocente", "/VerificarDocente",
		"/ListarCursosxDocente", "/ListarDocentesC9",
		"/ListarDocentesC9DINA", "/ListarDocenteC9Completo", "/ListarDocenteC9Categoria", "/ListarDocenteC9Parcial",
		"/ListarDocenteC9Investigador", "/ListarDocentes", "/ListarDocentesRegistrados"})
public class Servlet_Docente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			switch (request.getServletPath()) {
			case "/BuscarDocente":
				buscarDocente(request, response);
				break;
			case "/RegistrarDocente":
				registrarDocente(request, response);
				break;
			case "/EditarDocente":
				editarDocente(request, response);
				break;
			case "/RegistrarCursosDocente":
				registrarCursosDocente(request, response);
				break;
			case "/VerificarDocente": 
				verificarDocente(request, response);
				break;
			case "/ListarCursosxDocente": 
				listarCursosxDocente(request, response);
				break;
			case "/ListarDocentes":
				listarDocentes(request, response);
				break;
			case "/ListarDocentesC9":
				listarDocentesC9(request, response);
				break;
			case "/ListarDocentesC9DINA":
				listarDocentesC9DINA(request, response);
				break;
			case "/ListarDocenteC9Completo":
				listarDocentesC9COMPLETO(request, response);
				break;
			case "/ListarDocenteC9Categoria":
				listarDocentesC9Categoria(request, response);
				break;
			case "/ListarDocenteC9Parcial":
				listarDocentesC9Parcial(request, response);
				break;
			case "/ListarDocenteC9Investigador":
				listarDocentesC9Investigador(request, response);
				break;
			case "/ListarDocentesRegistrados":
				listarDocentesRegistrados(request, response);
				break;
			}
			
		} catch (Exception e) {
			System.out.println("error :" + e.getMessage());
			e.printStackTrace();
		}
	}

	private void buscarDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		if (nombre.length() <= 0) {
			nombre = "empty";
		} else {
			nombre = request.getParameter("nombre");
		}
		String apepat = request.getParameter("apepat");
		if (apepat.length() <= 0) {
			apepat = "empty";
		} else {
			apepat = request.getParameter("apepat");
		}
		String apemat = request.getParameter("apemat");
		if (apemat.length() <= 0) {
			apemat = "empty";
		} else {
			apemat = request.getParameter("apemat");
		}
		String numdoc = request.getParameter("dni");
		if (numdoc.length() <= 0) {
			numdoc = "0";
		} else {
			numdoc = request.getParameter("dni");
		}
		String respuesta = "";
		try {
			DocenteJDBC dao = new DocenteJDBC();
			Docente bean = dao.buscarDocente(nombre, apepat, apemat, Long.parseLong(numdoc));
			if (bean.getNombre() == null) {
				respuesta = "vacio";
			} else {
				respuesta = bean.getNombre() + " -|" + bean.getApepat() + " -|" + bean.getApemat() + " -|"
						+ bean.getPais() + " -|" + bean.getNumdoc() + "-|" + bean.getFecini() + "-|"
						+ bean.getLey30220() + "-|" + bean.getMayorgrado() + "-|" + bean.getMenciongrado() + "-|"
						+ bean.getUniv() + "-|" + bean.getPasiuniv() + "-|" + bean.getPregrado() + "-|"
						+ bean.getMaestria() + "-|" + bean.getDoctorado() + "-|" + bean.getCategoria() + "-|"
						+ bean.getRegimen() + "-|" + bean.getHoraclase() + "-|" + bean.getHoraactiv() + "-|"
						+ bean.getTotalhoras() + "-|" + bean.getInvestigador() + "-|" + bean.getDina() + "-|"
						+ bean.getCodD_sem() + "-|" + bean.getObservaciones() + "-|" + bean.getLicen() + "-|"
						+ bean.getSl01() + "-|" + bean.getSl02() + "-|" +bean.getSl03()+ "-|"
						+ bean.getTelefono() + "-|" + bean.getEmail() + "-|" + bean.getEscuela()+ "-|" + bean.getId();
						
						//+ bean.getTelefono() + "-|"
						//+ bean.getTelefono() + "-|" + bean.getId();
			}
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.getMessage();
		}
		System.out.println("respuesta: " + respuesta);
		response.setContentType("text/plain");
		response.getWriter().write(respuesta);
	}

	private void registrarDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, JSONException {

		boolean flag = false;
		String respuesta = "";

		String jsonData = request.getParameter("objetojson");
		JSONObject obj = new JSONObject(jsonData);
		JSONArray arr = obj.getJSONArray("linea");

		String nombre = "", apepat = "", apemat = "", pais = "", fecini = "", mayorgrado = "", menciongrado = "",
				uni = "", paiuni = "", categoria = "", regimen = "", codsem = "", escuela = "", email = "",
				observaciones = "";
		int horacla = 0, horaacti = 0, tothora = 0, ley = 0, pregrado = 0, maestria = 0, doctorado = 0,
				investigador = 0, dina = 0, telefono = 0, licen = 0, sl01=0, sl02=0, sl03=0;
		String numdoc = "";
		Docente bean = new Docente();

		try {
			DocenteJDBC dao = new DocenteJDBC();
			for (int i = 0; i < arr.length(); i++) {
				nombre = arr.getJSONObject(i).getString("txtnom");
				apepat = arr.getJSONObject(i).getString("txtapepat");
				apemat = arr.getJSONObject(i).getString("txtapemat");
				pais = arr.getJSONObject(i).getString("txtnac");
				numdoc = arr.getJSONObject(i).getString("txtnumdoc");
				fecini = arr.getJSONObject(i).getString("txtfecini");
				ley = arr.getJSONObject(i).getString("txtley").equals("SI") ? 1 : 0;
				mayorgrado = arr.getJSONObject(i).getString("maygra");
				menciongrado = arr.getJSONObject(i).getString("menmay");
				uni = arr.getJSONObject(i).getString("uni");
				paiuni = arr.getJSONObject(i).getString("paiuni");
				pregrado = arr.getJSONObject(i).getString("preg").equals("SI") ? 1 : 0;
				maestria = arr.getJSONObject(i).getString("maes").equals("SI") ? 1 : 0;
				doctorado = arr.getJSONObject(i).getString("doct").equals("SI") ? 1 : 0;
				categoria = arr.getJSONObject(i).getString("cat");
				regimen = arr.getJSONObject(i).getString("regded");
				horacla = Integer.parseInt(arr.getJSONObject(i).getString("horcla"));
				horaacti = Integer.parseInt(arr.getJSONObject(i).getString("horact"));
				tothora = Integer.parseInt(arr.getJSONObject(i).getString("tothor"));
				investigador = arr.getJSONObject(i).getString("docinv").equals("SI") ? 1 : 0;
				dina = arr.getJSONObject(i).getString("dina").equals("SI") ? 1 : 0;
				codsem = arr.getJSONObject(i).getString("peraca");
				observaciones = arr.getJSONObject(i).getString("obs");
//				licen = arr.getJSONObject(i).getString("licen").equals("SI") ? 1 : 0;
//				sl01 = arr.getJSONObject(i).getString("sl01").equals("SI") ? 1 : 0;
//				sl02 = arr.getJSONObject(i).getString("sl02").equals("SI") ? 1 : 0;
//				sl03 = arr.getJSONObject(i).getString("sl03").equals("SI") ? 1 : 0;
				escuela = arr.getJSONObject(i).getString("escuela");
				email = arr.getJSONObject(i).getString("email");
				telefono = arr.getJSONObject(i).getInt("telefono");

				bean.setNumdoc(numdoc);
				bean.setApepat(apepat);
				bean.setApemat(apemat);
				bean.setNombre(nombre);
				bean.setPais(pais);
				bean.setFecini(fecini);
				bean.setLey30220(ley);
				bean.setMayorgrado(mayorgrado);
				bean.setMenciongrado(menciongrado);
				bean.setUniv(uni);
				bean.setPasiuniv(paiuni);
				bean.setPregrado(pregrado);
				bean.setMaestria(maestria);
				bean.setDoctorado(doctorado);
				bean.setCategoria(categoria);
				bean.setRegimen(regimen);
				bean.setHoraclase(horacla);
				bean.setHoraactiv(horaacti);
				bean.setTotalhoras(tothora);
				bean.setInvestigador(investigador);
				bean.setDina(dina);
				bean.setCodD_sem(codsem);
				bean.setEscuela(escuela);
				bean.setEmail(email);
				bean.setTelefono(telefono);
				bean.setObservaciones(observaciones);
				bean.setLicen(licen);
				bean.setSl01(sl01);
				bean.setSl02(sl02);
				bean.setSl03(sl03);

				flag = dao.crearDocente(bean);
			}

			respuesta = flag == true ? "1" : "0";

			System.out.println("respuesta: " + respuesta);
			response.setContentType("text/plain");
			response.getWriter().write(respuesta);

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void editarDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id: " + id);
		String nombre = request.getParameter("nombre");
		System.out.println("nombre: " + nombre);
		String apepat = request.getParameter("apepat");
		System.out.println("apepat: " + apepat);
		String apemat = request.getParameter("apemat");
		System.out.println("apemat: " + apemat);
		String nac = request.getParameter("nac");
		String numdoc = request.getParameter("numdoc");
		String fecini = request.getParameter("fecini");
		int ley = request.getParameter("ley").equals("SI") ? 1 : 0;
		System.out.println("ley: " + ley);
		String mayorgrado = request.getParameter("maygra");
		String menciongrado = request.getParameter("menmay");
		String uni = request.getParameter("uni");
		String paiuni = request.getParameter("paiuni");
		int pregrado = request.getParameter("preg").equals("SI") ? 1 : 0;
		int maestria = request.getParameter("maes").equals("SI") ? 1 : 0;
		int doctorado = request.getParameter("doct").equals("SI") ? 1 : 0;
		String categoria = request.getParameter("cat");
		String regimen = request.getParameter("regded");
		int horacla = Integer.parseInt(request.getParameter("horcla"));
		int horaacti = Integer.parseInt(request.getParameter("horact"));
		int tothora = Integer.parseInt(request.getParameter("tothor"));
		int investigador = request.getParameter("docinv").equals("SI") ? 1 : 0;
		System.out.println("investigador: " + investigador);
		int dina = request.getParameter("dina").equals("SI") ? 1 : 0;
		String codsem = request.getParameter("peraca");
		String observaciones = request.getParameter("obs");
//		int licen = request.getParameter("licen").equals("SI") ? 1 : 0;
//		int sl01 = request.getParameter("dina").equals("SI") ? 1 : 0;
//		int sl02 = request.getParameter("dina").equals("SI") ? 1 : 0;
//		int sl03 = request.getParameter("dina").equals("SI") ? 1 : 0;
		
		String telef  = request.getParameter("telef");
		String email  = request.getParameter("email");
		String escuela  = request.getParameter("escuela");

		Docente bean = new Docente();

		bean.setId(id);
		bean.setNumdoc(numdoc);
		bean.setApepat(apepat);
		bean.setApemat(apemat);
		bean.setNombre(nombre);
		bean.setPais(nac);
		bean.setFecini(fecini);
		bean.setLey30220(ley);
		bean.setMayorgrado(mayorgrado);
		bean.setMenciongrado(menciongrado);
		bean.setUniv(uni);
		bean.setPasiuniv(paiuni);
		bean.setPregrado(pregrado);
		bean.setMaestria(maestria);
		bean.setDoctorado(doctorado);
		bean.setCategoria(categoria);
		bean.setRegimen(regimen);
		bean.setHoraclase(horacla);
		bean.setHoraactiv(horaacti);
		bean.setTotalhoras(tothora);
		bean.setInvestigador(investigador);
		bean.setDina(dina);
		bean.setCodD_sem(codsem);
		bean.setEscuela(escuela);// bean.setEscuela(escuela);
		bean.setEmail(email);// bean.setEmail(email);
		bean.setTelefono(Integer.parseInt(telef));// bean.setTelefono(telefono);
		bean.setObservaciones(observaciones);

		int respuesta = 0;

		try {
			DocenteJDBC dao = new DocenteJDBC();

			respuesta = dao.modificarDocente(bean) == true ? 1 : 0;

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(respuesta);
	}

	private void registrarCursosDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, JSONException {
		String jsonData = request.getParameter("objetojson");
		JSONObject obj = new JSONObject(jsonData);
		JSONArray arr = obj.getJSONArray("linea");

		Det_Docente_CursoJDBC dao = new Det_Docente_CursoJDBC();

		boolean flag = false;
		String idcurso = "";
		String descrip = "";
		long dnidoc = 0;
		String semes = "";
		int valor = -1;

		try {
			for (int i = 0; i < arr.length(); i++) {
				idcurso = arr.getJSONObject(i).getString("idcursog");// System.out.println("idcurso_
																		// "+idcurso);
				descrip = arr.getJSONObject(i).getString("nomcurg");// System.out.println("idcurso_
																	// "+descrip);
				dnidoc = Long.parseLong(arr.getJSONObject(i).getString("txtdnig"));// System.out.println("idcurso_
																					// "+dnidoc);
				semes = arr.getJSONObject(i).getString("semesg");

				Det_Docente_Curso bean = new Det_Docente_Curso();
				bean.setId_cur(idcurso);
				bean.setId_doc(dnidoc);
				bean.setDescri(descrip);
				bean.setIdsemestre(semes);

				flag = dao.registrarCursosxDocente(bean);

				if (!flag) {
					valor = 0;
					break;
				} else {
					valor = 1;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("resultado: " + valor);
		response.setContentType("text/plain");
		response.getWriter().write("" + valor);
	}

	private void listarCursosxDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcurso = request.getParameter("idc_ajax");
		String desCurso = request.getParameter("des_ajax");
		long dni = Long.parseLong(request.getParameter("dni_ajax"));
		String semestrecurso = request.getParameter("sem_ajax");

		StringBuilder sb = new StringBuilder("");
		int contador = 0;

		try {
			Det_Docente_CursoJDBC dao = new Det_Docente_CursoJDBC();

			List<Det_Docente_Curso> lista = dao.listarCursosxDocente(semestrecurso, dni);

			for (Det_Docente_Curso bean : lista) {
				if (idcurso.equalsIgnoreCase(bean.getId_cur().trim())) {
					contador++;
				}
			}

			if (contador <= 0) {
				sb.append(idcurso + "-|" + desCurso + ":");
			} else {
				sb.append(":");
			}

		} catch (Exception e) {
			System.out.println("Error :" + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("contador:" + contador);
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());

	}

	private void verificarDocente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String numdoc = request.getParameter("numerodoc");
		long dni = 0;
		if (numdoc.length() <= 0) {
			numdoc = "0";
		} else {
			dni = Long.parseLong(numdoc);
		}

		String valor = "";

		try {
			DocenteJDBC dao = new DocenteJDBC();
			Docente bean = dao.buscarDocente("", "", "", dni);

			if (bean.getNombre() == null) {
				valor = ":";
			} else {
				valor = bean.getNombre() + " -|" + bean.getApepat() + " -|" + bean.getApemat() + " -|"
						+ bean.getNumdoc() + ":";
			}
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}

		response.setContentType("text/plain");
		response.getWriter().write(valor);
	}
	
	private void listarDocentesRegistrados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = new StringBuilder("");
		try {
			DocenteJDBC dao = new DocenteJDBC();
			List<Docente> lista = dao.listarDocentesRegistrados();
			if (lista != null) {
				for (Docente bean : lista) {
					sb.append(bean.getNumdoc() + "=" + bean.getApepat() + "=" + bean.getApemat() + "=" + bean.getNombre() + "=" + 
				bean.getTelefono()+"="+bean.getEmail()+"$");
				}
			} else {
				sb.append("_");
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}

	private void listarDocentes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = new StringBuilder("");
		String var = request.getParameter("fecha");
		try {
			DocenteJDBC dao = new DocenteJDBC();
			List<Docente> lista = dao.listarDocentesC9(var);
			if (lista != null) {
				for (Docente bean : lista) {
					sb.append(bean.getNumdoc() + "=" + bean.getApepat() + "=" + bean.getApemat() + "=" + bean.getNombre() + "=" + bean.getPais()
							+ "="  + bean.getFecini() + "=" + bean.getLey30220() + "=" + "???"
							+ "=" + bean.getMayorgrado() + "=" + bean.getMenciongrado() + "=" + bean.getUniv() + "="
							+ bean.getPasiuniv() + "=" + bean.getPregrado() + "=" + bean.getMaestria() + "="
							+ bean.getDoctorado() + "=" + "???" + "=" + bean.getCategoria() + "=" + bean.getRegimen()
							+ "=" + bean.getHoraclase() + "=" + "???" + "=" + bean.getTotalhoras() + "="
							+ bean.getInvestigador() + "=" + bean.getDina() + "=" + bean.getCodD_sem() + "="
							+ bean.getObservaciones() + "=" + bean.getEscuela() + "$");
					// System.out.println(bean.getNumdoc());
				}
			} else {
				sb.append("_");
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}
	
	private void listarDocentesC9(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = new StringBuilder("");
		String var = request.getParameter("fecha");
		//String var = "2017-11-02";
		try {
			DocenteJDBC dao = new DocenteJDBC();
			System.out.println("listarDocentesC9");
			List<Docente> lista = dao.listarDocentesC9(var);
			if (lista != null) {
				for (Docente bean : lista) {
					sb.append(bean.getApepat() + "=" + bean.getApemat() + "=" + bean.getNombre() + "=" + bean.getPais()
							+ "=" + bean.getNumdoc() + "=" + bean.getFecini() + "=" + bean.getLey30220() + "=" + bean.getLicen() 
							+  "=" + bean.getMayorgrado() + "=" + bean.getMenciongrado() + "=" + bean.getUniv() + "="
							+ bean.getPasiuniv() + "=" + bean.getPregrado() + "=" + bean.getMaestria() + "="
							+ bean.getDoctorado() + "=" + bean.getSl01() + "=" + bean.getSl02() + "=" + bean.getSl03() + "=" + bean.getCategoria() + "=" + bean.getRegimen()
							+ "=" + bean.getHoraclase() + "=" + bean.getHoraactiv() + "=" + bean.getTotalhoras() + "="
							+ bean.getInvestigador() + "=" + bean.getDina() + "=" + bean.getCodD_sem() + "="
							+ bean.getObservaciones() + "=" + bean.getEscuela() +  "=" + bean.getEmail() + "=" + bean.getTelefono() + "$");
				}
			} else {
				sb.append("_");
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}
	
	
	
	private void listarDocentesC9DINA(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = new StringBuilder("");
		String var = request.getParameter("fecha");
		//String var = "2017-11-02";
		try {
			DocenteJDBC dao = new DocenteJDBC();
			System.out.println("listarDocentesC9DINA");
			List<Docente> lista = dao.listarDocentesC9DINA(var);
			if (lista != null) {
				for (Docente bean : lista) {
					sb.append(bean.getApepat() + "=" + bean.getApemat() + "=" + bean.getNombre() + "=" + bean.getPais()
					+ "=" + bean.getNumdoc() + "=" + bean.getFecini() + "=" + bean.getLey30220() + "=" + bean.getLicen() 
					+  "=" + bean.getMayorgrado() + "=" + bean.getMenciongrado() + "=" + bean.getUniv() + "="
					+ bean.getPasiuniv() + "=" + bean.getPregrado() + "=" + bean.getMaestria() + "="
					+ bean.getDoctorado() + "=" + bean.getSl01() + "=" + bean.getSl02() + "=" + bean.getSl03() + "=" + bean.getCategoria() + "=" + bean.getRegimen()
					+ "=" + bean.getHoraclase() + "=" + bean.getHoraactiv() + "=" + bean.getTotalhoras() + "="
					+ bean.getInvestigador() + "=" + bean.getDina() + "=" + bean.getCodD_sem() + "="
					+ bean.getObservaciones() + "=" + bean.getEscuela() +  "=" + bean.getEmail() + "=" + bean.getTelefono() + "$");
					// System.out.println(bean.getNumdoc());
				}
			} else {
				sb.append("_");
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}
	
	private void listarDocentesC9COMPLETO(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = new StringBuilder("");
		String var = request.getParameter("fecha");
		//String var = "2017-11-02";
		try {
			DocenteJDBC dao = new DocenteJDBC();
			System.out.println("listarDocentesC9COMPLETO");
			List<Docente> lista = dao.listarDocentesC9TIEMPO(var);
			if (lista != null) {
				for (Docente bean : lista) {
					sb.append(bean.getApepat() + "=" + bean.getApemat() + "=" + bean.getNombre() + "=" + bean.getPais()
					+ "=" + bean.getNumdoc() + "=" + bean.getFecini() + "=" + bean.getLey30220() + "=" + bean.getLicen() 
					+  "=" + bean.getMayorgrado() + "=" + bean.getMenciongrado() + "=" + bean.getUniv() + "="
					+ bean.getPasiuniv() + "=" + bean.getPregrado() + "=" + bean.getMaestria() + "="
					+ bean.getDoctorado() + "=" + bean.getSl01() + "=" + bean.getSl02() + "=" + bean.getSl03() + "=" + bean.getCategoria() + "=" + bean.getRegimen()
					+ "=" + bean.getHoraclase() + "=" + bean.getHoraactiv() + "=" + bean.getTotalhoras() + "="
					+ bean.getInvestigador() + "=" + bean.getDina() + "=" + bean.getCodD_sem() + "="
					+ bean.getObservaciones() + "=" + bean.getEscuela() +  "=" + bean.getEmail() + "=" + bean.getTelefono() + "$");
					// System.out.println(bean.getNumdoc());
				}
			} else {
				sb.append("_");
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}
	
	private void listarDocentesC9Categoria(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = new StringBuilder("");
		String var = request.getParameter("fecha");
		//String var = "2017-11-02";
		try {
			DocenteJDBC dao = new DocenteJDBC();
			System.out.println("listarDocentesC9CATEGORIA");
			List<Docente> lista = dao.listarDocentesC9CATEGORIA(var);
			if (lista != null) {
				for (Docente bean : lista) {
					sb.append(bean.getApepat() + "=" + bean.getApemat() + "=" + bean.getNombre() + "=" + bean.getPais()
					+ "=" + bean.getNumdoc() + "=" + bean.getFecini() + "=" + bean.getLey30220() + "=" + bean.getLicen() 
					+  "=" + bean.getMayorgrado() + "=" + bean.getMenciongrado() + "=" + bean.getUniv() + "="
					+ bean.getPasiuniv() + "=" + bean.getPregrado() + "=" + bean.getMaestria() + "="
					+ bean.getDoctorado() + "=" + bean.getSl01() + "=" + bean.getSl02() + "=" + bean.getSl03() + "=" + bean.getCategoria() + "=" + bean.getRegimen()
					+ "=" + bean.getHoraclase() + "=" + bean.getHoraactiv() + "=" + bean.getTotalhoras() + "="
					+ bean.getInvestigador() + "=" + bean.getDina() + "=" + bean.getCodD_sem() + "="
					+ bean.getObservaciones() + "=" + bean.getEscuela() +  "=" + bean.getEmail() + "=" + bean.getTelefono() + "$");
					// System.out.println(bean.getNumdoc());
				}
			} else {
				sb.append("_");
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}
	
	private void listarDocentesC9Parcial(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = new StringBuilder("");
		String var = request.getParameter("fecha");
		//String var = "2017-11-02";
		try {
			DocenteJDBC dao = new DocenteJDBC();
			System.out.println("listarDocentesC9Parcial");
			List<Docente> lista = dao.listarDocentesC9PARCIAL(var);
			if (lista != null) {
				for (Docente bean : lista) {
					sb.append(bean.getApepat() + "=" + bean.getApemat() + "=" + bean.getNombre() + "=" + bean.getPais()
					+ "=" + bean.getNumdoc() + "=" + bean.getFecini() + "=" + bean.getLey30220() + "=" + bean.getLicen() 
					+  "=" + bean.getMayorgrado() + "=" + bean.getMenciongrado() + "=" + bean.getUniv() + "="
					+ bean.getPasiuniv() + "=" + bean.getPregrado() + "=" + bean.getMaestria() + "="
					+ bean.getDoctorado() + "=" + bean.getSl01() + "=" + bean.getSl02() + "=" + bean.getSl03() + "=" + bean.getCategoria() + "=" + bean.getRegimen()
					+ "=" + bean.getHoraclase() + "=" + bean.getHoraactiv() + "=" + bean.getTotalhoras() + "="
					+ bean.getInvestigador() + "=" + bean.getDina() + "=" + bean.getCodD_sem() + "="
					+ bean.getObservaciones() + "=" + bean.getEscuela() +  "=" + bean.getEmail() + "=" + bean.getTelefono() + "$");
					// System.out.println(bean.getNumdoc());
				}
			} else {
				sb.append("_");
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}
	
	
	private void listarDocentesC9Investigador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = new StringBuilder("");
		String var = request.getParameter("fecha");
		//String var = "2017-11-02";
		try {
			DocenteJDBC dao = new DocenteJDBC();
			System.out.println("listarDocentesC9Parcial");
			List<Docente> lista = dao.listarDocentesC9INVESTIGADOR(var);
			if (lista != null) {
				for (Docente bean : lista) {
					sb.append(bean.getApepat() + "=" + bean.getApemat() + "=" + bean.getNombre() + "=" + bean.getPais()
					+ "=" + bean.getNumdoc() + "=" + bean.getFecini() + "=" + bean.getLey30220() + "=" + bean.getLicen() 
					+  "=" + bean.getMayorgrado() + "=" + bean.getMenciongrado() + "=" + bean.getUniv() + "="
					+ bean.getPasiuniv() + "=" + bean.getPregrado() + "=" + bean.getMaestria() + "="
					+ bean.getDoctorado() + "=" + bean.getSl01() + "=" + bean.getSl02() + "=" + bean.getSl03() + "=" + bean.getCategoria() + "=" + bean.getRegimen()
					+ "=" + bean.getHoraclase() + "=" + bean.getHoraactiv() + "=" + bean.getTotalhoras() + "="
					+ bean.getInvestigador() + "=" + bean.getDina() + "=" + bean.getCodD_sem() + "="
					+ bean.getObservaciones() + "=" + bean.getEscuela() +  "=" + bean.getEmail() + "=" + bean.getTelefono() + "$");
					// System.out.println(bean.getNumdoc());
				}
			} else {
				sb.append("_");
			}
		}catch(Exception e){
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}
	
}
