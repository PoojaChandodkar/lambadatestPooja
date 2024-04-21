package Pooja.PoojaLambdaTest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Hello World!" );
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options); 
        
//     Statement 1
        
    driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.findElement(By.xpath("//a[contains(text(),\'Simple Form Demo\')]")).click();
        String CurrentURL= driver.getCurrentUrl();
       System.out.println(CurrentURL);
       assertTrue(CurrentURL.contains("simple-form-demo"));
       String Text= "Welcome to LambdaTest";
       driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(Text);
        driver.findElement(By.xpath("//button[contains(text(),'Get Checked Value')]")).click();
        String displayedmessage= driver.findElement(By.xpath("//p[@id='message']")).getText();
      Assert.assertEquals(Text,displayedmessage);
      
        
//        Statement2
      driver.get("https://www.lambdatest.com/selenium-playground/");
      driver.findElement(By.xpath("//a[contains(text(),'Drag & Drop Sliders')]")).click(); 
      Actions builder = new Actions(driver);
   
      int increase=175;
     
      
      for( int value=15; value<=95; value++) {
    	  String value1=driver.findElement(By.xpath("//output[@id='rangeSuccess']")).getText();
    	 	 value=Integer.parseInt(value1);
    	 	 if(value==95){
    	 	 System.out.println("slider moved to value 95");
    	 	 break;}
    	 System.out.println(value);
    	 WebElement sliderlocation =driver.findElement(By.xpath("//input[@value='15']"));
    	 Thread.sleep(2000);
    	
    	 System.out.println(increase);
    	 builder.dragAndDropBy(sliderlocation, increase, 0).build().perform();
    	increase= increase+3;
      }
      
        
//        Statement3
      
      driver.get("https://www.lambdatest.com/selenium-playground/");
      driver.manage().window().maximize();
      driver.findElement(By.xpath("//a[contains(text(),'Input Form Submit')]")).click(); 
      
    driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click(); 
    String assertmessage= "Please fill in the fields.";
    String errormessage = driver.findElement(By.id("name")).getAttribute("validationMessage");
    SoftAssert softly = new SoftAssert();
    
    
    softly.assertEquals(assertmessage,errormessage);
    	

    
     

      driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Pooja");
      driver.findElement(By.xpath("//input[@id='inputEmail4']")).sendKeys("PoojaChandodkar@gmail.com");
      driver.findElement(By.xpath("//input[@id='inputPassword4']")).sendKeys("Pooja123");
      driver.findElement(By.xpath("//input[@id='inputCity']")).sendKeys("CT");
      
      driver.findElement(By.xpath("//input[@id='inputAddress2']")).sendKeys("Park road");
      driver.findElement(By.xpath("//input[@id='inputAddress1']")).sendKeys("101 deccan building ");
      driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Power-Company ");
      driver.findElement(By.xpath("//input[@id='websitename']")).sendKeys("https://www.lambdatest.com/selenium-playground/input-form-demo ");
      
      WebElement dropdown = driver.findElement(By.xpath("//select[@name='country']"));
      
      
      Select select= new Select(dropdown);
      select.selectByValue("US");
      driver.findElement(By.xpath("//input[@id='inputState']")).sendKeys("Hardford ");
      driver.findElement(By.xpath("//input[@id='inputZip']")).sendKeys("553421 ");
 driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
 String Succesmessage= "Thanks for contacting us, we will get back to you shortly.";

 String displayedSmessage= driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText();
Assert.assertEquals(Succesmessage,displayedSmessage);
      
    }
}
