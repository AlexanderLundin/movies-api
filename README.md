# movies-api

## Steps to build with docker

Retrieve the image from docker hub with docker toolbox or other docker CLI

$ docker pull alundin/movieservice

$ docker run -p 8080:8080 --rm alundin/movieservice

$ docker-machine ip

Open up brower on the ip address found from command above + ":8080/api/movies"
