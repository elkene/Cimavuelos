package proyecto;

import java.time.LocalDate;

public class Reservacion {
	// atributos
	public int numReservacion;
	public LocalDate fechaReservacion;
	public String numVuelo;
	public Pago pago;
	
	// sets
	public void setNumReservacion(int numReservacion) {
		this.numReservacion = numReservacion;
	}
	public void setFechaReservacion(LocalDate fechaReservacion) {
		this.fechaReservacion = fechaReservacion;
	}
	public void setNumVuelo(String numVuelo) {
		this.numVuelo = numVuelo;
	}
	
	// gets
	public int getNumReservacion() {
		return numReservacion;
	}
	public LocalDate getFechaReservacion() {
		return fechaReservacion;
	}
	public String getNumVuelo() {
		return numVuelo;
	}
}
