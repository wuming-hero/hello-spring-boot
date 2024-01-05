package com.wuming.starter.util;

import com.google.common.collect.Lists;
import com.wuming.starter.annotation.Handler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

/**
 * 注解处理工具类
 *
 * @author manji
 * @date 2024/1/5
 */
public class AnnotationUtil {

    private static final String RESOURCE_PATTERN = "/**/*.class";

    /**
     * 通用获取注解
     *
     * @param packageName
     * @param annotation
     * @return
     */
    public static List<Class<?>> getPackageAnnotation(String packageName,
                                                      Class<? extends Annotation> annotation) throws IOException, ClassNotFoundException {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        List<Class<?>> result = Lists.newArrayList();

        String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + ClassUtils.convertClassNameToResourcePath(packageName)
                + RESOURCE_PATTERN;
        Resource[] resources = resourcePatternResolver.getResources(pattern);
        MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
        for (Resource resource : resources) {
            if (resource.isReadable()) {
                MetadataReader reader = readerFactory.getMetadataReader(resource);
                //扫描到的class
                String className = reader.getClassMetadata().getClassName();
                Class<?> clazz = Class.forName(className);
                //判断是否有指定注解
                if (clazz.getAnnotation(annotation) != null) {
                    //这个类使用了自定义注解
                    result.add(clazz);
                }
            }
        }
        return result;
    }

    /**
     * 该路由
     *
     * @param packageName
     * @param type
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static List<Class<?>> getPackageAnnotation(String packageName,
                                                      String type) throws IOException, ClassNotFoundException {
        List<Class<?>> classes = AnnotationUtil.getPackageAnnotation(packageName, Handler.class);
        List<Class<?>> result = Lists.newArrayList();
        for (Class<?> handlerClass : classes) {
            Handler handler = handlerClass.getAnnotation(Handler.class);
            if (handler.type().equals(type)) {
                result.add(handlerClass);
            }
        }

        return result;
    }

    /**
     * 根据特定符号切分注解值
     *
     * @param value
     * @param split
     * @return
     */
    public static List<String> splitAnnotationValue(String value, String split) {
        return Arrays.asList(StringUtils.split(value, split));
    }

}
