package com.bolijiang3d.program.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.bolijiang3d.program.common.constants.Constants;
import com.bolijiang3d.program.common.model.ResponseMsg;
import com.bolijiang3d.program.entity.Admin;
import com.bolijiang3d.program.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjf
 * @since 2020-01-02
 */
@RestController
@RequestMapping("/admin")
@Api(value = "admin")
public class AdminController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);


    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login")
    @ApiOperation(value = "登录")
    @ResponseBody
    public ResponseMsg login(
            @ApiParam(name = "id",value = "编号")@RequestParam(name = "id",required = true) String id){
        Admin admin = adminService.selectById(id);
        System.out.println("id："+id+";Admin:"+admin);
        LOG.info("admin:"+admin);
        EntityWrapper<Admin> wrapper=new EntityWrapper<>();
        if (id != null && "".equals(id)){
            wrapper.eq("id",id);
        }
        LOG.info("Warrer:"+wrapper);
        Page<Admin> page = adminService.selectPage(new Page<>(1,5),wrapper);

        return new ResponseMsg(Constants.CODE_SUCCESS, Constants.MSG_SUCCESS, page);
    }
}

