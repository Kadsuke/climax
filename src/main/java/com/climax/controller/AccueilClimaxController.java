/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.climax.controller;

import com.climax.entity.AvgSalary;
import com.climax.entity.Client;
import com.climax.implementation.CSVReader;
import com.climax.implementation.JSONReader;
import com.climax.implementation.TextFileReader;
import com.climax.implementation.XMLReader;
import com.climax.interfaces.IFileReader;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Kadsuke
 */
public class AccueilClimaxController extends VueController implements Initializable {
    @FXML
    private ListView<Client> clientListView;
    
    @FXML
    private Map<String, Double> averageSalariesByProfession = new HashMap<>();

    @FXML
    private ObservableList<Client> clientsObservableList = FXCollections.observableArrayList();
    
    @FXML
    private TableView<AvgSalary> averageSalaryTableView;
    
    @FXML
    private ObservableList<AvgSalary> averageSalariesObservableList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clientListView.setItems(clientsObservableList);
        averageSalaryTableView.setItems(averageSalariesObservableList);

        TableColumn<AvgSalary, String> professionColumn = (TableColumn<AvgSalary, String>) averageSalaryTableView.getColumns().get(0);
        TableColumn<AvgSalary, Double> averageSalaryColumn = (TableColumn<AvgSalary, Double>) averageSalaryTableView.getColumns().get(1);

        professionColumn.setCellValueFactory(cellData -> cellData.getValue().getProfessionProperty());
        averageSalaryColumn.setCellValueFactory(cellData -> cellData.getValue().getAverageSalaryProperty().asObject());

    }
    

    @FXML
    private void importFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionnez un fichier");
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            String filePath = selectedFile.getAbsolutePath();
            IFileReader fileReader = determineFileReader(filePath);
            if (fileReader != null) {
                List<Client> clients = fileReader.readClients(filePath);
                clientsObservableList.addAll(clients);
                updateAverageSalaries(clients);
            } else {
                infoBoxError("Format de fichier non pris en charge", "Erreur Fichier", null);
            }
        }
    }

    @FXML
    private void quit() {
        System.exit(0);
    }
//compare le end des fichier pour determiner le type de fichier
    private IFileReader determineFileReader(String filePath) {
        if (filePath.endsWith(".csv")) {
            return new CSVReader();
        } else if (filePath.endsWith(".xml")) {
            return new XMLReader();
        } else if (filePath.endsWith(".json")) {
            return new JSONReader();
        } else if (filePath.endsWith(".txt")) {
            return new TextFileReader();
        } else {
            return null;
        }
    }
    
    private void updateAverageSalaries(List<Client> clients) {
        double totalSalary = 0;
        int totalClients = 0;

        for (Client client : clients) {
            String profession = client.getProfession();
            double salary = client.getSalaire();

            // Maj moyenne des salaires par profession
            if (averageSalariesByProfession.containsKey(profession)) {
                double currentAverage = averageSalariesByProfession.get(profession);
                averageSalariesByProfession.put(profession, (currentAverage + salary) / 2);
            } else {
                averageSalariesByProfession.put(profession, salary);
            }

            // Maj total des salaires pour calculer  moyenne globale
            totalSalary += salary;
            totalClients++;
        }
        
        averageSalariesObservableList.clear();
        for (Map.Entry<String, Double> entry : averageSalariesByProfession.entrySet()) {
            averageSalariesObservableList.add(new AvgSalary(entry.getKey(), entry.getValue()));
        }
    }
}
