package com.jfcbxp.rommanel.agendamento.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Objects;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.br.zenitharapi.repository",
        entityManagerFactoryRef = "zenitharEntityManager",
        transactionManagerRef = "zenitharTransactionManager"
)
@RequiredArgsConstructor
public class RepositoryConfig {
    private final Environment env;


    @Bean("agendamentoEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManager() {
        var em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.jfcbxp.rommanel.agendamento.domain");

        var vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("jpa.hibernate.ddl.auto"));
        properties.put("hibernate.show_sql", env.getProperty("jpa.show.sql"));
        properties.put("hibernate.format_sql", env.getProperty("jpa.format.sql"));
        properties.put("hibernate.dialect", env.getProperty("jpa.dialect"));
        properties.put("spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults", false);
        properties.put("spring.datasource.default-transaction-isolation-level", 1);

        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean("agendamentoDataSource")
    public DataSource dataSource() {
        var dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("sql.database.url"));
        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("sql.driver")));
        dataSource.setUsername(env.getProperty("sql.database.username"));
        dataSource.setPassword(env.getProperty("sql.database.password"));
        return dataSource;
    }

    @Bean("agendamentoTransactionManager")
    public PlatformTransactionManager transactionManager() {
        var transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager().getObject());
        return transactionManager;
    }

}
