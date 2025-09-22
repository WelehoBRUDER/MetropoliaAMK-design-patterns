import java.util.HashMap;
import java.util.Map;

public class Library {
    private AccessControlService accessControlService;
    private Map<Integer, DocumentInterface> documents;

    public Library() {
        this.accessControlService = AccessControlService.getInstance();
        this.documents = new HashMap<>();
    }

    public void createUnprotectedDocument(String content) {
        Document document = new Document(content);
        this.documents.put(document.getId(), document);
    }

    public void createProtectedDocument(String content) {
        Document document = new Document(content);
        DocumentProxy documentProxy = new DocumentProxy(document);
        this.documents.put(document.getId(), documentProxy);
    }

    public void giveAccess(int documentId, String username) {
        accessControlService.addUserAccess(documentId, username);
    }

    public DocumentInterface getDocument(int documentId) {
        return this.documents.get(documentId);
    }
}
