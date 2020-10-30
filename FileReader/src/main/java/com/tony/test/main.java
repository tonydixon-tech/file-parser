/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.test;

import com.tony.test.filereader.FileReader;
import com.tony.test.filereader.IFileReader;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tony
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println(args[0]+" "+args[1]);
        IFileReader reader = new FileReader();
        
        try {
            reader.parse(args[1]);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
