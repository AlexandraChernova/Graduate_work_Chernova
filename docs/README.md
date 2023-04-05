## Описание проекта
### Запуск docker
команда в терминале: docker-compose up;
### Запуск jar файла
команда в терминале: java -jar artifacts/aqa-shop.jar
### Запуск тестов
команда в терминале: ./gradlew clean test --info
### Генерация отчета и автоматическое открытие в браузере по умолчанию
команда в терминале: gradlew allureServe