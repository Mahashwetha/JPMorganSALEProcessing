class Product
{
// product price
	private int productPrice;

	// product quantity
	private int productQuantity;

	// product operation
	private String adjustmentOperator;

	//prodType
	private String productType;

	// all the totalof products
	private int totalQuantity;

	//totl price of all products
	private int totalPrice;

	// Constructor
	public Product(String type) {
		this.totalPrice = 0;
		this.totalQuantity = 0;
		this.productType = type;
		this.adjustmentOperator = null;
	}
	// Calculate the given quantity with given price and return the value
		public int calculatePrice(int productQuantity, int productPrice) {
			return productQuantity * productPrice;
		}

		// Set the total price of the sale to the given value of the requested product.
		public void setTotalPrice(int totalPrice) {
			this.totalPrice = totalPrice;
		}

		// Add the given value to the existing total price of the requested product.
		public void appendTotalPrice(int productPrice) {
			this.totalPrice += productPrice;
		}

		// Add the given quantity to the existing total quantity.
		public void setTotalQuantity(int quantity) {
			this.totalQuantity += quantity;
		}

		// Get the total quantity of the requested product.
		public int getTotalQuantity() {
			return this.totalQuantity;
		}

		// Get the total price of the requested product.
		public int getTotalPrice() {
			return this.totalPrice;
		}

		// Get the type of the requested product.
		public String getProductType() {
			return this.productType;
		}

		// Set the type of product with the requested type.
		// @note: This won't be used much since we keep log separately.
		public void setProductType(String type) {
			this.productType = type;
		}

		// Get the price of the requested product
		public int getProductPrice() {
			return productPrice;
		}

		// Set the price of the requested product
		public void setProductPrice(int productPrice) {
			this.productPrice = productPrice;
		}

		// Get the product quantity
		public int getProductQuantity() {
			return productQuantity;
		}

		// Set the product quantity to the given value
		public void setProductQuantity(int productQuantity) {
			this.productQuantity = productQuantity;
		}

		// Get the product adjustmentOperator and defaults to null.
		public String getAdjustmentOperator() {
			return adjustmentOperator;
		}

		// Set the product adjustmentOperator to the provided operator e.g, Add,
		// Subtract, or Multiply.
		public void setAdjustmentOperator(String adjustmentOperator) {
			this.adjustmentOperator = adjustmentOperator;
		}
}	