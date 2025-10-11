package org.nanawally.lecture2uppgifter.uppgift123;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
public class DogController {

    @GetMapping("/dog")
    public List<Object> dogAPI() {
        String uri = "https://dog.ceo/api/breeds/image/random";
        RestTemplate restTemplate = new RestTemplate();
        DogModel dogModel;

        try {
            dogModel = restTemplate.getForObject(uri, DogModel.class);
            if(dogModel != null){
                System.out.println(dogModel.message);
                System.out.println(dogModel.status);
            }
            return Collections.singletonList(dogModel);
        } catch (Error e) {
            e.printStackTrace();
        }
        //return restTemplate.getForObject(uri, String.class);
        return null;
    }

}
