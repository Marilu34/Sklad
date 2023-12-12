package topragservice.store.Sklad.configuration;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация Swagger для группировки эндпоинтов API и предоставления соответствующей документации.
 */

@Configuration
public class SwaggerConfig {


    /**
     * Создает группу Swagger для эндпоинтов с префиксом "/api".
     *
     * @return Группа Swagger для эндпоинтов с префиксом "/api".
     */

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder().group("api").pathsToMatch("/api/**").build();
    }
}
