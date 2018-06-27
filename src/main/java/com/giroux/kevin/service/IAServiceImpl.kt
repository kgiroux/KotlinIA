package com.giroux.kevin.service

import com.giroux.kevin.config.Config
import com.giroux.kevin.dao.persistence.ConfigPersistence
import com.giroux.kevin.network.NeuroneMessage
import com.giroux.kevin.network.NeuroneWebSocketHandler
import com.giroux.kevin.neurone.Neurone
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class IAServiceImpl : IAService {

    @Autowired
    private lateinit var neuroneWebSocketHandler: NeuroneWebSocketHandler

    @Autowired
    private lateinit var configurationService: ConfigurationService

    @Autowired
    private lateinit var learningService: LearningService

    @Autowired
    private lateinit var configPersistence: ConfigPersistence;

    private lateinit var neurone: Neurone


    override fun runProcessLearning(config: Config): String {
       val neuroneMessage = NeuroneMessage("Configuration du neurone")

        if(!checkConfiguration(config)){
            throw IllegalArgumentException("Not Valid configuration")
        }

        if(::neurone.isInitialized){
           neurone.clear()
       }
       neuroneWebSocketHandler.sendMessage(neuroneMessage)
       configurationService.configure(config)
        if(::neurone.isInitialized){
            neuroneMessage.setNeurone(neurone)
        }

        neuroneMessage.message = "Fin du la configuration du neurone"
       neuroneWebSocketHandler.sendMessage(neuroneMessage)
       this.neurone  = configurationService.retrieveNeurone()
        if(::neurone.isInitialized){
            neuroneMessage.setNeurone(neurone)
        }
        neuroneMessage.message = "Démarrage de l'apprentissage"
        neuroneWebSocketHandler.sendMessage(neuroneMessage)
        learningService.runLearning(config,neurone)
        neuroneMessage.message = "Fin de l'apprentissage"
        neuroneWebSocketHandler.sendMessage(neuroneMessage)
        return UUID.randomUUID().toString();
    }

    override fun checkLearning(config: Config) {
        val entries = this.generateEntries(config)
        this.neurone.preactivation(entries)
        this.neurone.activationSignoide()
    }

    private fun generateEntries(config: Config): MutableList<Double>{
        val entries : MutableList<Double> = mutableListOf()
        for (i in 0..(config.entriesNumber -1)){
            entries.add(UtilsService.rand())
        }
        return entries
    }

    fun checkConfiguration(config:Config): Boolean{
        if(config.biasValue == 0.0)
            return false;
        if(config.entriesNumber == 0)
            return false;
        if(config.epochNumber == 0)
            return false;
        if(config.learningRate == 0.0)
            return false;
        return true;
    }
}