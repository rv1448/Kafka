import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class MeetupRSVPProducer {

    public static void main(String[] args) throws Exception{
//        ws://stream.meetup.com/2/rsvps
        URL url = new URL("https://stream.meetup.com/2/rsvps");
      InputStream in = url.openStream();
//
//        BufferedReader Kn = new BufferedReader(
//                new InputStreamReader(in,"UTF-8"));
//

        JsonFactory factory = new JsonFactory();
        JsonParser jParser = factory.createParser(in);
//        String line = Kn.readLine();
        while (!jParser.isClosed()) {
            System.out.println(jParser.readValueAsTree());

        }


    }




}
