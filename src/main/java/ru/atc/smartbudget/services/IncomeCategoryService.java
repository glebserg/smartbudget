package ru.atc.smartbudget.services;

import org.springframework.stereotype.Service;
import ru.atc.smartbudget.dto.incomeCategory.GetIncomeCategory;
import ru.atc.smartbudget.dto.incomeCategory.IncomeCategoryMapping;
import ru.atc.smartbudget.dto.incomeCategory.PostIncomeCategory;
import ru.atc.smartbudget.dto.incomeCategory.PutIncomeCategory;
import ru.atc.smartbudget.exception.UserNotFoundException;
import ru.atc.smartbudget.exception.IncomeCategoryNotFoundException;
import ru.atc.smartbudget.model.DBIncomeCategory;
import ru.atc.smartbudget.repository.IncomeCategoryRepository;
import ru.atc.smartbudget.repository.UserRepository;

import java.util.List;
import java.util.Optional;

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

    public GetIncomeCategory getIncomeCategoryById(Long id) {
        return incomeCategoryRepository
                .findById(id)
                .map(incomeCategoryMapping::toDto)
                .orElseThrow(IncomeCategoryNotFoundException::new);
    }

    public List<GetIncomeCategory> getIncomeCategoriesByUserId(Long userId) {
        return userRepository.findById(userId).map(
                user -> incomeCategoryRepository.findByUserUserId(userId)
                        .stream()
                        .map(incomeCategoryMapping::toDto)
                        .toList()
        ).orElseThrow(UserNotFoundException::new);
    }

    public GetIncomeCategory createIncomeCategory(
            Long userId,
            PostIncomeCategory incomeCategoryData
    ) {
        return userRepository.findById(userId)
                .map(user -> incomeCategoryMapping.toDto(incomeCategoryRepository.save(incomeCategoryMapping.postToEntity(incomeCategoryData))
                )).orElseThrow(UserNotFoundException::new);
    }

    public GetIncomeCategory updateIncomeCategoryById(Long id, PutIncomeCategory inputData) {
        return incomeCategoryRepository.findById(id)
                .map(entity -> {
                    entity.setTitle(inputData.getTitle());
                    entity.setDescription(inputData.getDescription());
                    DBIncomeCategory updatedEntity = incomeCategoryRepository.save(entity);
                    return incomeCategoryMapping.toDto(updatedEntity);
                }).orElseThrow(IncomeCategoryNotFoundException::new);
    }

    public void deleteIncomeCategoryById(Long id) {
        incomeCategoryRepository.deleteById(id);
    }


}
