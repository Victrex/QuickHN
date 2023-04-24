/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.unah.grupo5.QuickHN.services;

import hn.unah.grupo5.QuickHN.models.Isv;
import java.util.List;

/**
 *
 * @author Kenne
 */
public interface IsvService {

    List<Isv> getAllIsv();

    Isv getIsvByID(String idisv);
}
