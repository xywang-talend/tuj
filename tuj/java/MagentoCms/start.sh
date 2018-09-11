#!/bin/bash

docker run --rm -d -p 55550:80 -p 55551:443 -e MAGENTO_BASE_URL=http://192.168.99.100:55550 -e MAGENTO_BASE_URL_SECURE=https://192.168.99.100:55551 -e MAGENTO_USE_SECURE=0 -e MAGENTO_USE_SECURE_ADMIN=0 --name magentocms components-integration-test-magentocms:1.0.0