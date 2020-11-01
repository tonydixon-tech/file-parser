/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.test.filereader;

import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author tonydixon
 */
public class FileReaderTest {

    public FileReaderTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of newInstance method, of class FileReader.
     */
    @org.junit.jupiter.api.Test
    public void testNewInstance() {
        System.out.println("newInstance");

        FileReader result = FileReader.newInstance();
        assertFalse(result == null);

    }

    /**
     * Test of parse method, of class FileReader.
     * @throws java.lang.Exception
     */
    @org.junit.jupiter.api.Test
    public void testParse() throws Exception {
        System.out.println("parse");
        final String TEST_INPUT = "test.txt";
        
        // Expected text (bytes)
        final long EXPECTED = 50;
        
        File dir = new File(".");
        String path = dir.getCanonicalPath();
        File file = new File(String.format("%s/%s", path, TEST_INPUT));
        
        // System.out.println(file.getAbsolutePath());

        FileReader instance = FileReader.newInstance();
        long bytes = instance.parse(file.getAbsolutePath());
        
        instance.print_stats();   
        
        assertEquals(EXPECTED, bytes, "Error: Bytes read not as expected");
    }

}
