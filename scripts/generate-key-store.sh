#!/bin/bash

keytool -genkeypair \
    -alias distributedConfigurations \
    -keystore distributed.configurations.jks \
    -storepass tdcPoa2018 \
    -keyalg RSA \
    -keypass tdcPoa2018 \
    -dname 'CN=www.emmanuelneri.com.br, OU=TDC POA 2018, O=Emmanuel Neri, L=Sao Paulo, C=BR'
