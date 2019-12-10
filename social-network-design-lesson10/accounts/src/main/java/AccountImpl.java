import javax.print.DocFlavor;
import java.net.URL;
import java.util.List;

public class AccountImpl implements Account {

    private Integer id;
    private String name;
    private String surname;
    private String nicName;
    private URL avatar;
    private List<Account> friends;

    public List<Account> getFriends() {
        return friends;
    }


    public AccountImpl(Integer id, String name, String surname, String nicName, URL avatar) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nicName = nicName;
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNicName() {
        return nicName;
    }

    public void setNicName(String nicName) {
        this.nicName = nicName;
    }

    public URL getAvatar() {
        return avatar;
    }

    public void setAvatar(URL avatar) {
        this.avatar = avatar;
    }

    @Override
    public void friend(Account newFriend) {
        friends.add(newFriend);
    }

    @Override
    public void unFriend(Account friend) {
        friends.remove(friend);
    }

}

