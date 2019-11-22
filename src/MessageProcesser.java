/*This class is used to parse the message as input.
 * assumptions : any plural form of geneirc fruits are reduced to single form and used to update the product inventory.
 * The no of arguments are fixed as well for each type of message.
 * message 1: item at price
 * message 2:noofsales of item at price
 * message 3:operation price of item 
 */
public class MessageProcesser {
	int productQuantity;
	String productType;
	String operation;
	int productValue;

	MessageProcesser(String message) {
		this.productQuantity = 0;
		this.productType = "";
		this.operation = "";
		this.productValue = 0;
	//	parseMessage(message);

	}

	public boolean parseMessage(String message) {
		if (message == null)
		{	System.out.println("No message received please retry");
		return false;
		}
		String[] parseMessage = message.trim().split(" ");
		String first = parseMessage[0];
		if (parseMessage[1].contentEquals("at")) {
			return parseMessageType1(parseMessage);
		} else if (parseMessage[0].matches("^\\d+")) {
			return parseMessageType2(parseMessage);
		} else if (first.matches("Add|Subtract|Multiply"))

		{
			return parseMessageType3(parseMessage);
		} else
			System.out.println("Sorry ,wrong message type as input.Try again");
		return true;

	}

	// parse messag eo type :message 1: item at price
	private boolean parseMessageType1(String[] parseMessage) {
		if (parseMessage.length > 3 || parseMessage.length < 3) {
			System.out.println("Your input is wrong");
			return false;
		}
		this.productType = parseMessage[0];
		this.productQuantity = 1;
		this.productValue = Integer.parseInt(parseMessage[2].replaceAll("p", ""));
		return true;

	}

//parse mesaage of type :noof sales of item at cost each
	private boolean parseMessageType2(String[] parseMessage) {
		if (parseMessage.length > 7 || parseMessage.length < 7) {
			System.out.print("Wrong sale message entered either correct message or add correct arguments");
			return false;
		}
		this.productType = parseType(parseMessage[3].toLowerCase());
		this.productValue = parsePrice(parseMessage[5]);
		this.productQuantity = Integer.parseInt(parseMessage[0]);
		return true;
	}

//parse message of type : operation price of item.
	private boolean parseMessageType3(String[] parseMessage) {

		if (parseMessage.length > 3 || parseMessage.length < 3) {
			System.out.println("Error in input please try again");
			return false;
		}
		this.operation = parseMessage[0];
		this.productType = parseType(parseMessage[2].toLowerCase());
		this.productQuantity = 0;
		this.productValue = parsePrice(parseMessage[1]);
		return true;

	}

	public String parseType(String rawType) {
		String parsedType = "";

		if (rawType.endsWith("s") && !rawType.matches("grapes"))
			parsedType = rawType.substring(0, (char) rawType.length() - 1) + "";
		else
			parsedType = rawType;
		if (parsedType.endsWith("ie"))
			parsedType = parsedType.substring(0, (char) parsedType.length() - 2) + "y";
		else if (parsedType.endsWith("e") && parsedType.contains("oe"))
			parsedType = parsedType.substring(0, (char) parsedType.length() - 1) + "";
		else {
			parsedType = String.format("%s", parsedType);
		}
		return parsedType.toLowerCase();
	}

	// Parse the price and get only value (eg:10p remove p)

	public int parsePrice(String parsePrice) {
		int price;
		price = Integer.parseInt(parsePrice.replaceAll("p", ""));
		return price;
	}

	// Get the product type
	public String getProductType() {
		return productType;
	}

	// Get the product price
	public int getProductPrice() {
		return productValue;
	}

	// Get the operator type
	public String getOperatorType() {
		return operation;
	}

	// Get the product quantity
	public int getProductQuantity() {
		return productQuantity;
	}

}
