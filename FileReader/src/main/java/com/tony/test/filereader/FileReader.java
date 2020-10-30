/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.test.filereader;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author tonydixon
 */
public class FileReader implements IFileReader{

    @Override
    public void parse(String filename) {try{
         = new Scanner(new File(filename));
    }


    
}
