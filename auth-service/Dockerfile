LABEL authors="nikita-matvei"
FROM eclipse-temurin:17-jdk-alpine AS build
#собираем базовый образ

WORKDIR /app
#устанавлиаем рабочую дерикторию внутри проекта /app
#все дальнейшие команды будут выполняться относительно этой дериктории

COPY . .
# 1 . откуда копируем (текущая дериктория) 2 . куда копируем (рабочая дериктория внутри контейнера - WORKDIR /app)

RUN ./gradlew clean build -x test
# результат оперции будет .jar файл в /app/build/libs/

FROM eclipse-temurin:17-jre-alpine
#запускает этап сбрки, конченыйц контейнер будет содержать jre - без jdk что уменьшит размер контейнера

WORKDIR /app
#создает рабочую дерикторию в созданном контейнере

COPY --from=build /app/build/libs/*.jar app.jar
#переносит .jar с этапа build в созданную дерикторию /app/build/libs/

ENTRYPOINT ["java", "-jar", "app.jar"]
#поределяет команду что будет воплнена после запуска контейнера