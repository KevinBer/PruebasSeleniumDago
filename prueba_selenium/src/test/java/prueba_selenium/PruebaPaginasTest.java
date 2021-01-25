package prueba_selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PruebaPaginasTest {
	private WebDriver driver;
	By userNameLocator = By.name("carne");
	By passwordLocator = By.name("pin");
	By sigPassBtnLocator = By.name("crudMethod");
	By logoutLocator = By.linkText("Salir");
	By datosLocator = By.linkText("Datos Personales");
	By direccionLocator = By.name("direccion");
	By btnActualizarLocator = By.className("button-submit");
	

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();// objeto driver de tipo chrome driver
		driver.manage().window().maximize();// le decimos al driver que maximice la ventana utilizando el instanciador
											// de chrome
		driver.get("https://ematricula.ucr.ac.cr/ematricula/");

	}

	@Test
	public void testLogin() throws InterruptedException {

		if (driver.getTitle().equalsIgnoreCase("Ingreso al sistema")) {
			driver.findElement(userNameLocator).sendKeys("B30957");
			Thread.sleep(1000); // para dar tiempo de espera de respuesta de la pagina
			driver.findElement(passwordLocator).sendKeys("Kevin1128!");
			Thread.sleep(1000); // para dar tiempo de espera de respuesta de la pagina
			driver.findElement(sigPassBtnLocator).click();
			Thread.sleep(3000); // para dar tiempo de espera de respuesta de la pagina
			driver.findElement(datosLocator).click();
			driver.findElement(direccionLocator).clear();
			Thread.sleep(2000); // para dar tiempo de espera de respuesta de la pagina
			driver.findElement(direccionLocator)
					.sendKeys("50 metros oeste de pulperia la deportiva, alto salas, casa a mano izquierda");
			Thread.sleep(2000); // para dar tiempo de espera de respuesta de la pagina
			driver.findElement(btnActualizarLocator).click();
			assertEquals("Actualización de datos personales", driver.getTitle());
			Thread.sleep(3000); // para dar tiempo de espera de respuesta de la pagina
		
			driver.findElement(logoutLocator).click();
			

		} else
			System.out.print("Página de Ingreso no disponible");

	}

	@Test
	public void testLogout() throws InterruptedException {
		driver.findElement(userNameLocator).sendKeys("B30957");
		Thread.sleep(1000); // para dar tiempo de espera de respuesta de la pagina
		driver.findElement(passwordLocator).sendKeys("Kevin1128!");
		driver.findElement(sigPassBtnLocator).click();
		driver.findElement(logoutLocator).click();
		Thread.sleep(2000); // para dar tiempo de espera de respuesta de la pagina
		assertEquals("Ingreso al sistema", driver.getTitle());

	}

	@After
	public void cerrar() {
		driver.quit();
	}

}
