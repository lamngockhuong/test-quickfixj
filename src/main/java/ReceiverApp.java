import quickfix.*;

import java.util.Scanner;

public class ReceiverApp {
    public static void main(String[] args) throws ConfigError {
        SessionSettings settings = new SessionSettings("conf/receiver.cfg");
        Application myApp = new FixReceiver();
        MessageStoreFactory storeFactory = new FileStoreFactory(settings);
        LogFactory logFactory = new ScreenLogFactory(settings);
        MessageFactory msgFactory = new DefaultMessageFactory();
        Acceptor acceptor = new SocketAcceptor(myApp, storeFactory, settings, logFactory, msgFactory);

        System.out.println("Begin");
        acceptor.start();

        System.out.println("-- 1 --");

        Scanner input = new Scanner(System.in);
        System.out.println("press <Enter> to quit");

        // get user input for a
        input.nextLine();

        System.out.println("-- 2 --");

        acceptor.stop();
        System.out.println("-- 3 --");
    }
}
