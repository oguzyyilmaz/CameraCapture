package com.sample.camera.camera;

import com.github.sarxos.webcam.Webcam;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.UUID;

/**
 * Created by oguz on 08.04.2017.
 */
public class Camera {
    Webcam webcam;
    String photoId = UUID.randomUUID().toString();

    public String webcam() {

        webcam = Webcam.getDefault();
        webcam.open();
        try {
            ImageIO.write(webcam.getImage(), "PNG", new File("photos/" + photoId+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ImageIO.read(new File("photos/" + photoId+".png"));
            return imageToBase64();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public String imageToBase64() {
        try {
            String base64;
            File file = new File("photos/" + photoId+".png");
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStreamReader.read(bytes);
            base64 = new String(Base64.encodeBase64(bytes), "UTF-8");
            webcam.close();
            return base64.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
