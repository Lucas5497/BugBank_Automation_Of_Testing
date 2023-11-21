import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class TestesLogin{
	
	private EdgeDriver driver;
	
	private registrarPage page;
	private loginPage pageLogin;
	
	String url = "https://bugbank.netlify.app/#";
	
	@BeforeEach
	public void inicializar() throws InterruptedException {
		
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.edge.driverwhitelistedIps", "C:\\Users\\Acer\\Desktop\\msedgedriver.exe");
		driver = new EdgeDriver(options);
		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.get(url);
		page = new registrarPage(driver);
		pageLogin = new loginPage(driver);
		Thread.sleep(1000);
	}
	
	
	@AfterEach
	public void finaliza() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
		
	@Test
	@DisplayName("Login com sucesso")
	public void loginComSucesso() throws InterruptedException {
	
		page.registrar();
		
		page.setEmail("lucaslopes@mail.com");
		page.setNome("Lucas Lopes");
		page.setSenha("teste123");
		page.setConfirmarSenha("teste123");
		page.setBotaoCriarContaComSaldo();
		page.cadastrar();
		Thread.sleep(1000);
		page.fechar();
		//loginComSucesso();
		pageLogin.setEmail("lucaslopes@mail.com");
		pageLogin.setSenha("teste123");
		
		pageLogin.acessar();
	}
	
	@Test
	@DisplayName("Login com senha incorreta")
	public void loginComSenhaIncorreta() throws InterruptedException {
	
		page.registrar();
		
		page.setEmail("lucaslopes@mail.com");
		page.setNome("Lucas Lopes");
		page.setSenha("teste123");
		page.setConfirmarSenha("teste123");
		page.setBotaoCriarContaComSaldo();
		page.cadastrar();
		Thread.sleep(1000);
		page.fechar();
		//loginComSucesso();
		pageLogin.setEmail("lucaslopes@mail.com");
		pageLogin.setSenha("testes123");
		pageLogin.acessar();
		Thread.sleep(1000);
		//Assertions.assertTrue(pageLogin.obterResultadoAcessar().startsWith("Usuário ou senha inválido."));
		
		page.fechar();
				
	}
	
	@Test
	@DisplayName("Login com email incorreto")
	public void loginComEmailIncorreto() throws InterruptedException {
	
		page.registrar();
		
		page.setEmail("lucaslopes@mail.com");
		page.setNome("Lucas Lopes");
		page.setSenha("teste123");
		page.setConfirmarSenha("teste123");
		page.setBotaoCriarContaComSaldo();
		page.cadastrar();
		Thread.sleep(1000);
		page.fechar();
		//loginComSucesso();
		pageLogin.setEmail("lucaslopes@teste.com");
		pageLogin.setSenha("teste123");
		pageLogin.acessar();
		Thread.sleep(1000);
		Assertions.assertTrue(pageLogin.obterResultadoAcessar().startsWith("Usuário ou senha inválido."));
		
		page.fechar();
				
	}
	
	
}