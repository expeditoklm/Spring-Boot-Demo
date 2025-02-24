package bj.formation.demoprojet.utils;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.convert.Jsr310Converters;

@SpringBootApplication
@EntityScan(basePackageClasses = { DemoApiApplication.class, Jsr310Converters.class })

public class DemoApiApplication {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
