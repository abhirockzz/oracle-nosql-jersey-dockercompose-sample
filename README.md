git clone
mvn clean install
connect to docker engine (daemon on host)
docker-compose -p demo up
curl --data "test" http://<docker_host_ip>:8080/
curl http://<docker_host_ip>:8080/test
docker-compose down //to kill all containers
docker rmi demo_jerseyapp //remove image