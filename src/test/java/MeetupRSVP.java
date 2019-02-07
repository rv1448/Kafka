import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class MeetupRSVP {
    public static void main(String[] args) throws Exception{
//        ws://stream.meetup.com/2/rsvps
        URL url = new URL("https://stream.meetup.com/2/rsvps");
        InputStream in = url.openStream();

//
        InputStreamReader Kn = new InputStreamReader(in,"UTF-8");
//        BufferedReader bn = new BufferedReader(kn);
//        String line;
//        while(line =)
//

//        JsonFactory factory = new JsonFactory();
//        JsonParser jParser = factory.createParser(in);
////        String line = Kn.readLine();
//        while (!jParser.isClosed()) {
//            System.out.println(jParser.readValueAsTree());
//
//        }


//        Gson json = new Gson();
//        JsonReader parser = new JsonReader(new InputStreamReader(in));
//        parser.setLenient(true);
//        String a =  json.fromJson(parser,String.class);
//        System.out.println(a);
//
//            JsonElement rootelement =  parser.
//            JsonObject rootobject = rootelement.getAsJsonObject();


    }



}
