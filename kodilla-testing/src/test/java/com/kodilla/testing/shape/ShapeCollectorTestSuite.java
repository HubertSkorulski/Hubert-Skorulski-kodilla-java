package com.kodilla.testing.shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ShapeCollectorTestSuite {
    @Nested
    @DisplayName("Adding & removing")
    class AddRemove {
        @Test
        void testAddShape() {
            //Given
            Shape square = new Square("Kwadrat", 40.5);
            ShapeCollector collector = new ShapeCollector();
            //When
            collector.addFigure(square);
            //Then
            Assertions.assertEquals(square, collector.getFigure(0));
        }


        @Test
        void testRemoveShape() {
            //Given
            Shape square = new Square("Kwadrat", 40.5);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(square);
            //When
            System.out.println(collector.showFigures());
            boolean result = collector.removeFigure(square);
            //Then
            Assertions.assertTrue(result);
            System.out.println(collector.showFigures()+"Jesli wyswietla sie tylko ten napis znaczy ze dziala");

        }
    }


    @Nested
    @DisplayName("Showing & getting")
    class ShowGet {
        @Test
        void testGetFigure() {
            //Given
            Shape square = new Square("Kwadrat", 40.5);
            Shape triangle = new Triangle("Trojkat", 30);
            ShapeCollector collector = new ShapeCollector();
            //When
            collector.addFigure(square);
            collector.addFigure(triangle);
            //Then
            Assertions.assertEquals(triangle, collector.getFigure(1));
        }

        @Test
        void testShowFigures () {
            //Given
            Square square = new Square("Kwadrat", 40.5);
            Triangle triangle = new Triangle("Trojkat", 30);
            ShapeCollector collector = new ShapeCollector();
            //When
            collector.addFigure(square);
            collector.addFigure(triangle);
            //Then
            Assertions.assertEquals("KwadratTrojkat", collector.showFigures());
        }
    }


}
