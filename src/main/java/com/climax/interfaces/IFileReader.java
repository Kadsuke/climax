/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.climax.interfaces;

import com.climax.entity.Client;
import java.util.List;

/**
 *
 * @author Kadsuke
 */
public interface IFileReader {
        List<Client> readClients(String filePath);
}
