package com.tledu.mybatis.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private Integer id;
    private String addr;
    private String phone;
    private String postcode;
    private Integer userId;

    private User user;
}
