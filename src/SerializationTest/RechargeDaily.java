package SerializationTest;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xucheng.liu
 * @date 2020/3/26
 */
public class RechargeDaily implements Serializable {

    private int id;

    private int accountId;

    private String cash;

    private String redPack;

    private String hotelFreeRoomRedPack;

    private String threshold;

    private Date time;

    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getRedPack() {
        return redPack;
    }

    public void setRedPack(String redPack) {
        this.redPack = redPack;
    }

    public String getHotelFreeRoomRedPack() {
        return hotelFreeRoomRedPack;
    }

    public void setHotelFreeRoomRedPack(String hotelFreeRoomRedPack) {
        this.hotelFreeRoomRedPack = hotelFreeRoomRedPack;
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
