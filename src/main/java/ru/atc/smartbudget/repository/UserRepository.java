package ru.atc.smartbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.atc.smartbudget.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
