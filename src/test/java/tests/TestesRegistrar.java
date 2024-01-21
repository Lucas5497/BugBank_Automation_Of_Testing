package tests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import pages.registrarPage;


public class TestesRegistrar{
	
	private EdgeDriver driver;
	
	private registrarPage page;
	String url = "https://bugbank.netlify.app/#";
	
	@BeforeEach
	public void inicializar() throws InterruptedException {
		
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.edge.driverwhitelistedIps", "C:\\Users\\Acer\\eclipse-workspace\\BugBank_Automation_Of_Testing\\msedgedriver.exe");
		driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.get(url);
		page = new registrarPage(driver);
		Thread.sleep(1000);
	}
	
	
	@AfterEach
	public void finaliza() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	@DisplayName("Registrar conta com sucesso")
	public void registrtarContaComSucesso() throws InterruptedException {
		page.registrar();
		
		page.setEmail("lucaslopes@mail.com");
		page.setNome("Lucas Lopes");
		page.setSenha("teste123");
		page.setConfirmarSenha("teste123");
		//page.setBotaoCriarContaComSaldo();
		page.cadastrar();
		Thread.sleep(1000);
		page.fechar();
	}
	
	@Test
	@DisplayName("Registrar conta com saldo")
	public void registrarContaComSaldo() throws InterruptedException {
		page.registrar();
		
		page.setEmail("lucaslopes@mail.com");
		page.setNome("Lucas Lopes");
		page.setSenha("teste123");
		page.setConfirmarSenha("teste123");
		page.setBotaoCriarContaComSaldo();
		page.cadastrar();
		Thread.sleep(1000);
		page.fechar();
		
	}
	
	@Test
	@DisplayName("Registrar conta com senhas diferentes")
	public void registrarContaComSenhasDiferentes() throws InterruptedException {
		page.registrar();
		
		page.setEmail("lucaslopes@mail.com");
		page.setNome("Lucas Lopes");
		page.setSenha("teste123");
		page.setConfirmarSenha("teste456");
		page.setBotaoCriarContaComSaldo();
		page.cadastrar();
		Thread.sleep(1000);
		Assertions.assertTrue(page.obterResultadoRegistrar().startsWith("As senhas não são iguais."));
		System.out.println(page.obterResultadoRegistrar());
		
		page.fechar();
	}
	
	@Test
	@DisplayName("Registrar conta com nome vazio")
	public void registrarContaComNomeVazio() throws InterruptedException {
		page.registrar();
		
		page.setEmail("lucaslopes@mail.com");
		page.setNome("");
		page.setSenha("teste123");
		page.setConfirmarSenha("teste123");
		page.setBotaoCriarContaComSaldo();
		page.cadastrar();
		Thread.sleep(1000);
		Assertions.assertTrue(page.obterResultadoRegistrar().startsWith("Nome não pode ser vazio."));
		System.out.println(page.obterResultadoRegistrar());
		
		page.fechar();
		
	}
	
}