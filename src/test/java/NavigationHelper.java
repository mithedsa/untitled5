import org.openqa.selenium.Dimension;

public class NavigationHelper extends HelperBase {
    public String baseURL;
    ApplicationManager manager;

    public NavigationHelper(ApplicationManager manager, String baseURL) {
        super(manager);
        this.baseURL = baseURL;
    }

    public void SetWindowSize() {
        driver.manage().window().setSize(new Dimension(1550, 838));
    }

    public void OpenHomePage() {
        driver.get(this.baseURL);
    }
}
