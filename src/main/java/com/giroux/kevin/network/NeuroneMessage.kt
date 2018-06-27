package com.giroux.kevin.network

import com.giroux.kevin.neurone.Neurone

data class NeuroneMessage(var message : String) {

    private lateinit var neurone: Neurone

    fun setNeurone(neurone:Neurone){
        this.neurone = neurone
    }

    fun getNeurone():Neurone{
        return if(::neurone.isInitialized){
            this.neurone
        }else {
            Neurone()
        }
    }
}