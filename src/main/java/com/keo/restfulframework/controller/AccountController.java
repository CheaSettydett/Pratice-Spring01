package com.keo.restfulframework.controller;

import com.keo.restfulframework.mapper.AutoAccountMapper;
import com.keo.restfulframework.model.Account;
import com.keo.restfulframework.model.response.AccountResponse;
import com.keo.restfulframework.service.AccountService;
import com.keo.restfulframework.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/account")
public class AccountController {
    final private AccountService accountService;
    private final AutoAccountMapper autoAccountMapper;


    public AccountController(AccountService accountService ,AutoAccountMapper autoAccountMapper) {
        this.accountService = accountService;
        this.autoAccountMapper = autoAccountMapper;
    }

    @GetMapping("/all-account")
    public Response<List<AccountResponse>> getAllAccount(){
        try{
            //modelmapper ,mapstrust
            List<Account> allAccount = accountService.getAllAccount();
            List<AccountResponse> accountResponses = autoAccountMapper.mapToAccountResponse(allAccount);
            return Response.<List<AccountResponse>>ok().setPayload(accountResponses).setMessage("successfully retrived all account");
//            HashMap<String , Object> response = new HashMap<>();
//            response.put("payload", accountResponses);
//            response.put("message","Successfully retrieve all account info!");
//            response.put("status", HttpStatus.OK);
//            return ResponseEntity.ok().body(response);
//            List<Account> allAccount = accountService.getAllAccount();
        }catch (Exception ex){
            System.out.println("Something wrong :" +ex.getMessage());
            return Response.<List<AccountResponse>>exception().setMessage("Exception occur! Failture to retrived account information");
        }
    }
}
