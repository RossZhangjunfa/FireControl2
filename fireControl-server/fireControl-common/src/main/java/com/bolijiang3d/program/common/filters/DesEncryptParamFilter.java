package com.bolijiang3d.program.common.filters;

import com.bolijiang3d.program.common.constants.Constants;
import com.bolijiang3d.program.common.utils.AesUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 参数解密过滤器
 */
public class DesEncryptParamFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Map<String, Object> map = new HashMap<String, Object>();
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            String value = request.getParameter(paraName);
            try {
                if(StringUtils.isNotBlank(value)){
                    String desValue = AesUtil.aesDecrypt(value, Constants.AES_DECRYPT_KEY);
                    map.put(paraName, desValue);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        request = new RequestHelper((HttpServletRequest) request, map);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {}

}
