# 使用 x86_64 架构的 OpenJDK 镜像
FROM openjdk:19 as builder

WORKDIR /app

# 将您的源代码复制到镜像中
COPY . .

RUN microdnf install findutils

# 使用 Gradle 构建应用程序
RUN ./gradlew build -x test

# 使用 x86_64 架构的 OpenJDK 镜像来运行应用程序
FROM openjdk:19

WORKDIR /app

# 从构建阶段的镜像中复制构建产物
COPY --from=builder /app/build/libs/messagebox-0.0.1-SNAPSHOT.jar /app/app.jar

# 指定容器启动时执行的命令
CMD ["java", "-jar", "/app/app.jar"]