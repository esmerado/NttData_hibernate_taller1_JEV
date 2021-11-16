package com.jesmeradonttdata.nttdata_hibernate_taller1_jev;

import java.util.*;

import org.hibernate.Session;

import com.jesmeradonttdata.persistence.NttDataClient;
import com.jesmeradonttdata.persistence.NttDataClientDaoI;
import com.jesmeradonttdata.persistence.NttDataClientDaoImpl;
import com.jesmeradonttdata.services.NttDataClientManagementServiceI;
import com.jesmeradonttdata.services.NttDataClientManagementServiceImpl;

/**
 * 
 * Javier Esmerado Vela - Hibernate - Taller 1.
 * 
 * Main Class.
 * 
 * @author jesmerad
 *
 */
public class NttDataClientHibernateMain {

	/**
	 * 
	 * Main Method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Open Session.
		final Session session = NttDataHibernateUtil.getSessionFactory().openSession();

		// Service inicialization.
		final NttDataClientManagementServiceImpl clientService = new NttDataClientManagementServiceImpl(session);

		// Audit
		final String updatedUser = "NTTDATAJEV_SYS";
		final Date updatedDate = new Date();

		// Client Generator.
		final NttDataClient clientOne = new NttDataClient();
		clientOne.setName("Javier3");
		clientOne.setFirstSurname("Esmerado3");
		clientOne.setSecondSurname("Vela3");
		clientOne.setNif(1234387L);
		clientOne.setUpdatedUser(updatedUser);
		clientOne.setUpdatedDate(updatedDate.toString());
		
		final NttDataClient clientTwo = new NttDataClient();
		clientTwo.setName("Alejandro");
		clientTwo.setFirstSurname("Tellez");
		clientTwo.setSecondSurname("Rubio");
		clientTwo.setNif(115668748L);
		clientTwo.setUpdatedUser(updatedUser);
		clientTwo.setUpdatedDate(updatedDate.toString());
		
		clientService.insertNewClient(clientOne);
		clientService.insertNewClient(clientTwo);

		final NttDataClient clientThree = new NttDataClient();
		clientThree.setUpdatedUser(updatedUser);
		clientThree.setUpdatedDate(updatedDate.toString());
		
		// Menu Implement.

		menu(clientService, clientThree);

		// Sesssion Close.
		session.close();
	}

	/**
	 * 
	 * Menu generation.
	 * 
	 * @param clientService
	 * @param client
	 */
	private static void menu(NttDataClientManagementServiceI clientService, NttDataClient client) {

		// Scanner
		Scanner sc = new Scanner(System.in);

		while (true) {

			try {

				System.out.println("!!BIENVENIDO AL TALLER 1 DE HIBERNATE!!");
				System.out.println("created by Javier Esmerado Vela");
				System.out.println("1.- Añadir cliente.");
				System.out.println("2.- Mostrar clientes.");
				System.out.println("3.- Modificar cliente.");
				System.out.println("4.- Eliminar cliente.");
				System.out.println("5.- Buscar cliente por id.");
				System.out.println("6.- Buscar cliente por nombre y apellido.");
				System.out.println("7.- Exit.");
				int select_num = sc.nextInt();

				switch (select_num) {
				case 1:
					añadirCliente(clientService, client, sc);
					break;
				case 2:
					mostrarClientes(clientService);
					break;
				case 3:
					modificarCliente(clientService, client, sc);
					break;
				case 4:
					eliminarCliente(clientService, client, sc);
					break;
				case 5:
					buscarClientePorId(clientService, client, sc);
					break;
				default:
					exit();

				}
			} catch (Exception e) {
				System.err.println("[ERROR] Ha introducido un valor no permitido.");
			}

		}

	}

	/**
	 * 
	 * Search by Id.
	 * 
	 * @param clientService
	 * @param client
	 * @param sc
	 */
	private static void buscarClientePorId(NttDataClientManagementServiceI clientService, NttDataClient client, Scanner sc) {
		
		System.out.println("Introduce el id del cliente que desea buscar: ");
		Long id = sc.nextLong();
		
		if (clientService.searchById(id) != null) {
			
			NttDataClient clientFromDB = clientService.searchById(id);
			
			System.out.println(clientFromDB.toString());
			
		} else {
			System.out.println("Lo sentimos, el id introducido no coincide con ningún cliente.");
		}
		
	}

	/**
	 * 
	 * Remove a client.
	 * 
	 * @param clientService
	 * @param client
	 */
	private static void eliminarCliente(NttDataClientManagementServiceI clientService, NttDataClient client, Scanner sc) {
		
		mostrarClientes(clientService);
		
		try {
			
			System.out.println("Introduzca el id del usuario a eliminar:");
			Long num = sc.nextLong();
			
			client = clientService.searchById(num);
			
			clientService.deletePlayer(client);
		} catch (Exception e) {
			System.err.println("[ERROR] Ha introducido un valor erróneo.");
		}
		
		
		
	}

	/**
	 * 
	 * Update Client.
	 * 
	 * @param clientService
	 * @param client
	 * @param sc
	 */
	private static void modificarCliente(NttDataClientManagementServiceI clientService, NttDataClient client,
			Scanner sc) {
		
		mostrarClientes(clientService);
		
		try {
			
			System.out.println("Introduce el id del cliente a modificar: ");
			Long num = sc.nextLong();
			
			client = clientService.searchById(num);
			
			System.out.println("Introduce el nuevo nombre: ");
			String name = sc.next();
			System.out.println("Introduce el nuevo primer apellido: ");
			String first_name = sc.next();
			System.out.println("Introduce el nuevo segundo apellido: ");
			String second_name = sc.next();
			
			client.setName(name);
			client.setFirstSurname(first_name);
			client.setSecondSurname(second_name);
			
			clientService.updateClient(client);
			
		} catch (Exception e) {
			System.err.println("[ERROR] Ha introducido un id o un valor incorrecto.");
		}
		
		
	}

	/**
	 * 
	 * Show all the clients.
	 * 
	 * @param clientService
	 * @param sc
	 */
	private static void mostrarClientes(NttDataClientManagementServiceI clientService) {
		
		List<NttDataClient> listOfClients = clientService.searchAll();
		
		listOfClients.stream().forEach(p -> System.out.println(p));
	}

	/**
	 * 
	 * Method to create a new client.
	 * 
	 * @param clientService
	 * @param client
	 * @param sc
	 */
	private static void añadirCliente(NttDataClientManagementServiceI clientService, NttDataClient client, Scanner sc) {

		try {
			
			System.out.println("Nombre: ");
			String name = sc.next();
			System.out.println("Primer apellido: ");
			String first_name = sc.next();
			System.out.println("Segundo apellido: ");
			String second_name = sc.next();
			System.out.println("DNI(Sólo números): ");
			Long nif = sc.nextLong();

			client.setName(name);
			client.setFirstSurname(first_name);
			client.setSecondSurname(second_name);
			client.setNif(nif);

			clientService.insertNewClient(client);
			
		} catch (Exception e) {
			System.err.println("[ERROR] Ha introducido un valor incorrecto.");
		}

	}

	/**
	 * Method to exit the app.
	 */
	private static void exit() {
		System.out.println("¡¡HASTA PRONTO!!");
		System.exit(0);

	}

}
