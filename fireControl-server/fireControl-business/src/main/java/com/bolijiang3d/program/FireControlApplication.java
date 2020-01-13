package com.bolijiang3d.program;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableAutoConfiguration(exclude = { JpaRepositoriesAutoConfiguration.class })
@SpringBootApplication(exclude ={ DataSourceAutoConfiguration.class})
@MapperScan(basePackages= {"com.bolijiang3d.program.mapper"})
public class FireControlApplication {

    public static void main(String[] args) {
        /*try {
            SpringApplication.run(WjdcApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }*/
        SpringApplication.run(FireControlApplication.class, args);
    }

}
