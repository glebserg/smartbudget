package ru.atc.smartbudget.services;

import org.springframework.stereotype.Service;
import ru.atc.smartbudget.dto.income.GetIncome;
import ru.atc.smartbudget.dto.income.IncomeMapping;
import ru.atc.smartbudget.model.DBIncome;
import ru.atc.smartbudget.dto.income.PostIncome;
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

    public DBIncome getIncomeById(Long id) {
        return incomeRepository.findById(id).orElseThrow();
    }

    public GetIncome createIncome(Long userId, PostIncome incomeData) {

//        System.out.println(";kdlgflfgkdnb");
//        DBIncome income = new DBIncome();
//        income.setIncomeCategoryId(incomeData.getIncomeCategoryId());
//        income.setUserId(userId);
//        income.setValue(incomeData.getValue());
//        income.setIncomeDate(incomeData.getIncomeDate());
//        return incomeRepository.save(income);
        return incomeMapping.toDto(incomeRepository.save(incomeMapping.postToEntity(incomeData)));
    }


    private boolean itIsMe(long id) {
        return true;
    }

}
