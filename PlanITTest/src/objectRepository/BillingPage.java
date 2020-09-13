package objectRepository;

import org.openqa.selenium.By;

public class BillingPage {

	public static By ddlBillingAddress = By.cssSelector("select#billing-address-select");
	public static By txtBoxFirstName = By.cssSelector("input#BillingNewAddress_FirstName");
	public static By txtBoxLastname = By.cssSelector("input#BillingNewAddress_LastName");
	public static By txtBoxEmail = By.cssSelector("input#BillingNewAddress_Email");
	public static By ddlCountry = By.cssSelector("select#BillingNewAddress_CountryId");
	public static By txtBoxCity = By.cssSelector("input#BillingNewAddress_City");
	public static By txtBoxAddress1 = By.cssSelector("input#BillingNewAddress_Address1");
	public static By txtBoxzip = By.cssSelector("input#BillingNewAddress_ZipPostalCode");
	public static By txtBoxphone = By.cssSelector("input#BillingNewAddress_PhoneNumber");
	public static By btnBillingContinue = By.cssSelector("div#billing-buttons-container input");
	public static By ddlShippingAddress = By.cssSelector("select#shipping-address-select");
	public static By btnShippingContinue = By.cssSelector("div#shipping-buttons-container input");
	public static By chbshippiingmEthod = By.cssSelector("input#shippingoption_1");
	public static By btnShippingMethodContinue = By.cssSelector("div#shipping-method-buttons-container input");
	public static By chbCOD = By.xpath("//input[@value='Payments.CashOnDelivery']");
	public static By btnPaymentContinue = By.cssSelector("div#payment-method-buttons-container input");
	public static By txtCODmessage = By.cssSelector("div.info p");
	public static By btnPaymentContinueAfterConfirmation = By.cssSelector("div#payment-info-buttons-container input");

	public static By btnConfirmOrder = By.cssSelector("div#confirm-order-buttons-container input");
	public static By txtOrderConformationMessage = By.cssSelector("div.title");

	public static By txtOrderNumber = By.cssSelector("ul.details");

	public static By btnOderContinue = By.cssSelector("input.order-completed-continue-button");
	

}
