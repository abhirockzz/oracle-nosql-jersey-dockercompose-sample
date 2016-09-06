![](https://abhirockzz.files.wordpress.com/2016/09/oracle-nosql-jersey-dockercompose-sample-blog-logo.jpg)


## Steps ##

- Clone the project `git clone`
- Build it `mvn clean install`
- [Point to the docker engine](https://docs.docker.com/machine/reference/env/) (if needed)
- Confirm connectivity `docker -version` 
- Invoke Docker Compose `docker-compose up`. This pulls oracle/nosql from Docker Hub, builds it's client app image and starts them up (your app is now setu and ready to use)
- Put some data (key) into KVLite instance `curl --data "test" http://<docker_host_ip>:8080/`
- See when it (the key) was inserted `curl http://<docker_host_ip>:8080/test`
- Clean up! `docker-compose down`
- Change code, rebuild again `docker up build`

## Also check out ##

- [Dockerized Oracle](https://github.com/oracle/docker-images) on GitHub
- Oracle on [DockerHub](https://hub.docker.com/u/oracle/)
- Associated [blog](https://abhirockzz.wordpress.com/2016/09/06/simple-sample-oracle-nosql-with-docker-compose)
