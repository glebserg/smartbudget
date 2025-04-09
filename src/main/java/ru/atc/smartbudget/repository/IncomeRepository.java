package ru.atc.smartbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.atc.smartbudget.model.Income;


import java.time.LocalDate;
import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    List<Income> findAllByUserId(Long userId);
    List<Income> findAllByUserIdAndIncomeDateBetweenOrderByIncomeDate(Long userId, LocalDate startDate, LocalDate endDate);
}
