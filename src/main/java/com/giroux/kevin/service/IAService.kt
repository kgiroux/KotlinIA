package com.giroux.kevin.service

import com.giroux.kevin.config.Config

interface IAService {
    /**
     * Method that can run neurone learning;
     * @param config: Config config for the neurone;
     */
    fun runProcessLearning(config: Config): String
    fun checkLearning(config: Config)

}