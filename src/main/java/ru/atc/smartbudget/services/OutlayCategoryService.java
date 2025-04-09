package ru.atc.smartbudget.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.atc.smartbudget.dto.outlayCategory.OutlayCategoryDetail;
import ru.atc.smartbudget.dto.outlayCategory.OutlayCategoryMapping;
import ru.atc.smartbudget.dto.outlayCategory.EditOutlayCategory;
import ru.atc.smartbudget.exception.OutlayCategoryNotFoundException;
import ru.atc.smartbudget.model.OutlayCategory;
import ru.atc.smartbudget.repository.OutlayCategoryRepository;

@AllArgsConstructor
@Service
public class OutlayCategoryService {
    private final OutlayCategoryRepository outlayCategoryRepository;
    private final OutlayCategoryMapping outlayCategoryMapping;


    public OutlayCategoryDetail getOutlayCategoryById(Long id) {
        return outlayCategoryRepository
                .findById(id)
                .map(outlayCategoryMapping::toDto)
                .orElseThrow(OutlayCategoryNotFoundException::new);
    }

    public OutlayCategoryDetail updateOutlayCategoryById(Long id, EditOutlayCategory inputData) {
        return outlayCategoryRepository.findById(id)
                .map(entity -> {
                    entity.setTitle(inputData.getTitle());
                    entity.setDescription(inputData.getDescription());
                    entity.setPriority(inputData.getPriority());
                    OutlayCategory updatedEntity = outlayCategoryRepository.save(entity);
                    return outlayCategoryMapping.toDto(updatedEntity);
                }).orElseThrow(OutlayCategoryNotFoundException::new);
    }

    public void deleteOutlayCategoryById(Long id) {
        outlayCategoryRepository.deleteById(id);
    }


}
