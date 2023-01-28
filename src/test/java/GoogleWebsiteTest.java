import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class GoogleWebsiteTest {
    ChromeDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
       // driver.manage().window().maximize();
    }
    @Test
    public void SearchBoxIsDisplayed(){
        WebElement searchBox = driver.findElement(By.name("search"));
        Assert.assertTrue(searchBox.isEnabled());
        System.out.println("SearchBooksIsDisplayed");
    }
    @Test
    public void SearchButtonTextIsCorrect(){

       WebElement searchButton = driver.findElement(By.id("search_header_mobile"));
        Assert.assertTrue(searchButton.isEnabled());
        System.out.println("SearchButtonIsCorrect");

        WebElement category = driver.findElement(By.className("img-fluid"));
        System.out.println(category.getSize());

        WebElement dollar = driver.findElement(By.id("dropdownMenuButton"));
        System.out.println(dollar.getSize());

    }

    @Test(priority = 3)
    public void searchButtonTextIsCorrect(){
      String expected = "بحث Google\u200F";
      String name = "btnK";
      WebElement searchBox = driver.findElementsByName(name).get(0);
      String actual = searchBox.getAttribute("value");
      Assert.assertEquals(actual, expected);
    }

    @Test(priority = 4)
    public void gmailLinkIsDisplayed(){
        WebElement gmail = driver.findElement(By.className("gb_d"));
        Assert.assertEquals(gmail.getText(),"Gmail");
        System.out.println(gmail.getText());
        System.out.println(gmail.getSize());
        gmail.click();

        WebElement buttonCreate = driver.findElement(By.className("mobile-tablet-only"));
        Assert.assertTrue(buttonCreate.isEnabled());
    }
    @Test(priority = 5)
    public void imagesLinkIsDisplayed(){
        WebElement imagesLink = driver.findElement(By.partialLinkText("صو"));
        Assert.assertEquals(imagesLink.getText(),"صور");
        imagesLink.click();

    }
}


//public class GoogleWebsiteTest {
//    ChromeDriver driver;
//
//    @BeforeClass
//    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.get("https://souq.mycn.io/ar");
//        // driver.manage().window().maximize();
//    }
//    @Test (priority = 1)
//    public void test0(){
//        System.out.println("test0");
//        Assert.assertEquals(true, true);
//    }
//    @Test (priority = 2)
//    public void test1(){
//        System.out.println("test1");
//        Assert.assertEquals(true, true);
//    }
//    @Test
//    public void SearchBoxIsDisplayed(){
//        WebElement searchBox = driver.findElement(By.name("search"));
//        Assert.assertTrue(searchBox.isEnabled());
//        System.out.println("SearchBooksIsDisplayed");
//    }
//    @BeforeMethod
//    public void WaitSeconds() throws InterruptedException {
//        Thread.sleep(2000);
//    }
//    @Test
//    public void SearchButtonTextIsCorrect(){
//
//        WebElement searchButton = driver.findElement(By.id("search_header_mobile"));
//        Assert.assertTrue(searchButton.isEnabled());
//        //   Assert.assertEquals(searchButton.getText(),"ضربة حظ");
//        searchButton.sendKeys("ml");
//        searchButton.sendKeys(Keys.ENTER);
//        System.out.println("SearchButtonIsCorrect");
//
//        WebElement category = driver.findElement(By.className("img-fluid"));
//        System.out.println(category.getSize());
//
//        WebElement dollar = driver.findElement(By.id("dropdownMenuButton"));
//        System.out.println(dollar.getSize());
//
//    }
//    @Test(priority = 3)
//    public void englishLanguageEnabled(){
//        WebElement englishLanguage = driver.findElement(By.className("language-link"));
//        Assert.assertTrue(englishLanguage.isEnabled());
//        System.out.println("englishLanguageEnabled");
//        System.out.println(englishLanguage.getAttribute("value"));
//        Assert.assertNotNull(englishLanguage.getText());
//        driver.navigate().to("https://souq.mycn.io/en");
//    }
//}
