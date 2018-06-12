import quickfix.*;

import java.util.Scanner;

public class ReceiverApp {
    public static void main(String[] args) throws ConfigError {
        SessionSettings settings = new SessionSettings("conf/receiver.cfg");
        Application myApp = new FixReceiver();
        FileStoreFactory fileStoreFactory = new FileStoreFactory(settings);
        ScreenLogFactory screenLogFactory = new ScreenLogFactory(settings);
        DefaultMessageFactory msgFactory = new DefaultMessageFactory();
        SocketAcceptor acceptor = new SocketAcceptor(myApp, fileStoreFactory, settings, screenLogFactory, msgFactory);

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
