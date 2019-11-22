import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import junit.framework.TestCase;

/**
 * @author mahashwetha
 *
 */
@PrepareForTest({CalculateCorrectPrice.class,Product.class})
public class CalculateCorrectPriceTest extends TestCase {

	
	/**
	 * @throws java.lang.Exception
	 * 
	 */
	Product prod;
	CalculateCorrectPrice price;

	@Before
	public void setUp() throws Exception {
		
		prod=PowerMockito.mock(Product.class);
		price = new CalculateCorrectPrice(prod);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testAddPrice() {
		
		Mockito.when(prod.getTotalQuantity()).thenReturn(10);
        Mockito.when(prod.getTotalPrice()).thenReturn(200);
        Mockito.when(prod.getProductPrice()).thenReturn(10);
		price.addPrice();
		Assert.assertEquals(300, price.adjustedPrice);
	}
	
	
	
	
	
	
	/**
	 * Test method for {@link CalculateCorrectPrice#subtractPrice()}.
	 */
	@Test
	public void testSubtractPrice() {
		CalculateCorrectPrice price = new CalculateCorrectPrice(prod);
		Mockito.when(prod.getTotalQuantity()).thenReturn(10);
        Mockito.when(prod.getTotalPrice()).thenReturn(200);
        Mockito.when(prod.getProductPrice()).thenReturn(10);
		price.subtractPrice();
		Assert.assertEquals(100, price.adjustedPrice);

	}

	/**
	 * Test method for {@link CalculateCorrectPrice#multiplyPrice()}.
	 */
	@Test
	public void testMultiplyPrice() {
		CalculateCorrectPrice price = new CalculateCorrectPrice(prod);
		Mockito.when(prod.getTotalQuantity()).thenReturn(10);
        Mockito.when(prod.getTotalPrice()).thenReturn(200);
        Mockito.when(prod.getProductPrice()).thenReturn(10);
		price.multiplyPrice();
		Assert.assertEquals(2300, price.adjustedPrice);

	}

	
}
