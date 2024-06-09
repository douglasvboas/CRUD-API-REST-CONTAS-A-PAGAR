# Use uma imagem oficial do OpenJDK como imagem base
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copia o arquivo JAR da aplicação para o contêiner
COPY target/*.jar app.jar

# Expõe a porta 8080
EXPOSE 8080

# Define o comando padrão para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
