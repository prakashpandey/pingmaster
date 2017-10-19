import java.io.IOException;
import java.util.List;

/**
 * Created by parkash on 19/10/17.
 */
public class App {

    public static void main(String... strings) throws IOException {
        System.out.println("===================== Application started =====================");
        ActiveDeviceFinder activeDeviceFinder = new ActiveDeviceFinder();
        byte add0 = (byte) 192;
        byte add1 = (byte) 168;
        byte add2 = 43;
        List<DeviceDetails> activeDevices = activeDeviceFinder.getActiveDeviceList(add0, add1, add2);
        activeDevices.forEach(activeDevice -> {
            System.out.println("Host: " + activeDevice.getHostName() + ", IP: " + activeDevice.getIp() + ", is active: " + activeDevice.isAlive());
        });
        System.out.println("===================== Application ended =====================");
    }
}
