package ui;
import java.util.Scanner;
import model.Company;
public class Main {
	private Company mainCompany;		
	public static Scanner lector;
	public Main(){
		createCompany();
	}
	public static void main(String[] args) {
		lector = new Scanner(System.in);
		int bucle = 0;
		Main controller = new Main();
		do{
				System.out.println("Escoja:\n1. Agregar cliente\n2. Eliminar Cliente\n3. Agregar carga\n4. Zarpar barco\n5. Descargar barco");
				int option=lector.nextInt();
				switch(option){
					case 1: 
						controller.addClient();
					break;
					case 2:
						controller.deleteClient();
					break;
					case 3:
						controller.addLoad();
					break;
					case 4:
						controller.departureShip();
					break;
					case 5:
						controller.downloadShip();
					break;
				}
			
			System.out.println("\nIr al menu: 0 \nCerrar el programa: 1");
			bucle = lector.nextInt();
		}
		while (bucle == 0);
	}
	
	public void createCompany(){
		String nameCompany = "El Pirata";
		mainCompany=new Company (nameCompany);
	}
	public void addClient(){
		System.out.println("Nombre del cliente");
		lector.nextLine();
		String nameClient=lector.nextLine();
		System.out.println("ID del cliente");
		String nit=lector.nextLine();
		System.out.println("Expedicion del ID del cliente");
		String expeditionDateNit=lector.nextLine();
		String message = mainCompany.addClient(nameClient,nit,expeditionDateNit);
		System.out.println(message);
	}
	public void deleteClient(){
		System.out.println("ID del cliente");
		String nit=lector.nextLine();
		String message = mainCompany.deleteClient(nit);
		System.out.println(message);
	}
	public void addLoad(){
		System.out.println("ID cliente");
		String owner=lector.nextLine();
		System.out.println("Numero de cajas");
		int boxes=lector.nextInt();
		System.out.println("Peso por caja (gr)");
		double boxWeight=lector.nextDouble();
		lector.nextLine();
		System.out.println("Tipo de carga: d:Dangerous, n:No Perishable, p:Perishable");
		char type=lector.nextLine().charAt(0);
		System.out.println("ID carga");
		String loadId=lector.nextLine();
		double loadPay = mainCompany.loadPay(boxes, boxWeight, type);
		String message = mainCompany.addLoad(boxes, boxWeight, type, owner, loadId, loadPay);
		System.out.println(message);
	}		

	public void departureShip(){
		String message = "";
		message = mainCompany.departureShip();
		System.out.println(message);
		if(message.equals ("Barco listo")){
			message = mainCompany.valueShip();
			System.out.println(message);
			mainCompany.updateCategory();
		}
	}
	public void downloadShip(){
		String message = "";
		message = mainCompany.downloadShip();			
	}
}