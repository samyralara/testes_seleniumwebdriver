package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/*Teste de cadastro de conta Gmail*/

public class CadastroPage {

	static WebDriver driver;
	
	public CadastroPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void PreencherCampos(){
		WebElement nome = driver.findElement(By.id("FirstName"));
		nome.sendKeys("Samyra Lara");
		WebElement sobrenome = driver.findElement(By.id("lastname-label"));
		sobrenome.sendKeys("Almeida");
		WebElement nome_usuario = driver.findElement(By.id("GmailAddress"));
		nome_usuario.sendKeys("samyraalmeida");
		WebElement senha = driver.findElement(By.id("Passwd"));
		senha.sendKeys("12345");
		WebElement confirmar_senha = driver.findElement(By.id("PasswdAgain"));
		confirmar_senha.sendKeys("12345");
		WebElement dataNascimento = driver.findElement(By.id("BirthDay"));
		dataNascimento.sendKeys("12");
		
		//Campo select mês
		WebElement campo_mes = driver.findElement(By.xpath(".//*[@id='BirthMonth']/div[1]"));
		campo_mes.click();
		//busca o elemento setembro pelo xpath no select
		WebElement mes_nascimento = driver.findElement(By.xpath(".//*[@id=':9']/div"));
		mes_nascimento.click();
		
		WebElement ano_nascimento = driver.findElement(By.id("BirthYear"));
		ano_nascimento.sendKeys("1988");
		
		WebElement sexo = driver.findElement(By.xpath(".//*[@id='Gender']/div[1]"));
		sexo.click();
		WebElement sexo_escolhido = driver.findElement(By.xpath(".//*[@id=':e']/div"));
		sexo_escolhido.click();
		
		WebElement numero_celular = driver.findElement(By.id("RecoveryPhoneNumber"));
		numero_celular.sendKeys("83999999999");
		
		WebElement email_atual = driver.findElement(By.id("RecoveryEmailAddress"));
		email_atual.sendKeys("samyra@gmail.com");
		
		WebElement salvar = driver.findElement(By.id("submitbutton"));
		salvar.click();   
		
	}

}
