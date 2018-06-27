package com.giroux.kevin.network

import com.giroux.kevin.config.Config
import com.giroux.kevin.service.IAService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/config")
@CrossOrigin("*")
class NeuroneConfigurationWS {


    @Autowired
    private lateinit var iaService: IAService


    @PutMapping()
    fun createConfiguration(@RequestBody config : Config): String{
         val result: String  = iaService.runProcessLearning(config);
        return result;
    }
}