package topragservice.store.Sklad.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Компонент, позволяющий получить пользовательские свойства.
 */
@Component
public class CustomProperties {

    @Value("${custom.domain}")
    private String domain;

    @Value("${custom.password}")
    private String password;

    @Value("${custom.service}")
    private String service;

    // Геттеры для получения значений свойств
    public String getDomain() {
        return domain;
    }

    public String getPassword() {
        return password;
    }

    public String getService() {
        return service;
    }
}
