package ru.atc.smartbudget.controller;

import java.time.LocalDate;
import java.util.List;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.atc.smartbudget.dto.income.IncomeDetail;
import ru.atc.smartbudget.dto.incomeCategory.IncomeCategoryDetail;
import ru.atc.smartbudget.dto.outlay.OutlayDetail;
import ru.atc.smartbudget.dto.outlay.CreateOutlay;
import ru.atc.smartbudget.dto.user.UserDetail;
import ru.atc.smartbudget.dto.user.EditUser;
import ru.atc.smartbudget.dto.income.CreateIncome;
import ru.atc.smartbudget.dto.incomeCategory.CreateIncomeCategory;
import ru.atc.smartbudget.dto.user.CreateUser;
import ru.atc.smartbudget.services.IncomeCategoryService;
import ru.atc.smartbudget.services.IncomeService;
import ru.atc.smartbudget.services.OutlayService;
import ru.atc.smartbudget.services.UserService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final IncomeService incomeService;
    private final IncomeCategoryService incomeCategoryService;
    private final OutlayService outlayService;


    @Tag(name = "Пользователи")
    @Operation(summary = "Список пользователей")
    @GetMapping
    public List<UserDetail> getAllUsers() {
        return userService.getAllUsers();
    }

    @Tag(name = "Пользователи")
    @Operation(summary = "Добавить пользователя")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDetail createUser(@RequestBody CreateUser user) {
        return userService.createUser(user);
    }

    @Tag(name = "Пользователи")
    @Operation(summary = "Пользователь по ID")
    @GetMapping("/{id}")
    public UserDetail getUserById(@PathVariable Long id) {
        return this.userService.getUserById(id);
    }

    @Tag(name = "Пользователи")
    @Operation(summary = "Редактировать пользователя по ID")
    @PutMapping("/{id}")
    public UserDetail updateUser(
            @PathVariable Long id,
            @RequestBody EditUser user
    ) {
        return this.userService.updateUser(id, user);
    }

    @Tag(name = "Пользователи")
    @Operation(summary = "Удалить пользователя по ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @Tag(name = "Доходы")
    @Operation(summary = "Список доходов пользователя")
    @GetMapping("/{id}/incomes")
    public List<IncomeDetail> getIncomes(
            @PathVariable Long id,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        if (startDate != null && endDate != null) {
            return userService.getUserIncomes(id, startDate, endDate);
        } else if (startDate == null && endDate == null) {
            return userService.getUserIncomes(id);
        }
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Необходимо указать обе даты (startDate и endDate) или не указывать ни одной"
        );
    }

    @Tag(name = "Расходы")
    @Operation(summary = "Список расходов пользователя")
    @GetMapping("/{id}/outlays")
    public List<OutlayDetail> getOutlays(
            @PathVariable Long id,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        if (startDate != null && endDate != null) {
            return userService.getUserOutlays(id, startDate, endDate);
        } else if (startDate == null && endDate == null) {
            return userService.getUserOutlays(id);
        }
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Необходимо указать обе даты (startDate и endDate) или не указывать ни одной"
        );
    }

    @Tag(name = "Доходы")
    @Operation(summary = "Добавить доход пользователю")
    @PostMapping("/{id}/incomes")
    public IncomeDetail createIncome(
            @PathVariable Long id,
            @RequestBody CreateIncome income
    ) {
        return incomeService.createIncome(id, income);
    }


    @Tag(name = "Расходы")
    @Operation(summary = "Добавить расход пользователю")
    @PostMapping("/{id}/outlays")
    public OutlayDetail createOutlay(
            @PathVariable Long id,
            @RequestBody CreateOutlay outlay
    ) {
        return outlayService.createOutlay(id, outlay);
    }

    @Tag(name = "Категории доходов")
    @Operation(summary = "Категории доходов пользователя")
    @GetMapping("/{id}/income-categories")
    public List<IncomeCategoryDetail> getIncomeCategories(
            @PathVariable Long id
    ) {
        return incomeCategoryService.getIncomeCategoriesByUserId(id);
    }

    @Tag(name = "Категории доходов")
    @Operation(summary = "Добавить категорию доходов пользователю")
    @PostMapping("/{id}/income-categories")
    @ResponseStatus(HttpStatus.CREATED)
    public IncomeCategoryDetail createIncomeCategories(
            @PathVariable Long id,
            @RequestBody CreateIncomeCategory incomeCategoryData
    ) {
        return incomeCategoryService.createIncomeCategory(id, incomeCategoryData);
    }

}
