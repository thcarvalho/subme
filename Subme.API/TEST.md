LOCAL:
endpoint:(POST) http://localhost:8080/company/create

PAYLOAD: {
"cnpj":"12.345.678/0001-90",
"name": "Marcelo B",
"email": "marcelo@fatec.com",
"address":{
"street": "rua 1",
"number": 2,
"city": "Sao Paulo",
"state": "São Paulo",
"country": "Brasil",
"zipcode": "01010-001"
},
"username": "admin",
"password": "123456"
}

endpoint: (GET) http://localhost:8080/companies
