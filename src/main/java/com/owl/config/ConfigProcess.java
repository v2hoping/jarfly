package com.owl.config;

import com.owl.core.constants.PropertiesC;
import com.owl.core.constants.XmlC;
import com.owl.core.interfaces.IConfigProcess;
import com.owl.core.model.Config;
import com.owl.core.model.DubboInterface;
import com.owl.core.model.Result;
import com.owl.utils.PropertiesUtils;
import com.owl.utils.ValidationResult;
import com.owl.utils.ValidatorUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * Created by wanghouping on 2017/10/1.
 * @author wang hou ping
 */
public class ConfigProcess implements IConfigProcess{

    private Config config = null;

    @Override
    public void fillConfig(Config config) throws IOException, DocumentException {
        //<1>解析配置文件，获得端口
        Properties properties = PropertiesUtils.getProperties(PropertiesC.APPLIATION_PROPERTIES);
        String include = properties.getProperty(PropertiesC.PROPER_SPRING_PROFILES_INCLUDE);
        String jarHttpPort = properties.getProperty(PropertiesC.PROPER_SERVICE_PORT);
        String jarDubboPort = properties.getProperty(PropertiesC.PROPER_DUBBO_PORT);
        //<2>解析Dubbo对外服务接
        SAXReader saxReade = new SAXReader();
        Document read = saxReade.read(this.getClass().getResourceAsStream("/dubbo/spring-dubbo-services.xml"));
        Element rootElement = read.getRootElement();
        Iterator<Element> elementIterator = rootElement.elementIterator();
        DubboInterface dubboInterface;
        List<DubboInterface> list = new ArrayList<DubboInterface>();
        while(elementIterator.hasNext()) {
            dubboInterface = new DubboInterface();
            Element element = elementIterator.next();
            dubboInterface.setInterfaceName(element.attributeValue(XmlC.INTERFACE));
            dubboInterface.setVersion(element.attributeValue(XmlC.VERSION));
            list.add(dubboInterface);
        }
        //<3>保存为公共配置
        config.setInclude(include);
        config.setDubboServices(list);
        config.setJarDubboPort(jarDubboPort);
        config.setJarHttpPort(jarHttpPort);
        //<4>保存配置
        this.config = config;
    }

    @Override
    public Result checkConfig() {
        //<1>验证配置对象不能为NULL
        Result result = new Result();
        result.setFlag(false);
        if(config == null) {
            result.setErrorMsg("config配置对象为NULL！");
            return result;
        }
        //<2>验证内部属性
        ValidationResult validationResult = ValidatorUtils.validateEntity(result);
        if(validationResult.getHasErrors()) {
            result.setErrorMsg(validationResult.getErrorString());
            return result;
        }
        //<3>验证Rsa秘钥和密码不能都为空
        if(StringUtils.isBlank(config.getPassword()) && StringUtils.isBlank(config.getRsaKey())) {
            result.setErrorMsg("Ras秘钥和密码不能为空！");
            return result;
        }
        //<4>正常
        result.setFlag(true);
        return result;
    }

    @Override
    public Result checkConfig(Config config) {
        //<1>验证配置对象不能为NULL
        Result result = new Result();
        result.setFlag(false);
        if(config == null) {
            result.setErrorMsg("config配置对象为NULL！");
            return result;
        }
        //<2>验证内部属性
        ValidationResult validationResult = ValidatorUtils.validateEntity(result);
        if(validationResult.getHasErrors()) {
            result.setErrorMsg(validationResult.getErrorString());
            return result;
        }
        //<3>验证Rsa秘钥和密码不能都为空
        if(StringUtils.isBlank(config.getPassword()) && StringUtils.isBlank(config.getRsaKey())) {
            result.setErrorMsg("Ras秘钥和密码不能为空！");
            return result;
        }
        //<4>正常
        result.setFlag(true);
        return result;
    }


}
