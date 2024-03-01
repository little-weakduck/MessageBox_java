FROM openjdk:19

WORKDIR /app

# 将构建产物复制到镜像中
COPY build/libs/messagebox-0.0.1-SNAPSHOT.jar /app/app.jar

# 指定容器启动时执行的命令
CMD ["java", "-jar", "/app/app.jar"]
