package ru.rkhayrit.computershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rkhayrit.computershop.exception.RecordNotFoundException;
import ru.rkhayrit.computershop.model.HardDisk;
import ru.rkhayrit.computershop.repository.HardDiskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HardDiskService {
    @Autowired
    HardDiskRepository repository;

    public List<HardDisk> getAllHardDisks() {
        Optional<List<HardDisk>>  HardDiskList = Optional.of(repository.findAll());
        return HardDiskList.orElseGet(ArrayList::new);
    }

    public HardDisk getHardDiskById(Long id) {
        Optional<HardDisk> HardDisk = repository.findById(id);

        if (HardDisk.isPresent()) {
            return HardDisk.get();
        } else {
            throw new RecordNotFoundException("There is no record for the given id " + id);
        }
    }

    public HardDisk addHardDisk(HardDisk entity) {
        entity = repository.save(entity);
        return entity;
    }

    public HardDisk updateHardDisk(HardDisk entity) {
        Optional<HardDisk> HardDisk = repository.findById(entity.getId());

        if(HardDisk.isPresent()) {
            HardDisk newEntity = HardDisk.get();
            newEntity.setSerialNumber(entity.getSerialNumber());
            newEntity.setManufacturer(entity.getManufacturer());
            newEntity.setPrice(entity.getPrice());
            newEntity.setAvailableOnTheStock(entity.getAvailableOnTheStock());
            newEntity.setVolume(entity.getVolume());

            newEntity = repository.save(newEntity);

            return newEntity;
        }

        throw new RecordNotFoundException("There is no such a record for updating");
    }

    public void deleteHardDiskById(Long id) {
        Optional<HardDisk> hardDisk = repository.findById(id);

        if(hardDisk.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("There is no record for the given id " + id);
        }
    }
}
