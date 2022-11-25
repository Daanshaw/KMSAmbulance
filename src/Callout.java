import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;


public class Callout implements Serializable, Remote, CalloutInterface {

    private String name;
    private String surname;
    private String accDesc;
    private Date datetime;
    private String location;
    private String actionTakenDesc;
    private int callTimeSec;

    @Override
    public String toString() {
        return "Callout{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", accDesc='" + accDesc + '\'' +
                ", datetime=" + datetime +
                ", location='" + location + '\'' +
                ", actionTakenDesc='" + actionTakenDesc + '\'' +
                ", callTimeSec=" + callTimeSec +
                '}';
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }

    @Override
    public void setName(String name) throws RemoteException {
        this.name = name;
    }

    @Override
    public String getSurname() throws RemoteException {
        return surname;
    }

    @Override
    public void setSurname(String surname) throws RemoteException {
        this.surname = surname;
    }

    @Override
    public String getAccDesc() throws RemoteException {
        return accDesc;
    }

    @Override
    public void setAccDesc(String accDesc) throws RemoteException {
        this.accDesc = accDesc;
    }

    @Override
    public Date getDatetime() throws RemoteException {
        return  datetime;
    }

    @Override
    public void setDatetime(Date datetime) throws RemoteException {
        this.datetime = datetime;
    }

    @Override
    public String getLocation() throws RemoteException {
        return location;
    }

    @Override
    public void setLocation(String location) throws RemoteException {
        this.location = location;
    }

    @Override
    public String getActionTakenDesc() throws RemoteException {
        return actionTakenDesc;
    }

    @Override
    public void setActionTakenDesc(String actionTakenDesc) throws RemoteException {
        this.actionTakenDesc = actionTakenDesc;
    }

    @Override
    public int getCallTimeSec() throws RemoteException {
        return callTimeSec;
    }

    @Override
    public void setCallTimeSec(int callTimeSec) throws RemoteException {
        this.callTimeSec = callTimeSec;
    }

    public Callout(String name, String surname, String accDesc, Date datetime, String location, String actionTakenDesc, int callTimeSec) {
        this.name = name;
        this.surname = surname;
        this.accDesc = accDesc;
        this.datetime = datetime;
        this.location = location;
        this.actionTakenDesc = actionTakenDesc;
        this.callTimeSec = callTimeSec;
    }
}
