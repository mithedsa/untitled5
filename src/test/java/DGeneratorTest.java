import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DGeneratorTest extends TestBase{

    @Test
    public void fourthTest(){
        for (int i = 0; i < generateData().size(); i++){

            System.out.println("№" + i + " " + generateData().get(i).getAddText() + " " + generateData().get(i).getKeyWord());

            manager.noteHelper.TextEditCkick();
            manager.noteHelper.clearText();
            manager.noteHelper.TextEdit(generateData().get(i).getAddText());
            manager.noteHelper.KeuWordClick();
            manager.noteHelper.KeuWordEdit(generateData().get(i).getKeyWord());
            manager.noteHelper.SaveBtn();

            manager.noteHelper.selectLastCreatedGroup();
            manager.noteHelper.openSelectedGroup();

            String lastCreatedNoteText = manager.noteHelper.getLastCreatedNoteText();

            Assert.assertEquals(generateData().get(i).getAddText(), lastCreatedNoteText);
        }

//        GroupData data = new GroupData("Всем привет, это моя новая запись в дневнике", "Ключ к новой записи");




    }

    public static ArrayList<GroupData> generateData() {
        ArrayList<GroupData> groupDataList = new ArrayList<GroupData>() {
        };
        try
        {
            File fXmlFile = new File("C:/Users/lika2/IdeaProjects/untitled5/ArrayOfGroupData.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("GroupData");

            for (int temp = 0; temp < nList.getLength(); temp++)
            {
                Node nNode = nList.item(temp);
                    Element eElement = (Element) nNode;

                    String genText = eElement.getElementsByTagName("name").item(0).getTextContent();
                String genKey = eElement.getElementsByTagName("keyword").item(0).getTextContent();
                GroupData groupData = new GroupData(genText,genKey);

                groupDataList.add(groupData);

//                    System.out.println("Текст: " + eElement.getElementsByTagName("name").item(0).getTextContent());
//                    System.out.println("Ключ слово: " + eElement.getElementsByTagName("keyword").item(0).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return groupDataList;
    }

}
