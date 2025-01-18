import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserCreation extends Launcher {

	static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	public static void userCreation() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Administration
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[11]/a")).click();

		// Create Users
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[11]/ul/li[2]/a")).click();
		Thread.sleep(5000);

		// Organization type
		WebElement orgType = driver.findElement(By.id("gs_sub_org_type"));
		Select organizationType = new Select(orgType);
		organizationType.selectByVisibleText("Dealer");
		// Organization type selection(check-box)
		driver.findElement(By.xpath("//*[@id=\"jqg_list_commonDiv1_2\"]")).click();

		// create btn
		driver.findElement(By.id("orgToAssignUser")).click();

		// username creation
		String un = "Nikhil";
		// current time HHmm
		ZoneId indianZone = ZoneId.of("Asia/Kolkata");
		// Get the current time in the Indian time zone
		LocalTime currentTime = LocalTime.now(indianZone);
		// Format the time to include only hours and minutes without a colon
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
		String formattedTime = currentTime.format(formatter);
		System.out.println("Indian time: " + formattedTime);

		// username
		String username = un + formattedTime;
		driver.findElement(By.id("userName")).sendKeys(username);

		// Email id
		driver.findElement(By.id("emailId")).sendKeys("nikhilkumar.temp@gmail.com");

		// MSISDN
		driver.findElement(By.id("mobileNo")).sendKeys("621234567890");

		// Organization owner
		WebElement OrgOwn = driver.findElement(By.id("org_owner"));
		Select OrganizationType = new Select(OrgOwn);
		OrganizationType.selectByVisibleText("Yes");

		// Owner Name
		driver.findElement(By.id("owner_name")).sendKeys("Nikhilkumar");

		// Operator name
		driver.findElement(By.id("operator_name")).sendKeys("Nikhilkumar");

		// Operator type
		WebElement operType = driver.findElement(By.id("operator_type"));
		Select operatorType = new Select(operType);
		operatorType.selectByVisibleText("MPC Owner");

		// Authentication type(web)
		driver.findElement(By.xpath("//option[@value='1151']")).click();

		// Role Id(MPC Owner)
		driver.findElement(By.xpath("//option[@value='2105']")).click();

		// Operator Alt Id
		WebElement AltId = driver.findElement(By.id("owner_alt_id_type"));
		Select OperatorAltId = new Select(AltId);
		OperatorAltId.selectByVisibleText("Citizen Card id");

		// Operator Alt Id no.
		driver.findElement(By.id("owner_alt_id_no")).sendKeys("821234567890");

//		// SALDOMOB MSISDN
		StringBuilder number = new StringBuilder("62");
		// Create a Random instance
		Random random = new Random();
		// Generate the remaining 12 digits, ensuring they are less than 8
		for (int i = 0; i < 12; i++) {
			int digit = random.nextInt(8); // Generate digits between 0 and 7
			number.append(digit);
		}
		System.out.println("SALDOMOB MSISDN: " + number);
		driver.findElement(By.id("saldomobo_msisdn_no")).sendKeys(number);

		// Assign type
		WebElement AssnType = driver.findElement(By.id("assign_type"));
		Select AssignType = new Select(AssnType);
		AssignType.selectByVisibleText("Create and Assign to Node");

		// Node selection
		driver.findElement(By.xpath("//*[@id=\"div_select_node\"]/span")).click();
		Thread.sleep(3000);
		// Select
		driver.findElement(By.id("selectRequiredNode")).click();

		// Roles(MPC - Owner)
		WebElement Role = driver.findElement(By.xpath("//*[@id=\"roles\"]/option[1]"));
		Role.click();
		Actions act = new Actions(driver);
		int x = 1;
		while (x != 11) {
			act.moveToElement(Role).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			x++;
		}
		// comes out of role menu
		driver.findElement(By.xpath("//*[@id=\"div_Position\"]/strong")).click();

		// Position(MPC - OWNER)
		WebElement position = driver.findElement(By.xpath("//*[@id=\"Position\"]/option[1]"));
		position.click();
		int y = 1;
		while (y != 11) {
			act.moveToElement(position).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			y++;
		}
		// comes out from that position manu
		driver.findElement(By.xpath("//*[@id=\"div_Position\"]/strong")).click();
		Thread.sleep(5000);

		// profile information: First name
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Nikhilkumar");

		// Mother maiden name
		driver.findElement(By.xpath("//input[@id='mother_mad_name']")).sendKeys("Sam");

		// Address type
		WebElement addressType = driver.findElement(By.id("addressTypeCreation"));
		Select selectAddressType = new Select(addressType);
		selectAddressType.selectByVisibleText("Office Address");

		// Streed Address
		driver.findElement(By.id("address1Res")).sendKeys("Koramangala");

		// Country
		WebElement selectCountry = driver.findElement(By.id("countryAddressTypeCreation"));
		Select country = new Select(selectCountry);
		country.selectByVisibleText("Indonesia");

		// Province
		WebElement selectProvince = driver.findElement(By.id("stateAddressTypeCreation"));
		Select province = new Select(selectProvince);
		province.selectByVisibleText("BALI");

		// City
		WebElement selectCity = driver.findElement(By.id("zoneAddressTypeCreation"));
		Select city = new Select(selectCity);
		city.selectByVisibleText("BANGLI");

		// District
		WebElement selectDistric = driver.findElement(By.id("cityAddressTypeCreation"));
		Select district = new Select(selectDistric);
		district.selectByVisibleText("BANGLI");

		// NIK
		driver.findElement(By.id("nik_id")).sendKeys("821123456789011223");

		// NPWP Type
		WebElement NPWPDropDwn = driver.findElement(By.id("npwp_type"));
		Select NPWPType = new Select(NPWPDropDwn);
		NPWPType.selectByVisibleText("Badan");

		// Image type
		WebElement imageTypeDrpDwn = driver.findElement(By.xpath("//select[@title='File Type is Required']"));
		Select imageType = new Select(imageTypeDrpDwn);
		imageType.selectByVisibleText("Self Portrait Image");

		// Choose File
		String filePath = "C:\\Users\\Admin\\Pictures\\Customer.jpg";
		WebElement chooseFile = driver.findElement(By.xpath("//tbody/tr/td[3]/label[1]/input[1]")); // Only xpath works,
																									// not id
		chooseFile.sendKeys(filePath);

		// Submit
		driver.findElement(By.xpath("//button[@id='sumitUser']")).click();
		Thread.sleep(1000);
		// Ok
		driver.findElement(By.xpath("/html/body/div[8]/div/div/div[2]/button[2]")).click();
		Thread.sleep(2000);
		// Back
		driver.findElement(By.id("confirmActionLink")).click();
		System.out.println("User Created Successfully✔️");
		// Users
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[11]/ul/li[1]/a")).click();

	}
}
