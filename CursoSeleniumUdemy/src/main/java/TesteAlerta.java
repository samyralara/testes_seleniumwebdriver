import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlerta {
	
	@Test
	public void DeveInteragirComAlertSimples(){
	System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
	driver.findElement(By.id("alert")).click();
	//Muda o foco da tela do teste para a tela do alerta
	Alert alert = driver.switchTo().alert();
	//guardar o texto contido no alerta.
	String textAlert = alert.getText();
	//verificar se o texto do alerta é igual ao informado.
	Assert.assertEquals("Alert Simples", textAlert);
	//selecionar o botão de ok do alerta.
	alert.accept();
	//escrever o conteúdo dentro do alerta num textfield só para verificar
	driver.findElement(By.id("elementosForm:nome")).sendKeys(textAlert);
	driver.quit();
	
	}

	@Test
	public void DeveInteragirComAlertConfirm() {
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("confirm")).click();
		Alert alerta = driver.switchTo().alert();
		// verifica se a mensagem do alerta é a informada.
		Assert.assertEquals("Confirm Simples", alerta.getText());
		// clica no botão de ok
		alerta.accept();
		// confirma a mensagem novamente
		Assert.assertEquals("Confirmado", alerta.getText());
		// clica no botao de ok
		alerta.accept();
		// driver.quit();

		/* Novo bloco para testar clicando o cancelar no alerta */

		driver.findElement(By.id("confirm")).click();
		alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		// para clicar no botão de cancelar
		alerta.dismiss();
		Assert.assertEquals("Negado", alerta.getText());
		alerta.dismiss();

	}
	
	@Test
	public void DeveInteragirComAlertPrompt() {
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("prompt")).click();
		Alert alerta = driver.switchTo().alert();
		//verificando a mensagem no alerta
		Assert.assertEquals("Digite um numero", alerta.getText());
		//escrevendo no alerta
		alerta.sendKeys("24");
		//clicar no ok
		alerta.accept();
		Assert.assertEquals("Era 24?", alerta.getText());
		alerta.accept();
		Assert.assertEquals(":D", alerta.getText());
		alerta.accept();	

	}
}