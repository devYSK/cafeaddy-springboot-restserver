#!/bin/bash

REPOSITORY=/root/app/server
PROJECT_NAME=cafeaddy-springboot-restserver
ROOT_PROJECT_NAME=cafeaddy-server


cd $REPOSITORY/$PROJECT_NAME/


echo -e "\n\033[31;1m git pull  \033[m \n"

git pull


echo -e "\n\033[31;1m> 프로젝트 Build 시작! \033[m \n"

./gradlew build

echo -e "\n\033[31;1m> server 디렉토리로 이동 \033[m \n"

cd $REPOSITORY

echo -e "\033[31;1m> Build 파일 복사\033[m"

cp $REPOSITORY/$PROJECT_NAME/build/libs/*.jar $REPOSITORY/

echo -e "\n\033[31;1m>현재 구동중인 애플리케이션 프로세스 id 확인\033[m"

CURRENT_PID=$(pgrep -f ${ROOT_PROJECT_NAME}*.jar)

echo -e "\033[31;1m>현재 구동중인 애플리케이션 프로세스 id : $CURRENT_PID \033[m"


if [ -z "$CURRENT_PID" ]; then
  echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
  echo "> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5

fi


echo -e "\033[31;1m> 새 애플리케이션 배포\033[m\n"

JAR_NAME=$(ls -tr $REPOSITORY/ | grep *.jar | tail -n 1)

echo -e "> JAR Name: $JAR_NAME\n"

echo -e "> $JAR_NAME 에 실행권한 추가\n"

chmod +x $JAR_NAME


echo -e "\033[31;1m>백그라운드로 애플리케이션 실행 \033[m"

nohup java -jar \
 -Dspring.config.location=classpath:/application.properties,classpath:/application-real.properties,/root/app/application-db.properties,/root/app/application-secret.properties \
 -Dspring.profiles.active=real,db,secret \
 $REPOSITORY/$JAR_NAME 2>&1 &