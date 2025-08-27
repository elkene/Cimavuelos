package proyecto;

import java.time.LocalDate;

public class Pago {
	// atributos
	public String titular;
	public int numTarjeta;
	public int numSeguridad;
	public LocalDate fechaVencimiento;
	public float monto;
	
	// sets
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public void setNumtarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public void setNumSeguridad(int numSeguridad) {
		this.numSeguridad = numSeguridad;
	}
	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	
	// gets
	public String getTitular() {
		return titular;
	}
	public int getNumTarjeta() {
		return numTarjeta;
	}
	public int getNumSeguridad() {
		return numSeguridad;
	}
	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}
	public float getMonto() {
		return monto;
	}

}
