package au.com.telstra.simcardactivator.Controller;

import au.com.telstra.simcardactivator.Entity.ActivationPayLoad;
import au.com.telstra.simcardactivator.Entity.ActuatorResponse;
import au.com.telstra.simcardactivator.Service.ActuatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SIMController {
    @Autowired
    private ActuatorService actuatorService;
    @PostMapping("/ActivateSIM")
    public ResponseEntity<String> activateSIM(@RequestBody ActivationPayLoad activationPayLoad){
        boolean isSuccess=actuatorService.activateSIM(activationPayLoad.getIccid());
        return ResponseEntity.ok("SIM ACTIVATION"+(isSuccess?"Successful":"Failed"));


    }

}
