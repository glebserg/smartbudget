package ru.atc.smartbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.atc.smartbudget.model.DBIncome;
import ru.atc.smartbudget.model.DBOutlay;

import java.time.LocalDate;
import java.util.List;

public interface OutlayRepository extends JpaRepository<DBOutlay, Long> {
}
