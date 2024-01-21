package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import core.DSL;

public class registrarPage{
	
	
	private DSL dsl;
	public registrarPage(EdgeDriver driver) {
		
		dsl = new DSL(driver);
	}
	
	String botaoRegistrar = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]";
	
	String emailRegisterElement = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input";
	
	String nomeRegisterElement = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[3]/input"; 
	
	String senhaRegisterElement = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input";
	
	String senhaConfimarRegisterElement = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/input";
	
	String botaoCriarComSaldo = "//*[@id=\"toggleAddBalance\"]";
	
	String botaoCadastrar = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button";
	
	String botaoFechar ="btnCloseModal";
	
	String resultadoAcessar = "modalText";
	
	public void setEmail(String email) {
		dsl.escrever(emailRegisterElement, email);
	}

	public void setNome(String nome) {
		dsl.escrever(nomeRegisterElement, nome);
	}
	
	public void setSenha(String senha) {
		dsl.escrever(senhaRegisterElement, senha);
	}
	
	public void setConfirmarSenha(String senhaConfirmar) {
		dsl.escrever(senhaConfimarRegisterElement, senhaConfirmar);
	}
	
	public void setBotaoCriarContaComSaldo() {
		dsl.clicarBotao(botaoCriarComSaldo);
	}
	
	public void cadastrar() {
		dsl.clicarBotao(botaoCadastrar);
	}
	
	public void registrar() {
		dsl.clicarBotao(botaoRegistrar);
	}
	
	public String obterResultadoRegistrar() {
		return dsl.pegarTexto(By.id(resultadoAcessar));	
	}
	public void fechar() {
		dsl.clicarBotaoId(botaoFechar);
	}
}


/*import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;



public class TesteRegistro{
	
	private EdgeDriver driver;
	
	private registrarPage page;
	
	String url = "https://bugbank.netlify.app/#";
	
	@Before
	public void inicializar() {
		
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.edge.driverwhitelistedIps", "C:\\Users\\lucas\\OneDrive\\Área de Trabalho\\msedgedriver.exe");
		driver = new EdgeDriver(options);
		
		driver.get(url);
		dsl = new DSL(driver);
		page = new registrarPage(driver);
		Thread.sleep(2000);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	
	@Test
	public void registrarComSucesso() {
		page.registrar();
	}
	
	
	
	
	
	
}*/