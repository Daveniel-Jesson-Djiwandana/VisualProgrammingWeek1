package com.daveniel_jesson_djiwandana.soal2wizardadventure

class EnemyMon(type: String) {
    private var type: String = type
    private var maxHP: Int = 50
    private var HP: Int = 50

    public fun getName(): String {
        return "${this.type}mon"
    }
    public fun getType(): String {
        return this.type
    }
    public fun setType(type: String) {
        this.type = type
    }
    public fun getMaxHP(): Int {
        return this.maxHP
    }
    public fun setMaxHP(maxHP: Int) {
        this.maxHP = maxHP
    }
    public fun getHP(): Int {
        return this.HP
    }
    public fun setHP(HP: Int) {
        this.HP = HP
    }
}