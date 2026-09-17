package com.daveniel_jesson_djiwandana.soal1orderingfood

class ListMenu {
    private var list: ArrayList<MenuThings> = ArrayList()
    public fun addDummy(menuThing: MenuThings) {
        list.add(menuThing)
    }
    public fun addMenu() {
        this.showMenu()
        println("What would you like to add?")
        print("Name: ")
        val tempName: String = readln()
        print("Price: ")
        val tempInput: String = readln()
        val tempPrice: Double? = tempInput.toDoubleOrNull()
        if (tempPrice == null) {
            println("Wrong Input\n")
        } else if(tempPrice < 0) {
            println("Prices have to be positive!")
        } else {
            list.add(MenuThings(tempName, tempPrice))
            println("$tempName has been added to the menu!")
        }

    }
    public fun deleteMenu() {
        if (list.isEmpty()) {
            println("There is no menu items to delete!\n")
        } else {
            this.showMenu()
            println("What would you like to delete?")
            print("No: ")
            val tempInput: String = readln()
            val tempNum: Int? = tempInput.toIntOrNull()
            if (tempNum == null || tempNum <= 0 ||tempNum > list.size) {
                println("Wrong Input\n")
            } else {
                val name: String = list.get(tempNum-1).getName()
                list.removeAt(tempNum-1)
                println("$name has been removed from the menu!")
            }

        }
    }
    public fun editMenu() {
        if (list.isEmpty()) {
            println("There is no menu items to edit!")
        } else {
            this.showMenu()
            println("What would you like to edit?")
            print("No: ")
            val tempInput: String = readln()
            val tempNum: Int? = tempInput.toIntOrNull()
            if (tempNum == null || tempNum <= 0 ||tempNum > list.size) {
                println("Wrong Input\n")
            } else {
                print("New Name: ")
                val tempName: String = readln()
                print("Price: ")
                val tempInput2: String = readln()
                val tempPrice: Double? = tempInput2.toDoubleOrNull()
                if (tempPrice == null ) {
                    println("Wrong Input\n")
                } else if(tempPrice < 0) {
                    println("Prices have to be positive!")
                } else {
                    list.get(tempNum-1).setName(tempName)
                    list.get(tempNum-1).setPrice(tempPrice)
                    println("No. $tempNum has been edited from the menu!")
                }


            }

        }
    }
    public fun showMenu() {
        if (list.isEmpty()) {
            println("The Menu is Empty\n")
        } else {
            var counter: Int = 1
            println("\nMENU LIST")
            for (menuThing: MenuThings in list) {
                println("$counter. ${menuThing.getName()} \$${menuThing.getPrice()}")
                counter++
            }
            println("\n")
        }

    }
}