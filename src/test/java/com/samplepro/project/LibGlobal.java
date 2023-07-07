package com.samplepro.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LibGlobal {
	
	
	//public static WebDriver driver;
	
	 public static WebDriver driver;
	 

	public static WebDriver launchBrowser(String browser) {
		
		 // launchBrowser(browser);

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("incognito");
				//options.addArguments("--headless");
				driver = new ChromeDriver(options);
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;

	}

	public static void loadUrl(String Url) {
		try {
			driver.get(Url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String getPageText(WebElement e) {
		String txt = null;
		try {
			txt = e.getText();
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		return txt;
	}

	public String getAttributeValue(WebElement e) {
		String value = null;
		try {
			value = e.getAttribute("value");
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		return value;
	}

	public static boolean displayed(WebElement button) {
		boolean displayed = false;
		try {
			displayed = button.isDisplayed();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return displayed;

	}

	public static boolean enabled(WebElement button) {
		boolean enabled = false;
		try {
			enabled = button.isEnabled();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return enabled;
	}

	public boolean selected(WebElement text) {
		boolean selected = false;
		try {
			selected = text.isSelected();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return selected;

	}

	public void setText(WebElement e, String data) {
		try {
			if (enabled(e) && displayed(e)) {
				e.sendKeys(data);
			}

		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}

	}

	public static void btnClick(WebElement element) {
		try {
			if (enabled(element) && displayed(element)) {
				element.click();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String getPageUrl() {
		String Url = null;
		try {
			Url = driver.getCurrentUrl();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return Url;

	}

	public String getPageTitle() {
		String title = null;
		try {
			Thread.sleep(2000);
			title = driver.getTitle();
			return title;
		} catch (Exception e) {
			//System.out.println(e.getMessage());
		}
		return "Title is not found in this page ";

	}

	public String getPageDescription() {
		try {
			Thread.sleep(2000);
			String description = null;
			description = driver.findElement(By.xpath("//meta[@name='description']")).getAttribute("content");
			return description;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		
		}
		return "Description is not found in this page";
		
	}

//	public String getPageCanonical() {
//		try {
//			Thread.sleep(2000);
//			String canonical = null;
//			canonical = driver.findElement(By.xpath("//link[@rel='canonical']")).getAttribute("href");
//			return canonical;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//			System.out.println("canonical is not found in this page");
//		
//		}
//		return "canonical is not found in this page";
//		}
	
	
	public String getPageKeywords() {
		try {
			Thread.sleep(2000);
			String keywords = null;
			keywords=driver.findElement(By.xpath("//meta[@name='keywords']")).getAttribute("content");
			return keywords;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return "Keyword is not found in this page";
	}
	public void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void manageNavigate() {
		try {
			driver.navigate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void manageWindow() {
		try {
			driver.manage();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getWindowHandle() {
		String next = null;
		try {
			next = driver.getWindowHandle();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return next;
	}

	public Set<String> getWindowHandles() {
		Set<String> allWindow = null;
		try {
			allWindow = driver.getWindowHandles();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return allWindow;

	}

	public Alert switchToAlert() {
		Alert al = null;
		try {
			al = switchToTargetElement().alert();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return al;
	}

	public void acceptAlert() {
		try {
			Alert al = switchToAlert();
			al.accept();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void dismissAlert() {
		try {
			Alert al = switchToAlert();
			al.dismiss();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String setValue() {
		String text = null;
		try {
			Alert al = switchToAlert();
			text = al.getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return text;
	}

	public void sendKeys(String data) {
		try {
			Alert al = switchToAlert();
			al.sendKeys(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void mouseOver(WebElement e) {
		try {
			Actions ac = new Actions(driver);
			ac.moveToElement(e).perform();
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
	}

	public void dragAndDropAction(WebElement src, WebElement dest) {
		try {
			Actions ac = new Actions(driver);
			ac.dragAndDrop(src, dest).perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void rightClick(WebElement gmail) {
		try {
			Actions ac = new Actions(driver);
			ac.contextClick(gmail).perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void doubleClick(WebElement page) {
		try {
			Actions ac = new Actions(driver);
			ac.doubleClick(page).perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void performAction() {
		try {
			Actions ac = new Actions(driver);
			ac.perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void selectOptionByIndex(WebElement ele, int index) {
		try {
			Select s = new Select(ele);
			s.selectByIndex(index);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void selectOptionByValue(WebElement ele, int value) {
		try {
			Select s = new Select(ele);
			s.selectByIndex(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void selectOptionByText(WebElement ele, String text) {
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(text);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void deselectOptionByIndex(WebElement ele, int index) {
		try {
			Select s = new Select(ele);
			s.deselectByIndex(index);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void deselectOptionByValue(WebElement ele, int value) {
		try {
			Select s = new Select(ele);
			s.deselectByIndex(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void deselectOptionByVisibleText(WebElement ele, String text) {
		try {
			Select s = new Select(ele);
			s.deselectByVisibleText(text);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<WebElement> getOptionsFromDropDown(WebElement ele) {
		List<WebElement> options = null;
		try {
			Select s = new Select(ele);
			options = s.getOptions();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return options;
	}

	public void getFirstSelectedOption(WebElement ele) {
		Select s = new Select(ele);
		s.getFirstSelectedOption();
	}

	public List<WebElement> getAllSlectedOptions(WebElement ele) {
		List<WebElement> option = null;
		try {
			Select s = new Select(ele);
			option = s.getAllSelectedOptions();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return option;
	}

	public void deselectAllOptions(WebElement ele) {
		try {
			Select s = new Select(ele);
			s.deselectAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean isMultipleSelect(WebElement mulSelect) {
		boolean multiple = false;
		try {
			Select s = new Select(mulSelect);
			multiple = s.isMultiple();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return multiple;
	}

	public Navigation navigate() {
		Navigation navigate = null;
		try {
			navigate = driver.navigate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return navigate;
	}

	public void navigateToUrl(String Url) {
		try {
			navigate().to(Url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void navigateBack() {
		try {
			navigate().back();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void navigateRefersh() {
		try {
			navigate().refresh();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void navigateForward() {
		try {
			navigate().forward();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public TargetLocator switchToTargetElement() {
		TargetLocator switchTo = null;
		try {
			switchTo = driver.switchTo();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return switchTo;
	}

	public void switchTopParentFrame() {
		try {
			switchToTargetElement().parentFrame();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void switchToDirectWebPage() {
		try {
			switchToTargetElement().defaultContent();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void switchToFrameById(String id) {
		try {
			switchToTargetElement().frame(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void switchToFrameByName(String name) {
		try {
			switchToTargetElement().frame(name);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void switchToFrameByIndex(int index) {
		try {
			switchToTargetElement().frame(index);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void switchToFrameByWebElement(WebElement frame1) {
		try {
			switchToTargetElement().frame(frame1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void jsSetText(String data, WebElement e) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value','" + data + "')", e);
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}

	}

	public void Click(WebElement e) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", e);
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}

	}

	public void getAttribute(String s) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("return arguments[0].getAttribute('value')", s);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static  void scrollDown(WebElement e) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", e);

		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
	}

	public void scrollUp(WebElement e) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(false)", e);
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}

	}

	

	public void updateDataInExcel(String sheet, int row, int cell, String value) throws IOException {
		try {
			File excelLoc = new File("C:\\Users\\j416\\eclipse-workspace\\scuf-customerPortal\\excel\\Book2.xlsx");
			FileInputStream stream = new FileInputStream(excelLoc);
			Workbook w = new XSSFWorkbook(stream);
			Sheet s = w.getSheet(sheet);
			Row r = s.getRow(row);
			Cell c = r.createCell(cell);
			c.setCellValue(value);
			FileOutputStream outputstream = new FileOutputStream(excelLoc);
			w.write(outputstream);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void passScreenCapture() throws IOException {
		Date d = new Date();
		System.out.println(d.toString());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(
				"C:\\Users\\j416\\eclipse-workspace\\uat.stfc\\Screenshot\\Screenshot" + sdf.format(d) + ".png"));
	}

	public void failScreenCapture() throws IOException {
		Date d = new Date();
		System.out.println(d.toString());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmss");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File(
				"C:\\Users\\j416\\eclipse-workspace\\uat.stfc\\Screenshot\\Screenshot" + sdf.format(d) + ".png"));

	}
	
	public  void sendemails() { 
        
       // change accordingly 
       final String username = "felix19499@gmail.com"; 
        
       // change accordingly 
       final String password = "thambipapa@1914"; 
        
       // or IP address 
       final String host = "192.23.4.196"; 

       // Get system properties 
       Properties props = new Properties();             
        
       // enable authentication 
       props.put("mail.smtp.auth", host);           
        
       // enable STARTTLS 
       props.put("mail.smtp.starttls.enable", "true");  
        
       // Setup mail server 
       props.put("mail.smtp.host", "smtp.gmail.com");   
        
       // TLS Port 
       props.put("mail.smtp.port", "587");              

       // creating Session instance referenced to 
       // Authenticator object to pass in 
       // Session.getInstance argument 
       Session session = Session.getInstance(props, 
       new javax.mail.Authenticator() { 
            
           //override the getPasswordAuthentication method 
           protected PasswordAuthentication 
                       getPasswordAuthentication() { 
                                        
               return new PasswordAuthentication(username, 
                                               password); 
           } 
       }); 

       try { 
            
           // compose the message 
           // javax.mail.internet.MimeMessage class is 
           // mostly used for abstraction. 
           Message message = new MimeMessage(session);  
            
           // header field of the header. 
           message.setFrom(new InternetAddress("felix19499@gmail.com")); 
            
           message.setRecipients(Message.RecipientType.TO, 
               InternetAddress.parse("edwinraj.raj@gmail.com")); 
           message.setSubject("hello"); 
           message.setText("Yo it has been sent"); 

           Transport.send(message);         //send Message 

           System.out.println("Done"); 

       } catch (MessagingException e) { 
           throw new RuntimeException(e); 
       } 
   } 
	
	
	
}
	
	
	


