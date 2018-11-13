FROM mysql/mysql-server:5.5

ENV MYSQL_ROOT_PASSWORD root
ENV MYSQL_ROOT_HOST %
ENV MYSQL_DATABASE bd_alunos

COPY ./sql-scripts/ /docker-entrypoint-initdb.d/