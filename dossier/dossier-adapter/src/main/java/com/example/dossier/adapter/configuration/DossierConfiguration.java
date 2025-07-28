package com.example.dossier.adapter.configuration;

import com.example.dossier.adapter.outbound.persistence.mapper.DossierMyBatisMappersBasePackage;
import javax.sql.DataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@MapperScan(basePackageClasses = DossierMyBatisMappersBasePackage.class)
public class DossierConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.dossier")
    public DataSource dossierDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200", "http://frontend")  // dev and docker
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
