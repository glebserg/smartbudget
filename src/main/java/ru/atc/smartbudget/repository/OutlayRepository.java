package ru.atc.smartbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.atc.smartbudget.model.Outlay;

import java.time.LocalDate;
import java.util.List;

public interface OutlayRepository extends JpaRepository<Outlay, Long> {
    List<Outlay> findAllByUserId(Long userId);
    List<Outlay> findAllByUserIdAndOutlayDateBetweenOrderByOutlayDate(Long userId, LocalDate startDate, LocalDate endDate);
}
