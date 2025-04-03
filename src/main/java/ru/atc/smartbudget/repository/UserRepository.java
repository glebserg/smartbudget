package ru.atc.smartbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.atc.smartbudget.model.DBUser;

public interface UserRepository extends JpaRepository<DBUser, Long> {
}
