# WordCount_Adaptavist
** Kafka Stream Application

In this application, We will upload a file from Rest endpoints. That file will be saved into Kafka topic "test-input". Then, our Kafka application will read records from the "test-topic" topic and will count the amount of times each word has appeared. Then it will stream the latest count for each word into the "output-topic" topic, which we will read with a Kafka Listener.

** Rest EndPoint to upload file :
POST http://localhost:8080/producer-app/upload
Body -> form-data -> Key -> write 'file' --> then upload any csv file

** Rest EndPoint to send records from Browser:
http://localhost:8080/producer-app/publish/*****.        (please type your record instead of ***)



** Requirements:
 Confluent Cloud Account or Local Kafka Cluster
Java
IDE like Intellij
