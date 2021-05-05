package Lesson4_HW;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {
    Triangle triangle;
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAll() {
        logger.info("To be executed before all tests");
    }

    @BeforeEach
    public void startTesting() {
        logger.info("Test started");
    }

        @Test
        @DisplayName("Triangle can be designed")
        void initialPositiveTest () {
            triangle = new Triangle(1, 1, 1);
        }

        @ParameterizedTest
        @CsvSource({"3, 4, 5, 6.000"})
        @DisplayName("Calculation is possible - valid triangle")
        void validTriangleTest ( int a, int b, int c, double result){
            triangle = new Triangle(a, b, c);
            double area = Triangle.getArea(3, 4, 5);
            Assertions.assertEquals(area, result);
        }

        @ParameterizedTest
        @CsvSource({"1, 0, 1, 0"})
        @DisplayName("The calculation cannot be executed - one of the sides equals 0")
        void zeroSideTest ( int a, int b, int c){
            triangle = new Triangle(a, b, c);
            double area = Triangle.getArea(1, 0, 1);
            Assertions.assertEquals(area, 0.0);
        }

    @Test
    @DisplayName("The calculation cannot be executed - one of the sides is the same length as the sum of two other sides")
    void StraightLineInsteadOfTriangleTest () {
        triangle = new Triangle(1, 2, 3);
        double area = Triangle.getArea(1, 2, 3);
        Assertions.assertEquals(area, 0.0);
    }

        @ParameterizedTest
        @CsvSource({"1, 1, -1"})
        @DisplayName("The calculation cannot be executed - one of the sides is negative")
        void negativeSideTest ( int a, int b, int c){
            triangle = new Triangle(a, b, c);
            double area = Triangle.getArea(1, 1, -1);
            Assertions.assertEquals(area, 0.0);
        }

        @Test
        @DisplayName("The calculation cannot be executed - one of the sides is longer than the sum of two other sides")
        void LongerSideTriangleTest () {
            triangle = new Triangle(1, 2, 4);
            double area = Triangle.getArea(1, 2, 4);
            Assertions.assertEquals(area, 0.0);
        }

        @AfterAll
        static void finishTesting () {
            logger.info("The testing is finished");
        }
    }