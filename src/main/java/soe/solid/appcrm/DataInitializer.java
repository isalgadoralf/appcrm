package soe.solid.appcrm;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class DataInitializer {

    private final DataSource dataSource;

    public DataInitializer(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public ApplicationRunner initializer() {
        return args -> {
            // Ejecutar el script import.sql después de que la aplicación esté completamente inicializada
            ResourceDatabasePopulator populator = new ResourceDatabasePopulator(new ClassPathResource("import.sql"));
            populator.execute(dataSource);
        };
    }
}