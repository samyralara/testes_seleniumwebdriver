
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	
	@Test
	public void testeTextField() {
	System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	//driver.get("file:///C:/Users/samyr/Downloads/selenium/campo-treinamento/componentes.html");
	//Assert.assertEquals("Google", driver.getTitle());
	//propriedade dinâmica para pegar onde a pagina esta sendo executada
	driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
	driver.findElement(By.id("elementosForm:nome")).sendKeys("Samyra");
	//o get value pega o valor contido no campo. 
	Assert.assertEquals("Samyra",driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	//driver.quit();
	}

	
	@Test
	public void testeTextArea(){
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//propriedade dinâmica para pegar onde a pagina esta sendo executada
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
		Assert.assertEquals("teste",driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		//driver.quit();
	}
	
	@Test
	public void deveInteragirComRadioButton(){
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//propriedade dinâmica para pegar onde a pagina esta sendo executada
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		//Testar se o radio button foi selecionado
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		System.out.println("OK!");
		//driver.quit();
	}
	
	@Test
	public void deveInteragirComCheckBox(){
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//propriedade dinâmica para pegar onde a pagina esta sendo executada
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		//Testar se o radio button foi selecionado
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		System.out.println("OK!");
		//driver.quit();
	}
	
	@Test
	public void  deveInteragirCombo(){
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		//1 opcao - selecionar a opcao do combo pelo index
		//combo.selectByIndex(2);
		//2 opção - selecionar pelo value
		//combo.selectByValue("2graucomp");
		//3 opção - selecionar pelo texto visível no combo - MAIS RECOMENDADO!
		combo.selectByVisibleText("Superior");
		
		// para verificar o valor selecionado - pega o primeiro valor selecionado
		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
		//driver.quit();
	}
	
	@Test
	public void  deveVerificarValoresCombo(){
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		//Retorna uma lista de webElements (opcoes disponiveis para o select)
		List<WebElement> options = combo.getOptions();
		//Teste para verificar quantidade de opcoes disponiveis no select
		Assert.assertEquals(8, options.size());
		
		//testar se existe alguma opção específica disponível no select
		boolean encontrou = false;
		for(WebElement option : options){
			if(option.getText().equals("Mestrado")){
				encontrou=true;
				break;
			}
		}
	
		Assert.assertTrue(encontrou);
		//
		//driver.quit();
	}
	
	@Test
	public void  deveVerificarValoresComboMultiplo(){
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select (element); 
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("");
		combo.selectByVisibleText("");
	}

}
	

