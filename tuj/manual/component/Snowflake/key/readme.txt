1. Generating RSA keys by keytool: 【use: git bash】
keytool -genkeypair -alias snow_xia -keyalg RSA -keystore keystoreSnow.jks -keypass 123456 -storepass 123456 -dname "CN=localhost, OU=localhost, O=localhost, L=SH, ST=SH, C=CN"

keytool -export -keystore keystoreSnow.jks -alias snow_xia -file public_rsa.pem -storepass 123456

keytool -importkeystore -srckeystore keystoreSnow.jks -srcstorepass 123456 -srckeypass 123456 -srcalias snow_xia -destalias snow_xia -destkeystore keystoreSnow.p12 -deststoretype PKCS12 -deststorepass 123456 -destkeypass 123456

openssl pkcs12 -in keystoreSnow.p12 -nodes -nocerts -out private_key.pem -password pass:123456
openssl rsa -in private_key.pem -out public_key.pem -pubout -outform PEM

Also, you have to update your snowflake user with a public RSA key, like I did(you have to login with Admin account to perform this action):
alter user XIA set rsa_public_key='MIIBIjANB......';   # C:\key\public_key.pem 从这文件里面拷贝
desc user XIA;   # 如果看到 RSA_PUBLIC_KEY_FP 有内容，说明设置成功了。



