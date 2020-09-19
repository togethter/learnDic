package com.itheima.mybatis.utils;
import com.itheima.mybatis.annotations.Select;
import com.itheima.mybatis.cfg.Configuration;
import com.itheima.mybatis.cfg.Mapper;
import com.itheima.mybatis.io.Resources;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于解析配置文件
 * 使用的技术：
 * dom4j+xpath
 */
public class XMLConfigBuilder {
    public static Configuration loadConfiguration(InputStream config) {
        // 定义封装连接信息的配置对象(mybatis的配置对象)
        Configuration cfg = new Configuration();
        // 1、获取SAXReader对象
        SAXReader reader = new SAXReader();
        // 2、根据字节输入流获取Document对象
        try {
            Document document = reader.read(config);
            Element root = document.getRootElement();
            List<Element> propertyElements = root.selectNodes("//property");
            for (Element propertyElement : propertyElements) {
                String name = propertyElement.attributeValue("name");
                if ("driver".equals(name)) {
                    // 表示驱动
                    String driver = propertyElement.attributeValue("value");
                    cfg.setDriver(driver);
                }
                if ("url".equals(name)) {
                    String url = propertyElement.attributeValue("value");
                    cfg.setUrl(url);
                }
                if ("username".equals(name)) {
                    // 表示用户名
                    // 获取property标签value属性的值
                    String username = propertyElement.attributeValue("value");
                    cfg.setUsername(username);
                }
                if ("password".equals(name)) {
                    // 表示密码
                    // 获取property标签value属性的值
                    String password = propertyElement.attributeValue("value");
                    cfg.setPassword(password);
                }
            }
            List<Element> mapperElements = root.selectNodes("//mappers/mapper");
            // 遍历集合
            for (Element mapperElement : mapperElements) {
                // 判断mapperElement使用的时哪个属性
                Attribute attribute = mapperElement.attribute("resource");
                if (attribute != null) {
                    System.out.println("使用的时XML");
                    // 表示有resource属性，用的时XML
                    // 取出属性的值
                    String mapperPath = attribute.getValue();// 获取属性的值"com/itheima/dao/IUserDao.xml"
                    // 把映射配置文件的内容获取出来，封装成一个map
                    Map<String, Mapper> mappers = loadMapperConfiguration(mapperPath);
                    cfg.setMappers(mappers);
                } else {
                    System.out.println("使用的时注解");
                    // 表示没有resource属性，用的时注解
                    // 获取class属性的值
                    String daoClassPath = mapperElement.attributeValue( "class");
                    // 根据daoClassPath获取封装的必要信息
                    Map<String, Mapper> mappers = loadMapperAnnotation(daoClassPath);
                    cfg.setMappers(mappers);
                }
            }
            return cfg;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                config.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return cfg;
        }
    }

    public static Map<String, Mapper> loadMapperAnnotation(String daoClassPath) throws Exception {
        // 定义返回值对象
        Map<String, Mapper> mappers = new HashMap<String, Mapper>();
        // 1、得到dao接口的字节码对象
        Class daoClass = Class.forName(daoClassPath);
        // 2、得到dao接口中的方法数组
        Method[] methods = daoClass.getMethods();
        // 3、遍历Method数组
        for (Method method : methods) {
            // 取出每一个方法，判断是否有select注解
            boolean isAnnotated = method.isAnnotationPresent(Select.class);
            if (isAnnotated) {
                Mapper mapper = new Mapper();
                Select selectAnno = method.getAnnotation(Select.class);
                String queryString = selectAnno.value();
                mapper.setQueryString(queryString);
                // 获取当前方法的返回值，还要求必须带有泛型信息
                Type type = method.getGenericReturnType();
                // List<User>
                // 判断type是不是参数化的类型
                if (type instanceof ParameterizedType) {
                    // 强转
                    ParameterizedType ptype = (ParameterizedType) type;
                    // 得到参数化类型中的实际类型参数
                    Type[] types = ptype.getActualTypeArguments();
                    // 取出第一个
                    Class domainClass = (Class) types[0];
                    // 获取domainClass的类名
                    String resultType = domainClass.getName();
                    // 给Mapper赋值
                    mapper.setResultType(resultType);
                }
                // 组装Key的信息
                // 获取方法的名称
                String methodName = method.getName();
                String className = method.getDeclaringClass().getName();
                String key = className + "." + methodName;
                // 给map赋值
                mappers.put(key,mapper);
            }
        }
        return mappers;
    }

    public static Map<String, Mapper> loadMapperConfiguration(String mapperPath) throws IOException {
        InputStream in = null;
        try {
            // 定义返回值对象
            Map<String, Mapper> mappers = new HashMap<String, Mapper>();
            // 1、根据路径获取字节输入流
            in = Resources.getResourceAsStream(mapperPath);
            // 2、根据字节输入流获取Document对象
            SAXReader reader = new SAXReader();
            Document document = reader.read(in);
            // 3、获取根节点
            Element root = document.getRootElement();
            // 4、获取根节点的namespace属性取值
            String namespace = root.attributeValue("namespace");// 是组成map中key的部分
            // 5、获取所有的select节点
            List<Element> selectElements = root.selectNodes("//select");
            // 6、遍历select节点集合
            for (Element selectElement : selectElements) {
                // 取出id属性的值 组成map中key的部分
                String id = selectElement.attributeValue("id");
                // 取出resultType属性的值 组成map中value的部分
                String resultType = selectElement.attributeValue("resultType");
                // 取出文本内容       组成map中value的部分
                String quertyString = selectElement.getText();
                // 创建key
                String key = namespace + "." + id;
                // 创建value
                Mapper mapper = new Mapper();
                mapper.setQueryString(quertyString);
                mapper.setResultType(resultType);
                // 把key和value存入mappers中
                mappers.put(key, mapper);
            }
            return mappers;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            in.close();
        }
    }
}
