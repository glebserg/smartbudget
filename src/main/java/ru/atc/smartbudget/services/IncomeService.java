package ru.atc.smartbudget.services;

import org.springframework.stereotype.Service;
import ru.atc.smartbudget.dto.income.IncomeDetail;
import ru.atc.smartbudget.dto.income.IncomeMapping;
import ru.atc.smartbudget.dto.income.EditIncome;
import ru.atc.smartbudget.dto.income.CreateIncome;
import ru.atc.smartbudget.exception.IncomeNotFoundException;
import ru.atc.smartbudget.model.Income;
import ru.atc.smartbudget.repository.IncomeRepository;

@Service
public class IncomeService {
    private final IncomeRepository incomeRepository;
    private final IncomeMapping incomeMapping;

    public IncomeService(
            IncomeRepository incomeRepository,
            IncomeMapping incomeMapping) {
        this.incomeRepository = incomeRepository;
        this.incomeMapping = incomeMapping;
    }

    public IncomeDetail getIncomeById(Long id) {
        return incomeRepository
                .findById(id)
                .map(incomeMapping::toDto)
                .orElseThrow(IncomeNotFoundException::new);
    }

    public IncomeDetail createIncome(Long userId, CreateIncome incomeData) {
        Income entity = incomeMapping.postToEntity(incomeData, userId);
        Income savedIncome = incomeRepository.save(entity);
        return incomeMapping.toDto(savedIncome);

    }

    public IncomeDetail updateIncomeById(Long incomeId, EditIncome incomeData) {
        return incomeRepository.findById(incomeId)
                .map(entity -> {
                    entity.setValue(incomeData.getValue());
                    entity.setIncomeDate(incomeData.getIncomeDate());
                    return incomeMapping.toDto(incomeRepository.save(entity));
                }).orElseThrow(IncomeNotFoundException::new);
    }

    private boolean isOwner(long userId) {
        return true;
    }

}
