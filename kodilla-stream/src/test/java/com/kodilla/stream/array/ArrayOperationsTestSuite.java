package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;
import java.util.OptionalDouble;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {
@Test
    void testGetAverage() {
    //Given
    int[] nums = {2,4,2,2,2,2,2,2,2,4,4,4,4,47,3,3,4,2,4,5};
    //When
    double result = ArrayOperations.getAverage(nums);
    //Then
    assertEquals(5.2,result);
}
}
