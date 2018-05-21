1import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart extends SortingCart {

	ArrayList<ShoppingList> shoppingList = new ArrayList<>(7);

	public String itemName;

	// Sorting every items priority wise

	// BUBBLE SORT
	@Override
	public void SortList() {
		for (int i = 0; i < 7; i++) {
			for (int j = 1; j < 7; j++) {

				if (shoppingList.get(j - 1).get_Priority() > shoppingList.get(j).get_Priority()) {

					ShoppingList temp = shoppingList.get(j - 1);

					shoppingList.set(j - 1, shoppingList.get(j));

					shoppingList.set(j, temp);

				}
			}

		}
	}// closing sorting loop

	@SuppressWarnings("resource")
	public void GetInput() throws Exception {
		String itemName;
		int priority;
		double price;
		int quantity;
		double totprice;
		double sum = 0;
		int i = 0;
		int k = 1;
		// ShoppingList[] shoppingList = new ShoppingList[7];

		System.out.println("WELOCOME TO MORE SUPER MARKET");

		try {
			while (i < 7) {
				Scanner keyboard = new Scanner(System.in);

				System.out.println("Please enter name of item : " + (i + 1));

				itemName = keyboard.nextLine();

				ShoppingList sp_List = new ShoppingList();
				ShoppingList sp_List1 = new ShoppingList();

				sp_List1.set_Name(itemName);

				if (i >= 1) {
					boolean isExists = false;

					// Checking Equal method for itemName
					for (int j = 0; j < i; j++) {
						if (sp_List1.equals(shoppingList.get(j))) {
							isExists = true;
							k = 10; // To continue the shopping with same Item
									// Number
							break;
						}

						else {
							isExists = false;
						}
					} // for loop closing

					if (isExists == false) {

						// shoppingList.set(i, sp_List1);
						shoppingList.add(sp_List);
					}

					else {

						throw new MyException("!!<<   Item name is already exists in the list   >>!!\n");
						// System.out.println("!!<< Item name is already exists
						// in
						// the list >>!!\n");

					}

				} // if loop closing

				// Checking the item name exist or not
				if (k == 10) {
					k = 0;
					continue;
				}

				System.out.println("Please enter priority of item : " + (i + 1));

				// Checking the given Priority number is integer or not!
				while (!keyboard.hasNextInt()) {

					System.out.println("Invalid number. Please enter only digits.");
					keyboard.next();// Go to next
				}

				// Storing the given Priority value in variable
				priority = keyboard.nextInt();

				System.out.println("Please enter price of the single item :" + (i + 1));

				// TO Check Whether the given price value is integer or not!
				while (!keyboard.hasNextInt()) {

					System.out.println("!!<<  Invalid number. Please enter only digits  >>!!");
					keyboard.next();// Go to next
				}

				// Storing the Price value in a variable

				price = keyboard.nextDouble();

				System.out.println("Please enter no of quantities of the item : " + (i + 1));

				// Checking the given Quantities number is integer or not!
				while (!keyboard.hasNextInt()) {

					System.out.println("Invalid number. Please enter only digits.");
					keyboard.next();// Go to next
				}

				// Storing the given Priority value in variable
				quantity = keyboard.nextInt();

				totprice = price * quantity;

				sum = sum + totprice;

				// Checking the sum greater than $100 for the last item in the
				// list
				if (i == 6) {
					if (sum < 100) {
						double min = 100 - sum + totprice;

						while (price < min) {
							System.out.println("Please enter price greater than: " + min + "$");

							price = Double.parseDouble(keyboard.next());// Go to
																		// next
						}
						System.out.println("Please enter no of quantities of the item : " + (i + 1));

						// Checking the given Quantities number is integer or
						// not!
						while (!keyboard.hasNextInt()) {

							System.out.println("Invalid number. Please enter only digits.");
							keyboard.next();// Go to next
						}
						quantity = keyboard.nextInt();

						totprice = price * quantity;
						sum = sum + totprice;
					}
				}

				// Storing Values in Array Object Shopping List

				sp_List.set_Name(itemName);

				sp_List.set_Priority(priority);

				sp_List.set_Price(price);

				sp_List.set_Quantity(quantity);

				sp_List.set_Totprice(totprice);

				shoppingList.add(i, sp_List);

				sp_List.copymethod(itemName, price, priority);

				System.out.println("!!<<   Item Saved  Successfully  >>!!\n");

				i++;

			} // Closing First While loop

			System.out.println("TOTAL AMOUNT OF CART : " + sum);

			FileWriterReader file = new FileWriterReader();

			try {

				file.FileIo(shoppingList);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("Exception thrown  :" + e);

		}

	}

	@Override
	public boolean equals(Object obj)

	{
		ShoppingList Item = (ShoppingList) obj;

		return itemName.equals(Item.get_Name());

	}

	public void GetOutput() {

		PurchaseCart myList = new PurchaseCart();
		myList.set_List(shoppingList);
		myList.display();
		SortList();
		myList.display();
		myList.PurchaseItems();
		// myList.display();
	}
}
