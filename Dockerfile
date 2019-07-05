FROM tomcat
WORKDIR /usr/local/tomcat
WORKDIR /usr/local/tomcat/webapps1/
COPY server.xml /usr/local/tomcat/conf/
COPY target/webdemo.war /usr/local/tomcat/webapps1
run echo "Asia/Shanghai" > /etc/timezone
ENV LANG C.UTF-8
EXPOSE 2345

