package topragservice.store.Sklad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Контроллер для обработки запросов, связанных с технической документацией API.
 * В данном контексте используется для отображения документации на веб-странице.
 */

@Controller
@RequestMapping("/api")
public class DocumentationController {

    /**
     * Обрабатывает GET-запрос для отображения технической документации API.
     *
     * @return Имя HTML-шаблона (без расширения .html), который будет отображен в ответе.
     */

    @GetMapping("/documentation")
    public String showDocumentation() {
        return "Documentation"; // это возвращает имя HTML-шаблона (без расширения .html)
    }

}

