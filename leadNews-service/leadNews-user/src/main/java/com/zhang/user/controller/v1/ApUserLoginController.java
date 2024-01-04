package com.zhang.user.controller.v1;

import com.zhang.model.common.dtos.Result;
import com.zhang.model.user.dtos.LoginDto;
import com.zhang.user.service.ApUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/login")
public class ApUserLoginController {

    @Autowired
    private ApUserService apUserService;

    @PostMapping
    public <T> Result<T> login(LoginDto dto) {
        return apUserService.login(dto);
    }
}
