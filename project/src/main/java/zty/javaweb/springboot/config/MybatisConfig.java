package zty.javaweb.springboot.config;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration  
@EnableTransactionManagement  
@ComponentScan
public class MybatisConfig {  
	@Resource(name="dc")
	private DruidConfig druidConfigProperties;
	
    @Bean  
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {  
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();  
        sqlSessionFactoryBean.setDataSource(dataSource);  
       // sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));  
  
       //添加Mybatis插件，例如分页，在之类创建你插件添加进去即可 
        //sqlSessionFactoryBean.setPlugins(new Interceptor[]{插件});  
        
        return sqlSessionFactoryBean.getObject();  
    }  
  
    @Bean  
    public PlatformTransactionManager transactionManager(DataSource dataSource) {  
        return new DataSourceTransactionManager(dataSource);  
    }  
  
    @Bean(initMethod = "init", destroyMethod = "close")   
    public DruidDataSource dataSource() throws SQLException {   
      DruidDataSource druidDataSource = new DruidDataSource();   
      druidDataSource.setDriverClassName(druidConfigProperties.getDriverClassName());   
      druidDataSource.setUrl(druidConfigProperties.getUrl());   
      druidDataSource.setUsername(druidConfigProperties.getUsername());   
      druidDataSource.setPassword(druidConfigProperties.getPassword());   
      druidDataSource.setInitialSize(druidConfigProperties.getMinIdle());   
      druidDataSource.setMinIdle(druidConfigProperties.getMinIdle());   
      druidDataSource.setMaxActive(druidConfigProperties.getMaxActive());   
      druidDataSource.setMaxWait(druidConfigProperties.getMaxWait());   
      druidDataSource.setTimeBetweenEvictionRunsMillis(druidConfigProperties.getTimeBetweenEvictionRunsMillis());   
      druidDataSource.setMinEvictableIdleTimeMillis(druidConfigProperties.getMinEvictableIdleTimeMillis());   
      druidDataSource.setValidationQuery(druidConfigProperties.getValidationQuery());   
      druidDataSource.setTestWhileIdle(druidConfigProperties.getTestWhileIdle());   
      druidDataSource.setTestOnBorrow(druidConfigProperties.getTestOnBorrow());   
      druidDataSource.setTestOnReturn(druidConfigProperties.getTestOnReturn());   
      druidDataSource.setPoolPreparedStatements(druidConfigProperties.getPoolPreparedStatements());   
      druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(druidConfigProperties.getMaxPoolPreparedStatementPerConnectionSize());   
      druidDataSource.setFilters(druidConfigProperties.getFilters());   
      return druidDataSource;   
    }
}  
