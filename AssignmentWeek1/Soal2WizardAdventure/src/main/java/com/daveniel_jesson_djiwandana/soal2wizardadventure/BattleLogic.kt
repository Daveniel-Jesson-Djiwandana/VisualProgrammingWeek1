package com.daveniel_jesson_djiwandana.soal2wizardadventure

class BattleLogic {
    public fun enterBattle(wizard: Wizard): Boolean {
        var enemy: EnemyMon = EnemyMon(enemyType())
        while (true) {
            println("---Battle---")
            wizard.showStatsBattle()

            println(enemy.getName())
            println("HP: ${enemy.getHP()}/${enemy.getMaxHP()}")
            println("Type: ${enemy.getType()}")
            println("------------")
            println("""a. Fire Attack
                |b. Water Attack
                |c. Grass Attack
                |d. Drink potion
                |e. Run
            """.trimMargin())
            var choice: String = readln().uppercase()
            when (choice) {
                "A" -> wizardAttack(wizard, enemy, "Fire")
                "B" -> wizardAttack(wizard, enemy, "Water")
                "C" -> wizardAttack(wizard, enemy, "Grass")
                "D" -> {
                    var num: Int = drinkPotion(wizard)
                    if (num == -1) {
                        continue
                    }
                }
                "E" -> {
                    println("You successfully ran away!\n")
                    return true
                }
                else -> {
                    println("Wrong Input\n")
                    continue
                }
            }
            if (enemy.getHP() <=0) {
                println("${enemy.getName()} died!\n")
                wizard.incrementKills()
                if (!wizard.getEvolved()) {
                    checkEvolve(wizard)
                } else {
                    wizard.incrementLifesteal()
                }
                return true
            }

            enemyAttack(wizard, enemy)

            if (wizard.getHP()<=0) {
                println("Game Over!!\n")
                return false
            }
        }
    }
    private fun enemyType(): String {
        val random = (1..3).random()
        when (random) {
            1 -> return "Fire"
            2 -> return "Water"
            3 -> return "Grass"
        }
        return ""
    }
    private fun wizardAttack(wizard: Wizard, enemy: EnemyMon, spell: String) {
        if (wizard.getMana() < 10) {
            println("Mana insufficient!\n")
            return
        }
        if (wizard.getMana()-10 < 0) {
            wizard.setMana(0)
        } else {
            wizard.setMana(wizard.getMana() - 10)
        }
        var damage = 10
        if (wizard.getEvolved()) {
            damage = 15
        }
        var actualDamage = damage * multiplier(spell, enemy.getType())

        if (enemy.getHP()-actualDamage < 0) {
            enemy.setHP(0)
        } else {
            enemy.setHP(enemy.getHP()-actualDamage)
        }
        println("You attacked ${enemy.getName()} for $actualDamage damage!")

        if (wizard.getEvolved()) {
            if (wizard.getHP() + wizard.getLifesteal() > wizard.getMaxHP()) {
                wizard.setHP(wizard.getMaxHP())
            } else {
                wizard.setHP(wizard.getHP() + wizard.getLifesteal())
            }
            println("You restored ${wizard.getLifesteal()} HP!")
        }
        println("\n")
    }
    private fun enemyAttack(wizard: Wizard, enemy: EnemyMon) {
        if (wizard.getHP()-10 < 0) {
            wizard.setHP(0)
        } else {
            wizard.setHP(wizard.getHP()-10)
        }
        println("You have been hit for 10 damage!\n")
    }
    private fun drinkPotion(wizard: Wizard): Int {
        println("1. HP Potion (stock: ${wizard.getHPPotion()})")
        println("2. MP Potion (stock: ${wizard.getManaPotion()})")
        var choice: String = readln()
        if (choice == "1") {
            if (wizard.getHPPotion() <= 0) {
                println("You have no HP potions!\n")
                return -1
            } else {
                wizard.setHPPotion(wizard.getHPPotion()-1)
                if (wizard.getHP() + 25 > wizard.getMaxHP()) {
                    wizard.setHP(wizard.getMaxHP())
                } else {
                    wizard.setHP(wizard.getHP() + 25)
                }
                println("You restored 25 HP!")
                return 1
            }
        } else if (choice == "2") {
            if (wizard.getManaPotion() <= 0) {
                println("You have no Mana potions!\n")
                return -1
            } else {
                wizard.setManaPPotion(wizard.getManaPotion() - 1)
                if (wizard.getMana() + 15 > wizard.getMaxMana()) {
                    wizard.setMana(wizard.getMaxMana())
                } else {
                    wizard.setMana(wizard.getMana() + 15)
                }
                println("You restored 15 MP!")
                return 1
            }
        } else {
            println("Wrong Input\n")
            return -1
        }
        return 0
    }
    private fun checkEvolve(wizard: Wizard) {
        if (wizard.getKills()>=5 && !wizard.getEvolved()) {
            wizard.setEvolved(true)
            wizard.incrementLifesteal()
            val tempMaxHP = (wizard.getMaxHP() * 1.5).toInt()
            val tempMaxMana = (wizard.getMaxMana()*1.5).toInt()
            wizard.setMaxHP(tempMaxHP)
            wizard.setMaxMana(tempMaxMana)
            println("${wizard.getName()} evolved!\n")
        } else {
            return
        }
    }
    private fun multiplier(spell: String, type: String): Int {
        if (spell == "Fire" && type == "Grass") {
            return 2
        }
        if (spell == "Water" && type == "Fire") {
            return 2
        }
        if (spell == "Grass" && type == "Water") {
            return 2
        }
        return 1
    }
}