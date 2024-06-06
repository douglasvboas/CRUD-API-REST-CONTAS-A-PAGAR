# Usar a imagem base oficial do OpenJDK 17
FROM openjdk:17-jdk-slim

# Criar um volume que pode ser usado para armazenamento temporário
VOLUME /tmp

# Copiar o arquivo JAR da aplicação para o contêiner
COPY target/contas-0.0.1-SNAPSHOT.jar app.jar

# Definir o comando de inicialização do contêiner
ENTRYPOINT ["java", "-jar", "/app.jar"]
