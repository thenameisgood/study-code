package com.wang.domain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-11-04 10:57:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    
    private Long id;
    
    private String name;
    
    private String password;
    
    private String email;
    /**
     * 类型
     */
    private Integer roleId;
    /**
     * 0正常，1禁用
     */
    private Integer status;
    
    private Date createTime;
    
    private Date updateTime;
    
    private String deleteTime;
    
    private String deleteFlag;

}

