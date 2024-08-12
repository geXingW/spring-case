package com.gexingw.spring.mybatis.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GeXingW
 */
@Data
public class UserRole implements Serializable {

    private Long id;

    private String code;

    private String name;

}
