package ru.atc.smartbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.atc.smartbudget.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
