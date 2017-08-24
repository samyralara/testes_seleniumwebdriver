package teste;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.CadastroPage;

public class CadastroTeste {

	static WebDriver driver;
	static CadastroPage cadastroPage;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com/SignUp");
		cadastroPage = new CadastroPage(driver);
	} 


	@Test
	public void test() {
		cadastroPage.PreencherCampos();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		//fecha apenas a aba que usou
		driver.close();
		
		//fecha o navegador e mata a sessão
		//driver.quit();
	}	
	
}
