/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.climax.factory;

import com.climax.implementation.CSVReader;
import com.climax.implementation.GenericFileReader;
import com.climax.implementation.JSONReader;
import com.climax.implementation.TextFileReader;
import com.climax.implementation.XMLReader;
import com.climax.interfaces.IFileReader;
import java.io.FileReader;

/**
 *
 * @author Kadsuke
 */
public class FileReaderFactory {
    public static IFileReader createFileReader(String filePath) {
        if (filePath.endsWith(".csv")) {
            return new CSVReader();
        } else if (filePath.endsWith(".xml")) {
            return new XMLReader();
        } else if (filePath.endsWith(".json")) {
            return new JSONReader();
        } else if (filePath.endsWith(".txt")) {
            return new TextFileReader();
        } else {
            return new GenericFileReader();
        }
    }
}
