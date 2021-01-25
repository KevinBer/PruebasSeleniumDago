package prueba_selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YoutubeSearchTest {
	private WebDriver driver;
	By searchLocator = By.name("search_query");
	By btnSearchLocator = By.id("search-icon-legacy");
	By selectSongLocator = By.linkText("Ed Sheeran - Afterglow [Official Performance Video]");
	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();// objeto driver de tipo chrome driver
		driver.manage().window().maximize();// le decimos al driver que maximice la ventana utilizando el instanciador
											// de chrome
		driver.get("https://www.youtube.com/");// enviar el enlace al navegador
	}

	@Test
	public void testBuscarYoutube() throws InterruptedException {
		
		driver.findElement(searchLocator).sendKeys("Ed Sheeran");
		Thread.sleep(1000);
		driver.findElement(btnSearchLocator).click();
		Thread.sleep(1000);
		driver.findElement(selectSongLocator).click();
		Thread.sleep(7000);
		
		assertEquals("Ed Sheeran - Afterglow [Official Performance Video] - YouTube", driver.getTitle());
		
		
	}

	
	  @After 
	  public void cerrar() { 
		  driver.quit(); 
	  }
	 

}
