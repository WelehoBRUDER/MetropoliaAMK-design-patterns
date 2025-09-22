import java.util.Date;

public class Document implements DocumentInterface {
    private int id;
    private Date creationDate;
    private String content;
    private static int idCounter = 0;

    public Document(String content) {
        this.id = idCounter++;
        this.creationDate = new Date();
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return content;
    }

}
