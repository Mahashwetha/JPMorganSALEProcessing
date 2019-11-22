/*This class takes care of adjustment of items price if already available based on a parrticlar operation*/
public class CalculateCorrectPrice {

	public  int adjustedPrice;

	// product holds the Product object.
	private  Product product;

	public CalculateCorrectPrice(Product product) {
		this.product = product;
		adjustedPrice = 0;
	}

	public int getCorrectedPrice() {
		String op = product.getAdjustmentOperator().toLowerCase();
		if (op.matches("add"))
			addPrice();
		else if (op.matches("subtract"))
			subtractPrice();
		else if (op.matches("multiply"))
			multiplyPrice();
		return adjustedPrice;
	}

	// Adds product totalprice with the requested price value.
	public  void addPrice() {
		adjustedPrice = product.getTotalPrice() + (product.getTotalQuantity() * product.getProductPrice());
	}

	// Subtracts product totalprice with the requested price
	// value.
	public  void subtractPrice() {
		adjustedPrice = product.getTotalPrice() - (product.getTotalQuantity() * product.getProductPrice());
	}

	// Multiplies product total price and quantity with the
	// requested price and appends to existing total value.
	public  void multiplyPrice() {
		adjustedPrice = product.getTotalPrice() + (product.getTotalPrice() * product.getProductPrice())
				+ (product.getTotalQuantity() * product.getProductPrice());
	}

	public String adjustPriceReport() {

		String adjustmentReport = String.format("Performed %s %d p to %d %s and price adjusted from %d to %d",
				product.getAdjustmentOperator(), product.getProductPrice(), product.getTotalQuantity(),
				product.getProductType(), product.getTotalPrice(), adjustedPrice);
		return adjustmentReport;
	}

}
