package collection;

import org.junit.jupiter.api.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.print("Test case: end\n");
    }
    @DisplayName("when create OddNumbersExterminator with empty list, " +
            "then exterminate method should return empty list"
    )
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        List <Integer> givenNumbers = new ArrayList<>();
        OddNumbersExterminator ext = new OddNumbersExterminator();
        List <Integer> expRes = new ArrayList<>();
        //When
        List<Integer> result = ext.exterminate(givenNumbers);
        //Then
        Assertions.assertEquals(expRes,result);
        System.out.println("Testing if list is empty");
    }

    @DisplayName("when create OddNumbersExterminator with some list, " +
            "then exterminate method should exterminate odd numbers"
    )
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        List <Integer> giNums = new ArrayList<>();
        for (int i = 0; i<8; i++) {
            giNums.add(i);
        }
        //When
        OddNumbersExterminator ext2 = new OddNumbersExterminator();
        List<Integer> newResult = ext2.exterminate(giNums);
        List <Integer> expResult = Arrays.asList(0,2,4,6);
        //Then
        Assertions.assertEquals(expResult,newResult);
        System.out.println("Testing if list contains only even digits");
    }
}
