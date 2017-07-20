package com.mengfw.rms.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * Created by MFW on 2017/5/29.
 */
@Data
public class LoginForm implements Serializable {
    private static final long serialVersionUID = -8195107446554743952L;
    @NotBlank(message = "登录手机号不能为空")
    @Pattern(regexp = "^\\d{11}$",message = "手机号格式不正确")
    private String mobile;
    @NotBlank(message = "密码不能为空")
    private String password;
}
