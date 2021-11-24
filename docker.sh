#!/bin/bash

IMAGE_NAME=supply:latest # don't publish this
CONTAINER_NAME=supply-dev # don't publish this
while [[ "$#" > 0 ]]
do
    cmd="$1"
    shift
    case $cmd in

        --create)
            echo "Rebuilding $CONTAINER_NAME image"
            # docker build arg prepare for build-arg config
            #docker pull docker.mediamath.com/media/core-qaf-lib:latest
            #./docker/dockerfile-dependency.sh
            docker build . -f Dockerfile -t $IMAGE_NAME #$(for i in `cat docker/.build.args`; do out+="--build-arg $i " ; done; echo $out;out="")
            ;;

        --start)
            # start dev container in qaf network
            MOUNTS="-v $(pwd):/tmp"

            docker run -d -ti --privileged -p 8080:8080  \
              $MOUNTS --hostname supply-dev --name $CONTAINER_NAME $IMAGE_NAME
            ;;

        --stop)
            docker stop $CONTAINER_NAME || true
            docker rm -f $CONTAINER_NAME || true
            ;;


        --restart)
            echo "Running $CONTAINER_NAME build"

            docker stop $CONTAINER_NAME || true
            docker rm -f $CONTAINER_NAME || true
            # start dev container in qaf network
            MOUNTS="-v $(pwd):/tmp"

            docker run -d -t --privileged -p 8080:8080  \
              $MOUNTS --hostname supply-dev --name $CONTAINER_NAME $IMAGE_NAME

            ;;


        *)
            echo "Unknown command $1"
            exit 1
            ;;
    esac
done

exit 0
