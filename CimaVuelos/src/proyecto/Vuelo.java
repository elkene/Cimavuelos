package proyecto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Vuelo {
	// atributos
	public int numVuelo;
	public String origen;
	public String destino;
	public LocalDate fechaVuelo;
	public LocalTime horaSalida;
	public LocalTime horaLlegada;
	public int capacidad;
	public String puerta;
	public float costo;
	
	public HashMap <String, ArrayList<Pasajero>> mapReservaciones;
	public ArrayList<String> asientosOcupados;
	
	// constructor
	public Vuelo(int numVuelo, String origen, String destino, LocalDate fechaVuelo, LocalTime horaSalida, LocalTime horaLlegada, int capacidad, String puerta, float costo){
		this.numVuelo = numVuelo;
		this.origen = origen;
		this.destino = destino;
		this.fechaVuelo = fechaVuelo;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.capacidad = capacidad;
		this.puerta = puerta;
		this.costo = costo;
		
		this.asientosOcupados = new ArrayList<>(); // se crea un arrayList para guardar los asientos ocupados del vuelo
		
		// cargar reservaciones de pasajeros
		HashMap<String, ArrayList<Pasajero>> todasReservaciones = Control.leerArchivosPasajeros(); // cargo las reservaciones
		this.mapReservaciones = new HashMap<>(); // se crea en HashMap para llevar un registro de sus pasajeros
		if (todasReservaciones.containsKey(String.valueOf(numVuelo))) { // si hay reservaciones con su numero de vuelo
			this.mapReservaciones.put(String.valueOf(numVuelo), todasReservaciones.get(String.valueOf(numVuelo))); // las obtiene
		}
		// cargar los asientos ocupados
		HashMap<String, ArrayList<String>> todosAsientosOcupados = Control.leerAsientosOcupados();
		if (todosAsientosOcupados.containsKey(String.valueOf(numVuelo))) {
		    this.asientosOcupados = todosAsientosOcupados.get(String.valueOf(numVuelo));
		}
	}
	
	// metodos para gestionar los asientos
	public void actualizarAsientosOcupados(ArrayList<String> nuevosAsientos) {
		asientosOcupados.addAll(nuevosAsientos);
	}
	
	public boolean estadoOcupado(String numAsiento) {
		return asientosOcupados.contains(numAsiento); 
	}
	
	public ArrayList<String> getAsientosOcupados(){
		return asientosOcupados;
	}
	
	// sets
	public void setNumVuelo(int numVuelo) {
		this.numVuelo = numVuelo;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public void setFecha(LocalDate fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}
	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}
	public void setHoraLlegada(LocalTime horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	// gets
	public int getNumVuelo() {
		return numVuelo;
	}
	public String getOrigen() {
		return origen;
	}
	public String getDestino() {
		return destino;
	}
	public LocalDate getFecha() {
		return fechaVuelo;
	}
	public LocalTime getHoraSalida() {
		return horaSalida;
	}
	public LocalTime getHoraLlegada() {
		return horaLlegada;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public String getPuerta() {
		return puerta;
	}
	public float getCosto() {
		return costo;
	}
}
