package SerializationTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author xucheng.liu
 * @date 2020/3/26
 */
public class Main {

    public static void main(String[] args) {
        RechargeDaily rechargeDaily = new RechargeDaily();
        rechargeDaily.setId(1);
        rechargeDaily.setAccountId(123456);
        rechargeDaily.setCash("1.0");
        rechargeDaily.setRedPack("0.0");
        rechargeDaily.setHotelFreeRoomRedPack("0.0");
        rechargeDaily.setThreshold("1000");
        rechargeDaily.setTime(new Date());
        rechargeDaily.setDate(new Date());
        try (FileOutputStream fos = new FileOutputStream("rechargeDaily");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(rechargeDaily);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}