FROM mysql:5.5

#这条语句可有可无
ENV MYSQL_DATABASE test

#设置免密登录
ENV MYSQL_ALLOW_EMPTY_PASSWORD yes

#将所需文件放到容器中
COPY setup.sh /mysql/setup.sh
COPY riceflowerblog_db.sql /mysql/riceflowerblog_db.sql
COPY privileges.sql /mysql/privileges.sql

#设置容器启动时执行的命令
CMD ["bash", "/mysql/setup.sh"]