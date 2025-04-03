package ru.atc.smartbudget.services;

import org.springframework.stereotype.Service;
import ru.atc.smartbudget.dto.outlay.GetOutlay;
import ru.atc.smartbudget.dto.outlay.OutlayMapping;
import ru.atc.smartbudget.dto.outlay.PostOutlay;
import ru.atc.smartbudget.dto.outlay.PutOutlay;
import ru.atc.smartbudget.repository.OutlayRepository;

import java.util.Optional;

@Service
public class OutlayService {
    private final OutlayRepository outlayRepository;
    private final OutlayMapping outlayMapping;

    public OutlayService(
            OutlayRepository outlayRepository,
            OutlayMapping outlayMapping
    ) {
        this.outlayRepository = outlayRepository;
        this.outlayMapping = outlayMapping;
    }

    public Optional<GetOutlay> getOutlayById(Long id) {
        return outlayRepository.findById(id).map(outlayMapping::toDto);
    }

    public GetOutlay createOutlay(Long userId, PostOutlay inputData) {
        return outlayMapping.toDto(outlayRepository.save(
                outlayMapping.postToEntity(inputData, userId))
        );
    }

    public Optional<GetOutlay> updateOutlayById(Long outlayId, PutOutlay inputData) {
        return outlayRepository.findById(outlayId)
                .map(entity -> {
                    entity.setValue(inputData.getValue());
                    entity.setOutlayDate(inputData.getOutlayDate());
                    return outlayMapping.toDto(outlayRepository.save(entity));
                });
    }

    private boolean isOwner(long userId) {
        return true;
    }

}
