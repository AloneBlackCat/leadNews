package com.zhang.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhang.model.common.dtos.Result;
import com.zhang.model.user.dtos.LoginDto;
import com.zhang.model.user.pojos.ApUser;

public interface ApUserService extends IService<ApUser> {

    /**
     * app 登录功能
     */
    <T> Result<T> login(LoginDto dto);
}
