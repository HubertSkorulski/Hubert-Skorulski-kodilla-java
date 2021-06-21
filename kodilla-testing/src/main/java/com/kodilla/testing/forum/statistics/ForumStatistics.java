package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    double usersCount;
    double usersPosts;
    double usersComments;
    double avgPost;
    double avgComments;
    double comPerPo;

    void calculateAdvStatistics(Statistics statistics) {
        usersCount = (double)statistics.userNames().size();
        usersPosts = (double)statistics.postsCount();
        usersComments = (double)statistics.commentsCount();
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
            comPerPo = usersComments / usersPosts;
        } else {
            System.out.println("do not divide by 0");
        }
    }
    String showStatistics(){
        return usersCount+ " " + usersPosts+  " " + usersComments+ " " + avgPost+ " " + avgComments+ " " + comPerPo;
    }
}
