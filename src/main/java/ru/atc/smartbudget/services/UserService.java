package ru.atc.smartbudget.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.atc.smartbudget.dto.income.IncomeDetail;
import ru.atc.smartbudget.dto.income.IncomeMapping;
import ru.atc.smartbudget.dto.outlay.OutlayDetail;
import ru.atc.smartbudget.dto.outlay.OutlayMapping;
import ru.atc.smartbudget.dto.user.UserDetail;
import ru.atc.smartbudget.dto.user.CreateUser;
import ru.atc.smartbudget.dto.user.EditUser;
import ru.atc.smartbudget.dto.user.UserMapping;
import ru.atc.smartbudget.exception.UserNotFoundException;
import ru.atc.smartbudget.model.User;
import ru.atc.smartbudget.repository.IncomeRepository;
import ru.atc.smartbudget.repository.OutlayRepository;
import ru.atc.smartbudget.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final IncomeRepository incomeRepository;
    private final UserMapping userMapping;
    private final IncomeMapping incomeMapping;
    private final OutlayMapping outlayMapping;
    private final OutlayService outlayService;
    private final OutlayRepository outlayRepository;


    public List<UserDetail> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapping::toDto)
                .toList();
    }

    public UserDetail getUserById(Long id) {
        return userRepository.findById(id).map(userMapping::toDto).orElseThrow(UserNotFoundException::new);
    }

    public UserDetail createUser(CreateUser userData) {
        return userMapping.toDto(userRepository.save(userMapping.toEntity(userData)));
    }

    public UserDetail updateUser(Long id, EditUser userData) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(userData.getFirstName());
                    user.setSecondName(userData.getSecondName());
                    User updatedUser = userRepository.save(user);
                    return userMapping.toDto(updatedUser);
                }).orElseThrow(UserNotFoundException::new);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public List<IncomeDetail> getUserIncomes(Long userId) {
        return incomeRepository.findAllByUserId(userId).stream()
                .map(this.incomeMapping::toDto)
                .toList();
    }

    public List<IncomeDetail> getUserIncomes(Long userId, LocalDate startDate, LocalDate endDate) {
        return incomeRepository.findAllByUserIdAndIncomeDateBetweenOrderByIncomeDate(userId, startDate, endDate).stream()
                .map(this.incomeMapping::toDto)
                .toList();
    }

    public List<OutlayDetail> getUserOutlays(Long userId) {
        return outlayRepository.findAllByUserId(userId).stream()
                .map(this.outlayMapping::toDto)
                .toList();
    }

    public List<OutlayDetail> getUserOutlays(Long userId, LocalDate startDate, LocalDate endDate) {
        return outlayRepository.findAllByUserIdAndOutlayDateBetweenOrderByOutlayDate(userId, startDate, endDate).stream()
                .map(this.outlayMapping::toDto)
                .toList();
    }

}
