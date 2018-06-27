package com.giroux.kevin.service

import java.util.*

class UtilsService {
    companion object {
        /**
         *  Permet de génerer un nombre aléatoire de type Double
         */

        private val random = Random()

        fun rand() : Double {
            return random.nextDouble()

        }
    }
}