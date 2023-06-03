package ru.rkhayrit.computershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rkhayrit.computershop.exception.RecordNotFoundException;
import ru.rkhayrit.computershop.model.DesktopComputer;
import ru.rkhayrit.computershop.repository.DesktopComputerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DesktopComputerService {

    @Autowired
    DesktopComputerRepository repository;

    public List<DesktopComputer> getAllDesktopComputers() {
        Optional<List<DesktopComputer>>  desktopComputerList = Optional.of(repository.findAll());
        return desktopComputerList.orElseGet(ArrayList::new);
    }

    public DesktopComputer getComputerById(Long id) {
        Optional<DesktopComputer> desktopComputer = repository.findById(id);

        if (desktopComputer.isPresent()) {
            return desktopComputer.get();
        } else {
            throw new RecordNotFoundException("There is no record for the given id " + id);
        }
    }

    public DesktopComputer addComputer(DesktopComputer entity) {
            entity = repository.save(entity);
            return entity;
    }

    public DesktopComputer updateComputer(DesktopComputer entity) {
        Optional<DesktopComputer> desktopComputer = repository.findById(entity.getId());

        if(desktopComputer.isPresent()) {
            DesktopComputer newEntity = desktopComputer.get();
            newEntity.setSerialNumber(entity.getSerialNumber());
            newEntity.setManufacturer(entity.getManufacturer());
            newEntity.setPrice(entity.getPrice());
            newEntity.setAvailableOnTheStock(entity.getAvailableOnTheStock());
            newEntity.setFormFactor(entity.getFormFactor());

            newEntity = repository.save(newEntity);

            return newEntity;
        }

        throw new RecordNotFoundException("There is no such a record for updating");
    }

    public void deleteDesktopComputerById(Long id) {
        Optional<DesktopComputer> desktopComputer = repository.findById(id);

        if(desktopComputer.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("There is no record for the given id " + id);
        }
    }


}
