/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.climax.implementation;

import com.climax.entity.Client;
import java.util.List;
import com.climax.interfaces.IFileReader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Kadsuke
 */
public class JSONReader implements IFileReader{

    @Override
    public List<Client> readClients(String filePath) {
        List<Client> clients = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            Iterator<JsonNode> elements = rootNode.elements();
            while (elements.hasNext()) {
                JsonNode node = elements.next();

                String nom = node.get("nom").asText();
                String prenom = node.get("prenom").asText();
                int age = node.get("age").asInt();
                String profession = node.get("profession").asText();
                double salaire = node.get("salaire").asDouble();

                clients.add(new Client(nom, prenom, age, profession, salaire));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clients;
    }
    
}
