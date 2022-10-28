FROM tomcat:9.0.58-jdk17-openjdk 

LABEL org.opencontainers.image.authors="peteryoungy98@gmail.com"  

# RUN mkdir -p /home/app

COPY ./target/jupiter.war /usr/local/tomcat/webapps/ROOT.war   

EXPOSE 8080

CMD ["catalina.sh", "run"]
