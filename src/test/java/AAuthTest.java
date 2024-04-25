import org.junit.Assert;
import org.junit.Test;

public class AAuthTest extends TestBase{
    @Test
    public void firstTest() throws InterruptedException {
        manager.navigationHelper.OpenHomePage();
        manager.navigationHelper.SetWindowSize();

        AccountData user = new AccountData("mithedsa", "qw5172718");

        manager.loginHelper.LoginFielsClick();
        manager.loginHelper.LoginField(user.getUsername());
        manager.loginHelper.PasswordFieldClick();
        manager.loginHelper.PasswordField(user.getPassword());

        manager.loginHelper.AuthBtn();
        Thread.sleep(2000);

        String userName = manager.loginHelper.assertUsername();

        Assert.assertEquals(user.getUsername(), userName);

    }
}
