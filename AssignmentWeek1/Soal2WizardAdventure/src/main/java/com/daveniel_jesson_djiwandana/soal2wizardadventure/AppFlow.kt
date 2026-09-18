package com.daveniel_jesson_djiwandana.soal2wizardadventure

class AppFlow {
    var user: Wizard = Wizard("")
    var logic: BattleLogic = BattleLogic()
    fun start() {
        println("What's your name?")
        var name: String = readln()
        user.setName(name)
        println("Good Luck ${user.getName()}! You're gonna need it!")
        while (true) {
            println("""What're you going to do?
                |1. View Stats
                |2. Enter Battle
                |3. Quit Game
            """.trimMargin())
            print("Choice: ")
            println("\n")
            var choice: String = readln()
            if (choice == "1") {
                while (true) {
                    user.showStatsNormal()
                    println("""a. Drink Mana Potion
                        |b. Drink Health Potion
                        |c. Rename Self
                        |d. Back
                    """.trimMargin())
                    print("Choice: ")
                    var input: String = readln().uppercase()
                    println("\n")
                    if (input == "A") {
                        drinkManaPotion()
                    } else if (input == "B") {
                        drinkHealthPotion()
                    } else if (input == "C") {
                        print("New Name: ")
                        var newName: String = readln()
                        user.setName(newName)
                        println("\n")
                        continue
                    } else if (input == "D") {
                        println("\n")
                        break
                    } else {
                        println("Wrong Input\n")
                        continue
                    }
                }


            } else if (choice == "2") {
                println("\n")
                if (!logic.enterBattle(user)) {
                    logic.resetStat(user)
                }
            } else if (choice == "3") {
                println("bye bye\n")
                return
            } else {
                println("Wrong Input\n")
                continue
            }
        }


    }
    private fun drinkHealthPotion() {
        if (user.getHPPotion() <= 0) {
            println("You have no HP potions!\n")
        } else {
            user.setHPPotion(user.getHPPotion()-1)
            if (user.getHP() + 25 > user.getMaxHP()) {
                user.setHP(user.getMaxHP())
            } else {
                user.setHP(user.getHP() + 25)
            }
            println("You restored 25 HP!\n")
        }
    }
    private fun drinkManaPotion() {
        if (user.getManaPotion() <= 0) {
            println("You have no Mana potions!\n")
        } else {
            user.setManaPPotion(user.getManaPotion() - 1)
            if (user.getMana() + 15 > user.getMaxMana()) {
                user.setMana(user.getMaxMana())
            } else {
                user.setMana(user.getMana() + 15)
            }
            println("You restored 15 MP!\n")
        }
    }
}