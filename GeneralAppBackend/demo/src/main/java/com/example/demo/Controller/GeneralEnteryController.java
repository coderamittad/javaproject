package com.example.demo.Controller;

import com.example.demo.entity.GeneralEntery;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class GeneralEnteryController {
    private Map<Long,GeneralEntery> generalEntries= new HashMap<>();
    @GetMapping
    public List<GeneralEntery> getall(){
        return new ArrayList<>(generalEntries.values());

    }
    @PostMapping
    public boolean postmap(@RequestBody GeneralEntery entry){
        generalEntries.put(entry.getId(),entry);
        return true;

    }
    @GetMapping("id/{myid}")
    public GeneralEntery generalEnterygetbyId(@PathVariable Long myid){
        return  generalEntries.get(myid);
    }
    @DeleteMapping("id/{myid}")
    public GeneralEntery generalEnterydeletbyId(@PathVariable  Long myid){
        return  generalEntries.remove(myid);
    }
    @PutMapping("id/{id}")
    public GeneralEntery updatelEnterygetbyId(@PathVariable  Long id ,@RequestBody GeneralEntery entry ){
        return  generalEntries.put(id, entry);
    }


}
