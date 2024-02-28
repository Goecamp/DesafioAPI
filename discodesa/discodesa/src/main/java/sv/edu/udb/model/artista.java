package sv.edu.udb.model;

public class artista {
	private int artista;
	private String nombre_artista;
	private String descripcion;
	
	/**
	 * 
	 * @return artista
	 */
	
	public int getArtista() {
		return artista;
	}
	public void setArtista(int artista) {
		this.artista = artista;
	}
	/**
	 * 
	 * @return Nombre_artista
	 */
	public String getNombre_artista() {
		return nombre_artista;
	}
	public void setNombre_artista(String nombre_artista) {
		this.nombre_artista = nombre_artista;
	}
	/**
	 * 
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
