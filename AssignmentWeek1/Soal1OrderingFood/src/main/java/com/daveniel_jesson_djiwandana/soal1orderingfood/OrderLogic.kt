package com.daveniel_jesson_djiwandana.soal1orderingfood

class OrderLogic {
    private var list: ArrayList<OrderThings> = ArrayList()

    public fun addOrder(menuList: MenuLogic) {

        if (menuList.getSize()==0) {
            return
        } else {
            var condition = true
            while (condition) {
                menuList.showMenu()
                println("What would you like to order? (Input q to go back)")
                var choice: String = readln()
                var tempIndex: Int? = choice.toIntOrNull()
                if (choice == "q") {
                    condition = false
                    println("\n")
                    break
                } else {
                    if (tempIndex == null || tempIndex <= 0 || tempIndex > menuList.getSize()) {
                        println("Wrong Input\n")
                        continue
                    } else {
                        print("Amount you want to order: ")
                        var amount: Int? = readln().toIntOrNull()
                        if (amount == null || amount <=0) {
                            println("Wrong Input \n")
                            continue
                        } else {
                            if (check(tempIndex-1, menuList) == -1) {
                                var menuThing: MenuThings? = menuList.getMenuThing((tempIndex-1))
                                if (menuThing != null) {
                                    list.add(OrderThings(menuThing, amount))
                                }

                            } else {
                                var before: Int = list.get(check(tempIndex-1, menuList)).getAmount()
                                list.get(check(tempIndex-1, menuList)).setAmount(before + amount)
                            }
                        }
                    }

                }
            }


        }
    }
    private fun check(index: Int, menuList: MenuLogic): Int {
        var menuToCheck: MenuThings? = menuList.getMenuThing(index)
        var nameToCheck: String? = menuToCheck?.getName()
        var counter = 0
        for (orderThing: OrderThings in list) {
            if (orderThing.getOrderThing()?.getName() == nameToCheck) {
                return counter
            }
            counter++
        }
        return -1
    }
    public fun showOrder() {
        println("\n-- Jesson’s ORDER --")
        if (list.isEmpty()) {
            println("You have not ordered yet!!\n")
        } else {
            var counter = 1
            var total: Double = 0.0
            for (orders: OrderThings in list) {
                println("$counter. ${orders.getOrderThing().getName()} x${orders.getAmount()}    \$${orders.subTotal()}")
                total += orders.subTotal()
                counter++
            }
            println("--------------------")
            println("Total         \$$total\n")
        }

    }
}