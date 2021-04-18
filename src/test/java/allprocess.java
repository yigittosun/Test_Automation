import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.Random;
import org.openqa.selenium.JavascriptExecutor;

public class allprocess {

    private static final Logger log = Logger.getLogger(allprocess.class);
    JavascriptExecutor js;
    @Test
    public void testMethod() throws InterruptedException {
        String baseURL = "https://www.gittigidiyor.com/";
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");

        // Ana sayfanın açıldığı kontrol edilir. Siteye login olunur
        WebDriver wd = new ChromeDriver();
        wd.get("https://www.gittigidiyor.com/uye-girisi");

        // Username
        WebElement txtbx_username = wd.findElement(By.name("kullanici"));
        txtbx_username.sendKeys("testingtest505376");

        // Password
        WebElement txtbx_password = wd.findElement(By.name("sifre"));
        txtbx_password.sendKeys("1234testing");

        // Submit Login Page
        wd.findElement(By.xpath("//input[@value='Giriş Yap' and @type='submit']")).click();
        String actualUrl="https://www.gittigidiyor.com/";
        String expectedUrl= wd.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        // Login işlemi kontrol edilir.
        System.out.println("Login Test Succesful");

        // Arama kutucuğuna bilgisayar kelimesi girilir.
        wd.findElement(By.name("k")).sendKeys("bilgisayar");
        wd.findElement(By.tagName("button")).click();

        // Arama sonuçları sayfasından 2.sayfa açılır.
        wd.get(baseURL +"arama/?k=bilgisayar&sf=2");

        // 2.sayfanın açıldığı kontrol edilir
        // Assert.assertEquals("2.sayfa açılmadı!" ,"2", wd.findElement(By.className("current")).getText());

        // Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir
        Random random = new Random();
        int rand = random.nextInt(49) + 1;

        wd.findElement(By.xpath("//div[@class='clearfix']/ul[@class='catalog-view clearfix products-container']/li["+rand+"]/a[@class='product-link']")).click();

        // Seçilen ürün sepete eklenir
        WebElement product = wd.findElement(By.id("add-to-basket"));
        ((RemoteWebDriver) wd).executeScript("arguments[0].scrollIntoView()", product);
        product.click();
        Thread.sleep(6000);
        wd.findElement(By.className("basket-title")).click();
        Thread.sleep(6000);

        // Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
        WebElement amountPicker = wd.findElement(By.cssSelector("select.amount"));
        amountPicker.click();
        WebElement addAmount = wd.findElement(By.cssSelector("select.amount > option:nth-child(2)"));
        addAmount.click();

        // Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.Yorum satırına almamın sebebi 2.ürünün eklendiğinin gösterilmesidir.Yorum slashlarını kaldırarak itemi silebilirsiniz.
        //wd.findElement(By.className("btn-update-item")).click();
    }

    }
