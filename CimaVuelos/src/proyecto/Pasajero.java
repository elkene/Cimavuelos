package proyecto;

import java.time.LocalDate;

public class Pasajero {
	// atributos
	public String primerNombre;
	public String segundoNombre;
	public String apellidoMaterno;
	public String apellidoPaterno;
	public String genero;
	public LocalDate fechaNacimiento;
	public String numTelefono;
	public String correo;
	public String contraseña;
	public String numAsiento;
	
	// constructor - pasajero
	public Pasajero(String primerNombre, String segundoNombre, String apellidoPaterno, String apellidoMaterno, String genero, LocalDate fechaNacimiento, String numTelefono, String correo, String numAsiento) {
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.correo = correo;
		this.numTelefono = numTelefono;
		this.numAsiento = numAsiento;
	} 
	
	// constructor (default) - usuario
	public Pasajero() {}
	
	// sets
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public void setNumAsiento(String numAsiento) {
		this.numAsiento = numAsiento;
	}
	
	// gets
	public String getPrimerNombre() {
		return primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public String getGenero() {
		return genero;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public String getNumTelefono() {
		return numTelefono;
	}
	public String getCorreo() {
		return correo;
	}
	public String getContraseña() {
		return contraseña;
	}
	public String getNumAsiento() {
		return numAsiento;
	}
}
