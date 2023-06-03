# ComputerShop

http://localhost:8080/computerShop/"названиеТовара"

http://localhost:8080/computerShop/"названиеТовара"/id

Имеется следующий список товаров

computer
harddisk
monitor
notebook

id всех товаров автогенерируемый
serialNumber является уникальным

Ниже приведены примеры для одного из товаров

Get http://localhost:8080/computerShop/computers получить весь список

Get http://localhost:8080/computerShop/computers поиск по id

Post http://localhost:8080/computerShop/computers добавление

Put http://localhost:8080/computerShop/computers редактирование

Delete http://localhost:8080/computerShop/computers/id удаление по id


Пример json для добавления

computer

{
    "serialNumber": 123456,
    "manufacturer": "asus",
    "price": 500,
    "availableOnTheStock": 9999,
    "formFactor": "MONOBLOCK"
}

monitor 

{
    "serialNumber": 12345,
    "manufacturer": "Dell",
    "price": 250,
    "availableOnTheStock": 9999,
    "diagonal": 24
}

hardisk

{
    "serialNumber": 1234,
    "manufacturer": "WD",
    "price": 150,
    "availableOnTheStock": 9999,
    "volume": 500
}

notebook

{
    "serialNumber": 1234
    "manufacturer": "Lenovo",
    "price": 1000,
    "availableOnTheStock": 9999,
    "size": 14
}


















