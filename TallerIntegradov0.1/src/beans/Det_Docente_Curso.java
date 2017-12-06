package beans;

public class Det_Docente_Curso {
	private int id;
	private long id_doc;//cambiar por int id_doc
	private String id_cur;
	private String descri;
	private String idsemestre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getId_doc() {//public int getId_doc()
		return id_doc;
	}
	public void setId_doc(long id_doc) {//public void setId_doc(int id_doc)
		this.id_doc = id_doc;
	}
	public String getId_cur() {
		return id_cur;
	}
	public void setId_cur(String id_cur) {
		this.id_cur = id_cur;
	}
	public String getDescri() {
		return descri;
	}
	public void setDescri(String descri) {
		this.descri = descri;
	}
	public String getIdsemestre() {
		return idsemestre;
	}
	public void setIdsemestre(String idsemestre) {
		this.idsemestre = idsemestre;
	}
}
