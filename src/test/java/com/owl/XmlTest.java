package com.owl;

import com.alibaba.fastjson.JSON;
import com.owl.core.constants.XmlC;
import com.owl.core.model.DubboInterface;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wanghouping on 2017/9/29.
 * @author wang hou ping
 */
public class XmlTest{

    public static void main(String[] args) throws DocumentException {
        SAXReader saxReade = new SAXReader();
        Document read = saxReade.read(XmlTest.class.getResourceAsStream("/dubbo/spring-dubbo-services.xml"));
        Element rootElement = read.getRootElement();
        Iterator<Element> elementIterator = rootElement.elementIterator();
        DubboInterface dubboInterface;
        List<DubboInterface> list = new ArrayList<DubboInterface>();
        while(elementIterator.hasNext()) {
            dubboInterface = new DubboInterface();
            Element element = elementIterator.next();
            String interfaceName = element.attributeValue(XmlC.INTERFACE);
            String versionName = element.attributeValue(XmlC.VERSION);
            dubboInterface.setInterfaceName(interfaceName);
            dubboInterface.setVersion(versionName);
            list.add(dubboInterface);
        }
        System.out.println("测试---" + JSON.toJSONString(list));
    }
}
