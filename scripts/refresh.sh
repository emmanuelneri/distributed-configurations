#!/usr/bin/env bash

url=http://localhost:8090
user=app
password=default

httpCode=$(curl -o /dev/null -s -w "%{http_code}\n" -X POST ${url}/actuator/refresh \
    -H "Content-Type: application/json" \
    -u ${user}:${password})

if [ $httpCode -eq 200 ]; then
    echo "${url} refreshed!"
    break
  else
    echo "Refresh error!"
    echo "URL: ${url}!"
    echo "HTTP Code: ${httpCode}"
fi
