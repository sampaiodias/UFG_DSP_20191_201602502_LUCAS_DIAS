/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sampaiodias.dsp;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 * @author Lucas Sampaio Dias
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String thing = "exemplo";
        String dir = App.class.getResource("/").getFile();
        //String dir = WriteResource.class.getResource("/dir").getFile();
        OutputStream os = new FileOutputStream("src/com/main/resources/exemplo.txt");
        final PrintStream printStream = new PrintStream(os);
        printStream.println(thing);
        printStream.close();
    }
    
}
