package ru.atc.smartbudget.services;

import org.springframework.stereotype.Service;
import ru.atc.smartbudget.dto.income.GetIncome;
import ru.atc.smartbudget.dto.income.IncomeMapping;
import ru.atc.smartbudget.dto.outlay.GetOutlay;
import ru.atc.smartbudget.dto.outlay.OutlayMapping;
import ru.atc.smartbudget.dto.user.GetUser;
import ru.atc.smartbudget.dto.user.PostUser;
import ru.atc.smartbudget.dto.user.PutUser;
import ru.atc.smartbudget.dto.user.UserMapping;
import ru.atc.smartbudget.exception.UserNotFoundException;
import ru.atc.smartbudget.model.DBUser;
import ru.atc.smartbudget.repository.IncomeRepository;
import ru.atc.smartbudget.repository.OutlayRepository;
import ru.atc.smartbudget.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final IncomeRepository incomeRepository;
    private final UserMapping userMapping;
    private final IncomeMapping incomeMapping;
    private final OutlayMapping outlayMapping;
    private final OutlayService outlayService;
    private final OutlayRepository outlayRepository;

    public UserService(
            UserRepository userRepository,
            IncomeRepository incomeRepository,
            UserMapping userMapping,
            IncomeMapping incomeMapping,
            OutlayMapping outlayMapping,
            OutlayService outlayService,
            OutlayRepository outlayRepository) {
        this.userRepository = userRepository;
        this.incomeRepository = incomeRepository;
        this.userMapping = userMapping;
        this.incomeMapping = incomeMapping;
        this.outlayMapping = outlayMapping;
        this.outlayService = outlayService;
        this.outlayRepository = outlayRepository;
    }

    public List<GetUser> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapping::toDto)
                .toList();
    }

    public GetUser getUserById(Long id) {
        return userRepository.findById(id).map(userMapping::toDto).orElseThrow(UserNotFoundException::new);
    }

    public GetUser createUser(PostUser userData) {
        return userMapping.toDto(userRepository.save(userMapping.toEntity(userData)));
    }

    public GetUser updateUser(Long id, PutUser userData) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(userData.getFirstName());
                    user.setSecondName(userData.getSecondName());
                    DBUser updatedUser = userRepository.save(user);
                    return userMapping.toDto(updatedUser);
                }).orElseThrow(UserNotFoundException::new);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public List<GetIncome> getUserIncomes(Long userId) {
        return incomeRepository.findAllByUserId(userId).stream()
                .map(this.incomeMapping::toDto)
                .toList();
    }

    public List<GetIncome> getUserIncomes(Long userId, LocalDate startDate, LocalDate endDate) {
        return incomeRepository.findAllByUserIdAndIncomeDateBetweenOrderByIncomeDate(userId, startDate, endDate).stream()
                .map(this.incomeMapping::toDto)
                .toList();
    }

    public List<GetOutlay> getUserOutlays(Long userId) {
        return outlayRepository.findAllByUserId(userId).stream()
                .map(this.outlayMapping::toDto)
                .toList();
    }

    public List<GetOutlay> getUserOutlays(Long userId, LocalDate startDate, LocalDate endDate) {
        return outlayRepository.findAllByUserIdAndOutlayDateBetweenOrderByOutlayDate(userId, startDate, endDate).stream()
                .map(this.outlayMapping::toDto)
                .toList();
    }

}
