import java.net.URL;
import java.util.List;

public interface Chat {

    Chat chatCreator (Account account);

    Chat groupChatCreator (List<Account> accounts);

    void endChat (Chat chat);

    void deleteChat (Chat chat);

    void forwardMessage (String message, Account account);

    void sendImg (URL url, Account account);

    void sendVideo (URL url, Account account);

}
