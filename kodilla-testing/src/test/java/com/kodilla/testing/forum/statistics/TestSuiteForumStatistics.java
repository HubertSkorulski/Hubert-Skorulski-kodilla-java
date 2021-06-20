package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestSuiteForumStatistics {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @Mock
    private Statistics statisticsMock;
    @DisplayName("Posts =0")
    @Test
    void testCalculateAdvStatisticsP0() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> users = new ArrayList<>();
        users.add("Kot");
        users.add("Pies");
        when(statisticsMock.userNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(4);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(0,forumStatistics.avgPost);
        Assertions.assertEquals(2,forumStatistics.avgComments);
        Assertions.assertEquals(0,forumStatistics.comPerPo);


    }
    @DisplayName("Posts = 1000")
    @Test
    void testCalculateAdvStatisticsP1000() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> users = new ArrayList<>();
        users.add("Kot");
        users.add("Pies");
        when(statisticsMock.userNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(4);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(500,forumStatistics.avgPost);
        Assertions.assertEquals(2,forumStatistics.avgComments);
        Assertions.assertEquals(0.004,forumStatistics.comPerPo,0.004);

    }
    @DisplayName("Comments = 0")
    @Test
    void testCalculateAdvStatisticsC0() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> users = new ArrayList<>();
        users.add("Kot");
        users.add("Pies");
        when(statisticsMock.userNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(4);
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(2,forumStatistics.avgPost);
        Assertions.assertEquals(0,forumStatistics.avgComments);
        Assertions.assertEquals(0,forumStatistics.comPerPo);

    }
    @DisplayName("Posts > Comments")
    @Test
    void testCalculateAdvStatisticsPC() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> users = new ArrayList<>();
        users.add("Kot");
        users.add("Pies");
        when(statisticsMock.userNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(50,forumStatistics.avgPost);
        Assertions.assertEquals(25,forumStatistics.avgComments);
        Assertions.assertEquals(0.5,forumStatistics.comPerPo, 0.5);

    }
    @DisplayName("Comments > Posts")
    @Test
    void testCalculateAdvStatisticsCP() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> users = new ArrayList<>();
        users.add("Kot");
        users.add("Pies");
        when(statisticsMock.userNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(100);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(25,forumStatistics.avgPost);
        Assertions.assertEquals(50,forumStatistics.avgComments);
        Assertions.assertEquals(2,forumStatistics.comPerPo);

    }
    @DisplayName("Users = 0")
    @Test
    void testCalculateAdvStatisticsU0() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> users = new ArrayList<>();
        users.add("Kot");
        users.add("Pies");
        when(statisticsMock.userNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(4);
        when(statisticsMock.commentsCount()).thenReturn(4);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(2,forumStatistics.avgPost);
        Assertions.assertEquals(2,forumStatistics.avgComments);
        Assertions.assertEquals(1,forumStatistics.comPerPo);

    }
    @DisplayName("Users = 1000")
    @Test
    void testCalculateAdvStatisticsU1000() {


        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> users = new ArrayList<>();
        for (int i = 0; i<1000; i++) {
            users.add("user"+i);
        }
        when(statisticsMock.userNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(4000);
        when(statisticsMock.commentsCount()).thenReturn(4000);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(4,forumStatistics.avgPost);
        Assertions.assertEquals(4,forumStatistics.avgComments);
        Assertions.assertEquals(1,forumStatistics.comPerPo);
    }

}
