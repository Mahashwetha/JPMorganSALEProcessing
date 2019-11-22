/*
 * This class is used to process different sales by getting the product details and updating inventory for a particular sale.
 */
public class SaleProcesser {
	MessageProcesser processer;
	Product product;
	ProductInventoryLogger productList;
	String line;
	private CalculateCorrectPrice adjustPrice;

	public SaleProcesser() {
		productList = new ProductInventoryLogger();
	}

	/* Make required updates for the sale message that is received */
	public void processSaleNotifications(String line) {
		processer = new MessageProcesser(line);
		processer.parseMessage(line);
		String productType = processer.getProductType().toLowerCase();
		if (productType != null)
			this.product = getProduct(productType);
		this.adjustPrice = new CalculateCorrectPrice(product);
		// Set the product details from the parsed message
		this.product.setProductQuantity(processer.getProductQuantity());
		this.product.setTotalQuantity(processer.getProductQuantity());
		this.product.setProductPrice(processer.getProductPrice());
		this.product.setAdjustmentOperator(processer.getOperatorType());

		// Set the total value of the product.
		setProductTotalPrice();
		productList.report(line);
		productList.updateProduct(product);

	}

	private void setProductTotalPrice() {
		int adjustedPrice;
		int productValue;

		if (!product.getAdjustmentOperator().isEmpty()) {
			adjustedPrice = adjustPrice.getCorrectedPrice();
			productList.setAdjustmentReports(adjustPrice.adjustPriceReport());
			product.setTotalPrice(adjustedPrice);
		} else {
			productValue = product.calculatePrice(product.getProductQuantity(), product.getProductPrice());
			product.appendTotalPrice(productValue);
		}
	}

	private Product getProduct(String productType) {

		Product prod = productList.getProduct(productType);
		return prod;
	}

	public void report() {
		if (productList != null)
			productList.report();

	}

}
