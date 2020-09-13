package objectRepository;

import org.openqa.selenium.By;

public class LogInPage {
	public static By lnkLogIn = By.cssSelector("a.ico-login");
	public static By txtWelcomeSignIn = By.xpath("//h1[text()='Welcome, Please Sign In!']");
	public static By txtBoxEmail = By.cssSelector("input#Email");
	public static By txtBoxPassword = By.cssSelector("input#Password");
	public static By btnLogin = By.cssSelector("input.button-1.login-button");
}
