package com.gexingw.spring.mybatis.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GeXingW
 */
@Data
public class UserVO implements Serializable {

    private Long id;

    private String name;

    private Role role;

    @Data
    public static class Role {
        private Long id;

        private String code;

        private String name;
    }

}
