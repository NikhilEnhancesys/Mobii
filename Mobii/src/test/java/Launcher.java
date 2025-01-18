import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Launcher {

	public static WebDriver driver;

	public static void launch() {

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.get(
				"https://indosattest.snoc.co.in:8443/snoc/login?service=https://indosattest.snoc.co.in:8443/incentive/services&locale=in_ID");
		driver.manage().window().maximize();

//		// Advanced btn
		driver.findElement(By.id("details-button")).click();
//		// Proceed link
		driver.findElement(By.id("proceed-link")).click();

		// Language selection
		WebElement lang = driver.findElement(By.id("languages"));
		Select language = new Select(lang);
		language.selectByVisibleText("English");

		// username and password
		driver.findElement(By.id("username")).sendKeys("INDOSAT");
		driver.findElement(By.id("password")).sendKeys("Admin@1234");
		driver.findElement(By.name("submit")).click();
	}

}
