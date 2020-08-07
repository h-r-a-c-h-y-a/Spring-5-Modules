package javay.main.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableCaching
@PropertySource("classpath:/javay/database.properties")
public class InfraConfig {
    @Bean
    public DataSource dataSource(
            @Value("${jdbc.driver}")String driver,
            @Value("${jdbc.url}")String url,
            @Value("${jdbc.username}")String username,
            @Value("${jdbc.password}")String password
            ) {
        DriverManagerDataSource simpleDataSource = new DriverManagerDataSource();
        simpleDataSource.setDriverClassName(driver);
        simpleDataSource.setUrl(url);
        simpleDataSource.setUsername(username);
        simpleDataSource.setPassword(password);
        return simpleDataSource;
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory (DataSource dataSource) {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource);
        sfb.setPackagesToScan("javay.main.model");
        Properties props = new Properties();
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
        sfb.setHibernateProperties(props);
        return sfb;
    }

//    @Bean
//    public BasicDataSource dataSource(
//            @Value("${jdbc.driver}")String driver,
//            @Value("${jdbc.url}")String url,
//            @Value("${jdbc.username}")String username,
//            @Value("${jdbc.password}")String password
//    ) {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(driver);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        dataSource.setInitialSize(5);
//        dataSource.setMaxActive(10);
//        return dataSource;
//    }

//    @Bean
//    public JndiObjectFactoryBean dataSource() {
//        JndiObjectFactoryBean jndiObject = new JndiObjectFactoryBean();
//        jndiObject.setJndiName("jdbc/datasource");
//        jndiObject.setResourceRef(true);
//        jndiObject.setProxyInterface(javax.sql.DataSource.class);
//        return jndiObject;
//    }

    @Bean
    public TransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
        }
}
