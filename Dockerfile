# OpenJDKの軽量イメージをベースにする
FROM eclipse-temurin:17-jdk-alpine as builder
WORKDIR /app

# Gradle or Maven の場合は依存定義ファイルだけコピーして先にビルドキャッシュ
COPY mvnw ./
COPY .mvn .mvn
COPY pom.xml ./

RUN ./mvnw dependency:go-offline

# ソースをコピーしてビルド
COPY src ./src
RUN ./mvnw clean package -DskipTests

# ==============================
# 実行用イメージ
# ==============================
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]