package com.cmkj.mall.web.config;

import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 支持mybatis.type-aliases-package扫描的多包及通配符配置
 * @author swallowff
 * @create 2019/10/13
 */
public class PackagesSqlSessionFactoryBean extends SqlSessionFactoryBean {
    private static final Logger logger = LoggerFactory.getLogger(PackagesSqlSessionFactoryBean.class);

    static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

    @Override
    public void setTypeAliasesPackage(String typeAliasesPackage) {
        if (StringUtils.isBlank(typeAliasesPackage)){
            super.setTypeAliasesPackage(typeAliasesPackage);
            return;
        }
        String configs[] = typeAliasesPackage.split(",");
        if (null == configs || configs.length <= 1){
            configs = typeAliasesPackage.split(";");
        }

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resolver);

        List<String> allResult = new ArrayList<String>();
        for (int i = 0; i < configs.length; i++) {
            try {
                List<String> result = getResourcePath(configs[i], resolver, metadataReaderFactory);
                allResult.addAll(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(allResult.size() > 0) {
            super.setTypeAliasesPackage(StringUtils.join(allResult.toArray(), ","));
        }else{
            logger.warn("typeAliasesPackage:"+typeAliasesPackage+"，does not matches any packages");
        }
    }

    private List<String> getResourcePath(String typeAliasesPackage, ResourcePatternResolver resolver, MetadataReaderFactory metadataReaderFactory) throws IOException {
        List<String> result = new ArrayList<String>();

        typeAliasesPackage = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                ClassUtils.convertClassNameToResourcePath(typeAliasesPackage) + "/" + DEFAULT_RESOURCE_PATTERN;
        Resource[] resources =  resolver.getResources(typeAliasesPackage);

        if(resources != null && resources.length > 0){
            MetadataReader metadataReader = null;
            for(Resource resource : resources){
                if(resource.isReadable()){
                    metadataReader =  metadataReaderFactory.getMetadataReader(resource);
                    try {
                        result.add(Class.forName(metadataReader.getClassMetadata().getClassName()).getPackage().getName());
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
    }



}
