import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;


public class Callout implements Serializable, Remote {

    private String name;
    private String surname;
    private String accDesc;
    private Date datetime;
    private String location;
    private String action_taken_desc;
    private int call_time_sec;

    @Override
    public String toString() {
        return "Callout{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", accDesc='" + accDesc + '\'' +
                ", datetime=" + datetime +
                ", location='" + location + '\'' +
                ", action_taken_desc='" + action_taken_desc + '\'' +
                ", call_time_sec=" + call_time_sec +
                '}';
    }

    public String getName() throws RemoteException {
        return name;
    }

    public void setName(String name) throws RemoteException {
        this.name = name;
    }

    public String getSurname() throws RemoteException {
        return surname;
    }

    public void setSurname(String surname) throws RemoteException {
        this.surname = surname;
    }

    public String getAccDesc() throws RemoteException {
        return accDesc;
    }

    public void setAccDesc(String accDesc) throws RemoteException {
        this.accDesc = accDesc;
    }

    public Date getDatetime() throws RemoteException {
        return datetime;
    }

    public void setDatetime(Date datetime) throws RemoteException {
        this.datetime = datetime;
    }

    public String getLocation() throws RemoteException {
        return location;
    }

    public void setLocation(String location) throws RemoteException {
        this.location = location;
    }

    public String getAction_taken_desc() throws RemoteException {
        return action_taken_desc;
    }

    public void setAction_taken_desc(String action_taken_desc) throws RemoteException {
        this.action_taken_desc = action_taken_desc;
    }

    public int getCall_time_sec() throws RemoteException {
        return call_time_sec;
    }

    public void setCall_time_sec(int call_time_sec) throws RemoteException {
        this.call_time_sec = call_time_sec;
    }

    public Callout(String name, String surname, String accDesc, Date datetime, String location, String action_taken_desc, int call_time_sec) {
        this.name = name;
        this.surname = surname;
        this.accDesc = accDesc;
        this.datetime = datetime;
        this.location = location;
        this.action_taken_desc = action_taken_desc;
        this.call_time_sec = call_time_sec;
    }
}
