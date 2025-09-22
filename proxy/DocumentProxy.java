import java.util.Date;

public class DocumentProxy implements DocumentInterface {
    private int  id;
    private Date creationDate;
    private Document document;
    private AccessControlService accessControlService;

    public DocumentProxy(Document document) {
        this.id = document.getId();
        this.creationDate = document.getCreationDate();
        this.document = document;
        this.accessControlService = AccessControlService.getInstance();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        System.out.println("User " + user.getUsername() + " attempting to access document " + this.getId());
        if (accessControlService.isAllowed(this.getId(), user.getUsername())) {
            System.out.print("[ACCESS GRANTED] ");
            return document.getContent(user);
        }
        throw new AccessDeniedException("User " + user.getUsername() + " does not have permission to view document " + this.getId());
    }
}
