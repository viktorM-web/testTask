# testTask
digital chief
1. В качестве БД используем postgreSQL image:
   docker run --name postgres-for-digital-chief -e POSTGRES_PASSWORD=pass -p 5433:5432 -d postgres:15.1
2. Создаем таблицы в БД из файла resources/sql/init.sql
3. Вносим данные в таблмцы БД из файла resources/sql/data.sql
4. Запускаем приложение из ApplicationRunner.java
Все зависимости описанны в pom.xml
В файле resources/test.json документация сгенерированная с помощью Swagger.
Предметная область гаражи для автомобилей.
