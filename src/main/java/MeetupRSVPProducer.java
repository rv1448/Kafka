
import java.net.*;
import java.io.*;


public class MeetupRSVPProducer {

    public static void main(String[] args)  throws IOException{


        URL url = new URL("https://stream.meetup.com/2/rsvps");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                conn.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);



    }
}



//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import com.google.gson.stream.JsonReader;
//import com.google.gson.Gson;
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.Reader;
//import java.net.URL;
//
//public class MeetupRSVPProducer {
//
//    public static void main(String[] args) throws Exception{
////        ws://stream.meetup.com/2/rsvps
//        URL url = new URL("https://stream.meetup.com/2/rsvps");
//      InputStream in = url.openStream();
////
////        BufferedReader Kn = new BufferedReader(
////                new InputStreamReader(in,"UTF-8"));
////
//
////        JsonFactory factory = new JsonFactory();
////        JsonParser jParser = factory.createParser(in);
//////        String line = Kn.readLine();
////        while (!jParser.isClosed()) {
////            System.out.println(jParser.readValueAsTree());
////
////        }
//
//
//            Gson json = new Gson();
//            JsonReader parser = new JsonReader(new InputStreamReader(in));
//                      parser.setLenient(true);
//                     String a =  json.fromJson(parser,String.class);
//                     System.out.println(a);
////
////            JsonElement rootelement =  parser.
////            JsonObject rootobject = rootelement.getAsJsonObject();
//
//
//    }
//
//
//
//
//}
