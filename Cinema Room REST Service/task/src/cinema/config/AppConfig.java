package cinema.config;

import cinema.model.Room;
import cinema.model.Statics;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Room roomSource(){
        return new Room();
    }
    @Bean
    public Statics staticsSource(){
        return new Statics();
    }
}
