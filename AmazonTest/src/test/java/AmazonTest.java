import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;

public class AmazonTest {
    static ChromeDriver driver = new ChromeDriver();
    public static void main(String[] args) {
        driver.navigate().to("https://www.amazon.com/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("iphone");
        driver.findElement(By.cssSelector("input[id='nav-search-submit-button']")).click();
        driver.findElement(By.linkText("Apple iPhone 12, 64GB, Green - Unlocked (Renewed Premium)")).click();

        //Añadir al carro
//        boolean cart = driver.findElement(By.cssSelector("input[id='add-to-cart-button']")).isDisplayed();
        driver.findElement(By.cssSelector("input[id='add-to-cart-button']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        if(cart){
//            System.out.println("Boton 'Add to Cart' está visible");
//        } else{
//            System.out.println("Boton 'Add to Cart' no está visible");
//            driver.navigate().back();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//            driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[11]")).click();
//       }

        //Ir al carro
            driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //Validaciones
        String price = driver.findElement(By.cssSelector("span[class*='sc-product-price']")).getText();
        String total = driver.findElement(By.cssSelector("span[id='sc-subtotal-amount-buybox'] span")).getText();
        System.out.println(price);
        System.out.println(total);
        if(Objects.equals(price, total)){
            System.out.println("Se muestra el precio total del articulo agregado");
        } else{
            System.out.println("No se muestra el precio total del articulo agregado");
        }

        boolean items = driver.findElement(By.xpath("//*[@id=\"nav-cart-count\"]")).getText().contains("1");
        boolean quantity = driver.findElement(By.cssSelector("span[class*='a-dropdown-prompt']")).getText().contains("1");

        if(items && quantity){
            System.out.println("Se muestra indicado el articulo agregado");
        } else{
            System.out.println("No se muestra indicado el articulo agregado");
        }

        driver.close();
    }
}
