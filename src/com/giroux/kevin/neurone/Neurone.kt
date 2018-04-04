package com.giroux.kevin.neurone

import com.giroux.kevin.config.Config

/**
 * Class Neurone
 * This class implements the auto learning
 * @author Kévin Giroux
 */
class Neurone{
    /**
     *  Class that contain the weight for each entries
     */
    var weight : MutableList<Double> = mutableListOf()
    /**
     * Bias for the neurone
     */
    var bias                : Double = 0.0
    /**
     * Output, the result after the activation phase
     */
    private var output              : Double = 0.0
    /**
     * PreactivationResult is the result after the preactivation phase
     */
    private var preactivationResult : Double = 0.0
    /**
     * Gradien of the bias
     */
    private var gradientBias        : Double = 0.0
    /**
     * Gradien of weight
     */
    private var gradientWeight     :MutableList<Double> = mutableListOf()
    /**
     * Preactivation phase
     */

    fun preactivation(entries : MutableList<Double> ){
        var result = 0.0

        for (item in  this.weight)  {
            result += item * entries[this.weight.indexOf(item)]
        }
        result += this.bias
        println("Value of the preactivation phase :$result")

        this.preactivationResult = result
    }

    /**
     * Activation signoide
     */
    fun activationSignoide(){
        val result = 1 / (1 + Math.exp(-this.preactivationResult))
        println("Value of the signoide :   $result")
        this.output = result
    }

    /**
     * Descent of Gradient
     * Allow to calculate the new weight, and bias for the neurone that can create the auto learning phase
     */
    fun descentOfGradient(dataSet : DataSet, config : Config){
        this.gradientWeight.clear()
        this.gradientBias = (this.output - dataSet.target) * (Math.exp(-this.preactivationResult) / Math.pow(1 + Math.exp(-this.preactivationResult), 2.0))
        for(item in dataSet.entries){
            val result : Double = (this.output - dataSet.target) * (Math.exp(-this.preactivationResult) /Math.pow(1 + Math.exp(-this.preactivationResult), 2.0) * item)
            this.gradientWeight.add(result)
        }
        for(i in 0..(weight.size-1)){
            weight[i] -= config.learningRate * this.gradientWeight[i]
        }
        bias -= config.learningRate * this.gradientBias
    }

    override fun toString(): String {
        return "Neurone(" +
                "\n\tweight=$weight, " +
                "\n\tbias=$bias, " +
                "\n\toutput=$output, " +
                "\n\tpreactivationResult=$preactivationResult, " +
                "\n\tgradientBias=$gradientBias, " +
                "\n\tgradientWeight=$gradientWeight" +
                "\n)"
    }



}