package com.giroux.kevin.service

import com.giroux.kevin.config.Config
import com.giroux.kevin.neurone.Neurone
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class ConfigurationServiceImpl : ConfigurationService {

    /**
     * Entries for the configuration
     */
    lateinit var entries : MutableList<Double>

    /**
     *  Configuration of the neurone
     */
    lateinit var config : Config

    /**
     * Neurone
     */
    lateinit var neurone : Neurone

    @PostConstruct
    fun initService(){
        this.entries = mutableListOf()
        this.config = Config()
        this.neurone = Neurone()
    }

    override fun configure(config : Config){
        this.defineConfiguration(config)
        this.generateEntries()
        this.definedNeurone()
        this.runComputation()
    }

    fun generateEntries(){
        this.generate()
    }

    private fun defineConfiguration(config : Config){
        this.config = config
    }

    private fun generate(){
        for (i in 0..(config.entriesNumber -1)){
            entries.add(UtilsService.rand())
        }
    }

    private fun definedNeurone(){
        for (i in 0..(config.entriesNumber -1)){
            neurone.addWeigh(UtilsService.rand())
        }
        neurone.bias = config.biasValue

    }

    private fun runComputation(){
        neurone.preactivation(entries)
        neurone.activationSignoide()
    }


    override fun retrieveNeurone(): Neurone{
        return neurone;
    }

}