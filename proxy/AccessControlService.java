import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccessControlService {
    private static AccessControlService instance;
    private final Map<Integer, List<String>> documentPermissions = new HashMap<>();

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void addUserAccess(int documentId, String username) {
        if (documentPermissions.containsKey(documentId)) {
            List<String> names = documentPermissions.get(documentId);
            if (!names.contains(username)) {
                names.add(username);
            }
        } else {
            documentPermissions.put(documentId, new ArrayList<>());
            documentPermissions.get(documentId).add(username);
        }
    }

    public boolean isAllowed(int documentId, String username) {
        if (documentPermissions.containsKey(documentId)) {
            return documentPermissions.get(documentId).contains(username);
        }
        return false;
    }
}
