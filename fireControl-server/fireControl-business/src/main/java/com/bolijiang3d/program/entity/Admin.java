package com.bolijiang3d.program.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zjf
 * @since 2020-01-02
 */
@Data
@Accessors(chain = true)
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String realname;
    private Long age;
    @TableField("phone_number")
    private String phoneNumber;
    @TableField("head_picture")
    private String headPicture;
    @TableField("add_date")
    private Date addDate;
    @TableField("update_date")
    private Date updateDate;
    private String state;


}
