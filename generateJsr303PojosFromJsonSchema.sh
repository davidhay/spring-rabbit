jsonschema2pojo --source src/main/resources/schema/POR-schema.json \
  --target src/main/java \
  --package 'com.ealanta.generated.cli' \
  -303 \
  --long-integers
  
jsonschema2pojo --source src/main/resources/schema/Position-schema.json \
  --target src/main/java \
  --package 'com.ealanta.generated.cli' \
  -303 \
  --long-integers
