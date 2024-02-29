package com.hgm.bean;

import com.hgm.anno.Bean;
import com.hgm.anno.Di;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationApplicationContext implements ApplicationContext {

    /**  存储bean的容器  **/
    private Map<Class, Object> beanFactory = new HashMap<>();
    /**  根路径  **/
    private static String rootPath;


    /**
     * 返回对象
     */
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }


    /**
     * 创建有参构造，传递包路径，设置包扫描规则
     * @param basePackage
     */
    public AnnotationApplicationContext(String basePackage) {
        // 当前包及其子包，哪个类有@Bean注解，把这个类通过反射实例化
        try {
            // 1、替换.为\
            String packagePath = basePackage.replaceAll("\\.", "\\\\");

            // 2、获取包的绝对路径
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                // 获取解码后的全路径
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");

                // 截取包前面固定的部分
                rootPath = filePath.substring(0, filePath.length() - packagePath.length());

                loadBean(new File(filePath));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 属性注入
        loadDi();
    }


    /**
     * 加载Bean对象
     * @param file
     * @throws Exception
     */
    private void loadBean(File file) throws Exception {
        // 1. 判断当前是否文件夹
        if (file.isDirectory()) {
            // 2. 获取文件夹里面的所有内容
            File[] childFiles = file.listFiles();

            // 3. 判断文件夹里面是否为空，直接返回
            if (childFiles.length == 0 || childFiles == null) {
                return;
            }

            // 4. 如果内容不为空，遍历所有内容
            for (File child : childFiles) {
                // 4.1 遍历得到每个File对象，继续判断是否文件递归
                if (child.isDirectory()) {
                    // 递归
                    loadBean(child);
                } else {
                    // 4.2 遍历得到的不是File对象，是文件
                    // 4.3 得到包路径+类名称部分-字符串截取
                    String pathWithClass = child.getAbsolutePath().substring(rootPath.length() - 1);

                    // 4.4 判断当前文件类型是否.class
                    if (pathWithClass.contains(".class")) {
                        // 4.5 如果是，则把路径\替换成 . 把.class去掉
                        String allName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");

                        // 4.6 判断类上面是否有注解@Bean，如果有则实例化
                        // 4.6.1 获取类的Class
                        Class<?> clazz = Class.forName(allName);
                        // 4.6.2 判断是不是接口
                        if (!clazz.isInterface()) {
                            // 4.6.3 判断类上面是否有注解 @Bean
                            Bean bean = clazz.getAnnotation(Bean.class);
                            if (bean != null) {
                                // 4.6.4 实例化
                                Object instance = clazz.getConstructor().newInstance();
                                // 4.7 把对象实例化后，放到map集合beanFactory中
                                // 4.7.1 判断当前类如果有接口，让接口class作为map的key，没有则让自己的class作为key
                                if (clazz.getInterfaces().length > 0) {
                                    beanFactory.put(clazz.getInterfaces()[0], instance);
                                } else beanFactory.put(clazz, instance);
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * 属性注入
     */
    private void loadDi() {
        // 实例化的对象都在beanFactory的Map集合中
        // 1、遍历beanFactory的Map集合
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for (Map.Entry<Class, Object> entry : entries) {
            // 2、获取Map集合中的每个对象（value），每个对象属性获取到
            Object obj = entry.getValue();
            Class<?> clazz = obj.getClass();
            // 获取所有属性
            Field[] declaredFields = clazz.getDeclaredFields();

            // 3、遍历得到每个对象属性数组，得到每个属性
            for (Field field : declaredFields) {
                // 4、判断属性上面是否有@Di注解
                Di annotation = field.getAnnotation(Di.class);
                if (annotation!=null){
                    // 如果私有属性，可以设置值
                    field.setAccessible(true);
                    // 5、如果有@Di注解，把对象进行设置（注入）
                    try {
                        field.set(obj,beanFactory.get(field.getType()));// 字段类型获取对象
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}