package ru.atc.smartbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.atc.smartbudget.model.OutlayCategory;

public interface OutlayCategoryRepository extends JpaRepository<OutlayCategory, Long> {
}
