#!/usr/bin/env bash

value=$1
url=http://localhost:8888
user=config
password=config

result=$(curl -s ${url}/decrypt \
    -u ${user}:${password} \
    -H "Content-Type: text/plain" \
    -d ${value})

echo "-------------Encrypt------------------"
echo "Value: $value"
echo "Encrypted: $result"
echo "--------------------------------------"