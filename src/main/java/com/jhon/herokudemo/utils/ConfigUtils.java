package com.jhon.herokudemo.utils;

import java.util.Properties;

public class ConfigUtils
{
    private static Properties properties = null;

    private ConfigUtils()
    {
        properties = PropFileUtil.getInstance("/config/db.properties").getProperties();
    }

    private static final class RemarkProcHolder
    {
        private static final ConfigUtils INSTANCE = new ConfigUtils();
    }

    public static ConfigUtils getInstance()
    {
        return RemarkProcHolder.INSTANCE;
    }

    /**
     * <p> 功能描述：获取配置文件信息</p>
     * 
     * @author jiangyu
     * @date 2016年9月27日 上午9:10:47
     * @param key
     *            获取属性 值
     * @return
     * @version v1.0
     * @since V1.0
     */
    public String getRemarkProcProp(String key)
    {
        return properties.getProperty(key);
    }

    /**
     * <p> 功能描述：获取中文的备注信息 </p>
     * 
     * @author jiangyu
     * @date 2016年9月27日 上午9:23:42
     * @param key 模板标识
     * @param params 模板中需要替换的参数
     * @return 返回替换后的模板字符串
     * @version v1.0
     * @since V1.0
     */
    public String getRemarkReplacedStr(String key, Object... params)
    {
        String templateStr = ConfigUtils.getInstance().getRemarkProcProp(key);
        if (!CollectionUtil.isEmpty(params))
        {
            for (int i = 0; i < params.length; i++ )
            {
                /** 为空的判断 **/
                if (CollectionUtil.isEmpty(params[i]))
                {
                    params[i] = "";
                }
                templateStr = templateStr.replace("{"+i+"}", params[i].toString());
            }
        }
        return templateStr;
    }
}
