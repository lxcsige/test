package JPEGTest;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by lxcfour on 2017/3/28.
 */
public class Solution {
    public static void main(String[] args) {
        URLConnection connection;
        BufferedImage image = null;
        try {
            URL url = new URL("https://p1.meituan.net/dpmerchantalbum/ad85913050b28ed6f6378a05b076165a1691304.jpg");
            connection = url.openConnection();
            connection.setDoOutput(true);
            image = ImageIO.read(connection.getInputStream());
        } catch (Exception e) {
            String tempPicName = downloadPic("https://p1.meituan.net/dpmerchantalbum/ad85913050b28ed6f6378a05b076165a1691304.jpg");
            File picFile = new File("/data/appdatas/download_temp/" + tempPicName);
            try {
                JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(new FileInputStream(picFile));
                image = decoder.decodeAsBufferedImage();
            } catch (Exception e1) {
                picFile.delete();
            }
        } finally {
            if (image != null) {
                int width = image.getWidth();
                int height = image.getHeight();
            }
        }
    }

    private static String downloadPic(String picUrl) {
        InputStream is = null;
        FileOutputStream fs = null;
        String tempPicName = null;
        try {
            URL url = new URL(picUrl);
            URLConnection con = url.openConnection();
            con.setConnectTimeout(3000);
            is = con.getInputStream();

            //下载缓冲区
            byte[] bs = new byte[2048];

            //读取到的数据长度
            int len;

            //输出的文件流
            File sf = new File("/data/appdatas/download_temp");
            if (!sf.exists()) {
                sf.mkdirs();
            }

            //并发时保证图片名称唯一
            tempPicName = "temp" + Thread.currentThread().getId() + ".jpg";
            fs = new FileOutputStream(sf.getPath() + "/" + tempPicName);

            //开始读取
            while ((len = is.read(bs)) != -1) {
                fs.write(bs, 0, len);
            }
        } catch (Exception e) {
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                }
            }
            if (fs != null) {
                try {
                    fs.close();
                } catch (Exception e) {
                }
            }
        }
        return tempPicName;
    }
}
