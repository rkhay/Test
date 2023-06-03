package ru.rkhayrit.computershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rkhayrit.computershop.model.HardDisk;

import java.util.UUID;

@Repository
public interface HardDiskRepository extends JpaRepository<HardDisk, Long> {
}
