FROM tomcat
WORKDIR /usr/local/tomcat
COPY target/webdemo.war /usr/local/tomcat/webapps
run echo "Asia/Shanghai" > /etc/timezone
ENV LANG C.UTF-8
EXPOSE 2345

