
# Документация для веб-приложения Sklad

### Введение    
Добро пожаловать в документацию веб-приложения Sklad!   
Sklad представляет собой систему управления складами,
позволяющую отслеживать информацию о складах и их ячейках.
В этой документации вы найдете информацию о доступных API-методах, моделях данных и инструкции по использованию. 

### Быстрый старт
Для начала использования Sklad вам необходимо выполнить следующие шаги:

### Запуск приложения: 
Запустите веб-приложение Sklad, используя класс SkladApplication.   
Приложение будет доступно по адресу https://toprag-service.store.

### Получение списка складов:
Используйте метод GET /api/v1/sklad для получения списка всех складов.

### Получение свободных ячеек склада:
Используйте метод POST /api/v1/warehouse-cell для получения списка свободных ячеек заданного склада,
указав идентификатор склада в теле запроса.

### Ресурсы API
#### SkladController     
Получение списка всех складов      
Метод: GET  
Путь:
    
    /api/v1/all-warehouse  
Описание: Получает список всех складов.     
Пример запроса: 

    https://toprag-service.store/api/v1/sklad
Пример ответа:
    
    json
    [{  
    "id": 3,    
    "point_name": "Поликарпова 2к8",    
    "point_address": "Анапа, ул. Прликарпова 2к8",  
    "latitude": 44.865969,  
    "longitude": 37.331073,     
    "count_free_cell": 3,    
    "url_images": [ 
    "https://toprag-service.ru/reports/anapapolikarpova2k8.png"
    ],   
    "schedule": "Работает круглосуточно",   
    "big_cell": 0,  
    "medium_cell": 1,   
    "small_cell": 2 
    },  

    { 
    "id": 2,    
    "point_name": "Астраханская 97",    
    "point_address": "Анапа, ул. Астраханская 97",  
    "latitude": 44.880268,  
    "longitude": 37.337493,     
    "count_free_cell": 9,   
    "url_images": [
    "https://toprag-service.ru/reports/anapaastrahanskaya97.png"
        ],
    "schedule": "Работает круглосуточно",   
    "big_cell": 3,  
    "medium_cell": 2,   
    "small_cell": 4 
    }, 

    {
    "id": 1,    
    "point_name": "Проспект Революции 3",   
    "point_address": "Анапа, Проспект Революции 3",     
    "latitude": 44.895444,  
    "longitude": 37.300619,     
    "count_free_cell": 8,   
    "url_images": [
    "https://toprag-service.ru/reports/anaparevolucii3.png"
    ],  
    "schedule": "Работает круглосуточно",   
    "big_cell": 4,  
    "medium_cell": 2,   
    "small_cell": 2 
    }]

#### WarehouseCellController 

Получение списка свободных ячеек для заданного склада   
Метод: POST     
Путь:
    
    /api/v1/warehouse-cell    
Описание: Получает список свободных ячеек для заданного склада.     
Тело запроса: Идентификатор склада.     
Пример запроса:

    https://toprag-service.store/api/v1/warehouse-cell

Пример ответа:

    json
     [ 
    {   
    "id": 1,        
    "warehouseId": 1,   
    "number": 101,  
    "category": "Категория 1",  
    "area": 50.5,   
    "length": 5.0,  
    "width": 2.5,   
    "height": 3.0,  
    "tier": 1,  
    "price": 100.0, 
    "busy": false,  
    "lockKey": null 
    },  
    // Другие ячейки...
    ]   

Модели данных   
#### SkladEntity
Модель, представляющая сущность "Склад".
    
    json
    {   
    "id": 1,    
    "pointName": "Склад 1",     
    "pointAddress": "Адрес склада 1",   
    "latitude": 55.12345,   
    "longitude": 37.54321,  
    "urlImages": ["http://example.com/image1.jpg", "http://example.com/image2.jpg"],
    "schedule": "Пн-Пт 9:00-18:00",     
    "bigCell": 10,  
    "mediumCell": 20,   
    "smallCell": 30,    
    "countFreeCell": 15 
}   
#### WarehouseCellEntity
Модель, представляющая сущность "Ячейка склада".
    
    json
    {   
    "id": 1,    
    "warehouseId": 1,   
    "number": 101,  
    "category": "Категория 1",  
    "area": 50.5,   
    "length": 5.0,  
    "width": 2.5,   
    "height": 3.0,  
    "tier": 1,  
    "price": 100.0, 
    "busy": false,  
    "lockKey": null 
    }

#### Дополнительные компоненты
CustomProperties    
Компонент, позволяющий получить пользовательские свойства.

Пример использования:

     @Autowired 
    private CustomProperties customProperties;
    
    String domain = customProperties.getDomain();   
    String password = customProperties.getPassword();   
    String service = customProperties.getService();  

#### StringListConverter 

Конвертер атрибута для преобразования списка строк в строку базы данных и обратно
(для поля urlImages в SkladEntity).

### Репозитории
#### SkladRepository
Интерфейс репозитория для работы с сущностью SkladEntity.

#### WarehouseCellRepository
Интерфейс репозитория для работы с сущностью WarehouseCellEntity.

### Сервисы
SkladService    
Сервис для работы с сущностью "Склад".

Пример использования:
    
     @Autowired
    private SkladService skladService;
    
    List<SkladEntity> allSklads = skladService.getAllSklads();  
#### WarehouseCellService
Сервис для работы с сущностью "Ячейка склада".

Пример использования:
    
     @Autowired
    private WarehouseCellService warehouseCellService;
    
    List<WarehouseCellEntity> freeCells = warehouseCellService.getWarehouseCells(1L);

#### Пользовательские настройки
Пример настроек приложения в файле application.properties:

# Дополнительные пользовательские свойства
    custom.domain=root@31.129.107.4 
    custom.password=nhP&373eBUsu    
    custom.service=toprag-service.store     

# Настройки базы данных
    spring.datasource.url=jdbc:postgresql://62.217.176.63/ozon
    spring.datasource.username=postgres
    spring.datasource.password=1172922

# Настройки Hibernate
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=none

# История изменений

    | Дата       | Версия | Описание изменений                 |
    |------------|--------|-----------------------------------|
    | 2023/11/01 | 1.0.0  | Первая версия документации Sklad API|

### Завершение
Это была краткая документация для веб-приложения Sklad. 
Если у вас есть дополнительные вопросы или вам нужна дополнительная информация,
не стесняйтесь обращаться к разработчикам. Удачного использования Sklad!

## Стек:   
    · Java   
    · Spring Boot   
    · Hibernate     
    · PostgreSQL    
    
    