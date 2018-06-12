import quickfix.*;

public class FixSender implements Application {
    public void onCreate(SessionID sessionID) {
        System.out.println("Sender onCreate: " + sessionID);
    }

    public void onLogon(SessionID sessionID) {
        System.out.println("Sender onLogon: " + sessionID);
    }

    public void onLogout(SessionID sessionID) {
        System.out.println("Sender onLogout: " + sessionID);
    }

    public void toAdmin(Message message, SessionID sessionID) {
        System.out.println("Sender toAdmin: " + sessionID);
    }

    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        System.out.println("Sender fromAdmin: " + sessionID);
    }

    public void toApp(Message message, SessionID sessionID) throws DoNotSend {
        System.out.println("Sender toApp: " + message.toString());
    }

    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        System.out.println("Sender fromApp: " + sessionID);
    }
}
