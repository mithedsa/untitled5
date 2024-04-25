import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class HelperBase extends TestBase {
    public ApplicationManager manager;

    public HelperBase(ApplicationManager manager){
        this.manager = manager;
        this.driver = manager.driver;
    }

    public static WebDriver driver;
    public Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}
