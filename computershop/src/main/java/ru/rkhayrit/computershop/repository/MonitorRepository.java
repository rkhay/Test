package ru.rkhayrit.computershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rkhayrit.computershop.model.Monitor;

import java.util.UUID;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {
}
