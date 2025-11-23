# Multi-stage Dockerfile: instala JARs locais no repo maven, builda e garante runtime classpath
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY . /app

# Garante que a pasta lib existe (evita problemas)
RUN mkdir -p /app/lib

# Se houver JARs em lib/, instala cada um no repositório local do Maven
RUN if [ -d /app/lib ]; then \
      for f in /app/lib/*.jar; do \
        if [ -f "$f" ]; then \
          artifactId=$(basename "$f" .jar); \
          mvn org.apache.maven.plugins:maven-install-plugin:3.0.0-M1:install-file \
            -Dfile="$f" -DgroupId=local.lib -DartifactId="$artifactId" -Dversion=1.0 -Dpackaging=jar || true; \
        fi; \
      done; \
    fi

RUN mvn -DskipTests package

FROM eclipse-temurin:17-jre
WORKDIR /work

# Copia o app Quarkus buildado
COPY --from=build /app/target/quarkus-app /work/quarkus-app

# Copia a pasta lib inteira para o classpath de runtime do quarkus
COPY --from=build /app/lib /work/quarkus-app/lib

EXPOSE 8080
ENV JAVA_OPTS=""
CMD ["sh","-c","java $JAVA_OPTS -jar /work/quarkus-app/quarkus-run.jar"]
