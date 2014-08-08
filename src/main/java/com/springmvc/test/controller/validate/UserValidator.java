package com.springmvc.test.controller.validate;

import com.springmvc.test.common.dao.helper.RecordNotFound;
import com.springmvc.test.dao.UserDao;
import com.springmvc.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

public class UserValidator extends BaseValidator {
    @Autowired(required = true)
    @Qualifier(value = "UserDao")
    private UserDao userDao;

    private static final String ERROR_CODE = "验证码输入不正确";
    private static final String ERORR_CONFIRM_PWD = "两次输入的密码不相同";

    protected Map<String, String> validate(User user, String code) {
        Map<String, String> errorMessageMap = super.validate(user);
        validateConfirmPwd(user, errorMessageMap);
        vaildateCode(user, code, errorMessageMap);
        validateSameUserName(user, errorMessageMap);
        return errorMessageMap;
    }

    private void validateSameUserName(User user, Map<String, String> errorMessageMap) {
        try {
            userDao.findByName(user.getUsername());
            errorMessageMap.put("user","用户名已经被注册");
        } catch (RecordNotFound e) {
        }
    }

    private void vaildateCode(User user, String code, Map<String, String> errorMessageMap) {
        if (code != null) {
            if (!code.equalsIgnoreCase(user.getVerificationCode())) {
                errorMessageMap.put("code", ERROR_CODE);
            }
        }
    }

    private void validateConfirmPwd(User user, Map<String, String> errorMessageMap) {
        if (!user.getPassword().equals(user.getConfirmPwd())) {
            errorMessageMap.put("password", ERORR_CONFIRM_PWD);
        }
    }
}
