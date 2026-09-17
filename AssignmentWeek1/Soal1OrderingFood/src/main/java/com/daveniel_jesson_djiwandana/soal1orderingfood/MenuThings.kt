package com.daveniel_jesson_djiwandana.soal1orderingfood

class MenuThings(name: String, price: Double) {
    private var name: String = name
    private var price: Double = price

    public fun getName(): String {
        return this.name
    }
    public fun setName(name: String) {
        this.name = name
    }
    public fun getPrice(): Double {
        return this.price
    }
    public fun setPrice(price: Double) {
        if (price < 0) {
            println("Prices have to be positive!")
        } else {
            this.price = price
        }
    }

}