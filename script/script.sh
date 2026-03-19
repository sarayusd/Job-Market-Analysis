#!/bin/bash

docker compose -f docker-compose.yaml up -d

sleep 5

echo "Copying files from local system to temp storage in container..."

docker cp ~/Documents/CSE587-DataIntensiveComputing/project/job_postings/datasets job_postings-namenode-1:/tmp/


if ! docker exec job_postings-namenode-1 jps | grep -q "NameNode"; then
    echo "Error: Hadoop is not running. Please start Hadoop first."
    exit 1
else
    echo "Hadoop is running, executing commands inside NameNode"
fi

docker exec -it job_postings-namenode-1 bash

