import java.util.ArrayList;
import java.util.Scanner;

public class PurchaseCart implements Shopping, DispalyItems {
	// ShoppingList[] lists = new ShoppingList[7];

	ArrayList<ShoppingList> lists = new ArrayList<ShoppingList>();
	// private ShoppingList[] lists;

	public PurchaseCart() {
		lists = new ArrayList<ShoppingList>(7);
	}

	public void set_List(ArrayList<ShoppingList> list) {
		this.lists = list;
	}

	public ArrayList<ShoppingList> get_List() {
		return lists;
	}

	@Override
	public void PurchaseItems() {

		double PurchaseSum = 0;

		int PriorityNum;

		Scanner pr = new Scanner(System.in);

		int[] array = new int[7];

		int[] array1 = new int[7];

		int item = 1;

		int qty, bankacct;

		String name;

		System.out.println("Please enter customer name\n");

		name = pr.nextLine();

		System.out.println("Please enter amount to purchase from bank account");

		bankacct = pr.nextInt();

		for (int i = 0; i < 7; i++) {
			System.out.println("PURCHASE ITEM : " + (i + 1));

			System.out.println("Please enter Item's Priority number to Purchase");

			PriorityNum = pr.nextInt();

			for (int j = 0; j < 7; j++) {
				if (lists.get(j).get_Priority() == PriorityNum) {
					if ((PurchaseSum + lists.get(j).get_Totprice()) < bankacct) {
						array[i] = j;

						System.out.println("PRIORITY    Item Name     Price     Quantity     TotalPrice");

						System.out.println("-------    ---------     -------    ---------   ----------");

						System.out.println("   " + lists.get(j).get_Priority() + "    " + "     "
								+ lists.get(j).get_Name() + "       " + lists.get(j).get_Price() + "       "
								+ lists.get(j).get_Quantity() + "       " + lists.get(j).get_Totprice());

						System.out.println(" ");

						System.out.println("<<....Item Purchased....>>\n");

						PurchaseSum = PurchaseSum + lists.get(j).get_Totprice();

						break;
					}

					else
						System.out.println("Please enter different Priority Number to purchase\n");
					// throw new MyException("Please enter different Priority
					// Number to purchase\n");
					i = i - 1;
					break;
				}

			}
			System.out.println("You have " + (bankacct - PurchaseSum) + "$ to purchase items\n");

			System.out.println(
					"If you want to stop purchasing.Please enter 2 (TWO)  !! To continue shopping press any Number/Key !");

			int temp = pr.nextInt();

			System.out.println(" ");

			if (temp == 2) {

				item = i + 1;

				System.out.println("Items purchesed are: " + item);

				break;

			}

		} // Closing First for loop

		// Purchased Items Priority number positions in the Array Object
		System.out.println("Purchased item priority numbers positions: ");

		for (int k = 0; k < item; k++) {
			System.out.println(array[k]);
		}

		for (int k = 0; k < 7; k++) {
			array1[k] = k;
		}

		// Displaying Items Purchased
		System.out.println("\n!!<<  PURCHASED ITEMS ARE   >>!!\n");

		System.out.println("PRIORITY \t Item Name \t Price \t    Quantity \t  TotalPrice");

		System.out.println("------- \t --------- \t ------- \t ------------- \t ----------");

		for (int i = 0; i < item; i++) {
			for (int j = 0; j < 7; j++) {

				if (array[i] == j) {

					System.out.println("   " + lists.get(j).get_Priority() + "\t\t" + lists.get(j).get_Name() + "\t\t"
							+ lists.get(j).get_Price() + "\t\t" + lists.get(j).get_Quantity() + "\t\t"
							+ lists.get(j).get_Totprice());

					break;
				}
			}
		}

		// Displaying NOT purchased Items

		for (int i = 0; i < item; i++) {
			int k = 0;

			k = array[i];

			for (int j = k; j < 6; j++) {
				array1[j] = array1[j + 1];
			}

			if (k == 6) {
				array1[k] = 0;
			}
		}

		System.out.println("!!<<   NOT PURCHASED ITEMS   >>!!\n");

		System.out.println("PRIORITY \t Item Name \t Price \t    Quantity \t  TotalPrice");

		System.out.println("------- \t --------- \t ------- \t ------------- \t ----------");

		for (int k = 0; k < (7 - item); k++) {
			int i = array1[k];

			System.out.println("   " + lists.get(i).get_Priority() + "\t\t" + lists.get(i).get_Name() + "\t\t"
					+ lists.get(i).get_Price() + "\t\t" + lists.get(i).get_Quantity() + "\t\t"
					+ lists.get(i).get_Totprice());
		}

		System.out.println("You have left " + (bankacct - PurchaseSum) + "$  in your account\n");

		System.out.println("Thanks for shopping");

	} // Closing Not Purchasing Items loop

	@Override
	public void display() {
		System.out.println("SHOPPING ITEMS");

		System.out.println("-------------------");

		System.out.println("PRIORITY \t Item Name \t Price \t    Quantity \t  TotalPrice");

		System.out.println("------- \t --------- \t ------- \t ------------- \t ----------");

		for (int i = 0; i < 7; i++)

		{

			System.out.println("   " + lists.get(i).get_Priority() + "\t\t" + lists.get(i).get_Name() + "\t\t"
					+ lists.get(i).get_Price() + "\t\t" + lists.get(i).get_Quantity() + "\t\t"
					+ lists.get(i).get_Totprice());
		}

	}// Closing display

}
