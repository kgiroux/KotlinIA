package com.giroux.kevin.service

import com.giroux.kevin.config.Config
import com.giroux.kevin.neurone.Neurone

interface LearningService {

    fun runLearning(config: Config, neurone : Neurone)
}