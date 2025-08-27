package proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Control {
	// atributos
	public static ArrayList<Pasajero> pasajeros = new ArrayList<>(); // ArrayList para guardar los pasajeros existentes
	public static Pasajero pasajeroActual; // variable para trabajar con el pasajero actual
	public static ArrayList<Vuelo> vuelos; // ArrayList para guardar los vuelos existentes
	public static ArrayList<String> asientosSeleccionados = new ArrayList<>(); // ArrayList para guardar los asientos seleccionados
	
	// metodo para crear y agregar los vuelos disponibles
	public static void inicializarVuelos() {
		// crear vuelos
		Vuelo vuelo127 = new Vuelo(127, "Tijuana", "Guadalajara", LocalDate.of(2024, 11, 25), LocalTime.of(14, 30, 0), LocalTime.of(14, 30, 0).plusHours(2).plusMinutes(40), 60, "A14", 900);
		Vuelo vuelo128 = new Vuelo(128, "CDMX", "Oaxaca", LocalDate.of(2024, 11, 26), LocalTime.of(3, 50, 0), LocalTime.of(3, 50, 0).plusHours(1).plusMinutes(15), 60, "A8", 1000);
		Vuelo vuelo129 = new Vuelo(129, "Monterrey", "Chiapas", LocalDate.of(2024, 11, 27), LocalTime.of(18, 0, 0), LocalTime.of(18, 0, 0).plusHours(2).plusMinutes(15), 60, "B16", 860);
		Vuelo vuelo130 = new Vuelo(130, "Tijuana", "Chiapas", LocalDate.of(2024, 11, 27), LocalTime.of(8, 50, 0), LocalTime.of(8, 50, 0).plusHours(2).plusMinutes(55), 60, "A12", 1870);
		Vuelo vuelo131 = new Vuelo(131, "Monterrey", "Yucatan", LocalDate.of(2024, 11, 26), LocalTime.of(20, 30, 0), LocalTime.of(20, 30, 0).plusHours(2).plusMinutes(10), 60, "C12", 1200);
		Vuelo vuelo132 = new Vuelo(132, "Monterrey", "Guadalajara", LocalDate.of(2024, 11, 27), LocalTime.of(18, 50, 0), LocalTime.of(18, 50, 0).plusHours(1).plusMinutes(20), 60, "C13", 1150);
		Vuelo vuelo133 = new Vuelo(133, "Tijuana", "Oaxaca", LocalDate.of(2024, 11, 26), LocalTime.of(2, 0, 0), LocalTime.of(2, 0, 0).plusHours(3).plusMinutes(0), 60, "A12", 1340);
		Vuelo vuelo134 = new Vuelo(134, "Tijuana", "Yucatan", LocalDate.of(2024, 11, 25), LocalTime.of(7, 45, 0), LocalTime.of(7, 45, 0).plusHours(3).plusMinutes(20), 60, "A11", 1250);
		Vuelo vuelo135 = new Vuelo(135, "Tijuana", "CDMX", LocalDate.of(2024, 11, 25), LocalTime.of(19, 30, 0), LocalTime.of(19, 30, 0).plusHours(2).plusMinutes(45), 60, "A10", 2050);
		Vuelo vuelo136 = new Vuelo(136, "CDMX", "Guadalajara", LocalDate.of(2024, 11, 27), LocalTime.of(8, 10, 0), LocalTime.of(8, 10, 0).plusHours(1).plusMinutes(25), 60, "A9", 1700);
		Vuelo vuelo137 = new Vuelo(137, "CDMX", "Chiapas", LocalDate.of(2024, 11, 27), LocalTime.of(1, 50, 0), LocalTime.of(1, 50, 0).plusHours(1).plusMinutes(20), 60, "A13", 790);
		Vuelo vuelo138 = new Vuelo(138, "Monterrey", "CDMX", LocalDate.of(2024, 11, 26), LocalTime.of(13, 50, 0), LocalTime.of(13, 50, 0).plusHours(1).plusMinutes(30), 60, "C14", 1230);
		Vuelo vuelo139 = new Vuelo(139, "CDMX", "Yucatan", LocalDate.of(2024, 11, 25), LocalTime.of(8, 10, 0), LocalTime.of(8, 10, 0).plusHours(1).plusMinutes(25), 60, "A4", 1900);
		Vuelo vuelo140 = new Vuelo(140, "Monterrey", "Oaxaca", LocalDate.of(2024, 11, 25), LocalTime.of(12, 15, 0), LocalTime.of(12, 15, 0).plusHours(2).plusMinutes(45), 60, "C12", 2435);
		
		
		// agregar al ArrayList
		vuelos = new ArrayList<>(); // crear el ArrayList
		vuelos.add(vuelo127);
		vuelos.add(vuelo128);
		vuelos.add(vuelo129);
		vuelos.add(vuelo130);
		vuelos.add(vuelo131);
		vuelos.add(vuelo132);
		vuelos.add(vuelo133);
		vuelos.add(vuelo134);
		vuelos.add(vuelo135);
		vuelos.add(vuelo136);
		vuelos.add(vuelo137);
		vuelos.add(vuelo138);
		vuelos.add(vuelo139);
		vuelos.add(vuelo140);
	}
	
	// metodo para escribir en el Archivo de Asientos Ocupados
	public static void escribirAsientosOcupados(String numVuelo, ArrayList<String> asientosOcupados) {
		try {
	        File archivo = new File("asientosOcupados.txt");
	        FileWriter escritor = new FileWriter(archivo, true); // true para añadir en vez de sobrescribir
	        StringBuilder informacion = new StringBuilder();
	        
	        informacion.append("Vuelo: ").append(numVuelo).append("\n");
	        informacion.append("Asientos: ").append(String.join(",", asientosOcupados)).append("\n");
	        informacion.append("-\n");
	        
	        escritor.write(informacion.toString());
	        escritor.close();
	        System.out.println("Información guardada en asientosOcupados.txt");
		} catch (IOException ex) {
            System.out.println("Ocurrió un error al escribir en el archivo.");
            ex.printStackTrace();
        }
	}
	
	// metodo para leer el Archivo de Asientos Ocupados
	public static HashMap<String, ArrayList<String>> leerAsientosOcupados(){
		HashMap<String, ArrayList<String>> asientosOcupadosMap = new HashMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader("asientosOcupados.txt"))) {
			String linea;
			String numVuelo = null;
			
			while( (linea = br.readLine()) != null) {
				if (linea.startsWith("Vuelo:")) {
					numVuelo = linea.split(": ")[1].trim();
				} else if (linea.startsWith("Asientos:")) {
	                ArrayList<String> nuevosAsientos = new ArrayList<>(Arrays.asList(linea.split(": ")[1].split(",")));
	                // si ya existe, se agrega
	                if (asientosOcupadosMap.containsKey(numVuelo)) {
	                	ArrayList<String> asientosExistentes = asientosOcupadosMap.get(numVuelo);
	                	asientosExistentes.addAll(nuevosAsientos);
	                } else {
	                	// si no existe, se crea
	                	asientosOcupadosMap.put(numVuelo, nuevosAsientos);
	                }
	          
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return asientosOcupadosMap;
	}
	
	// metodo para escribir en el Archivo de Pasajeros (vuelos y sus pasajeros)
	public static void escribirArchivosPasajeros(String numVuelo, Pasajero pasajero) {
        // Crear o escribir en el archivo
        try {
            File archivo = new File("pasajeros.txt");
            FileWriter escritor = new FileWriter(archivo, true); // true para añadir en vez de sobrescribir
            StringBuilder informacion = new StringBuilder(); // StringBuilder para añadir la informacion a guardar
            
            informacion.append("Vuelo: ").append(numVuelo).append("\n");
            informacion.append("Nombre(s): ").append(pasajero.getPrimerNombre()).append(pasajero.getSegundoNombre()).append("\n");
            informacion.append("Apellidos: ").append(pasajero.getApellidoPaterno()).append(pasajero.getApellidoMaterno()).append("\n");
            informacion.append("Género: ").append(pasajero.getGenero()).append("\n");
            informacion.append("Fecha de nacimiento: ").append(pasajero.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");
            informacion.append("Correo Electrónico: ").append(pasajero.getCorreo()).append("\n");
            informacion.append("Teléfono: ").append(pasajero.getNumTelefono()).append("\n");
            informacion.append("Asiento: ").append(pasajero.getNumAsiento()).append("\n");
            informacion.append("-\n");
            
            escritor.write(informacion.toString());
            escritor.close();
            System.out.println("Información guardada en pasajeros.txt");
        } catch (IOException ex) {
            System.out.println("Ocurrió un error al escribir en el archivo.");
            ex.printStackTrace();
        }
	}
	
	// metodo para leer el archivo de Pasajeros (vuelos y sus pasajeros)
	public static HashMap<String, ArrayList<Pasajero>> leerArchivosPasajeros() {
		HashMap <String, ArrayList<Pasajero>> mapReservaciones = new HashMap<>(); 
		
	    try (BufferedReader br = new BufferedReader(new FileReader("pasajeros.txt"))) { // se intenta leer el archivo txt	        
	        String linea; // creo un String linea para recorrer el contenido del archivo
	        String numeroVuelo = null;
	        ArrayList<Pasajero> listaPasajeros = new ArrayList<>();	 
	        Pasajero pasajero = null; // se establece un pasajero para llenar los datos
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // establecer formato para la fecha de nacimiento
	        
	        while ((linea = br.readLine()) != null) {
	            if (linea.startsWith("Vuelo:")) { 
	                if (numeroVuelo != null && pasajero != null) { 
	                    listaPasajeros.add(pasajero); // se agrega el pasajero a la lista
	                    mapReservaciones.put(numeroVuelo, listaPasajeros);
	                }
	                numeroVuelo = linea.split(": ")[1];
	                listaPasajeros = new ArrayList<>();
	                pasajero = null;

	            } else if (linea.startsWith("Nombre(s):")) { 
	            	pasajero = new Pasajero();	           
	            	String nombreCompleto = linea.split(":", 2)[1].trim();
                    String[] nombres = nombreCompleto.split(" ");
                    pasajero.setPrimerNombre(nombres[0]);
                    pasajero.setSegundoNombre(nombres.length > 1 ? nombres[1] : "");                
	            } else if (linea.startsWith("Apellidos:")) {
	            	String apellidoCompleto = linea.split(":", 2)[1].trim();
	            	String[] apellidos = apellidoCompleto.split(" ");
	            	pasajero.setApellidoPaterno(apellidos[0]);
	            	pasajero.setApellidoMaterno(apellidos.length > 1 ? apellidos[1] : "");                    
	            } else if (linea.startsWith("Género:")) {
	            	pasajero.setGenero(linea.split(": ")[1]);
	            } else if (linea.startsWith("Fecha de nacimiento:")) {
	            	String fecha = linea.split(": ")[1];
	            	pasajero.setFechaNacimiento(LocalDate.parse(fecha, dateFormatter));	            	
	            } else if (linea.startsWith("Correo Electrónico:")) {
	            	pasajero.setCorreo(linea.split(": ")[1]);
	            } else if (linea.startsWith("Teléfono:")) {
	            	pasajero.setNumTelefono(linea.split(": ")[1]);
	            } else if (linea.startsWith("Asiento:")) {
	            	pasajero.setNumAsiento(linea.split(": ")[1]);
	            } else if (linea.equals("-")) {
	            	if (pasajero != null) {
	            		listaPasajeros.add(pasajero);
	            	}
	            }
	        }

	        // se agrega el último pasajero al terminar el archivo
	        if (numeroVuelo != null && !listaPasajeros.isEmpty()) {
	            mapReservaciones.put(numeroVuelo, listaPasajeros);
	        }

	    } catch (Exception e) { // Excepción al no poder leer el archivo
	        e.printStackTrace(); // Imprime información del error
	    }
	    return mapReservaciones;
	}
	
	// metodo para escibir en el Archivo de Registros (usuarios registrados)
	public static void escribirArchivoRegistros(String primerNombre, String segundoNombre, String apellidoPaterno, String apellidoMaterno,
									   String genero, String dia, String mes, String año, String correo, String telefono, String contraseña) {
    	// Formatear la información en una cadena
    	String informacion = "-\n" +
    					 "Nombre(s): " + primerNombre + " " + segundoNombre + "\n" +
                         "Apellidos: " + apellidoPaterno + " " + apellidoMaterno + "\n" +
                         "Género: " + genero + "\n" +
                         "Fecha de nacimiento: " + dia + "/" + mes + "/" + año + "\n" +
                         "Correo Electrónico: " + correo + "\n" +
                         "Teléfono: " + telefono + "\n" +
                         "Contraseña: " + contraseña + "\n\n";
    	
        // Crear o escribir en el archivo
        try {
            File archivo = new File("registro.txt");
            FileWriter escritor = new FileWriter(archivo, true); // true para añadir en vez de sobrescribir
            escritor.write(informacion);
            escritor.close();
            System.out.println("Información guardada en registro.txt");
        } catch (IOException ex) {
            System.out.println("Ocurrió un error al escribir en el archivo.");
            ex.printStackTrace();
        }
	}
	
	// metodo para leer el archivo de Registros (usuarios registrados)
	public static void leerArchivoRegistros() {
	    try (BufferedReader br = new BufferedReader(new FileReader("registro.txt"))) { // se intenta leer el archivo txt	        

	        pasajeros.clear(); // limpio el ArrayList antes de agregar nuevos datos

	        String linea; // creo un String linea para recorrer el contenido del archivo
	        Pasajero pasajero = null; // se establece un pasajero para llenar los datos
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // establecer formato para la fecha de nacimiento
	        
	        while ((linea = br.readLine()) != null) {
	            if (linea.startsWith("-")) { // llego al final
	                if (pasajero != null) { // si hay informacion en pasajero
	                    pasajeros.add(pasajero); // se agrega el pasajero a la lista
	                }
	                pasajero = new Pasajero(); // creo un nuevo objeto pasajero
	            } else if (linea.startsWith("Nombre(s):")) { 
	            	String nombreCompleto = linea.split(":", 2)[1].trim();
                    String[] nombres = nombreCompleto.split(" ");
                    pasajero.setPrimerNombre(nombres[0]);
                    pasajero.setSegundoNombre(nombres.length > 1 ? nombres[1] : "");                
	            } else if (linea.startsWith("Apellidos:")) {
	            	String apellidoCompleto = linea.split(":", 2)[1].trim();
	            	String[] apellidos = apellidoCompleto.split(" ");
	            	pasajero.setApellidoPaterno(apellidos[0]);
	            	pasajero.setApellidoMaterno(apellidos.length > 1 ? apellidos[1] : "");                    
	            } else if (linea.startsWith("Género:")) {
	            	pasajero.setGenero(linea.split(": ")[1]);
	            } else if (linea.startsWith("Fecha de nacimiento:")) {
	            	String fecha = linea.split(": ")[1];
	            	pasajero.setFechaNacimiento(LocalDate.parse(fecha, dateFormatter));
	            } else if (linea.startsWith("Correo Electrónico:")) {
	            	pasajero.setCorreo(linea.split(": ")[1]);
	            } else if (linea.startsWith("Teléfono:")) {
	            	pasajero.setNumTelefono(linea.split(": ")[1]);
	            } else if (linea.startsWith("Contraseña:")) {
	            	pasajero.setContraseña(linea.split(": ")[1]);
	            }
	        }

	        // se agrega el último pasajero al terminar el archivo
	        if (pasajero != null) {
	            pasajeros.add(pasajero);
	        }

	    } catch (Exception e) { // Excepción al no poder leer el archivo
	        e.printStackTrace(); // Imprime información del error
	    }
	} 
	
	// metodo para leer el Archivo de Reservaciones 
    public static List<Reservacion> obtenerReservaciones(String correoUsuario) {
        List<Reservacion> reservaciones = new ArrayList<>();
        try {
            File archivo = new File("reservaciones.txt");
            if (!archivo.exists()) {
                return reservaciones;
            }

            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;
            Reservacion reservacionActual = null;
            boolean perteneceAlUsuario = false;

            while ((linea = lector.readLine()) != null) {
                if (linea.startsWith("Número de Reservación: ")) {
                    reservacionActual = new Reservacion();
                    reservacionActual.setNumReservacion(Integer.parseInt(linea.split(": ")[1]));
                    perteneceAlUsuario = false;
                } else if (linea.startsWith("Fecha de Reservación: ")) {
                    String fecha = linea.split(": ")[1];
                    reservacionActual.setFechaReservacion(LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                } else if (linea.startsWith("Vuelo: ")) {
                    reservacionActual.setNumVuelo(linea.split(": ")[1]);
                } else if (linea.startsWith("Correo Electrónico: ")) {
                    String correo = linea.split(": ")[1];
                    if (correo.equals(correoUsuario)) {
                    	perteneceAlUsuario = true;
                    }
                } else if (linea.equals("-")) {
                    if (perteneceAlUsuario && reservacionActual != null) {
                        reservaciones.add(reservacionActual);
                    }
                    reservacionActual = null;
                }
            }
            lector.close();
        } catch (IOException ex) {
            System.out.println("Ocurrió un error al leer el archivo de reservaciones.");
            ex.printStackTrace();
        }
        return reservaciones;
    }

	
	// metodo para escibir en el Archivo de Reservaciones (para los usuarios registrados)
	public static void escribirArchivoReservaciones(Reservacion reservacion, Pasajero pasajero) {
        try {
            File archivo = new File("reservaciones.txt");
            FileWriter escritor = new FileWriter(archivo, true); // true para añadir en vez de sobrescribir
            StringBuilder informacion = new StringBuilder();

            informacion.append("Número de Reservación: ").append(reservacion.getNumReservacion()).append("\n");
            informacion.append("Fecha de Reservación: ").append(reservacion.getFechaReservacion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");
            informacion.append("Vuelo: ").append(reservacion.numVuelo).append("\n");
            informacion.append("Nombre(s): ").append(pasajero.getPrimerNombre()).append(" ").append(pasajero.getSegundoNombre()).append("\n");
            informacion.append("Apellidos: ").append(pasajero.getApellidoPaterno()).append(" ").append(pasajero.getApellidoMaterno()).append("\n");
            informacion.append("Correo Electrónico: ").append(pasajero.getCorreo()).append("\n");
            informacion.append("-\n"); // Separador entre reservaciones

            escritor.write(informacion.toString());
            escritor.close();
            System.out.println("Reservación guardada en reservaciones.txt");
        } catch (IOException ex) {
            System.out.println("Ocurrió un error al escribir en el archivo.");
            ex.printStackTrace();
        }			
	}
	
    // metodo para generar un número de reservación 
    public static int generarNumReservacion() {
        int numeroReservacion = 1;
        try {
            File archivo = new File("reservaciones.txt");
            if (!archivo.exists()) {
                return numeroReservacion;
            }

            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.startsWith("Número de Reservación: ")) {
                    int numero = Integer.parseInt(linea.split(": ")[1]);
                    if (numero >= numeroReservacion) {
                        numeroReservacion = numero + 1;
                    }
                }
            }
            lector.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return numeroReservacion;
    }
    
    // metodo para crear una nueva reservacion
    public static void crearReservacion(String numVuelo, Pasajero pasajero) {
        if (pasajero != null) {
            Reservacion nuevaReservacion = new Reservacion();
            nuevaReservacion.setNumReservacion(generarNumReservacion());
            nuevaReservacion.setFechaReservacion(LocalDate.now());
            nuevaReservacion.numVuelo = numVuelo;
            
            escribirArchivoReservaciones(nuevaReservacion, pasajero);
        }
    }
	
	// metodo para cambiar el estado de los asientos una vez realizada la compra
	public static void comprarAsientos(Vuelo vuelo) {
		String numVuelo = String.valueOf(vuelo.getNumVuelo()); // obtengo el num de vuelo como String
		ArrayList<String> asientosComprados = new ArrayList<>(getAsientosSeleccionados()); // obtengo los asientos seleccionados
		
		vuelo.actualizarAsientosOcupados(asientosComprados);
		escribirAsientosOcupados(numVuelo, asientosComprados);
		limpiarAsientos(); //
	}
	
	// metodo para agregar asiento a los asientos seleccionados
	public static void agregarAsiento(String numAsiento) {
		if (!asientosSeleccionados.contains(numAsiento)) {
			asientosSeleccionados.add(numAsiento);
		}
	}
	
	// metodo para remover asiento a los asientos seleccionados
	public static void removerAsiento(String numAsiento) {
		asientosSeleccionados.remove(numAsiento);
	}
	
	// metodo para vaciar los asientos seleccionados
	public static void limpiarAsientos() {
		asientosSeleccionados.clear();
	}
	
	// sets
	public static void setPasajeroActual(Pasajero pasajero) {
		Control.pasajeroActual = pasajero;
	}
	
	// gets
	public static Pasajero getPasajeroActual() {
		return pasajeroActual;
	}
	public static ArrayList<Vuelo> getVuelos() {
		return vuelos;
	}
	public static ArrayList<Pasajero> getPasajeros() {
		return pasajeros;
	}
	public static ArrayList<String> getAsientosSeleccionados(){
		return asientosSeleccionados;
	}
}
