Active Redis instance is required => http://redis.io/download

Start application => java -jar postcoder-0.0.1-SNAPSHOT.jar --spring.profile.active=prod

Once application is started, you can test API with:

curl http://[HOST]/pcw/[api-key]/address/ie/[eircode-or-address-fragment]
and
curl http://[HOST]/pcw/[api-key]/address/uk/[postcode-or-address-fragment]

examples:
curl http://localhost:8080/pcw/PCW45-12345-12345-1234X/address/ie/D02X285
curl http://localhost:8080/pcw/PCW45-12345-12345-1234X/address/uk/NR147PZ

=======================================================================================
