/**
 * Created by parkash on 19/10/17.
 */
public class DeviceDetails {
    private String ip;
    private String hostName;
    private boolean alive;

    public DeviceDetails(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public String getHostName() {
        return hostName;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "DeviceDetails{" +
                "ip='" + ip + '\'' +
                ", hostName='" + hostName + '\'' +
                ", alive=" + alive +
                '}';
    }
}
