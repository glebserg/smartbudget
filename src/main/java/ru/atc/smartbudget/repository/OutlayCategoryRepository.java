package ru.atc.smartbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.atc.smartbudget.model.DBOutlayCategory;

public interface OutlayCategoryRepository extends JpaRepository<DBOutlayCategory, Long> {
}
