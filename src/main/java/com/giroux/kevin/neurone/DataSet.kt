package com.giroux.kevin.neurone

/**
 * Class that will store dataSet
 * @author Kévin Giroux
 */
class DataSet{
    /**
     * Target for the dataSet
     */
    var target : Double = 0.0
    /**
     * List of the entries for the dataSet
     */
    var entries : MutableList<Double> = mutableListOf()

    override fun toString(): String {
        return "DataSet(\n\ttarget=$target, \n\tentries=$entries\n)"
    }


}