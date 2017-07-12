package com.coolapps;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
@Configuration
@SpringBootApplication
public class OrganiserApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganiserApplication.class, args);
	}
	
	@Bean
	@Autowired
	public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);

	    Properties jpaProperties = new Properties();
	    jpaProperties.setProperty("hibernate.show_sql", "true");
	    jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    jpaProperties.setProperty("hibernate.id.new_generator_mappings", "true");

	    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	    localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
	    localContainerEntityManagerFactoryBean.setPackagesToScan("com.coolapps");
	    localContainerEntityManagerFactoryBean.setDataSource(dataSource);
	    localContainerEntityManagerFactoryBean.setJpaProperties(jpaProperties);
	    localContainerEntityManagerFactoryBean.afterPropertiesSet();

	    return localContainerEntityManagerFactoryBean.getObject();
	}

	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
	    jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
	    return jpaTransactionManager;
	}
}
