import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class FileWriterReader {

	public void FileIo(ArrayList<ShoppingList> shoppingitems) throws Exception {
		FileOutputStream fos = new FileOutputStream("ShoppingItems.txt");
		DataOutputStream dos = new DataOutputStream(fos);

		dos.writeUTF("Priority    Item Name     Price     Quantity     TotalPrice\n");

		dos.writeUTF("\r\n");
		dos.writeUTF("-------    ---------     -------    ---------   ----------\n");
		dos.writeUTF("\r\n");

		for (int j = 0; j < shoppingitems.size(); j++) {

			dos.writeUTF(shoppingitems.get(j).get_Priority() + " , " + shoppingitems.get(j).get_Name() + " , "
					+ shoppingitems.get(j).get_Price() + " , " + shoppingitems.get(j).get_Quantity());

			dos.writeUTF("\r\n");

		}

	}

}