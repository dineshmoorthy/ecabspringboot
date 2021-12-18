# ecabspringboot
springboot + RabbitMQ + H2 database


#docker command used
docker run -d --hostname ecabs-rabbit --name rabbit-assignment  -e RABBITMQ_DEFAULT_VHOST=/ -e RABBITMQ_DEFAULT_USER=guest -e RABBITMQ_DEFAULT_PASS=guest -p 5672:5672 -p 15672:15672 rabbitmq:3-management
