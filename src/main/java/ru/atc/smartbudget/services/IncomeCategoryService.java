package ru.atc.smartbudget.services;

import org.springframework.stereotype.Service;
import ru.atc.smartbudget.dto.incomeCategory.IncomeCategoryDetail;
import ru.atc.smartbudget.dto.incomeCategory.IncomeCategoryMapping;
import ru.atc.smartbudget.dto.incomeCategory.CreateIncomeCategory;
import ru.atc.smartbudget.dto.incomeCategory.EditIncomeCategory;
import ru.atc.smartbudget.exception.UserNotFoundException;
import ru.atc.smartbudget.exception.IncomeCategoryNotFoundException;
import ru.atc.smartbudget.model.IncomeCategory;
import ru.atc.smartbudget.model.User;
import ru.atc.smartbudget.repository.IncomeCategoryRepository;
import ru.atc.smartbudget.repository.UserRepository;

import java.util.List;

@Service
public class IncomeCategoryService {
    private final IncomeCategoryRepository incomeCategoryRepository;
    private final IncomeCategoryMapping incomeCategoryMapping;
    private final UserRepository userRepository;

    public IncomeCategoryService(
            IncomeCategoryRepository incomeCategoryRepository,
            IncomeCategoryMapping incomeCategoryMapping,
            UserRepository userRepository
    ) {
        this.incomeCategoryRepository = incomeCategoryRepository;
        this.incomeCategoryMapping = incomeCategoryMapping;
        this.userRepository = userRepository;
    }

    public IncomeCategoryDetail getIncomeCategoryById(Long id) {
        return incomeCategoryRepository
                .findById(id)
                .map(incomeCategoryMapping::toDto)
                .orElseThrow(IncomeCategoryNotFoundException::new);
    }

    public List<IncomeCategoryDetail> getIncomeCategoriesByUserId(Long userId) {
        return userRepository.findById(userId).map(
                user -> incomeCategoryRepository.findByUserUserId(userId)
                        .stream()
                        .map(incomeCategoryMapping::toDto)
                        .toList()
        ).orElseThrow(UserNotFoundException::new);
    }

    public IncomeCategoryDetail createIncomeCategory(
            Long userId,
            CreateIncomeCategory incomeCategoryData
    ) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        IncomeCategory entity = incomeCategoryMapping.postToEntity(user,incomeCategoryData);
        IncomeCategory savedEntity = incomeCategoryRepository.save(entity);
        return incomeCategoryMapping.toDto(savedEntity);
    }

    public IncomeCategoryDetail updateIncomeCategoryById(Long id, EditIncomeCategory inputData) {
        return incomeCategoryRepository.findById(id)
                .map(entity -> {
                    entity.setTitle(inputData.getTitle());
                    entity.setDescription(inputData.getDescription());
                    IncomeCategory updatedEntity = incomeCategoryRepository.save(entity);
                    return incomeCategoryMapping.toDto(updatedEntity);
                }).orElseThrow(IncomeCategoryNotFoundException::new);
    }

    public void deleteIncomeCategoryById(Long id) {
        incomeCategoryRepository.deleteById(id);
    }


}
