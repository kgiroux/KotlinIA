package com.giroux.kevin.starter

/**
 * Classe de démarrage
 */
class AppKt{

    /*companion object {
        @JvmStatic fun main(args: Array<String>) {
            println("Kotlin main is running here!")
            println("Hello world")
            println("First Neurone")
             ConfigurationService
            val config = Config()
            config.log = true
            config.epochNumber = 200000
            config.learningRate = 0.08
            config.entriesNumber = 2
            val entries : MutableList<Double> = mutableListOf()
            val  neurone = Neurone()
            // Entries creation
            for (i in 0..(config.entriesNumber -1)){
                entries.add(rand())
                neurone.weight.add(rand())
            }

            neurone.bias = -0.6

            neurone.preactivation(entries)
            neurone.activationSignoide()

            println("Initialisation coefficient : ")
            println("$neurone.weight[0]")
            println("$neurone.weight[1]")
            println("$neurone.bias")

            val dataSets : MutableList<DataSet> = mutableListOf()
            for (j in 0..(config.entriesNumber -1 /2)){
                val dataSet = DataSet()
                dataSet.target = 1.0
                for (i in 0..(config.entriesNumber -1)){
                    dataSet.entries.add( - Math.abs(rand()))
                }
                dataSets.add(dataSet)
            }

            for (j in 0..(config.entriesNumber -1 /2)){
                val dataSet = DataSet()
                dataSet.target = 0.0
                for (i in 0..(config.entriesNumber - 1)){
                    dataSet.entries.add(-Math.abs(rand()))
                }
                dataSets.add(dataSet)
            }

            println("Neurone : $neurone")
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
            println("++++++++++++++++++++++++++++++++++++++")
            println("Result after learning")
            println("Neurone : $neurone")


            println("++++++Verification des resultats++++++")

            entries.clear()
            entries.add(15.0)
            entries.add(15.0)

            neurone.preactivation(entries)
            neurone.activationSignoide()
            println("Neurone : $neurone")

            entries.clear()
            entries.add(-15.0)
            entries.add(-15.0)

            neurone.preactivation(entries)
            neurone.activationSignoide()
            println("Neurone : $neurone")

            println("++++++==========================++++++")

        }


    }*/

}