package com.daveniel_jesson_djiwandana.soal1orderingfood

class OrderThings (orderThing: MenuThings, amount: Int){
    private var orderThing: MenuThings = orderThing
    private var amount: Int = amount

    public fun getOrderThing(): MenuThings {
        return this.orderThing
    }
    public fun setOrderThing(orderThing: MenuThings) {
        this.orderThing = orderThing
    }
    public fun getAmount(): Int {
        return this.amount
    }
    public fun setAmount(amount: Int) {
        this.amount = amount
    }
    public fun subTotal(): Double {
        return orderThing.getPrice() * amount
    }
}