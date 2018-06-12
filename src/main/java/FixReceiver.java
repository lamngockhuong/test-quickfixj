import quickfix.*;
import quickfix.fix44.MessageCracker;
import quickfix.fix44.NewOrderSingle;
import quickfix.fix44.News;

public class FixReceiver extends MessageCracker implements Application {
    public void onCreate(SessionID sessionID) {
        System.out.println("Receiver onCreate.. " + sessionID);
    }

    public void onLogon(SessionID sessionID) {
        System.out.println("Receiver onLogon.. " + sessionID);
    }

    public void onLogout(SessionID sessionID) {
        System.out.println("Receiver onLogout.. " + sessionID);
    }

    public void toAdmin(Message message, SessionID sessionID) {
        System.out.println("Receiver toAdmin.. " + sessionID);
    }

    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        System.out.println("Receiver fromAdmin.. " + sessionID);
    }

    public void toApp(Message message, SessionID sessionID) throws DoNotSend {
        System.out.println("Receiver toApp.. " + sessionID);
    }

    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        System.out.println("Receiver fromApp.. " + message);
        crack(message, sessionID); // calls onMessage(...,...)
    }

    public void onMessage(NewOrderSingle order, SessionID sessionID) throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
        System.out.println("Receiver onMessage..  " + order);
    }
}
