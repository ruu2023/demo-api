package com.luve2code.junitdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
        // System.out.println("@BeforeEach executes before the execution of each test method");
    }

    
    @Test
    @DisplayName("Equals and Not Equals")
    void testEqualsAndNotEqaulas() {

        // System.out.println("Running test : testEqualsAndNotEqaulas");
        
        assertEquals(6, demoUtils.add(2,4), "2 + 4 must be 6");
        assertNotEquals(6, demoUtils.add(1,9), "1 + 9 must not be 6");
    }
    
    @Test
    @DisplayName("Null and Not Null")
    void testNullAndNotNull() {

        // System.out.println("Running test : testNullAndNotNull");

        String str1 = null;
        String str2 = "luve2code";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");

    }

    @DisplayName("Same and Not Same")
    @Test
    void testSameAndNotSame() {

        String str = "Luv2Code";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDupilicate(), "Object should refer to the same object");
        assertNotSame(str, demoUtils.getAcademy(), "Object should not refer to the same object");
    }

    @DisplayName("True and False")
    @Test
    void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");        
    }

    // @AfterEach
    // void tearDownAfterEach() {
    //     System.out.println("Running @AfterEach");
    //     System.out.println();
    // }

    // @BeforeAll
    // static void setupBeforeEachClass() {
    //     System.out.println("@BeforeAll executes once before all test methods in this class");
    // }

    // @AfterAll
    // static void tearDownAfterAll() {
    //     System.out.println("@AfterAll executes once after all test methods in this class");
    // }
}
