package model;
public class Company{
	// Attributes
	private String nameCompany;
	private String ownerCompany;
	private double gains;
	// Constants
	public final static String OWNER = "Morgan";
	public final static int MAXCLIENTS = 5;
	public final static double DISCOUNTSILVER = 0.015;
	public final static double DISCOUNTGOLD = 0.03;
	public final static double DISCOUNTPLATINUM = 0.05;
	// Relations
	private Ship mainShip;
	private Client[] clients;
	// Methods
	public Company (String nameCompany){
		this.nameCompany = nameCompany;
		this.ownerCompany = OWNER;
		this.gains = 0;
		this.clients = new Client[MAXCLIENTS];
		this.mainShip = new Ship();
	}
	
	public Client searchClient(String nit){
		Client existClient = null;
		boolean clientFound = false;
		for(int i=0; (i<clients.length)&&(!clientFound); i++){
			if(clients[i]!=null){
			if(clients[i].getNit().equalsIgnoreCase(nit)){
				existClient = clients[i];
				clientFound = true;
				}
			}
		}	
		return existClient;
	}
	
	public String addClient(String nameClient, String nit, String expeditionDateNit){
		String message = "";
		boolean addClient = false;
		Client existClient = searchClient(nit);
		if(existClient!=null){
			message = "Error: The client already exist";
		}
		else{
			for(int i=0; (i<clients.length)&&(!addClient); i++){
				if(clients[i]==null){
					clients[i] = new Client(nameClient, nit, expeditionDateNit);
					addClient = true;
					message = "Client registered";
				}
			}
			if(!addClient){
				message = "Error: The clients list is full";
			}
		}
		return message;
	}
	
	public String deleteClient(String nit){
		String message = "";
		boolean deleteClient = false;
		for(int i=0; (i<clients.length)&&(!deleteClient); i++){
			if(clients[i]!=null){
				if(clients[i].getNit().equalsIgnoreCase(nit)){
				
				message = "Client eliminated";
				clients[i] = null;
				deleteClient = true;
				
				}
			}
		}
		if(!deleteClient){
			message = "Error: ";
		}
		return message;
		
		
	}
	
	public String addLoad(int boxes, double boxWeight, char type, String owner, String loadId, double loadPay){
		String message = "";
		Client existClient = searchClient(owner);
		if(existClient==null){
			message = "Error: The client doesn't exist";
		}
		else{
			message = mainShip.addLoad(boxes, boxWeight, type, owner, loadId, loadPay);
			if(message.equals("Load registered")){
				double totalPay = loadPay(boxes, boxWeight, type);
				message = "Total value: "+message;
			}
		}
		return message;
	}
	
	public double loadPay(int boxes, double boxWeight, char type){
		double pay = 0;
		if(type==mainShip.DANGEROUS){
			pay =(boxes*boxWeight/1000)*mainShip.PRICEDANGEROUS;
		}
		else if(type==mainShip.PERISHABLE){
			pay =(boxes*boxWeight/1000)*mainShip.PRICEPERISHABLE;
		}
		else if(type==mainShip.NOTPERISHABLE){
			pay =(boxes*boxWeight/1000)*mainShip.PRICENOTPERISHABLE;
		}
		return pay;
	}
	
	public String departureShip(){
		String message = mainShip.departureShip();
		return message;
	}
	
	public String valueShip(){
		double pay = mainShip.shipPay();
		double shipWeight = mainShip.calculateShipWeight();
		String message = "El peso del barco es: "+shipWeight+" por lo que se pagara: "+pay;
		return message;
	}
	
	public void updateCategory(){
        for(int i=0; i<clients.length; i++){
            if(clients[i]!=null){
                double pay = mainShip.clientPay(clients[i].getNit());
                double kg = mainShip.clientKg(clients[i].getNit());
				String type = clients[i].updateCategory(pay, kg);
                clients[i].setCategory(type);
                clients[i].setTotalPay(pay);
                clients[i].setTotalKg(kg);
            }
        }
    }
	
	public String downloadShip(){
		String message = "";
		message = mainShip.downloadShip();
		return message;
	}
	public String getNameCompany(){
		return nameCompany;
	}
	public void setNameCompany(String nameCompany){
		this.nameCompany = nameCompany;
	}
	public double getGains(){
		return gains;
	}
	public void setGains(double gains){
		this.gains = gains;
	}
}
	
	