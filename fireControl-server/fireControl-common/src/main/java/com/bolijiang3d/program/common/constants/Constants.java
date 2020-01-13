package com.bolijiang3d.program.common.constants;

public class Constants {

    // 接口返回码
    public final static int CODE_SUCCESS = 200;
    public final static String MSG_SUCCESS = "请求成功";
    public final static int CODE_INVALID_CODE = 201;
    public final static String MSG_INVALID_CODE = "无效校验码";
    public final static int CODE_INVALID_REQUEST = 202;
    public final static String MSG_INVALID_REQUEST = "无效请求";
    public final static int CODE_INVALID_USER = 203;
    public final static String MSG_INVALID_USER = "无效用户";
    public final static int CODE_ERROR = 500;
    public final static String MSG_ERROR = "请求失败";
    public final static int CODE_FAIL = 400;
    public final static String MSG_FAIL = "服务器出错";
    public final static int CODE_NOT_FIND = 404;
    public final static String MSG_NOT_FIND = "地址找不到";

    // 参数解密KEY
    public static final String AES_DECRYPT_KEY = "4e92604801cc4d11";


    //业务配置
    public static final int DEFAULT_PAGE_SIZE = 10;  //默认查询页数

}
