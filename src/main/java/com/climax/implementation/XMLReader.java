/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.climax.implementation;

import com.climax.entity.Client;
import java.util.List;
import com.climax.interfaces.IFileReader;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Kadsuke
 */
public class XMLReader implements IFileReader{

    @Override
    public List<Client> readClients(String filePath) {
        List<Client> clients = new ArrayList<>();
        try {
            File file = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("client");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String nom = element.getElementsByTagName("nom").item(0).getTextContent().trim();
                    String prenom = element.getElementsByTagName("prenom").item(0).getTextContent().trim();
                    int age = Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent().trim());
                    String profession = element.getElementsByTagName("profession").item(0).getTextContent().trim();
                    double salaire = Double.parseDouble(element.getElementsByTagName("salaire").item(0).getTextContent().trim());

                    clients.add(new Client(nom, prenom, age, profession, salaire));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clients;
    }
}
