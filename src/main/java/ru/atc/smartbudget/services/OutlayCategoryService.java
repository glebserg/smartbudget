package ru.atc.smartbudget.services;

import org.springframework.stereotype.Service;
import ru.atc.smartbudget.dto.outlayCategory.GetOutlayCategory;
import ru.atc.smartbudget.dto.outlayCategory.OutlayCategoryMapping;
import ru.atc.smartbudget.dto.outlayCategory.PutOutlayCategory;
import ru.atc.smartbudget.model.DBOutlayCategory;
import ru.atc.smartbudget.repository.OutlayCategoryRepository;

import java.util.Optional;

@Service
public class OutlayCategoryService {
    private final OutlayCategoryRepository outlayCategoryRepository;
    private final OutlayCategoryMapping outlayCategoryMapping;

    public OutlayCategoryService(
            OutlayCategoryRepository outlayCategoryRepository,
            OutlayCategoryMapping outlayCategoryMapping
    ) {
        this.outlayCategoryRepository = outlayCategoryRepository;
        this.outlayCategoryMapping = outlayCategoryMapping;
    }

    public Optional<GetOutlayCategory> getOutlayCategoryById(Long id) {
        return outlayCategoryRepository.findById(id).map(outlayCategoryMapping::toDto);
    }

    public Optional<GetOutlayCategory> updateOutlayCategoryById(Long id, PutOutlayCategory inputData) {
        return outlayCategoryRepository.findById(id)
                .map(entity -> {
                    entity.setTitle(inputData.getTitle());
                    entity.setDescription(inputData.getDescription());
                    entity.setPriority(inputData.getPriority());
                    DBOutlayCategory updatedEntity = outlayCategoryRepository.save(entity);
                    return outlayCategoryMapping.toDto(updatedEntity);
                });
    }

    public void deleteOutlayCategoryById(Long id) {
        outlayCategoryRepository.deleteById(id);
    }


}
