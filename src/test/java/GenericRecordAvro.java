import org.apache.avro.Schema;

public class GenericRecordAvro {
    public static void main(String[] args) {
        //Step 0 Create a schema
        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse("{\n" +
                "    \"type\": \"record\",\n" +
                "    \"namespace\":\"com.example\",\n" +
                "    \"name\":\"customer\",\n" +
                "    \"doc\":\"Avro schemas for our customer\",\n" +
                "    \"fields\": [\n" +
                "        {\"name\":\"first_name\",\"type\":\"string\",\"doc\":\"firstname of the customer\"},\n" +
                "        {\"name\":\"last_name\",\"type\":\"string\",\"doc\":\"lastname of the customer\"},\n" +
                "        {\"name\":\"age\",\"type\":\"int\",\"doc\":\"This is the age of person\"},\n" +
                "        {\"name\":\"height\",\"type\":\"float\",\"doc\":\"\"},\n" +
                "        {\"name\":\"weight\",\"type\":\"float\",\"doc\":\"\"},\n" +
                "        {\"name\":\"automated_email\",\"type\":\"boolean\",\"doc\":\"\"}\n" +
                "    ]\n" +
                "\n" +
                "}");
        //Step 1 Create a generic record
        //Step 2 Write the generic record to a file
        //Step 3 read a generic record from a file
        //Step 4 Interpret a generic record
    }
}
