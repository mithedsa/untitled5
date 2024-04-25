import org.junit.Assert;
import org.junit.Test;

public class CEditNoteTest extends TestBase {

    @Test
    public void thirdTest() {

        GroupData data = new GroupData("Мы изменили запись", "Новое ключевое слово");

        manager.noteHelper.selectLastCreatedGroup();
        manager.noteHelper.openSelectedGroup();

        manager.noteHelper.TextEditCkick();
        manager.noteHelper.clearText();
        manager.noteHelper.TextEdit(data.getAddText());

        manager.noteHelper.SaveBtn();

        manager.noteHelper.selectLastCreatedGroup();
        manager.noteHelper.openSelectedGroup();

        String lastCreatedNoteText = manager.noteHelper.getLastCreatedNoteText();

        Assert.assertEquals(data.getAddText(), lastCreatedNoteText);
    }
}
