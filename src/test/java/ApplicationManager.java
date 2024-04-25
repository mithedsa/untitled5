import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager  {
    public WebDriver driver;
    public Map<String, Object> vars;
    JavascriptExecutor js;

    public NavigationHelper navigationHelper;
    public LoginHelper loginHelper;
    public NoteHelper noteHelper;


    private static ApplicationManager instance = new ApplicationManager();

    private ApplicationManager(){
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        String baseURL = "https://diary.anek.ws/";


        NavigationHelper navigation = new NavigationHelper(this, baseURL);
        this.navigationHelper = navigation;

        LoginHelper login = new LoginHelper(this);
        this.loginHelper = login;

        NoteHelper note = new NoteHelper(this);
        this.noteHelper = note;

        Destructor.addManagerDestructor(this);

    }

    public WebDriver getDriver() {
        return driver;
    }

    public NavigationHelper getNavigation() {
        return navigationHelper;
    }

    public LoginHelper getLogin() {
        return loginHelper;
    }

    public NoteHelper getNote() {
        return noteHelper;
    }

    public static ApplicationManager getInstance () {
        return instance;
    }

}
