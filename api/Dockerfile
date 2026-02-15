# Passo 1: Usar uma imagem leve do Java 17 (mesma que você usa no projeto)
FROM eclipse-temurin:17-jdk-alpine

# Passo 2: Definir a pasta de trabalho dentro do container
WORKDIR /app

# Passo 3: Copiar o arquivo JAR do seu projeto para dentro do container
# (Certifique-se de que você gerou o jar com './mvnw package')
COPY target/*.jar app.jar

# Passo 4: O comando que inicia a sua API
ENTRYPOINT ["java", "-jar", "app.jar"]