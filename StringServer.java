
import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    String sentence = null;

    public void handleRequest(URI url) {
        if (url.getPath().contains("/add-message")) {
            System.out.println(sentence);
            String[] parameters = url.getQuery().split("=");
            sentence = (parameters[0]);
            System.out.println(sentence);
            
        }
    }
}

class NumberServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("no request found");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}