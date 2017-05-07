package com.jhon.herokudemo.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhon.herokudemo.utils.ConfigUtils;

/**
 * <p>功能描述</br> 测试profile</p>
 * @className  HerokuController
 * @author  jiangy19
 * @date  2017年5月7日 下午12:04:41
 * @version  v1.0
 */
@Controller
@RequestMapping("/heroku")
public class HerokuController
{
    private static final Logger LOG = Logger.getLogger(HerokuController.class);
    
    @RequestMapping(value = "/getConfigProfile.do", method = RequestMethod.GET)
    @ResponseBody
    public Object getConfigProfile()
    {
        LOG.info("====================Method Has Coming =================");
        return ConfigUtils.getInstance().getRemarkProcProp("project.env");
    }
}
