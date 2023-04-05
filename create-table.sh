aws dynamodb create-table --endpoint-url http://localhost:4566  \
--table-name fraud \
--attribute-definitions \
  AttributeName=code,AttributeType=S \
	AttributeName=date_registry,AttributeType=S \
	AttributeName=customer,AttributeType=S \
--key-schema \
	AttributeName=code,KeyType=HASH \
	AttributeName=date_registry,KeyType=RANGE \
--provisioned-throughput \
ReadCapacityUnits=5,WriteCapacityUnits=5 \
--global-secondary-indexes \
'[
    {
      "IndexName": "dateCustomer-index",
      "KeySchema": [
        {
           "AttributeName": "customer",
           "KeyType": "HASH"
        },
        {
            "AttributeName": "date_registry",
            "KeyType": "RANGE"
        }
      ],
      "Projection": {
        "ProjectionType": "ALL"
      },
      "ProvisionedThroughput": {
        "ReadCapacityUnits": 10,
        "WriteCapacityUnits": 5
      }
    }
]'