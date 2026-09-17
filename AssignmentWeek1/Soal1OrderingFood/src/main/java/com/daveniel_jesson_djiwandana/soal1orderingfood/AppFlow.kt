package com.daveniel_jesson_djiwandana.soal1orderingfood

class AppFlow {
    val menuList: ListMenu = ListMenu()
    init {
        menuList.addDummy(MenuThings("Nasi Goreng", 20.0))
        menuList.addDummy(MenuThings("Soto Betawi", 15.0))
        menuList.addDummy(MenuThings("Sate Babi", 30.0))
    }
    fun start() {
        var condition: Boolean = true;
        while (condition) {
            println("""ORDER SYSTEM
1. Make Order
2. View Orders
3. View Menu
4. Add Menu
5. Edit Menu
6. Delete Menu
7. Exit""".trimMargin())
            print("Pick A Number: ")
            val choice = readln()
            if (choice == "7") {
                println("byebye")
                return
            }
            if (choice == "1" || choice == "2" || choice == "3" || choice == "4" || choice == "5" || choice == "6") {
                mainMenu(choice.toInt())
            } else {
                println("wrong input\n")
            }
        }
    }
    fun mainMenu (input: Int) {
        when (input) {
            3 -> menuList.showMenu()
            4 -> menuList.addMenu()
            5 -> menuList.editMenu()
            6 -> menuList.deleteMenu()
        }
    }


}