import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NoteHelper extends HelperBase {
    ApplicationManager manager;

    public NoteHelper(ApplicationManager manager) {
        super(manager);
    }

    public void SaveBtn() {
        driver.findElement(By.id("btn_save")).click();
    }

    public void KeuWordEdit(String keyWord) {
        driver.findElement(By.name("Word[]")).sendKeys(keyWord);
    }

    public void KeuWordClick(){
        driver.findElement(By.name("Word[]")).click();
    }

    public void TextEdit(String addText) {
        driver.findElement(By.id("DiText")).sendKeys(addText);
    }

    public void TextEditCkick() {
        driver.findElement(By.id("DiText")).click();
    }

    public void selectLastCreatedGroup() {
        driver.findElement(By.linkText("Все записи")).click();
    }

    public void openSelectedGroup() {
        driver.findElement(By.linkText("Править")).click();
    }

    public void clearText() {
        driver.findElement(By.id("DiText")).clear();
    }


    public String getLastEditNote() {
        WebElement noteElement = driver.findElement(By.xpath("(//div[contains(@class, 'dt')])[last()]"));
        return noteElement.getText();
    }

    public String getLastCreatedNoteText() {
        WebElement noteElement = driver.findElement(By.cssSelector("#DiText"));
        return noteElement.getText();
    }



}
