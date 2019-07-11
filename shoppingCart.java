import java.util.ArrayList;
import java.util.Scanner;
public class shoppingCart {
	static ArrayList<String> items = new ArrayList<String>(5);
	static ArrayList<Integer> qty = new ArrayList<Integer>(5);
	static ArrayList<Integer> index = new ArrayList<Integer>(5);
	static int[] price = new int[5];
	static int finalPrice=0;
		class item{
			String name;
			int quantity;
		}
	public static void addToCart(){
		shoppingCart.item obj = new shoppingCart().new item();
		
		price[0]=100;price[1]=200;price[2]=250;price[3]=300;price[4]=400;
		while(true){
			int count = 0;
			boolean flag = false;
			System.out.println("Menu(in Kg)");
			System.out.println("1) Oats \t"+price[0]);
			System.out.println("2) Wheat\t"+price[1]);
			System.out.println("3) Mangoes\t"+price[2]);
			System.out.println("4) Apples\t"+price[3]);
			System.out.println("5) Rice \t"+price[4]);
			System.out.println("Press 0 to stop adding");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			int len = index.size();
			for(int i=0;i<len;i++){
				if((option-1) == index.get(i))
					flag = true;
			}
			if(flag==true)
				System.out.println("Item Already Added. Kindly Update the Item");
			if(flag==false){
				if(option==0) break;
				else if(option==1){
					System.out.println("Enter Quantity");
					Scanner sc1 = new Scanner(System.in);
					obj.quantity = sc1.nextInt();
					items.add("Oats");
					index.add(0);
					qty.add(obj.quantity);
					finalPrice = finalPrice + (obj.quantity)*price[0];
				}
				else if(option==2){
					System.out.println("Enter Quantity");
					Scanner sc1 = new Scanner(System.in);
					obj.quantity = sc1.nextInt();
					items.add("Wheat");
					index.add(1);
					qty.add(obj.quantity);
					finalPrice = finalPrice + (obj.quantity)*price[1];
				}
				else if(option==3){
					System.out.println("Enter Quantity");
					Scanner sc1 = new Scanner(System.in);
					obj.quantity = sc1.nextInt();
					items.add("Mangoes");
					index.add(2);
					qty.add(obj.quantity);
					finalPrice = finalPrice + (obj.quantity)*price[2];
				}
				else if(option==4){
					System.out.println("Enter Quantity");
					Scanner sc1 = new Scanner(System.in);
					obj.quantity = sc1.nextInt();
					items.add("Apples");
					index.add(3);
					qty.add(obj.quantity);
					finalPrice = finalPrice + (obj.quantity)*price[3];
				}
				else if(option==5){
					System.out.println("Enter Quantity");
					Scanner sc1 = new Scanner(System.in);
					obj.quantity = sc1.nextInt();
					items.add("Rice");
					index.add(4);
					qty.add(obj.quantity);
					finalPrice = finalPrice + (obj.quantity)*price[4];
				}
			}
			
		}	
	}
	public static void removeFromCart(){
	 while(true){
		System.out.println("Select the item you want to remove");
		System.out.println("Press 0 to stop removing");
		showCart();
		Scanner sc = new Scanner(System.in);
		int rmv = sc.nextInt();
		if(rmv==0)
			break;
		finalPrice = finalPrice - (qty.get(rmv-1))*(price[index.get(rmv-1)]);
		items.remove(rmv-1);
		qty.remove(rmv-1);
		index.remove(rmv-1);
	 }
	 showCart();
	}
	public static void updateCart(){
		while(true){
			showCart();
			System.out.println("Select the item whose quantity you want to update");
			System.out.println("Press 0 to Stop Updating");
			Scanner sc = new Scanner(System.in);
			int upd = sc.nextInt();
			if(upd==0) break;
			System.out.println("Enter the updated quantity");
			Scanner sc1 = new Scanner(System.in);
			int upd_qty = sc1.nextInt();
			if(upd_qty == 0){
				finalPrice = finalPrice - (qty.get(upd-1))*(price[index.get(upd-1)]);
				items.remove(upd-1);
				qty.remove(upd-1);
				index.remove(upd-1);
			}
			else{
				finalPrice = finalPrice + (upd_qty - qty.get(upd-1))*price[index.get(upd-1)];
				qty.set(upd-1,upd_qty);				
			}
		}
		showCart();
	}
	public static void showCart(){
		int noofitems = items.size();
		System.out.println("Items\tQuantity");
		for(int i=0;i<noofitems;i++){
			System.out.println(items.get(i)+"\t"+qty.get(i));
		}
		System.out.print("\n");
	}
	public static void generateBill(){
		int noofitems = items.size();
		System.out.println("Items Quantity Price");
		for(int i=0;i<noofitems;i++){
			System.out.println(items.get(i)+"\t"+ qty.get(i)+"\t"+ price[index.get(i)]);
		}
		System.out.println("\t\t"+finalPrice+"<-- Total");
		System.out.print("\n");
	}
	public static void main(String[] args) {
	  while(true){
		System.out.println("Metacube Pantry");
		System.out.println("\nPlease select the suitable action to perform");
		System.out.println("1) Add an item to the Cart");
		System.out.println("2) Remove an item from the Cart");
		System.out.println("3) Update Cart");
		System.out.println("4) Show Cart");
		System.out.println("5) Generate Bill");
		System.out.println("6) Exit");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		if(input==1){
			addToCart();
		}
		if(input==2){
			removeFromCart();
		}
		if(input==3) updateCart();
		if(input==4) showCart();
		if(input==5) generateBill();
		if(input==6) break;
	  }
	}

}
