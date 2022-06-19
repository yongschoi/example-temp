package yongs.temp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages="yongs.temp.mapper")
public class MybatisConfig {
	
}
