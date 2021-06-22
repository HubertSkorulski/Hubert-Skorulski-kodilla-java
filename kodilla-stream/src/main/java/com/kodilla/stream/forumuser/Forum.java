package com.kodilla.stream.forumuser;


import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> theUserList = new ArrayList<>();

    public List<ForumUser> getUserList() {
        theUserList.add(new ForumUser(1,"Tomek",'M',1995,8,14,4));
        theUserList.add(new ForumUser(2,"Romek",'M',2001,6,22,3));
        theUserList.add(new ForumUser(3,"Atomek",'M',1999,8,14,0));
        theUserList.add(new ForumUser(4,"Basia",'F',1994,8,14,0));
        return new ArrayList<>(theUserList);
    }

}
