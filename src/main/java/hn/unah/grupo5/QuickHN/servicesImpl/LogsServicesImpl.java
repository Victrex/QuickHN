/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.unah.grupo5.QuickHN.servicesImpl;

import hn.unah.grupo5.QuickHN.models.Logs;
import hn.unah.grupo5.QuickHN.models.Usuarios;
import hn.unah.grupo5.QuickHN.repositories.LogsRepository;
import hn.unah.grupo5.QuickHN.services.LogsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soriano
 */
@Service
public class LogsServicesImpl implements LogsService{
    @Autowired
    private LogsRepository logsRepository;

    @Override
    public List<Logs> getAllLogs() {
        return this.logsRepository.findAll();
    }

    @Override
    public Logs saveLog(Logs log) {
        return this.logsRepository.save(log);
    }

    @Override
    public Logs getLogByID(String idLog) {
        return this.logsRepository.findById(idLog).orElse(null);
    }

    @Override    
    public List<Logs> getLogsByUsuario(Usuarios idUsuario){
	return this.logsRepository.findByidusuario(idUsuario);
    };
    
}
