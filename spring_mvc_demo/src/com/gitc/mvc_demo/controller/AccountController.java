package com.gitc.mvc_demo.controller;

import com.gitc.mvc_demo.model.Account;
import com.gitc.mvc_demo.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.initDirectFieldAccess();
        binder.setDisallowedFields("id");
        binder.setRequiredFields("name", "balance");
    }

    @GetMapping("/open-account")
    public String openAccountForm() {
        return "account-form";
    }

    //    @GetMapping("/account")
//    public String getAccountDetails(ModelMap modelMap,
//                                    @RequestParam("accountId") long accountId) {
//        Account account = accountService.findOne(accountId);
//        modelMap.put("account", account);
//        return "account-details";
//    }
    @GetMapping("/account/{accountId}")
    public String getAccountDetails(ModelMap modelMap,
                                    @PathVariable Long accountId) {
        Account account = accountService.findOne(accountId);
        modelMap.put("account", account);
        return "account-details";
    }

    @PostMapping("/open-account")
    public String save(@Valid @ModelAttribute("account") Account account,
                       Errors errors) {
        if (errors.hasErrors()) {
           return "account-form";
        }
        accountService.open(account);
        return "redirect:/account/" + account.getId();
    }

    @GetMapping("/all-accounts")
    public String all(ModelMap modelMap) {
        List<Account> accounts = accountService.findAll();
        modelMap.put("accounts", accounts);
        return "accounts";
    }
}
