package application;

//-----Author: Hoo Ern Ping
//-----ID: B200152B
public class Non_Member extends Customer{
	
	//-----default constructor
	public Non_Member() {
		super();
	}
			
	//-----constructor with parameter
	public Non_Member(int id, String name, String movie, 
				String[] seatID, int adultQty, int kidQty) {
		
		super(id, name, movie, seatID, adultQty, kidQty);
	}
	
	//-----task method
	public double calcTotalDiscount() {
		double discount = 0.0;
		int totalQty = super.getAdultQty() + super.getKidQty();
		
		if(totalQty > 10) {
			discount = 0.2;
		}else if(totalQty > 3) {
			discount = 0.1;
		}else {
			discount = 0.0;
		}
		
		return discount * super.calcTotalPrice();
	}
	
	public double calcGrandTotal() {
		return super.calcTotalPrice() - calcTotalDiscount();
	}
	
	//-----print price method
	public String printPrice() {
		return String.format("%.2f",calcTotalDiscount())+","+String.format("%.2f",calcGrandTotal());
	}
		
	//-----print method
	public String toString() {
		return super.toString()+
				"\nNon Member Discount: "+ String.format("%.2f",calcTotalDiscount())+
				"\nGrand Total: "+String.format("%.2f",calcGrandTotal());
	}	
}
