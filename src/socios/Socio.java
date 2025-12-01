package socios;

public class Socio {
    public static final String NOMBRE_BIBLIOTECA = "Lectura Viva";
    public static final double CUOTA_BASE = 12.0;

    private String dni;
    private String nombreCompleto;
    private int mesAlta;
    private int anioAlta;
    private int limiteLibros;

    public Socio(String dni, String nombreCompleto, int mesAlta, int anioAlta, int limiteLibros) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.mesAlta = mesAlta;
        this.anioAlta = anioAlta;
        this.limiteLibros = limiteLibros;
    }

    public String getDni() { return dni; }
    public String getNombreCompleto() { return nombreCompleto; }
    public int getMesAlta() { return mesAlta; }
    public int getAnioAlta() { return anioAlta; }
    public int getLimiteLibros() { return limiteLibros; }

    

	public static String getNombreBiblioteca() {
		return NOMBRE_BIBLIOTECA;
	}

	public static double getCuotaBase() {
		return CUOTA_BASE;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public void setMesAlta(int mesAlta) {
		this.mesAlta = mesAlta;
	}

	public void setAnioAlta(int anioAlta) {
		this.anioAlta = anioAlta;
	}

	public void setLimiteLibros(int limiteLibros) {
		this.limiteLibros = limiteLibros;
	}

	public int aniosEnBiblioteca() {
        return java.time.Year.now().getValue() - anioAlta;
    }

    public double calcularCuota() {
        double cuota = CUOTA_BASE;
        if (limiteLibros > 3) cuota += (limiteLibros - 3);
        if (aniosEnBiblioteca() >= 8) cuota -= 2;
        return cuota;
    }

    public void mostrarInfo() {
        System.out.println("DNI: " + dni + ", Nombre: " + nombreCompleto +
                ", Alta: " + mesAlta + "/" + anioAlta +
                ", Límite libros: " + limiteLibros +
                ", Cuota final: " + calcularCuota() + "€");
    }

@Override
public String toString() {
	return "Socio [dni=" + dni + ", nombreCompleto=" + nombreCompleto + ", mesAlta=" + mesAlta + ", anioAlta="
			+ anioAlta + ", limiteLibros=" + limiteLibros + "]";
}
}