package day3.sealedClasses

// 定义密封类
sealed class Calculator

// 定义子类实现父类
class Add: Calculator()
class Subtract: Calculator()