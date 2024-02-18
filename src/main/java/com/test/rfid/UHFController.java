package com.test.rfid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UHFController {
    @Autowired
    private UHFService uhfService;

    @CrossOrigin
    @RequestMapping(value="/addReader", method = RequestMethod.POST)
    ResponseEntity addReader() {
        final int instaceId = uhfService.createMainFrameInstance();
        return new ResponseEntity(instaceId, HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value="/openTCP", method = RequestMethod.POST)
    ResponseEntity openTCP(@RequestParam("id") String id,
                           @RequestParam("ip") String ip,
                           @RequestParam("port") int port) {
        if (uhfService.openTCP(Integer.parseInt(id), ip, port)) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.OK);
        }
    }

    @CrossOrigin
    @RequestMapping(value="/closeTCP", method = RequestMethod.POST)
    ResponseEntity closeTCP(@RequestParam("id") String id) {
        if (uhfService.closeTCP(Integer.parseInt(id))) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.OK);
        }
    }

    @CrossOrigin
    @RequestMapping(value="/startTCP", method = RequestMethod.POST)
    ResponseEntity startTCP(@RequestParam("id") String id) {
        if (uhfService.startTCP(Integer.parseInt(id))) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.OK);
        }
    }

    @CrossOrigin
    @RequestMapping(value="/stopTCP", method = RequestMethod.POST)
    ResponseEntity stopTCP(@RequestParam("id") String id) {
        if (uhfService.stopTCP(Integer.parseInt(id))) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.OK);
        }
    }


}
