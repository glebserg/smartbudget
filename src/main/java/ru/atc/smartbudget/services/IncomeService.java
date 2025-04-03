package ru.atc.smartbudget.services;

import org.springframework.stereotype.Service;
import ru.atc.smartbudget.dto.income.GetIncome;
import ru.atc.smartbudget.dto.income.IncomeMapping;
import ru.atc.smartbudget.dto.income.PutIncome;
import ru.atc.smartbudget.dto.income.PostIncome;
import ru.atc.smartbudget.repository.IncomeRepository;

import java.util.Optional;

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

    public Optional<GetIncome> getIncomeById(Long id) {
        return incomeRepository.findById(id).map(incomeMapping::toDto);
    }

    public GetIncome createIncome(Long userId, PostIncome incomeData) {
        return incomeMapping.toDto(incomeRepository.save(
                incomeMapping.postToEntity(incomeData, userId))
        );
    }

    public Optional<GetIncome> updateIncomeById(Long incomeId, PutIncome incomeData) {
        return incomeRepository.findById(incomeId)
                .map(entity -> {
                    entity.setValue(incomeData.getValue());
                    entity.setIncomeDate(incomeData.getIncomeDate());
                    return incomeMapping.toDto(incomeRepository.save(entity));
                });
    }

    private boolean isOwner(long userId) {
        return true;
    }

}
