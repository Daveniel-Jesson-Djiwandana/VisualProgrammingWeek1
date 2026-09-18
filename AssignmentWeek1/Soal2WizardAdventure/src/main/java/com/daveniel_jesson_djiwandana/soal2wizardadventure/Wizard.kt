package com.daveniel_jesson_djiwandana.soal2wizardadventure

class Wizard(name: String) {
    private var name: String = name
    private var maxHP: Int = 50
    private var HP: Int = 50
    private var maxMana: Int = 30
    private var mana: Int = 30
    private var kills: Int = 0
    private var evolved: Boolean = false
    private var lifesteal: Int = 0
    private var HPPotions: Int = 5
    private var manaPotions: Int = 5

    public fun getName(): String {
        return this.name
    }
    public fun setName(name: String) {
        this.name = name
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
    public fun getMaxMana(): Int {
        return this.maxMana
    }
    public fun setMaxMana(maxMana: Int) {
        this.maxMana = maxMana
    }
    public fun getMana(): Int {
        return this.mana
    }
    public fun setMana(mana: Int) {
        this.mana = mana
    }
    public fun getKills(): Int {
        return this.kills
    }
    public fun setKills(kills: Int) {
        this.kills = kills
    }
    public fun incrementKills() {
        this.kills += 1
    }
    public fun getEvolved(): Boolean {
        return this.evolved
    }
    public fun setEvolved(evolved: Boolean) {
        this.evolved = evolved
    }
    public fun getLifesteal(): Int {
        return this.lifesteal
    }
    public fun setLifesteal(lifesteal: Int) {
        this.lifesteal = lifesteal
    }
    public fun incrementLifesteal() {
        this.lifesteal += 1
    }
    public fun getHPPotion(): Int {
        return this.HPPotions
    }
    public fun setHPPotion(HPPotion: Int) {
        this.HPPotions = HPPotion
    }
    public fun getManaPotion(): Int {
        return this.manaPotions
    }
    public fun setManaPPotion(manaPotion: Int) {
        this.manaPotions = manaPotion
    }


}