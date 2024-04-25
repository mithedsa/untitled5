import org.junit.Before;

public class TestBase {

    ApplicationManager manager;

    @Before
    public void setUp() {
        manager = ApplicationManager.getInstance();
    }

//    @After
//    public void tearDown() {
//        manager.Stop();
//    }
}
