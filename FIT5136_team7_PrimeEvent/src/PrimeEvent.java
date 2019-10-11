import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PrimeEvent {
	
	Hall hallarr[] = new Hall[100];
	private ArrayList<Booking> listOfBooking = new ArrayList<Booking>();
	private ArrayList<Hall> listOfHall = new ArrayList<Hall>();
	private ArrayList<User> listOfUsers = new ArrayList<User>();
	int bookIDCount = 20000;
	Scanner input;
	Scanner sc = new Scanner(System.in);
	UserInterface ui = new UserInterface();
	
	public PrimeEvent() {
		input = new Scanner(System.in);
	}

		
	//Login
	public void login(String userName, String password) {		
		//Verify details
		boolean found = false;
		for(User thisUser : listOfUsers) {
			if(thisUser.getUsername().equals(userName)) {
				if(thisUser.getPassword().equals(password)) {
					//Display page based on user's privilege
					System.out.println("\nLogin successful." + "\nWelcome " + userName);
					System.out.println("\nRedirecting to home page\n");
					System.out.println();
					ui.displayHomePage(thisUser.getClass());
				}
			}
		}
		
		
	}
	
	//Logout
	public void logout() {
		System.out.println();
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		System.out.println("\n\nLogout successful.");
		System.out.println("\nRedirecting to home page");
		System.out.println();
		
		//return to home
		ui.displayHomePage("home");;
	}
	
	//Register
	public boolean register(String[] userData) {			
		System.out.println("First Name: ");
		input.nextLine();
		input.nextLine();
		System.out.println("Last Name: ");
		input.nextLine();
		System.out.println("Email: ");
		input.nextLine();
		System.out.println("Phone Number:");
		input.nextLine();
		System.out.println("Address");
		input.nextLine();
		System.out.println("Username: ");
		input.nextLine();
		System.out.println("Password: ");
		input.nextLine();
		
		if(type == 1) {
			System.out.println("Do you have concession [y/n]?");
			input.nextLine();
		}
		//create the corresponding user object
		
		//return to home
		System.out.println("\nRegister successful.");
		System.out.println("\nRedirecting to home page\n");
		System.out.println();
		
		//display based on user
		allHome(type);
		
	}
	
	//Search
	
	//Manage Hall
	public void manageHall() {
		int ch = 0;
		System.out.println();
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		System.out.println("\nManage Hall\n");
		
		do {
			try {
				System.out.println("Choose to continue");
				System.out.println("1. Create Hall");
				System.out.println("2. Edit Hall");
				System.out.print("Your choice [1/2]? ");
				ch = input.nextInt();
				System.out.println(ch);
			} catch (Exception e) {
				System.out.print("Invalid input. Please choose again.");
			}
		}while(ch != 1 && ch != 2);
		
		if(ch == 1) {
			createHall();
		}
		else if(ch == 2) {
			editHall();
		}
	}
	public void createHall() {
		Hall p0 = new Hall();
		Hall p1 = new Hall();
		Hall p2 = new Hall();
		
		if(hallarr[0] == null) {
			System.out.println("Hall Name: ");
			input.nextLine();
			p0.setName(input.nextLine());
			System.out.println("Address: ");
			p0.setAddress(input.nextLine());
			System.out.println("Email: ");
			p0.setEmail(input.nextLine());
			System.out.println("Phone Number:");
			p0.setNumber(input.nextLine());
			System.out.println("Description");
			p0.setDescription(input.nextLine());
			System.out.println("Event: ");
			p0.setEvent(input.nextLine());
			System.out.println("Size: ");
			p0.setSize(input.nextLine());
			System.out.println("Price: ");
			p0.setPrice(input.nextLine());
			
		};
		
		if(hallarr[0] != null && hallarr[1] == null) {
			System.out.println("Hall Name: ");
			input.nextLine();
			p1.setName(input.nextLine());
			System.out.println("Address: ");
			p1.setAddress(input.nextLine());
			System.out.println("Email: ");
			p1.setEmail(input.nextLine());
			System.out.println("Phone Number:");
			p1.setNumber(input.nextLine());
			System.out.println("Description");
			p1.setDescription(input.nextLine());
			System.out.println("Event: ");
			p1.setEvent(input.nextLine());
			System.out.println("Size: ");
			p1.setSize(input.nextLine());
			System.out.println("Price: ");
			p1.setPrice(input.nextLine());
		};
		
		if(hallarr[1] != null && hallarr[2] == null) {
			System.out.println("Hall Name: ");
			input.nextLine();
			p2.setName(input.nextLine());
			System.out.println("Address: ");
			p2.setAddress(input.nextLine());
			System.out.println("Email: ");
			p2.setEmail(input.nextLine());
			System.out.println("Phone Number:");
			p2.setNumber(input.nextLine());
			System.out.println("Description");
			p2.setDescription(input.nextLine());
			System.out.println("Event: ");
			p2.setEvent(input.nextLine());
			System.out.println("Size: ");
			p2.setSize(input.nextLine());
			System.out.println("Price: ");
			p2.setPrice(input.nextLine());
		};
		
		if(p0.getName() != null) {
			hallarr[0] = p0;
		}
		if(p1.getName() != null) {
			hallarr[1] = p1;
		}
		if(p2.getName() != null) {
			hallarr[2] = p2;
		}
		System.out.println("\nChange saved.");
		System.out.println("\nRedirecting to home page\n");
		System.out.println();
		
		sc.nextLine();
		
		//display based on user
		allHome(2);
	}
	
	public void editHall() {
		int ed =0;
		System.out.println("Please choose Hall number:");
		int x = 0;
		index: for(int j=0; j<hallarr.length;j++) {
			if(hallarr[j] != null) {
				x = j;
			}
			else {
				break index;
			}
		}
		for(int i=0; i<=x;i++) {
			System.out.println(i+1 + "."+ hallarr[i].getName());
		}
		ed = input.nextInt();
		// modify name
		System.out.println("Name: "+ hallarr[ed-1].getName());
		System.out.println("change: ");
		String edname = input.nextLine();
		edname = input.nextLine();
		if (edname != null) {
			hallarr[ed-1].setName(edname);
		}
		sc.nextLine();
		
		// modify address;
		System.out.println("Address: "+ hallarr[ed-1].getAddress());
		System.out.println("change: ");
		String edaddress = input.nextLine();
		if (edaddress != null) {
			hallarr[ed-1].setAddress(edaddress);
		}

		// modify phoneNumber
		System.out.println("Phone Number: "+ hallarr[ed-1].getNumber());
		System.out.println("change: ");
		String ednumber = input.nextLine();
		if (ednumber != null) {
			hallarr[ed-1].setNumber(ednumber);
		}

		// modify Email
		System.out.println("Email: "+ hallarr[ed-1].getEmail());
		System.out.println("change: ");
		String edemail = input.nextLine();
		if (edemail != null) {
			hallarr[ed-1].setEmail(edemail);
		}

		// modify description
		System.out.println("Description: "+ hallarr[ed-1].getDescription());
		System.out.println("change: ");
		String eddes = input.nextLine();
		if (eddes != null) {
			hallarr[ed-1].setDescription(eddes);
		}

		// modify Event
		System.out.println("Event: "+ hallarr[ed-1].getEvent());
		System.out.println("change: ");
		String edevent = input.nextLine();
		if (edevent != null) {
			hallarr[ed-1].setEvent(edevent);
		};

		// modify Size
		System.out.println("Size: "+ hallarr[ed-1].getSize());
		System.out.println("change: ");
		String edsize = input.nextLine();
		if (edsize != null) {
			hallarr[ed-1].setSize(edsize);
		};
		
		// modify price
		System.out.println("Price: "+ hallarr[ed-1].getPrice());
		System.out.println("change: ");
		String edprice = input.nextLine();
		if (edprice != null) {
			hallarr[ed-1].setPrice(edprice);
		};
		
		

		
		System.out.println("\nChange saved.");
		System.out.println("\nRedirecting to home page\n");
		System.out.println();
		
		sc.nextLine();
		
		//display based on user
		allHome(2);
		
		
	}
	
	//search hall
	public void searchHall() {
		String search = "";

		System.out.println();
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		System.out.println("\nSearch Hall\n");
		
		System.out.println("Size (metre^2): ");
		input.nextLine();
		String size = input.nextLine();
		System.out.println("Name: ");
		String name = input.nextLine();
		System.out.println("Price: ");
		String price = input.nextLine();
		if(hallarr[0] == null) {
			System.out.println("There is no availible Halls, please try again");
			allHome(1);
		}
		int i = 0;
		int count = 0;
		while(hallarr[i] != null) {
			
			if(size.length() == 0 && name.length() != 0 && price.length() != 0) {
				if(hallarr[i].getName().equals(name) && hallarr[i].getPrice().equals(price)) {
					System.out.println("Display hall infomation");
					System.out.println("Name:"+hallarr[i].getName());
					System.out.println("Owner:"+hallarr[i].getOwner());
					System.out.println("Address:"+hallarr[i].getAddress());
					System.out.println("Number:"+hallarr[i].getNumber());
					System.out.println("Description:"+hallarr[i].getDescription());
					System.out.println("Email:"+hallarr[i].getEmail());
					System.out.println("Event:"+hallarr[i].getEvent());
					System.out.println("Price:"+hallarr[i].getPrice());
					
					System.out.println("Do you want create a booking?([y/n])");
					String choice = input.next();
					if(choice.toLowerCase().equals("y")) {
						createBooking();
						
					}
					count ++;
				}else {
					System.out.println("There is no availible Halls, please try again");
					
					allHome(1);
				}
			}
			else if(size.length() == 0 && name.length() == 0 && price.length() != 0) {
				if(hallarr[i].getPrice().equals(price)) {
					System.out.println("Display hall infomation");
					System.out.println("Name:"+hallarr[i].getName());
					System.out.println("Owner:"+hallarr[i].getOwner());
					System.out.println("Address:"+hallarr[i].getAddress());
					System.out.println("Number:"+hallarr[i].getNumber());
					System.out.println("Description:"+hallarr[i].getDescription());
					System.out.println("Email:"+hallarr[i].getEmail());
					System.out.println("Event:"+hallarr[i].getEvent());
					System.out.println("Price:"+hallarr[i].getPrice());
					
					System.out.println("Do you want create a booking?([y/n])");
					String choice = input.next();
					if(choice.toLowerCase().equals("y")) {
						createBooking();
						
					}
					count ++;
				}else {
					System.out.println("There is no availible Halls, please try again");
					
					allHome(1);
				}
			}
			else if(size.length() == 0 && name.length() == 0 && price.length() == 0) {

					System.out.println("Display hall infomation");
					System.out.println("Name:"+hallarr[i].getName());
					System.out.println("Owner:"+hallarr[i].getOwner());
					System.out.println("Address:"+hallarr[i].getAddress());
					System.out.println("Number:"+hallarr[i].getNumber());
					System.out.println("Description:"+hallarr[i].getDescription());
					System.out.println("Email:"+hallarr[i].getEmail());
					System.out.println("Event:"+hallarr[i].getEvent());
					System.out.println("Price:"+hallarr[i].getPrice());
					
					System.out.println("Do you want create a booking?([y/n])");
					String choice = input.next();
					if(choice.toLowerCase().equals("y")) {
						createBooking();
						
					}
					count ++;
				
				
			}
			else if(size.length() == 0 && name.length() != 0 && price.length() == 0) {
				if(hallarr[i].getName().equals(name)) {
					System.out.println("Display hall infomation");
					System.out.println("Name:"+hallarr[i].getName());
					System.out.println("Owner:"+hallarr[i].getOwner());
					System.out.println("Address:"+hallarr[i].getAddress());
					System.out.println("Number:"+hallarr[i].getNumber());
					System.out.println("Description:"+hallarr[i].getDescription());
					System.out.println("Email:"+hallarr[i].getEmail());
					System.out.println("Event:"+hallarr[i].getEvent());
					System.out.println("Price:"+hallarr[i].getPrice());
					
					System.out.println("Do you want create a booking?([y/n])");
					String choice = input.next();
					if(choice.toLowerCase().equals("y")) {
						createBooking();
						
					}
					count ++;
				}else {
					System.out.println("There is no availible Halls, please try again");
					
					allHome(1);
				}
			}
		    
			else if(size.length() != 0 && name.length() != 0 && price.length() != 0) {
				if(hallarr[i].getSize().equals(size) &&hallarr[i].getName().equals(name) && hallarr[i].getPrice().equals(price)) {
					System.out.println("Display hall infomation");
					System.out.println("Name:"+hallarr[i].getName());
					System.out.println("Owner:"+hallarr[i].getOwner());
					System.out.println("Address:"+hallarr[i].getAddress());
					System.out.println("Number:"+hallarr[i].getNumber());
					System.out.println("Description:"+hallarr[i].getDescription());
					System.out.println("Email:"+hallarr[i].getEmail());
					System.out.println("Event:"+hallarr[i].getEvent());
					System.out.println("Price:"+hallarr[i].getPrice());
					
					System.out.println("Do you want create a booking?([y/n])");
					String choice = input.next();
					if(choice.toLowerCase().equals("y")) {
						createBooking();
						
					}
					count ++;
				}else {
					System.out.println("There is no availible Halls, please try again");
					
					allHome(1);
				}
			}
			
			else if(size.length() != 0 && name.length() == 0 && price.length() != 0) {
				if(hallarr[i].getSize().equals(size)  && hallarr[i].getPrice().equals(price)) {
					System.out.println("Display hall infomation");
					System.out.println("Name:"+hallarr[i].getName());
					System.out.println("Owner:"+hallarr[i].getOwner());
					System.out.println("Address:"+hallarr[i].getAddress());
					System.out.println("Number:"+hallarr[i].getNumber());
					System.out.println("Description:"+hallarr[i].getDescription());
					System.out.println("Email:"+hallarr[i].getEmail());
					System.out.println("Event:"+hallarr[i].getEvent());
					System.out.println("Price:"+hallarr[i].getPrice());
					
					System.out.println("Do you want create a booking?([y/n])");
					String choice = input.next();
					if(choice.toLowerCase().equals("y")) {
						createBooking();
						
					}
					count ++;
				}else {
					System.out.println("There is no availible Halls, please try again");
					
					allHome(1);
				}
			}
			else if(size.length() != 0 && name.length() == 0 && price.length() == 0) {
				if(hallarr[i].getSize().equals(size) ) {
					System.out.println("Display hall infomation");
					System.out.println("Name:"+hallarr[i].getName());
					System.out.println("Owner:"+hallarr[i].getOwner());
					System.out.println("Address:"+hallarr[i].getAddress());
					System.out.println("Number:"+hallarr[i].getNumber());
					System.out.println("Description:"+hallarr[i].getDescription());
					System.out.println("Email:"+hallarr[i].getEmail());
					System.out.println("Event:"+hallarr[i].getEvent());
					System.out.println("Price:"+hallarr[i].getPrice());
					
					System.out.println("Do you want create a booking?([y/n])");
					String choice = input.next();
					if(choice.toLowerCase().equals("y")) {
						createBooking();
						
					}
					count ++;
				}else {
					System.out.println("There is no availible Halls, please try again");
					
					allHome(1);
				}
			}
			else if(size.length() != 0 && name.length() != 0 && price.length() == 0) {
				if(hallarr[i].getSize().equals(size) &&hallarr[i].getName().equals(name) ) {
					System.out.println("Display hall infomation");
					System.out.println("Name:"+hallarr[i].getName());
					System.out.println("Owner:"+hallarr[i].getOwner());
					System.out.println("Address:"+hallarr[i].getAddress());
					System.out.println("Number:"+hallarr[i].getNumber());
					System.out.println("Description:"+hallarr[i].getDescription());
					System.out.println("Email:"+hallarr[i].getEmail());
					System.out.println("Event:"+hallarr[i].getEvent());
					System.out.println("Price:"+hallarr[i].getPrice());
					
					System.out.println("Do you want create a booking?([y/n])");
					String choice = input.next();
					if(choice.toLowerCase().equals("y")) {
						createBooking();
						
					}
					count ++;
				}else {
					System.out.println("There is no availible Halls, please try again");
					
					allHome(1);
				}
			}
			i++;
		}
		if(count == 0) {
			System.out.println("There is no availible Halls, please try again");
			allHome(1);
		}
		
}
	
	public void manageBooking() {
		System.out.println();
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		System.out.println("\nEdit Booking\n");
		
		System.out.println("Booking number: ");
		input.nextLine();
		input.nextLine();
		System.out.println("Start Date: ");
		input.nextLine();
		System.out.println("Duration: ");
		input.nextLine();
		System.out.println("Propose: ");
		input.nextLine();
		System.out.println("Name:");
		input.nextLine();
		System.out.println("Email:");
		input.nextLine();
		System.out.println("Phone Number: ");
		input.nextLine();
		
		System.out.println("\nBooking changed.");
		System.out.println("\nRedirecting to home page");
		System.out.println();
		
		allHome(1);
	}
	
	public void createBooking() {
		Booking newBook = new Booking();
		Date stratTime;
		Date endTime;
		//String create = "";
		System.out.println("Please select one of the given results to book:");
		System.out.println("[1. Fake1, 2. Fake2, 3. Fake3, 4. Fake4, 5. Fake5]");
		System.out.println("Your choice?");
		input.nextLine();
		
		System.out.println("Start Date: ");
		System.out.println("In format:dd-mm-yyyy");
		String startTime=input.nextLine();
		SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyyy");
		try {
			stratTime = format.parse(startTime);
			newBook.setStratTime(stratTime);
		} catch (ParseException e) {

		}

		System.out.println("End Date: ");
		System.out.println("In format:dd-mm-yyyy");
		input.nextLine();
		String EndTime=input.nextLine();
		try {
			endTime = format.parse(EndTime);
			newBook.setEndTime(endTime);
		} catch (ParseException e) {

		}

		System.out.println("Propose: ");
		input.nextLine();
		System.out.println("Name:");
		input.nextLine();
		System.out.println("Email:");
		input.nextLine();
		System.out.println("Phone Number: ");
		input.nextLine();
		
		System.out.println("\nHall Booking successful.");
		System.out.println("\nRedirecting to home page");
		System.out.println();
		listOfBooking.add(newBook);
		allHome(1);
	}
	
	public void tick() {
		System.out.println();
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		System.out.println("\nManage Booking\n");
		System.out.println("There is no booking ");
		System.out.println("\nRedirecting to home page");
		allHome(2);
	}
	

	//Quotation page
	public void requestQuotation() {
		String name = "";
		String dateTime = "";
		String event = "";
		
		System.out.println();
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		
		System.out.println("\nRequest Quotation\n");
		
		System.out.println("Hall Name: ");
		input.nextLine();
		name = input.nextLine();
		
		System.out.println("Date and Time: ");
		dateTime = input.nextLine();
		
		System.out.println("Event: ");
		event = input.nextLine();
		
		System.out.println("A request has been sent.");
		System.out.println("\nRedirecting to home page\n");
		System.out.println();
		allHome(1);
		
	}
	
	
	
	public void header() {
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		System.out.println("\nPrime Event Booking System");
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
	}
	public static void main(String[] args) {
		
		PrimeEvent homePage = new PrimeEvent();
		homePage.allHome(0);
	

	}
	
	
	
	

}





//String arr[] = {"p0","p1","p2","p3","p4","p5","p6","p7","p8","p9","p10"};
//
//check: for (int i=0; i<hallarr.length;i++) {
//	if(hallarr[i] != null) {
//		i = i+1;
//	}
//	else {
//		Hall arr[i] = new Hall();
//		break check;
//	}
//}