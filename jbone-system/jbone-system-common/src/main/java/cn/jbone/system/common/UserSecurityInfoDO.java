package cn.jbone.system.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserSecurityInfoDO implements Serializable {
    private String password;
    private int locked;
    private String salt;
}
