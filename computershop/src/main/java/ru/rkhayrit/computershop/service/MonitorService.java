package ru.rkhayrit.computershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rkhayrit.computershop.exception.RecordNotFoundException;
import ru.rkhayrit.computershop.model.Monitor;
import ru.rkhayrit.computershop.repository.MonitorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MonitorService {

    @Autowired
    MonitorRepository repository;

    public List<Monitor> getAllMonitors() {
        Optional<List<Monitor>> MonitorList = Optional.of(repository.findAll());
        return MonitorList.orElseGet(ArrayList::new);
    }

    public Monitor getMonitorById(Long id) {
        Optional<Monitor> Monitor = repository.findById(id);

        if (Monitor.isPresent()) {
            return Monitor.get();
        } else {
            throw new RecordNotFoundException("There is no record for the given id " + id);
        }
    }

    public Monitor addMonitor(Monitor entity) {
        entity = repository.save(entity);
        return entity;
    }

    public Monitor updateMonitor(Monitor entity) {
        Optional<Monitor> Monitor = repository.findById(entity.getId());

        if(Monitor.isPresent()) {
            Monitor newEntity = Monitor.get();
            newEntity.setSerialNumber(entity.getSerialNumber());
            newEntity.setManufacturer(entity.getManufacturer());
            newEntity.setPrice(entity.getPrice());
            newEntity.setAvailableOnTheStock(entity.getAvailableOnTheStock());
            newEntity.setDiagonal(entity.getDiagonal());

            newEntity = repository.save(newEntity);

            return newEntity;
        }

        throw new RecordNotFoundException("There is no such a record for updating");
    }

    public void deleteMonitorById(Long id) {
        Optional<Monitor> employee = repository.findById(id);

        if(employee.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("There is no record for the given id " + id);
        }
    }

}
