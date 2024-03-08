```shell
    curl --location --request POST 'http://localhost:8080/users/register' \
--header 'Content-Type: application/json' \
--data-raw '{
	"login": "testuser",
	"email": "testuser@gmail.com",
	"password": "testtest"
}'


curl --location --request GET 'http://localhost:8080/users/login?login=testuser&password=testtest'


curl --location --request GET 'http://localhost:8080/hello/'


curl --location --request GET 'http://localhost:8080/hello/me' \
--header 'Authorization: Bearer $YOURTOKEN'


curl --location --request GET 'http://localhost:8080/hello/admin' \
--header 'Authorization: Bearer $YOURTOKEN'


curl --location --request GET 'http://localhost:8080/hello/void' \
--header 'Authorization: Bearer $YOURTOKEN'
```