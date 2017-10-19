import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by parkash on 19/10/17.
 */
public class ActiveDeviceFinder {

    public static void main(String... strings) {
        ActiveDeviceFinder activeDeviceFinder = new ActiveDeviceFinder();
        byte add3 = (byte)192;
        byte add2 = (byte)168;
        byte add1 = 43;
        for (int i=0; i<255; i++) {
            byte add0 = (byte)i;
            String address = add3 + "." + add2 + "." + add1 + "." + i;
            if (activeDeviceFinder.isDeviceActive(add0, add1, add2, add3)) {
                System.out.println(address + " is active.");
            }
        }
    }

    /**
     *
     * @param add0
     * @param add1
     * @param add2
     * @param add3
     * @return
     */
    boolean isDeviceActive(byte add0, byte add1, byte add2, byte add3) {
        boolean isDeviceAlive = false;
        try {
            InetAddress inetAddress = InetAddress.getByAddress(new byte[] { add3, add2, add1, add0 });
            isDeviceAlive = inetAddress.isReachable(100);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isDeviceAlive;
    }
}
