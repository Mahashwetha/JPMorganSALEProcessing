import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;


/**
 * @author mahashwetha
 *
 */

public class MessageProcesserTest extends TestCase {

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	MessageProcesser processor;
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testMessageType1() {
		String msg ="apple at 10p";
		processor=new MessageProcesser(msg);
		Assert.assertEquals(processor.productType,"apple");
		Assert.assertEquals(processor.productQuantity,1);
		Assert.assertEquals(processor.productValue,10);
		Assert.assertTrue(processor.parseMessage(msg));
	}
	@Test
	public void testMessageType2() {
		String msg ="20 sales of apples at 10p each";
		processor=new MessageProcesser(msg);
		Assert.assertEquals(processor.productType,"apple");
		Assert.assertEquals(processor.productQuantity,20);
		Assert.assertEquals(processor.productValue,10);
		Assert.assertTrue(processor.parseMessage(msg));
	}
	@Test
	public void testMessageType3() {
		String msg ="Add 20p apples";
		processor=new MessageProcesser(msg);
		Assert.assertEquals(processor.productType,"apple");
		Assert.assertEquals(processor.productQuantity,0);
		Assert.assertEquals(processor.productValue,20);
		Assert.assertEquals(processor.operation,"Add");
		Assert.assertTrue(processor.parseMessage(msg));
	}
	@Test
	public void testMessageType1_InvalidArguments() {
		String msg ="apple at 10p for sale";
		processor=new MessageProcesser(msg);
		Assert.assertFalse(processor.parseMessage(msg));
		
	}
	@Test
	public void testMessageType2_InvalidArguments() {
		String msg ="20 sales for 10 p of apples is done";
		processor=new MessageProcesser(msg);
		Assert.assertFalse(processor.parseMessage(msg));
		
	}
	@Test
	public void testMessageType3_InvalidArguments() {
		String msg ="Add 20p apples for you";
		processor=new MessageProcesser(msg);
		Assert.assertFalse(processor.parseMessage(msg));
		
	}
	@Test
	public void testMessageTypeNull() {
		String msg =null;
		processor=new MessageProcesser(msg);
		Assert.assertEquals(processor.productType,"");
		Assert.assertEquals(processor.productQuantity,0);
		Assert.assertEquals(processor.productValue,0);
		Assert.assertFalse(processor.parseMessage(msg));
	}

}
