import quickfix.*;
import quickfix.field.*;
import quickfix.fix44.NewOrderSingle;

import java.time.ZoneId;
import java.util.Date;


public class SenderApp {
    public static void main(String[] args) throws ConfigError, InterruptedException, SessionNotFound {
        SessionSettings settings = new SessionSettings("conf/sender.cfg");
        Application myApp = new FixSender();
        FileStoreFactory fileStoreFactory = new FileStoreFactory(settings);
        ScreenLogFactory screenLogFactory = new ScreenLogFactory(settings);
        DefaultMessageFactory msgFactory = new DefaultMessageFactory();
        SocketInitiator initiator = new SocketInitiator(myApp, fileStoreFactory, settings, screenLogFactory, msgFactory);

        initiator.start();

        System.out.println("Before sleep 3s");
        Thread.sleep(3000);
        System.out.println("Start");

        // matching values from sender.cfg
        SessionID sessionID = new SessionID("FIX.4.4", "CLIENT1", "FixServer");
        NewOrderSingle order = new NewOrderSingle(new ClOrdID("DLF"),
                new Side(Side.BUY),
                new TransactTime(new Date().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime()),
                new OrdType(OrdType.LIMIT));

        order.set(new OrderQty(45.00));
        order.set(new Price(25.40));
        order.set(new Symbol("BHP"));
        Session.sendToTarget(order, sessionID);

        System.out.println("End");
        Thread.sleep(3000);
        System.out.println("After sleep 3s");

        initiator.stop();
        System.out.println("Finished");
    }
}
