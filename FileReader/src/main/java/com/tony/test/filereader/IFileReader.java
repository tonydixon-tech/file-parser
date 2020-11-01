/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.test.filereader;

import java.io.FileNotFoundException;

/**
 *
 * @author tonydixon
 */
public interface IFileReader {
    
    /**
     * Parses the file
     * 
     * @param filename 
     * @return  the bytes read
     * @throws java.io.FileNotFoundException 
     */
    public long parse(final String filename) throws FileNotFoundException;
    
    /**
     * Print out the word statistics
     */
    public void print_stats();
    
   
}
