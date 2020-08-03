# airasia-assignment

Run as spring boot app

1. Sample create order request:
curl --location --request POST 'localhost:8080/orders' \
--header 'Content-Type: application/json' \
--data-raw '{
    "hotelId":"test",
    "hotelName":"test_name",
    "checkinDate":"23-10-2020",
    "checkoutDate":"23-10-2020",
    "customer":{
        "email":"swapneel.a.kulkarni@gmail.com",
        "name":"Swapneel",
        "phone":"8123483345"
    },
    "roomId":"123",
    "roomName":"tulip",
    "noOfGuests":2,
    "amount":30.5
}'

2. GET all orders
curl --location --request POST 'localhost:8080/orders'
