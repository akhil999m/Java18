
public class ShoppingList

{

	private String ShoppingItemName;

	private double ItemPrice;

	private int ItemPriority;

	private double TotalPrice;

	private int ItemQuantity;

	public ShoppingList(String ItemName, double Price, int Priority, double ToPrice, int qty) {
		ShoppingItemName = ItemName;
		ItemPrice = Price;
		ItemPriority = Priority;
		TotalPrice = ToPrice;
		ItemQuantity = qty;
	}

	// Default Constructor
	public ShoppingList() {
		ShoppingItemName = "";
		ItemPrice = 0.0;
		ItemPriority = 0;
		TotalPrice = 0.0;
		ItemQuantity = 0;
	}

	// Equals method to compare item names
	@Override
	public boolean equals(Object obj)

	{
		ShoppingList Item = (ShoppingList) obj;

		return ShoppingItemName.equals(Item.get_Name());

	}

	public String get_Name()

	{
		return ShoppingItemName;
	}

	public int get_Priority() {
		return ItemPriority;
	}

	public double get_Price() {
		return ItemPrice;
	}

	public double get_Totprice() {
		return TotalPrice;
	}

	public int get_Quantity() {
		return ItemQuantity;
	}

	public void set_Name(String ItemName) {
		ShoppingItemName = ItemName;
	}

	public void set_Priority(int Priority)

	{
		ItemPriority = Priority;
	}

	public void set_Price(double Price) {
		ItemPrice = Price;
	}

	public void set_Totprice(double ToPrice) {
		TotalPrice = ToPrice;
	}

	public void set_Quantity(int qty)

	{
		ItemQuantity = qty;
	}

	public void copymethod(String ItemNames, double Price, int Priority) {
		ShoppingItemName = ItemNames;
		ItemPrice = Price;
		ItemPriority = Priority;
	}

}
