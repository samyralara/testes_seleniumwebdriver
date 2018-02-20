import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	
	@Test
	public void teste() {
		//System.setProperty("webdriver.gecko.driver", "C:/Users/samyr/Downloads/selenium/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		//alterando o tamanho da janela do navegador.
		driver.manage().window().setSize(new Dimension(1200,765));
		
		driver.get("http://www.google.com.br");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
		
	}
	

}
