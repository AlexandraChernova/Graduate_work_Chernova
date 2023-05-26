## Описание проекта
### Запуск docker
команда в терминале: docker-compose up -d;

### *Для MySQL*
### Запуск jar файла
команда в терминале: java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar
### Запуск тестов
команда в терминале: ./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"

### *Для Postgresql*
### Запуск jar файла
java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar
### Запуск тестов
./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"

### Генерация отчета и автоматическое открытие в браузере по умолчанию
команда в терминале: gradlew allureServe