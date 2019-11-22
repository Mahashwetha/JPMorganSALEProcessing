import java.util.ArrayList;
import java.util.HashMap;

/*This is the inventory logger class that is responsible to format the output for all the products and also checks the count of notifications*/
public class ProductInventoryLogger {
	static HashMap<String, Product> prodInv;
	/* Used for normal product operation in tab form */
	private static ArrayList simpleReport = new ArrayList();
	/*
	 * This is used to print the adjustments done as part of operations like add,
	 * subtract and so on
	 */
	private static ArrayList adjustReport = new ArrayList();

	ProductInventoryLogger() {
		prodInv = new HashMap<String, Product>();
	}

	public Product getProduct(String productType) {
		if (prodInv.get(productType) == null) {
			prodInv.put(productType, new Product(productType));
			return prodInv.get((productType));
		} else
			return prodInv.get(productType);
	}

	public void updateProduct(Product product) {
		prodInv.put(product.getProductType(), product);
	}

	private int totalSalesValue;

	public void report() {
		// Report after 10th iteration and not at the beginning.
		if ((simpleReport.size() % 10) == 0 && simpleReport.size() != 0) {

			System.out.println("10 sales appended to log");
			System.out.println("*************** Log Report *****************");
			System.out.println("Product           |Quantity   |Value      ");
			prodInv.forEach((k, v) -> formatReports(k, v));
			System.out.println("-------------------------------------------");
			System.out.println(String.format("%-30s|%-11d", "Total Sales", getTotalSalesValue()));
			System.out.println("-------------------------------------------");

			try {

				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// After 50th message report the info and also about the adjusted price info if
		// done any.
		if ((simpleReport.size() % 50) == 0 && simpleReport.size() != 0) {
			System.out.println(
					"Application reached 50 messages and cannot process further. The following are the adjustment records made;\n");
			getAdjustmentReports().forEach(System.out::println);
			System.exit(1);
		}
	}

	// Append any given value to the totalSalesValue field
	public void appendTotalSalesValue(int productTotalPrice) {
		totalSalesValue += productTotalPrice;
	}

	/* To display all the sale value */
	public void formatReports(String type, Product product) {
		String lineItem = String.format("%-18s|%-11d|%-11d", product.getProductType(), product.getTotalQuantity(),
				product.getTotalPrice());
		appendTotalSalesValue(product.getTotalPrice());
		System.out.println(lineItem);
	}

	// Get all the adjustment report as an array list
	public ArrayList getAdjustmentReports() {
		return adjustReport;
	}

	// Set an adjustment report string to the adjustmentReports array
	public void setAdjustmentReports(String adjustmentReport) {
		adjustReport.add(adjustmentReport);
	}

	public void report(String line) {

		simpleReport.add(line);
	}

	// return the total sales value
	public int getTotalSalesValue() {
		return totalSalesValue;
	}
}
