package com.samplepro.project;



import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
public class AppTest extends LibGlobal
{
	int count = 0;
	static int respCode = 200;
	static HttpURLConnection huc = null;
	LibGlobal lb = new LibGlobal();

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = Excel_utils.getDataFromexcel();
		return testData.iterator();
	}
	@Parameters("browser")
	@BeforeTest
	private void browserExe() {

		launchBrowser("chrome");

	}

	
  
    @Test(dataProvider = "getTestData")
    public void shouldAnswerWithTrue(String INDEX, String PageURL, String Title, String Description, String keywords, String H1Tags)
    		throws Exception{


		Thread.sleep(1000);

        //0-4 second load time is best for conversion rates, 
		//and the first five seconds of page-load time have the highest impact on conversion rates
		long start = System.currentTimeMillis();
		loadUrl(PageURL);
		long ends = System.currentTimeMillis();
		long total = ends - start;
		long loadingtimeinsecond = total / 1000;

		String Seconds = String.valueOf(loadingtimeinsecond);
		String stotal = String.valueOf(total);

		huc = (HttpURLConnection) (new URL(PageURL).openConnection());

		huc.setRequestMethod("GET");

		huc.connect();

		respCode = huc.getResponseCode();
		

		if (respCode != 200) {

			System.out.println(PageURL + " is a broken link" + " " + respCode);
			int parseInt = Integer.parseInt(INDEX);
			Excel_utils.writeinexcel2("INVALID URL", parseInt);
			Excel_utils.writeinexcel3("INVALID URL", parseInt);
			Excel_utils.writeinexcel4("INVALID URL", parseInt);
			Excel_utils.writeinexcel5("INVALID URL", parseInt);
			Excel_utils.writeinexcel6("INVALID URL", parseInt);
			Excel_utils.writeinexcel7("INVALID URL", parseInt);

			Excel_utils.writeinexcel12(respCode, parseInt);

			++count;
			throw new SkipException("skip");

		} else {

			System.out.println(PageURL + " is a valid link" + " " + respCode);
			int parseInt = Integer.parseInt(INDEX);
			Excel_utils.writeinexcel12(respCode, parseInt);

			if (total <= 4000) {

				System.out.println("Page load Second");
				System.out.println("pass");
				System.out.println(Seconds);
				System.out.println(stotal);

			}

		}

		try {
			driver.findElement(By.xpath("//link[@rel='canonical']"));
			int parseInt = Integer.parseInt(INDEX);
			Excel_utils.writeinexcel10("PASS", parseInt);
			System.out.println("canonical is pass");
		} catch (Exception e1) {
			int parseInt = Integer.parseInt(INDEX);
			Excel_utils.writeinexcel10("FAIL", parseInt);

		}
        //H1s are a good indicator of what the most important text on a page is
		// H1 Tag count
		List<WebElement> findElements = driver.findElements(By.tagName("h1"));
		System.out.println("h1 count is:" + "" + findElements.size());
		//Thread.sleep(2000);
		String h1count = String.valueOf(findElements.size());

		if (h1count.isEmpty()) {
			System.out.println(" H1 page not have");
			int parseInt = Integer.parseInt(INDEX);
			
			Excel_utils.writeinexcel9("page not have", parseInt);
		} else if (h1count.length()==1) {
			System.out.println("H1 Pass");
			int parseInt = Integer.parseInt(INDEX);
			Excel_utils.writeinexcel9(h1count, parseInt);
			
		}

		else {
			System.out.println("H1 Fail");
			int parseInt = Integer.parseInt(INDEX);
			Excel_utils.writeinexcel9(h1count, parseInt);
			Excel_utils.writeinexcel8("FAIL", parseInt);
					}
		//Thread.sleep(2000);

		
		
		// second parameter(Title)
		//The title tag and meta description (otherwise known as the “SEO title” and “SEO description”) 
	    //inform Google and other search engines about what the topic of your website is about

		String Actualtitle = driver.getTitle().toLowerCase().trim();
		System.out.println(Actualtitle + "\t" + " --PAGE TITLE ");
		System.out.println(Title + "\t" + "--Excel Data");

		if (Actualtitle.equals(Title.trim())) {
			int parseInt = Integer.parseInt(INDEX);
		
			Excel_utils.writeinexcel2("PASS", parseInt);
			System.out.println("PASS");
		} else {
			int parseInt = Integer.parseInt(INDEX);
			Excel_utils.writeinexcel2("FAIL", parseInt);

			Excel_utils.writeinexcel5(Actualtitle, parseInt);
			System.out.println("FAIL");

		}
		// 3 params(description)

		String pageDescription = lb.getPageDescription().toLowerCase().trim();

		System.out.println(pageDescription + "\t" + " --PAGE DESCRIPTION");
		System.out.println(Description + "\t" + "--Excel Data");

		if (pageDescription.equals(Description.trim())) {

			int parseInt = Integer.parseInt(INDEX);
			Excel_utils.writeinexcel3("PASS", parseInt);
			System.out.println("PASS");

		} else {
			int parseInt = Integer.parseInt(INDEX);
			Excel_utils.writeinexcel3("FAIL", parseInt);
			Excel_utils.writeinexcel6(pageDescription, parseInt);
			System.out.println("FAIL");
		}

		// 4 params (keywords)
		//the words and phrases that searchers enter into search engines to discover content,
		String pageKeywords = lb.getPageKeywords().toLowerCase().trim();

		System.out.println(pageKeywords + "\t" + " --PAGE KEYWORDS");
		System.out.println(keywords + "\t" + "--Excel Data");

		if (pageKeywords.equals(keywords.trim())) {
			int parseInt = Integer.parseInt(INDEX);
			Excel_utils.writeinexcel4("PASS", parseInt);
			// Excel_utils.writeinexcel7(pageKeywords, parseInt);
			System.out.println("PASS");
		} else {
			
			int parseInt = Integer.parseInt(INDEX);
			Excel_utils.writeinexcel4("FAIL", parseInt);
			Excel_utils.writeinexcel7("page not have", parseInt);
			System.out.println("FAIL");

		}
	
		
		//H1 Values validation
		
		String H1tagpage = driver.findElement(By.tagName("h1")).getAttribute("innerHTML").trim().toLowerCase();
		System.out.println(H1tagpage+H1Tags); 
		if (H1tagpage.equals(H1Tags)) {
			int parseInt = Integer.parseInt(INDEX);
			Excel_utils.writeinexcel8("PASS", parseInt);
			System.out.println("h1 value pass");
		}
		else {
			
			
			int parseInt = Integer.parseInt(INDEX);
			Excel_utils.writeinexcel8(H1tagpage, parseInt);
			
			System.out.println("h1 value fail"); 
		}

		// Follow means : page will be crawled.
		// No Follow means : page will not be crawled.
		// Index means : your page show in search Results.
		// No Index means : your page does not show in search Results.
		
		boolean displayed = driver.findElements(By.xpath("//meta[contains(@content,'index, follow')]")).size()>0;
				
		if (displayed) {
		
		  
		System.out.println("Index follow is visble");
			//writeinexcel11
			int parseInt = Integer.parseInt(INDEX);
			Excel_utils.writeinexcel11("Index Follow", parseInt);
		} else {
			
				System.out.println("Noindex nofollow ");
			int parseInt = Integer.parseInt(INDEX); 
			Excel_utils.writeinexcel11("Noindex Nofollow ", parseInt);
			
		}

		try {
			SimpleDateFormat dateformet = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date date = new Date();
			String format = dateformet.format(date);
			int parseInt = Integer.parseInt(INDEX); 
		    Excel_utils.writeinexcel13(format, parseInt);

			System.out.println(++count + "\t" + "is Row is completed." + "\t" + format);
			
				
		} catch (NumberFormatException e) {

			e.printStackTrace();

		}
		
	

	
      
    }
    
    @AfterTest
	public void driver_close() throws InterruptedException {

		//Thread.sleep(2000);
		driver.quit();

}
    
}
