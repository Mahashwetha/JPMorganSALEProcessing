# JPMorganSALEProcessing
JP morgan test for sale notification processing

JP morgan coding test 
I have done the coding in given time however which running i was getting exceptions and couldnt debug further.

1.MessageProcessingApplication ->Main file which has access to SaleProcessor .
2.SaleProcessor -> This processes the message and updates the Product accordingly once the input line is parsed.
3. ProductInventoryLogger ->Consists of hashmap of all product inventory with producttype as key and Product as value.This alsi displaysthe output as requested in Tabs.
4.Product ->This is the main class with product field and value and required getter setters
5.CalculateCorrectPrice -> For different operations like add,sub and multiply this class is used and calculations are done accordingly.

Added input text for reference as well.Junit for 2 classes as apart from parsing the text and calculating price there was not much logic to test .
