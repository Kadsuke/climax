/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.climax.implementation;

import com.climax.entity.Client;
import java.util.List;
import com.climax.interfaces.IFileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kadsuke
 */
public class TextFileReader implements IFileReader{

    @Override
    public List<Client> readClients(String filePath) {
        List<Client> clients = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assumez que les données sont bien formées pour cet exemple
                String[] data = line.split("\\s*;\\s*");

                String nom = data[0].trim();
                String prenom = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                String profession = data[3].trim();
                double salaire = Double.parseDouble(data[4].trim());

                clients.add(new Client(nom, prenom, age, profession, salaire));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return clients;
    }
    
}
