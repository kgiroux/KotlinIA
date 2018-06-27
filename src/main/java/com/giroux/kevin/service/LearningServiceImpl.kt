package com.giroux.kevin.service

import com.giroux.kevin.config.Config
import com.giroux.kevin.neurone.DataSet
import com.giroux.kevin.neurone.Neurone
import org.springframework.stereotype.Service

@Service
class LearningServiceImpl : LearningService {
    private fun runGenerationOfDataSet(config: Config): MutableList<DataSet> {
        val dataSets : MutableList<DataSet> = mutableListOf()
        for (j in 0..(config.entriesNumber -1 /2)){
            val dataSet = DataSet()
            dataSet.target = 1.0
            for (i in 0..(config.entriesNumber -1)){
                dataSet.entries.add( - Math.abs(UtilsService.rand()))
            }
            dataSets.add(dataSet)
        }

        for (j in 0..(config.entriesNumber -1 /2)){
            val dataSet = DataSet()
            dataSet.target = 0.0
            for (i in 0..(config.entriesNumber - 1)){
                dataSet.entries.add(-Math.abs(UtilsService.rand()))
            }
            dataSets.add(dataSet)
        }

        return dataSets
    }


    override fun runLearning(config: Config, neurone: Neurone) {
        val dataSets : MutableList<DataSet>  = runGenerationOfDataSet(config)
        this.runDescentOfGradient(config, neurone, dataSets)
    }

    private fun runDescentOfGradient(config: Config, neurone: Neurone, dataSets : MutableList<DataSet>): Neurone {
        for(i in 0..config.epochNumber){
            println("Epoch n° $i")
            for(item in dataSets){
                neurone.preactivation(item.entries)
                neurone.activationSignoide()
                if(config.log){
                    println("DataSet $item")
                }
                neurone.descentOfGradient(item,config)
            }
        }
        return neurone
    }
}