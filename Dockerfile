FROM tomcat
WORKDIR /usr/local/tomcat
WORKDIR /usr/local/tomcat/webapps2
COPY server.xml /usr/local/tomcat/conf/
COPY setenv.sh /usr/local/tomcat/bin/
COPY target/webdemo.war /usr/local/tomcat/webapps2
run echo "Asia/Shanghai" > /etc/timezone
ENV LANG C.UTF-8
EXPOSE 2345

