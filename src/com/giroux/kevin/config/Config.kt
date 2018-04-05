package com.giroux.kevin.config

/**
 * Configuration's class for the neurone
 * @author Kévin Giroux
 */
class Config {
    /**
     * Log's activation
     */
    var log          : Boolean = false
    /**
     * Learning Step
     */
    var learningRate : Double = 0.08
    /**
     *  Epoch Number for the learning phase
     */
    var epochNumber  : Int = 0
    /**
     *  Entries Number
     */
    var entriesNumber : Int = 100
}