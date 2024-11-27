# Lib
Приложение "Библиотека"


## Особенности

- Система для учета книг клиентов


## Технологии

- Java 8
- JDK 1.8
- Spring Boot 2.x
- Spring Data JPA (Hibernate)
- PostgreSQL 15
- Maven

## Установка и запуск

### Предварительные требования

- [JDK 1.8+](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/)

### Шаги для запуска

1. **Клонирование репозитория**

   ```bash
   git clone https://github.com/Alexandr893/lib-.git
   cd lib-

2. Убедитесь, что у вас установлен PostgreSQL и доступны настройки подключения.

 - Настройте пользователя и пароль, если необходимо, в соответствии с вашим application.properties.

3. Используйте Maven для сборки и запуска приложения

    - mvn clean install
    - mvn clean package
   
4. Запуск приложения.
    - java -jar target/lib-0.0.1-SNAPSHOT.jar


### Приложение будет доступно по адресу http://localhost:9060.