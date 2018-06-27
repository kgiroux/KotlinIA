package com.giroux.kevin.service

import com.giroux.kevin.config.Config
import com.giroux.kevin.neurone.Neurone

interface ConfigurationService {

    fun configure(config : Config)
    fun retrieveNeurone(): Neurone
}