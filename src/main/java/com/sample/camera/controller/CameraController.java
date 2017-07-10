package com.sample.camera.controller;

import com.sample.camera.camera.Camera;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by oguz on 08.04.2017.
 */
@RestController
@RequestMapping()
public class CameraController {


    @GetMapping("/photo")
    @ResponseBody
    public String camera(HttpServletRequest request) {
        final String userIpAddress = request.getRemoteAddr();
        final String userAgent = request.getHeader("user-agent");
        System.out.println(userIpAddress +"  \n   " +userAgent);
        Camera webCamera = new Camera();
        String image = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <title>3></title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <img style='display:block; width:1024;height:768;' id='base64image'\n" +
                "       src='data:image/jpeg;base64, "+webCamera.webcam() + "' />\n" +
                "  </body>\n" +
                "</html>";
        return image;
    }
}
