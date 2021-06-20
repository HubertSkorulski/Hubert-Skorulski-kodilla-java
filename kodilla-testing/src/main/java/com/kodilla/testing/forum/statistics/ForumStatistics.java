package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    int usersCount;
    int usersPosts;
    int usersComments;
    double avgPost;
    double avgComments;
    double comPerPo;

    void calculateAdvStatistics(Statistics statistics) {
        usersCount = statistics.userNames().size();
        usersPosts = statistics.postsCount();
        usersComments = statistics.commentsCount();
        if (usersCount != 0) {
            avgPost = usersPosts / usersCount;
        } else {
            System.out.println("Do not divide by 0");
        }
        if (usersCount !=0) {
            avgComments = usersComments / usersCount;
        } else {
            System.out.println("do not divide by 0");
        }
        if (usersPosts!=0) {
            comPerPo = Math.round(usersComments / usersPosts*100.0)/100.0;
        } else {
            System.out.println("do not divide by 0");
        }
    }
    String showStatistics(){
        return usersCount+ " " + usersPosts+  " " + usersComments+ " " + avgPost+ " " + avgComments+ " " + comPerPo;
    }
}
