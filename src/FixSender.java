import quickfix.*;

public class FixSender implements Application {
    @Override
    public void onCreate(SessionID sessionID) {
        System.out.println("Sender onCreate: " + sessionID);
    }

    @Override
    public void onLogon(SessionID sessionID) {
        System.out.println("Sender onLogon: " + sessionID);
    }

    @Override
    public void onLogout(SessionID sessionID) {
        System.out.println("Sender onLogout: " + sessionID);
    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {
        System.out.println("Sender toAdmin: " + sessionID);
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        System.out.println("Sender fromAdmin: " + sessionID);
    }

    @Override
    public void toApp(Message message, SessionID sessionID) throws DoNotSend {
        System.out.println("Sender toApp: " + message.toString());
    }

    @Override
    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        System.out.println("Sender fromApp: " + sessionID);
    }
}
