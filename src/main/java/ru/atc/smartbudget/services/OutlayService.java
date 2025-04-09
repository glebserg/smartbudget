package ru.atc.smartbudget.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.atc.smartbudget.dto.outlay.OutlayDetail;
import ru.atc.smartbudget.dto.outlay.OutlayMapping;
import ru.atc.smartbudget.dto.outlay.CreateOutlay;
import ru.atc.smartbudget.dto.outlay.EditOutlay;
import ru.atc.smartbudget.exception.OutlayCategoryNotFoundException;
import ru.atc.smartbudget.exception.OutlayNotFoundException;
import ru.atc.smartbudget.model.Outlay;
import ru.atc.smartbudget.model.OutlayCategory;
import ru.atc.smartbudget.repository.OutlayCategoryRepository;
import ru.atc.smartbudget.repository.OutlayRepository;

@AllArgsConstructor
@Service
public class OutlayService {
    private final OutlayRepository outlayRepository;
    private final OutlayCategoryRepository outlayCategoryRepository;
    private final OutlayMapping outlayMapping;


    public OutlayDetail getOutlayById(Long id) {
        return outlayRepository
                .findById(id)
                .map(outlayMapping::toDto)
                .orElseThrow(OutlayNotFoundException::new);
    }

    public OutlayDetail createOutlay(Long userId, CreateOutlay inputData) {
        OutlayCategory outlayCategory = outlayCategoryRepository
                .findById(inputData.getOutlayCategoryId())
                .orElseThrow(OutlayCategoryNotFoundException::new);
        Outlay outlay = outlayMapping.postToEntity(inputData, userId, outlayCategory);
        return outlayMapping.toDto(
                outlayRepository.save(outlay)
        );
    }

    public OutlayDetail updateOutlayById(Long outlayId, EditOutlay inputData) {
        return outlayRepository.findById(outlayId)
                .map(entity -> {
                    entity.setValue(inputData.getValue());
                    entity.setOutlayDate(inputData.getOutlayDate());
                    return outlayMapping.toDto(outlayRepository.save(entity));
                }).orElseThrow(OutlayNotFoundException::new);
    }


    private boolean isOwner(long userId) {
        return true;
    }

}
