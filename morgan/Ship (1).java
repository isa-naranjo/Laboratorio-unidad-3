package model;
public class Ship{
	// Attributes
	private String nameShip;
	private double shipWeight;
	// Constants
	public final static String NAMESHIP = "El Pirata";
	public final static int MAXCAPACITY = 28000;
	public final static int MINCAPACITY = 12000;
	public final static int MINLOAD = 2;
	public final static int MAXLOAD = 100;
	public final static char DANGEROUS = 'd';
	public final static char NOTPERISHABLE = 'n';
	public final static char PERISHABLE = 'p';
	public final static int PRICENOTPERISHABLE = 80000;
	public final static int PRICEDANGEROUS = 390000;
	public final static int PRICEPERISHABLE = 250000;
	// Relations
	private Load[] listLoads;
	// Methods 
	public Ship (){
		this.nameShip = NAMESHIP;
		this.shipWeight = 0;
		this.listLoads = new Load[MAXLOAD];
	}
	
	public Load searchLoad(String loadId){
		Load existLoad = null;
		boolean loadFound = false;
		for(int i=0; (i<listLoads.length)&&(!loadFound); i++){
			if(listLoads[i]!=null){
				if(listLoads[i].getLoadId().equalsIgnoreCase(loadId)){
					existLoad = listLoads[i];
					loadFound = true;
				}
			}
		}
		return existLoad;
	}
	
	public String addLoad(int boxes, double boxWeight, char type, String owner, String loadId, double loadPay){
	String message = "";
	boolean addLoad = false;
	Load existLoad = searchLoad(loadId);
	if(existLoad!=null){
		message = "Error: La carga ya existe";
		}
		else{
			for(int i=0; (i<listLoads.length)&&(!addLoad); i++){
				if(listLoads[i]==null){
					boolean acceptLoad = compatibleLoad(type);
					if(acceptLoad){
						listLoads[i] = new Load(boxes, boxWeight, type, owner, loadId, loadPay);
						addLoad = true;
						message = "Carga registrada";
					}
					else{
						message = "Error: No se puede cargar por sanidad";
						addLoad = true;
					}
				}
			}
			if(!addLoad){
			message = "Error: El barco esta lleno";
			}
		}
		return message;
	}
	
	public boolean compatibleLoad(char type){
		boolean acceptLoad = true;
		if(type!=NOTPERISHABLE){
			for(int i=0; (i<listLoads.length)&&(!acceptLoad); i++){
				if(listLoads[i]!=null){
					if((listLoads[i].getType()==DANGEROUS)&&(type==PERISHABLE)){
						acceptLoad = false;
					}
					else if((listLoads[i].getType()==PERISHABLE)&&(type==DANGEROUS)){
						acceptLoad = false;
					}
				}
			}
		}
		return acceptLoad;
	}
	
	public String departureShip(){
		String message = "";
		int numLoads = 0;
		shipWeight = 0;
		for(int i=0; i<listLoads.length; i++){
			if(listLoads[i]!=null){
			numLoads++;
			shipWeight = shipWeight + (((listLoads[i].getBoxes())*(listLoads[i].getBoxWeight()))/1000);
			}
		}
		if(shipWeight<MINCAPACITY){
			message = "El barco no puede zarpar";
		}
		else if((numLoads<MINLOAD)&&!(shipWeight>=MINCAPACITY)){
			message = "Error: Falta carga";
		}
		else if(shipWeight>MAXCAPACITY){
			message = "Error: Fuera de capacidad";
		}
		else{
			message = "Barco listo";
		}
	return message;
	}
	
	public double calculateShipWeight(){
		for(int i=0; i<listLoads.length; i++){
			if(listLoads[i]!=null){
				shipWeight = shipWeight+ (((listLoads[i].getBoxes())*(listLoads[i].getBoxWeight()))/1000);
			}
		}
		return shipWeight;
	}
	
	public double shipPay(){
		double pay = 0;
		for(int i=0; i<listLoads.length; i++){
			if(listLoads[i]!=null){
				if(listLoads[i].getType()==DANGEROUS){
					pay =((listLoads[i].getBoxes())*(listLoads[i].getBoxWeight())/1000)*PRICEDANGEROUS;
				}
				else if(listLoads[i].getType()==PERISHABLE){
					pay =((listLoads[i].getBoxes())*(listLoads[i].getBoxWeight())/1000)*PRICEPERISHABLE;
				}
				else if(listLoads[i].getType()==NOTPERISHABLE){
					pay =((listLoads[i].getBoxes())*(listLoads[i].getBoxWeight())/1000)*PRICENOTPERISHABLE;
				}
			}
		}
		
		return pay;
	}
	
	public double clientPay(String nit){
		double pay = 0;
		for(int i=0; i<listLoads.length; i++){
			if(listLoads[i]!=null){
				if(listLoads[i].getOwner().equals(nit)){
					pay += listLoads[i].getLoadPay();
				}
			}
		}
		return pay;
	}
	
	public double clientKg(String nit){
		double kg = 0;
		for(int i=0; i<listLoads.length; i++){
			if(listLoads[i]!=null){
				if(listLoads[i].getOwner().equals(nit)){
					kg = kg + (listLoads[i].getBoxes()*listLoads[i].getBoxWeight()/1000);
				}
			}
		}
		return kg;
	}
	
	public String downloadShip(){
		String message = "";
		for(int i=0; i<listLoads.length; i++){
			listLoads[i]=null;
		}
		message = "El barco esta limpio";
		return message;
	}
	public String getNameShip(){
		return nameShip;
	}
	public void setNameShip(String nameShip){
		this.nameShip = nameShip;
	}
	public double getShipWeight(){
		return shipWeight;
	}
	public void setShipWeight(double ShipWeight){
		this.shipWeight = shipWeight;
	}
}