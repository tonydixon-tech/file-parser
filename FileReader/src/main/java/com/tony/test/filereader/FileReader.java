/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tony.test.filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tonydixon
 */
public class FileReader implements IFileReader {

    // Keeps count of word length
    private ArrayList<Integer> record;

    // maximum word length
    private static final int MAX_LENGTH = 50;

    // word count
    private int word_count;

    private FileReader() {
        this.word_count = 0;

        this.record = new ArrayList<>(0);
        for (int i = 0; i < MAX_LENGTH; i++) {
            this.record.add(0);
        }
    }

    /**
     * Create a new instance of the class
     * 
     * @return 
     */
    public static FileReader newInstance() {
        return new FileReader();
    }

    /**
     * Process the line, removing any unnecessary characters
     *
     * @param line
     */
    private void process_line(final String line) {
        System.out.println("Input = " + line);
        
        // remove stars from test file (bible)
        String ln = line.replaceAll("\\*", "");
        
        // Split lines on spaces, dot and commas etc
        String[] tokens = ln.split("\\s|\\.|\\;|\\:");

        for (String token : tokens) {
            int length = token.length();
            if (length > 0) {
                int value = this.record.get(length);
                this.record.set(length, value + 1);
                this.word_count += 1;
            }
        }
    }

    @Override
    public long parse(final String filename) throws FileNotFoundException {
        long bytes = 0;
        Scanner scan = new Scanner(new File(filename));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            bytes += line.getBytes().length;

            process_line(line);
        }
        return bytes;
    }

    @Override
    public void print_stats() {
        System.out.format("Word count = %d\n", getWord_count());
        System.out.format("Average word length = %5.3f\n", calc_average());
        int i = 0;
        for (Integer val : record) {
            if (val > 0) {
                System.out.format(("Number of words of length %d is %d\n"), i, val);
            }
            i++;
        }

        print_longest_words();
    }

    /**
     * Calculates the average word length
     * 
     * @return the average length
     */
    private float calc_average() {
        int sum = 0;
        for (int i = 0; i < record.size(); i++) {
            sum += i * record.get(i);
        }
        return (float) sum / (float) word_count;
    }

    public int getWord_count() {
        return word_count;
    }

    /**
     * get the length of the longest word in the file
     *
     * @return
     */
    private int longest_word() {
        int max = 0;

        for (int i = 0; i < record.size(); i++) {
            if (record.get(i) > max) {
                max = record.get(i);
            }
        }
        return max;
    }

    /**
     * Prints the most frequent word length
     */
    private void print_longest_words() {
        ArrayList<Integer> items = new ArrayList<>();
        int longest = longest_word();

        // Loop throough the mord length and get the longest
        for (int i = 0; i < record.size(); i++) {
            if (record.get(i) == longest) {
                items.add(i);
            }
        }

        System.out.format("The most frequent occuring word length is %d, for word lengths of ", items.size());
        for (int i = 0; i < items.size(); i++) {
            if (i == items.size() - 1) {
                System.out.format("%d\n", items.get(i));
            } else {
                System.out.format("%d & ", items.get(i));
            }
        }
    }

}
