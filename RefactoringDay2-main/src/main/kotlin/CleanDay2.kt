package org.example

import kotlin.math.*

fun main() {
    GearboxDesigner().performCalculation(
        powerKw = 5.5,
        inputSpeedRpm = 1450.0,
        totalTransmissionRatio = 8.0
    )
}

class GearboxDesigner {

    // Выделение констант в companion object согласно заданию
    companion object {
        const val TORQUE_CONVERSION_CONSTANT = 9550.0   // Коэффициент для расчета момента
        const val HELICAL_GEAR_COEFFICIENT = 450.0      // Коэффициент Ka для косозубых колес
        const val CONTACT_STRESS_COEFFICIENT = 480.0    // Коэффициент для расчета напряжений
        const val GEAR_WIDTH_COEFFICIENT = 0.3          // Коэффициент ширины венца (psi_ba)
        const val ALLOWED_SHEAR_STRESS = 25.0           // Допускаемое напряжение на кручение (МПа)
        const val BEARING_LIFE_EXPONENT = 3.0           // Показатель степени для шарикоподшипников
        const val STAGE_EFFICIENCY = 0.97               // КПД одной ступени
    }

    fun performCalculation(powerKw: Double, inputSpeedRpm: Double, totalTransmissionRatio: Double) {

        // 1. Кинематический расчет
        val inputTorqueNm = TORQUE_CONVERSION_CONSTANT * powerKw / inputSpeedRpm
        val ratioStep1 = sqrt(totalTransmissionRatio) // Разбивка для близости габаритов
        val outputTorqueNm = inputTorqueNm * ratioStep1 * STAGE_EFFICIENCY

        // 2. Геометрический расчет (Межосевое расстояние)
        val centerDistanceMm = HELICAL_GEAR_COEFFICIENT * (ratioStep1 + 1) * cbrt((inputTorqueNm * 1.1) / (ratioStep1.pow(2) * GEAR_WIDTH_COEFFICIENT))

        // 3. Прочностные расчеты (Контактные напряжения)
        val pinionDiameterMm = 2 * centerDistanceMm / (ratioStep1 + 1)
        val gearWidthMm = centerDistanceMm * GEAR_WIDTH_COEFFICIENT
        val tangentialForceN = 2000 * inputTorqueNm / pinionDiameterMm
        val contactStressMpa = CONTACT_STRESS_COEFFICIENT * sqrt((tangentialForceN * (ratioStep1 + 1)) / (pinionDiameterMm * gearWidthMm * ratioStep1))

        // 4. Расчет валов
        val shaftDiameterMm = cbrt(inputTorqueNm / (0.2 * ALLOWED_SHEAR_STRESS)) * 10

        // 5. Подшипники (Динамическая грузоподъемность)
        val radialLoadN = tangentialForceN * 1.2
        val totalRevolutionsMillions = (10000 * inputSpeedRpm) / 60 / 1_000_000
        val requiredDynamicLoadKn = radialLoadN * totalRevolutionsMillions.pow(1.0 / BEARING_LIFE_EXPONENT) / 100

        printResults(centerDistanceMm, contactStressMpa, shaftDiameterMm, requiredDynamicLoadKn)
    }

    private fun printResults(aw: Double, sh: Double, dv: Double, c: Double) {
        println("--- РЕЗУЛЬТАТЫ РАСЧЕТА ---")
        println("Межосевое расстояние: ${"%.2f".format(aw)} мм")
        println("Контактные напряжения: ${"%.2f".format(sh)} МПа")
        println("Диаметр ведущего вала: ${"%.2f".format(dv)} мм")
        println("Треб. динам. грузоподъемность: ${"%.2f".format(c)} кН")
    }
}