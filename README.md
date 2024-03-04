# SpringBoot 3.2.3 + MyBatis + Vue 게시판
<hr>

### 1. 초기 설정
> mybatis, lombok, mysql


### 2. 데이터 베이스 연동
> application.properties 내부에
> 
> mysql 드라이버, 계정, 비밀번호 설정

### 둘 중 선택

#### 1) mapper 경로 설정 (*.xml)파일 
```xml
# Mapper Xml Location
mybatis.mapper-locations=classpath:mappers/**.xml
-> mapper.xml 파일 위치설정
mybatis.type-aliases-package=com.example.toyproject01.dto
-> DTO 객체 위치
```

#### 2) MybatisConfig.java 설정
```java
package com.example.toyproject01.config;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


    // application.properties 설정 대신 좀더 상세한 설정을 위한 config
    @Configuration
    @Lazy
//@EnableTransactionManagement
    @RequiredArgsConstructor
    @MapperScan(basePackages = "com.example.toyproject01.mapper")
    public class MybatisConfig {

        private final ApplicationContext context;

        @Bean
        public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

            sessionFactory.setDataSource(dataSource);
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

            sessionFactory.setMapperLocations(
                    context.getResources( // 1
                            // 실제 쿼리가 들어갈 xml 패키지 경로
                            "classpath:/mappers/**.xml"
                    ));

            // Value Object를 선언해 놓은 package 경로
            // Mapper의 result, parameterType의 패키지 경로를 클래스만 작성 할 수 있도록 도와줌.
            sessionFactory.setTypeAliasesPackage("com.example.toyproject01.mapper");
            return sessionFactory.getObject();
        }

        // Mybatis Template
        @Bean
        public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
            SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);

            sqlSessionTemplate.getConfiguration().setMapUnderscoreToCamelCase(true);

//        sqlSessionTemplate.getConfiguration().setUseGeneratedKeys(true);
            return sqlSessionTemplate;
        }

        @Bean
        public DataSourceTransactionManager transactionManager(DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }
    }



```

#### mapper.xml 파일
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- dtd 선언 -->

<mapper namespace="com.example.toyproject01.mapper.PostMapper">
<!--  mapper.java 인터페이스 경로  -->
    <select id="findAllPosts" parameterType="int" resultType="com.example.toyproject01.dto.PostDTO">
<!--    resultType 데이터 경로 PostDTO라고 적어도 되는 듯함    -->
        select * from board where no=#{no}
    </select>
</mapper>
```

#### 데이터 조회 흐름 
Controller <-> service <-> DAO <-> mapper

<br>

### 3. Vue.js 설정

 