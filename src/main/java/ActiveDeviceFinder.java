import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by parkash on 19/10/17.
 */
public class ActiveDeviceFinder {

    List<DeviceDetails> getActiveDeviceList(byte add0, byte add1, byte add2) {
        List<DeviceDetails> activeDevices = new ArrayList<DeviceDetails>();
        for (int i = 0; i < 255; i++) {
            byte add3 = (byte) i;
            try {
                DeviceDetails deviceDetail = getDeviceDetails(add0, add1, add2, add3);
                if (deviceDetail.isAlive()) {
                    activeDevices.add(deviceDetail);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return activeDevices;
    }

    /**
     * @param add0
     * @param add1
     * @param add2
     * @param add3
     * @return
     */
    DeviceDetails getDeviceDetails(byte add0, byte add1, byte add2, byte add3) throws IOException {
        boolean isDeviceAlive = false;
        InetAddress inetAddress = InetAddress.getByAddress(new byte[]{add0, add1, add2, add3});
        isDeviceAlive = inetAddress.isReachable(100);
        String address = add0 + "." + add1 + "." + add2 + "." + add3;
        DeviceDetails activeDevice = new DeviceDetails(inetAddress.getHostAddress());
        activeDevice.setAlive(isDeviceAlive);
        activeDevice.setHostName(inetAddress.getHostName());
        return activeDevice;
    }

    /**
     *
     * @param address
     * @return
     * @throws IOException
     */
    DeviceDetails getDeviceDetails(String address) throws IOException {
        boolean isDeviceAlive = false;
        InetAddress inetAddress = InetAddress.getByName(address);
        isDeviceAlive = inetAddress.isReachable(100);
        DeviceDetails activeDevice = new DeviceDetails(inetAddress.getHostAddress());
        activeDevice.setAlive(isDeviceAlive);
        activeDevice.setHostName(new String(inetAddress.getHostName()));
        return activeDevice;
    }
}
