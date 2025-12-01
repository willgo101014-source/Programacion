package socios;

public class Bibliotecarios {
    public static final double PLUS_BIBLIOTECARIO = 30.0;

    private Socio socio;
    private String seccion;

    public Bibliotecarios(Socio socio, String seccion) {
        this.socio = socio;
        this.seccion = seccion;
    }

    public Socio getSocio() { return socio; }
    public String getSeccion() { return seccion; }

    public static double getPlusBibliotecario() {
		return PLUS_BIBLIOTECARIO;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public double calcularCuotaFinal() {
        return socio.calcularCuota() + PLUS_BIBLIOTECARIO;
    }

    public void mostrarInfo() {
        System.out.println("DNI: " + socio.getDni() + ", Nombre: " + socio.getNombreCompleto() +
                ", Alta: " + socio.getMesAlta() + "/" + socio.getAnioAlta() +
                ", Límite libros: " + socio.getLimiteLibros() +
                ", Sección: " + seccion +
                ", Cuota final: " + calcularCuotaFinal() + "€ (Bibliotecario)");
    }
}
