import org.junit.Assert;
import org.junit.Test;


public class BAddNoteTest extends TestBase{

  @Test
  public void secondTest() {

    GroupData data = new GroupData("Всем привет, это моя новая запись в дневнике", "Ключ к новой записи");

    manager.noteHelper.TextEditCkick();
    manager.noteHelper.TextEdit(data.getAddText());
    manager.noteHelper.KeuWordClick();
    manager.noteHelper.KeuWordEdit(data.getKeyWord());
    manager.noteHelper.SaveBtn();

    manager.noteHelper.selectLastCreatedGroup();
    manager.noteHelper.openSelectedGroup();

    String lastCreatedNoteText = manager.noteHelper.getLastCreatedNoteText();

    Assert.assertEquals(data.getAddText(), lastCreatedNoteText);

  }
}
