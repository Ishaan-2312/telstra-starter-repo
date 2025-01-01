package au.com.telstra.simcardactivator.Service;

import au.com.telstra.simcardactivator.Entity.ActuatorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service

public class ActuatorService {
    private static final String ActuatorURL="http://localhost:8444/actuate";
    private static final Logger log= LoggerFactory.getLogger(ActuatorService.class);

    public boolean activateSIM(String iccid) {
        RestTemplate restTemplate=new RestTemplate();
        try{
            Map<String,String> payload=new HashMap<String,String>();
            payload.put("ICCID",iccid);
            ActuatorResponse actuatorResponse=restTemplate.postForObject(ActuatorURL,payload, ActuatorResponse.class);
            if(actuatorResponse==null)log.info("SimCardActuator Not Started");
            return actuatorResponse!=null && actuatorResponse.isSuccess();
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }


    }
}
