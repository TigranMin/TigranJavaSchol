import java.util.List;

public interface Community {

    Community communityCreator (String communityName, CommunityType communityType, List<Account> members);

    void addMember (Account newMember);

    void removeMember (Account member);

    void notify (List<Account> members, Post post);

}
