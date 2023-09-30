import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class loginPage{
	
	private DSL dsl;
	
	public loginPage(EdgeDriver driver) {
		dsl = new DSL(driver);
	}
	
	String emailElement = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[1]/input";
	
	
	String senhaElement = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[2]/div/input";
	
	String acessarBotaoElement = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[1]";
	
	
	String registrarBotaoElement ="//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]";
	
	String resultadoAcessar = "modalText";
	
	public void setEmail(String email) {
		dsl.escrever(emailElement, email);
	}
	
	public void setSenha(String senha) {
		dsl.escrever(senhaElement, senha);
	}
	
	public void acessar() {
		dsl.clicarBotao(acessarBotaoElement);
	}
	
	public void registrar() {
		dsl.clicarBotao(registrarBotaoElement);
	}
	
	public String obterResultadoAcessar() {
		return dsl.pegarTexto(By.id(resultadoAcessar));	
	}
	
	/*public String obterResultadoAcessar1() {
		return dsl.obterValueElemento(resultadoAcessar);
				
	}*/
	
	
}