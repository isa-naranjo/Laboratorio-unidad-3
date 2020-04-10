package model;
public class Load{
	// Attributes 
	private int boxes;
	private double boxWeight;
	private char type;
	private String owner;
	private String loadId;
	private double loadPay;
	// Constants
	
	// Relations
	private Client client;
	// Methods
	public Load (int boxes, double boxWeight, char type, String owner, String loadId, double loadPay){
		this.boxes = boxes;
		this.boxWeight = boxWeight;
		this.type = type;
		this.owner = owner;
		this.loadId = loadId;
		this.loadPay = 0;
	}
	public int getBoxes(){
		return boxes;
	}
	public void setBoxes(int boxes){
		this.boxes = boxes;
	}
	public double getBoxWeight(){
		return boxWeight;
	}
	public void setBoxWeight(double boxWeight){
		this.boxWeight = boxWeight;
	}
	public char getType(){
		return type;
	}
	public void setType(char type){
		this.type = type;
	}
	public String getOwner(){
		return owner;
	}
	public void setOwner(String owner){
		this.owner = owner;
	}
	public String getLoadId(){
		return loadId;
	}
	public void setLoadId(String loadId){
		this.loadId = loadId;
	}
	public double getLoadPay(){
		return loadPay;
	}
	public void setLoadPay(double loadPay){
		this.loadPay = loadPay;
	}
}