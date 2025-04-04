package ru.atc.smartbudget.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.atc.smartbudget.dto.outlay.GetOutlay;
import ru.atc.smartbudget.dto.outlay.OutlayMapping;
import ru.atc.smartbudget.dto.outlay.PostOutlay;
import ru.atc.smartbudget.dto.outlay.PutOutlay;
import ru.atc.smartbudget.exception.OutlayCategoryNotFoundException;
import ru.atc.smartbudget.exception.OutlayNotFoundException;
import ru.atc.smartbudget.model.DBOutlay;
import ru.atc.smartbudget.model.DBOutlayCategory;
import ru.atc.smartbudget.repository.OutlayCategoryRepository;
import ru.atc.smartbudget.repository.OutlayRepository;

import java.util.Optional;

@Service
public class OutlayService {
    private final OutlayRepository outlayRepository;
    private final OutlayCategoryRepository outlayCategoryRepository;
    private final OutlayMapping outlayMapping;

    public OutlayService(
            OutlayRepository outlayRepository,
            OutlayCategoryRepository outlayCategoryRepository,
            OutlayMapping outlayMapping
    ) {
        this.outlayRepository = outlayRepository;
        this.outlayCategoryRepository = outlayCategoryRepository;
        this.outlayMapping = outlayMapping;
    }

    public GetOutlay getOutlayById(Long id) {
        return outlayRepository
                .findById(id)
                .map(outlayMapping::toDto)
                .orElseThrow(OutlayNotFoundException::new);
    }

    public GetOutlay createOutlay(Long userId, PostOutlay inputData) {
        DBOutlayCategory outlayCategory = outlayCategoryRepository
                .findById(inputData.getOutlayCategoryId())
                .orElseThrow(OutlayCategoryNotFoundException::new);
        DBOutlay outlay = outlayMapping.postToEntity(inputData, userId, outlayCategory);
        return outlayMapping.toDto(
                outlayRepository.save(outlay)
        );
    }

    public GetOutlay updateOutlayById(Long outlayId, PutOutlay inputData) {
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
