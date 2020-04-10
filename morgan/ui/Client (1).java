package model;
public class Client{
	// Attributes
	private String nameClient;
	private String nit;
	private String expeditionDateNit;
	private String category;
	private double totalPay;
	private double totalKg;
	// Constants
	public final static String BASIC = "basic";
	public final static String SILVER = "silver";
	public final static String GOLD = "gold";
	public final static String PLATINUM = "platinum";
	public final static double UPPLATINUM = 5000000;
	public final static double UPGOLD = 2000000;
	public final static double GOLDENWEIGHT = 55000;
	public final static double SILVERWEIGHT = 35000;
	
	// Methods
	public Client (String nameClient, String nit, String expeditionDateNit){
		this.nameClient = nameClient;
		this.nit = nit;
		this.expeditionDateNit = expeditionDateNit;
		this.totalKg=0;
		this.totalPay=0;
		this.category= BASIC;
	}
	
	public String updateCategory(double totalPay, double totalKg){
		String newCategory = "";
		if(totalPay>=UPPLATINUM){
			newCategory = PLATINUM;
		}
		else if((totalPay>=UPGOLD)||(totalKg>=GOLDENWEIGHT)){
			newCategory = GOLD;
		}
		else if(totalKg>=SILVERWEIGHT){
			newCategory = SILVER;
		}
		else{
			newCategory = BASIC;
		}
		return newCategory;
	}
	public String getNameClient(){
		return nameClient;
	}
	public void setName(String nameClient){
		this.nameClient = nameClient;
	}
	public String getNit(){
		return nit;
	}
	public void setNit(String nit){
		this.nit = nit;
	}
	public String getCategory(){
		return category;
	}
	public void setCategory(String category){
		this.category = category;
	}
	public double getTotalKg(){
		return totalKg;
	}
	public void setTotalKg(double totalKg){
		this.totalKg = totalKg;
	}
	public double getTotalPay(){
		return totalPay;
	}
	public void setTotalPay(double totalPay){
		this.totalPay = totalPay;
	}
}