
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*Mahashwetha Rao */
public class MessageProcessingApplication {

	public static void main(String[] main) {

		try {
			BufferedReader rd = new BufferedReader(new FileReader("C:\\Users\\mahashwetha\\Desktop\\input.txt"));
			String line;
			SaleProcesser sp = new SaleProcesser();
			while ((line = rd.readLine()) != null) {

				sp.processSaleNotifications(line);
				sp.report();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
