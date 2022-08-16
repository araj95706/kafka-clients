package kafka_clients;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class SampleProducer {
	String key = "Key1";
	String value = "HI";

	public SampleProducer() {
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("quickstart-events", key, value);
		Producer<String, String> producer = new KafkaProducer<String, String>(properties);

		producer.send(producerRecord);
		producer.close();

		System.out.println("SimpleProducer Completed.");
	}
}
