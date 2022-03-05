package com.divfish.jupiter;


import com.divfish.jupiter.entity.config.YamlConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableWebMvc
public class ApplicationConfig {

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory(YamlConfig yamlConfig) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource(yamlConfig));

        sessionFactory.setPackagesToScan("com.divfish.jupiter.entity.db");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean(name = "dataSource")
    public DataSource dataSource(YamlConfig yamlConfig) {

        // TODO: ADD ENDPOINTS, USERNAME PASSWORD
//        String RDS_ENDPOINT = "rds-mysql-1.crelr6pvrmw6.us-east-2.rds.amazonaws.com";
//        String USERNAME = "admin";
//        String PASSWORD = "12345678Yy!";


        String RDS_ENDPOINT = yamlConfig.getDbInfo().getRds_endpoint();
        String USERNAME = yamlConfig.getDbInfo().getUsername();
        String PASSWORD = yamlConfig.getDbInfo().getPassword();


        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://" + RDS_ENDPOINT + ":3306/twitch?createDatabaseIfNotExist=true&serverTimezone=UTC");
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        return dataSource;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        // detect changes in Entity, Hibernate will sync the change
        // when first launched, Hibernate will create the table
        // "create-drop": drop if exists and create new
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");

        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        return hibernateProperties;
    }

    @Bean("yamlConfig")
    public YamlConfig yamlConfig() {
        // note: parse yaml
        Yaml yaml = new Yaml(new Constructor(YamlConfig.class));

        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("config/deploy.yml");
        YamlConfig yamlConfig = yaml.load(inputStream);

//        YamlConfig yamlConfig = (YamlConfig) yaml.load("./config/deploy.yml");

//        Map<String, Object> object = (Map<String, Object>) yaml.load("./config/deploy.yml");
//        System.out.println(object);
//        return (YamlConfig) object;
        System.out.println(yamlConfig);
        return yamlConfig;
    }
}


