# 졸업프로젝트 SpringBoot- Rest Server

## 1. 작품 주제 
 대중의 카페 수요는 지속적으로 증가하며, 카페 좌석 공간을 확보하여 앉기란 쉽지 않습니다. 
카페 좌석공간을 확보하기위해 카메라를 통해 카페 내 모든 좌석의 상태를 파악하고
사용자에게 주변 카페 위치 제공하여 잔여 좌석 정보를 웹 서비스를 통하여 제공하기 위해 만들었습니다 


## 2. 팀 구성

1. 프론트엔드 : 김민옥
2. 백엔드 : 김영수
3. 딥러닝 : 권태현, 신현섭
4. 클라우드 및 서버 구축 : 김영수  


## 3. 서버 개발의도 
REST는 웹 기술과 HTTP 프로토콜을 그대로 활용하므로 웹의 장점을 최대한 활용할 수 있는 아키텍처 스타일입니다. 
클라이언트와 서버가 API 통신을 통해 Resource 정보를 주고받으며, 단일 인터페이스를 사용하므로 애플리케이션 분리 및 통합에 편리합니다. 
또한 다양한 브라우저와 모바일 기기 등 멀티 플랫폼에서도 Resource를 교환할 수 있으므로 이 시스템의 개발에 적합한 아키텍처입니다.  
이 시스템을 추후 확장성을 위해 클라이언트와 서버의 역할을 명확히 분리할 필요가 있어, 통신을 위한 Rest-api 서버를 제작하였습니다.

## 4. 개발 환경 

* Language : Java 1.8
* SpringBoot 2.3.2
  - spring-web
  - spring-data-jpa
  - spring-security
  
* Cloud : 네이버 클라우드 
* Server O/S : Ubuntu Server 16.04 (64-bit)
* DBMS : MySQL 8.0.21 (x86_64)

## 5. 시스템 구성도
![image](https://user-images.githubusercontent.com/41531594/101609673-9531ec80-3a4a-11eb-814d-d522e33f95e5.png)

## 6. 개발 기간 
 2020-06 ~ 2020-12
 
## 7. 개발된 웹 서비스 


![image](https://user-images.githubusercontent.com/41531594/101608820-8b5bb980-3a49-11eb-9762-eabcc5769ca4.png)

![image](https://user-images.githubusercontent.com/41531594/101609031-d1188200-3a49-11eb-8017-697fd8babbc6.png)
 
### 특이점


* 쉘 스크립트를 이용한 편리한 배포
    ```shell script
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
    ```




