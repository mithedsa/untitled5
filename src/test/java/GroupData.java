public class GroupData {
    private String addText;
    private String keyWord;

//обязательный
    public GroupData(String addText, String keyWord) {
        this.addText = addText;
        this.keyWord = keyWord;
    }


    public String getAddText() {
        return addText;
    }

    public void setAddText(String addText) {
        this.addText = addText;
    }

//необязательный
    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

}
