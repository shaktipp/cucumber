package com.spp.spring.bdd.jenkins.app.controller;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spp.spring.bdd.jenkins.app.entity.MathInput;



@RestController
@RequestMapping("/math")
public class MathController
{
    @GetMapping(path = "/add/{num1}/{num2}")
    public Long add(@PathVariable Long num1,@PathVariable Long num2)
    {
        return num1 + num2;
    }
    
    
    @GetMapping(path = "/sub/{num1}/{num2}")
    public Long sub(@PathVariable Long num1,@PathVariable Long num2)
    {
        return num1 - num2;
    }
    
    
    @GetMapping(path = "/mul/{num1}/{num2}")
    public Long mul(@PathVariable Long num1,@PathVariable Long num2)
    {
        return num1 * num2;
    }
    
    @GetMapping(path = "/div/{num1}/{num2}")
    public Long div(@PathVariable Long num1,@PathVariable Long num2)
    {
        return num1 / num2;
    }
    
    @PostMapping(path = "/calc", consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MathInput> performMathCalc(@RequestBody MathInput mathInput)
    {
        String lv_operator ="";
        switch(mathInput.getOperator( ))
        {
            case "add" :
                mathInput.setResult( mathInput.getNum1( ) + mathInput.getNum2( ) );
                break;
            case "sub" :
                mathInput.setResult( mathInput.getNum1( ) - mathInput.getNum2( ) );
                break;
            case "mul" :
                mathInput.setResult( mathInput.getNum1( ) * mathInput.getNum2( ) );
                break;
            default :
                mathInput.setResult( mathInput.getNum1( ) / mathInput.getNum2( ) );
                break;
            
        }
        
        return ResponseEntity.ok( ).body( mathInput );
    }

}//end of class MathController
