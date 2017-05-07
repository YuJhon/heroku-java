package com.jhon.herokudemo.utils;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


/**
 * <p>功能描述</br> properties文件获取工具类</p>
 * 
 * @className PropFileUtil
 * @author jiangyu
 * @date 2016年4月11日 上午9:11:28
 * @version v1.0
 */
public class PropFileUtil
{
    private static String properiesName = "";

    private PropFileUtil()
    {}

    private static final class PropHolder
    {
        private static final PropFileUtil INSTANCE = new PropFileUtil();
    }

    public static PropFileUtil getInstance(String properiesName)
    {
        PropFileUtil.properiesName = properiesName;
        return PropHolder.INSTANCE;
    }

    /**
     * <p> 功能描述：读取配置文件</p>
     * 
     * @author jiangyu
     * @date 2016年4月11日 上午9:13:15
     * @param key
     * @return
     * @version v1.0
     * @since V1.0
     */
    public String readProperty(String key)
    {
        String value = "";
        InputStream is = null;
        try
        {
            is = PropFileUtil.class.getClassLoader().getResourceAsStream(properiesName);
            Properties p = new Properties();
            p.load(is);
            value = p.getProperty(key);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                is.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return value;
    }

    /**
     * <p> 功能描述：获取properties对象</p>
     * 
     * @author jiangyu
     * @date 2016年4月11日 上午9:13:36
     * @return
     * @version v1.0
     * @since V1.0
     */
    public Properties getProperties()
    {
        Properties p = new Properties();
        InputStream is = null;
        try
        {
            is = PropFileUtil.class.getClassLoader().getResourceAsStream(properiesName);
            p.load(is);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                is.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return p;
    }

    /**
     * <p> 功能描述：写properties属性值</p>
     * 
     * @author jiangyu
     * @date 2016年4月11日 上午9:14:02
     * @param key
     * @param value
     * @version v1.0
     * @since V1.0
     */
    public void writeProperty(String key, String value)
    {
        InputStream is = null;
        OutputStream os = null;
        Properties p = new Properties();
        try
        {
            is = new FileInputStream(properiesName);
            p.load(is);
            os = new FileOutputStream(PropFileUtil.class.getClassLoader().getResource(
                properiesName).getFile());

            p.setProperty(key, value);
            p.store(os, key);
            os.flush();
            os.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (null != is) is.close();
                if (null != os) os.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}
