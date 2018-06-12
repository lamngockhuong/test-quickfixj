import quickfix.*;
import quickfix.fix44.MessageCracker;
import quickfix.fix44.NewOrderSingle;
import quickfix.fix44.News;

public class FixReceiver extends MessageCracker implements Application {
    @Override
    public void onCreate(SessionID sessionID) {
        System.out.println("Receiver onCreate.. " + sessionID);
    }

    @Override
    public void onLogon(SessionID sessionID) {
        System.out.println("Receiver onLogon.. " + sessionID);
    }

    @Override
    public void onLogout(SessionID sessionID) {
        System.out.println("Receiver onLogout.. " + sessionID);
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {
        System.out.println("Receiver toAdmin.. " + sessionID);
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        System.out.println("Receiver fromAdmin.. " + sessionID);
    }

    @Override
    public void toApp(Message message, SessionID sessionID) throws DoNotSend {
        System.out.println("Receiver toApp.. " + sessionID);
    }

    @Override
    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        System.out.println("Receiver fromApp.. " + message);
        crack(message, sessionID); // calls onMessage(...,...)
    }

    @Override
    public void onMessage(NewOrderSingle order, SessionID sessionID) throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
        System.out.println("Receiver onMessage..  " + order);
    }
}
