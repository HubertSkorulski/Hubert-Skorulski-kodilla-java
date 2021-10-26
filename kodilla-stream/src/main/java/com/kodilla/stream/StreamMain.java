package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();
        LocalDate date20 = LocalDate.of(LocalDate.now().getYear()-20,LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth()+1);

        Map<Integer,ForumUser> par = forum.getUserList().stream()
                .filter(user -> user.getDateOfBirth().isBefore(date20))
                .filter(user -> user.getSex() == 'M')
                .filter(user -> user.getPostCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user));

        System.out.println("# elements: " + par.size());
        par.entrySet().stream()
                .map(entry -> "ID:" + entry.getKey() + "->" + entry.getValue())
                .forEach(System.out::println);

        System.out.println("Nothing");
    }
}
