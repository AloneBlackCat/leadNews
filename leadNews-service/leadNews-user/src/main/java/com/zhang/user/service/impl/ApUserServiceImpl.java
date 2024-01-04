package com.zhang.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhang.model.common.dtos.Result;
import com.zhang.model.common.enums.AppHttpCodeEnum;
import com.zhang.model.user.dtos.LoginDto;
import com.zhang.model.user.pojos.ApUser;
import com.zhang.user.mapper.ApUserMapper;
import com.zhang.user.service.ApUserService;
import com.zhang.utils.common.AppJwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.HashMap;

@Service
@Slf4j
@Transactional
public class ApUserServiceImpl extends ServiceImpl<ApUserMapper, ApUser> implements ApUserService {

    /**
     * app端登录功能
     *
     * @param dto 登录信息
     */
    @Override
    public <T> Result<T> login(LoginDto dto) {

        // 正常登录
        if (StringUtils.isNotEmpty(dto.getPhone()) && StringUtils.isNotEmpty(dto.getPassword())){
            // 根据用户手机号查询用户
            ApUser apUser = getOne(Wrappers.<ApUser>lambdaQuery().eq(ApUser::getPhone, dto.getPhone()));
            if (apUser == null) {
                return Result.error(AppHttpCodeEnum.DATA_NOT_EXIST);
            }
            // 比对密码是否正确
            String pswd = DigestUtils.md5DigestAsHex((dto.getPassword() + apUser.getSalt()).getBytes());
            if (!pswd.equals(apUser.getPassword())) {
                return Result.error(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
            }
            // 返回数据
            String token = AppJwtUtil.getToken(apUser.getId().longValue());
            HashMap<String, Object> map = new HashMap<>();
            map.put("token",token);
            map.put("user",apUser);

            return Result.success(map);
        } else {
            // 游客登录
        }
        return null;
    }
}
