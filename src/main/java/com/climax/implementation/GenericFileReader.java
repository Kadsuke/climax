/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.climax.implementation;

import com.climax.entity.Client;
import java.util.List;
import com.climax.interfaces.IFileReader;
import java.util.ArrayList;

/**
 *
 * @author Kadsuke
 */
public class GenericFileReader implements IFileReader{

    @Override
    public List<Client> readClients(String filePath) {
        System.out.println("Nouveay format de fichier : " + filePath);
        return new ArrayList<>();
    }
    
}
