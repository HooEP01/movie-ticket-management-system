package application;
import java.util.ArrayList;

//-----Author: Hoo Ern Ping
//-----ID: B200152B
public class MovieTicketSystem {
	
	//-----arraylist
	private ArrayList<Customer> entry;
	
	//-----deflaut constructor
	public MovieTicketSystem() {
		entry = new ArrayList<Customer>();
	}
	
	//-----buy ticket or add method
	public String add(Customer q) {
		boolean found = false;
		String info = "";
		
		for(int i = 0; i < entry.size(); i++) {
			Customer p = entry.get(i);
			
			if(p.getID() == q.getID()) {
				found = true;
			}
		}
		
		if(found == true) {
			info = "Record of customer id: "+ q.getID()+" exists."+
					"\nPlease enter other customer id.";
		}else {
			entry.add(q);
			info = "Added customer id: "+ q.getID()
			+ entry.get(entry.size()-1).toString();
		}
		return info;
	}
	
	//-----remove ticket or remove method
	public String remove(int id) {
		String info = "";
		int i = 0;
		
		for(i = 0; i < entry.size(); i++) {
			Customer p = entry.get(i);
			
			if(p.getID() == id) {
				break;
			}
		}
		
		if(i == entry.size()) {
			info = "Cannot find the id";
		}else {
			//-----remove customer
			entry.remove(i);
			info = "---Customer id: "+id+" is removed succefully.";
		}
		
		return info;
	}
	
	//-----select one customer or search method
	public String search(int id) {
		String info = "";
		int i = 0;
		
		for(i = 0; i < entry.size(); i++) {
			Customer p = entry.get(i);
			
			if(p.getID() == id) {
				break;
			}
		}
		
		if(i == entry.size()) {
			info = "Cannot find the id";
		}else {
			// toString method form Customer class
			info = entry.get(i).toString();
		}
		
		return info;
	}
	
    //-----display all customer's purchase detail or print method
    public String toString() {
    	String output = "";
    	for(Customer q: entry) {
    		output += q + "\n";
    	}
    	return output;
    }
	
}
