public interface Search {

    Account accountSearch (String name);

    Post postSearch (String postTitle);

    Community communitySearch (String communityName);

    Object allSearch (String searchObjectName);

}
