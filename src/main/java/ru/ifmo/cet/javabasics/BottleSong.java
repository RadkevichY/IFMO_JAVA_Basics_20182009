package ru.ifmo.cet.javabasics;

/**
 * Нужно реализовать констурктор и метод, возвращающий слова песни про бутылки на стене.
 * <p>
 * Слова следующие:
 * <p>
 * 99 bottles of beer on the wall, 99 bottles of beer
 * Take one down, pass it around, 98 bottles of beer
 * 98 bottles of beer on the wall, 98 bottles of beer
 * Take one down, pass it around, 97 bottles of beer
 * 97 bottles of beer on the wall, 97 bottles of beer
 * Take one down, pass it around, 96 bottles of beer
 * 96 bottles of beer on the wall, 96 bottles of beer
 * Take one down, pass it around, 95 bottles of beer
 * 95 bottles of beer on the wall, 95 bottles of beer
 * ...
 * <p>
 * 3 bottles of beer on the wall, 3 bottles of beer
 * Take one down, pass it around, 2 bottles of beer
 * 2 bottles of beer on the wall, 2 bottles of beer
 * Take one down, pass it around, 1 bottles of beer
 * 1 bottle of beer on the wall, 1 bottle of beer
 * Take one down, pass it around, no more bottles of beer on the wall
 * No more bottles of beer on the wall, no more bottles of beer
 * Go to the store and buy some more, 99 bottles of beer on the wall
 * <p>
 * Дело усложняется тем, что текст песни переменный:
 * За раз может быть взято несколько бутылок.
 * Значение передается в качестве параметра конструктора
 * Нужно ограничить возможность взятия бутылок натуральным число не более 99 бутылок за раз.
 */
public class BottleSong {

    int bottleTakenAtOnce;

    public BottleSong(int bottleTakenAtOnce) {
        if(bottleTakenAtOnce>99 | bottleTakenAtOnce<1) {
            throw new IllegalArgumentException();
        }
        this.bottleTakenAtOnce=bottleTakenAtOnce;
    }

    public String getNumber(int bottleTakenAtOnce){
        String number = "";

        if (bottleTakenAtOnce > 19) {
            switch (bottleTakenAtOnce / 10) {
                case 2:
                    number = "twenty "; break;
                case 3:
                    number = "thirty "; break;
                case 4:
                    number = "forty "; break;
                case 5:
                    number = "fifty "; break;
                case 6:
                    number = "sixty "; break;
                case 7:
                    number = "seventy "; break;
                case 8:
                    number = "eighty "; break;
                case 9:
                    number = "ninety "; break;
            }
        }

        switch (bottleTakenAtOnce%10) {
            case 1:
                number += "one "; break;
            case 2:
                number += "two "; break;
            case 3:
                number += "three "; break;
            case 4:
                number += "four "; break;
            case 5:
                number += "five "; break;
            case 6:
                number += "six "; break;
            case 7:
                number += "seven "; break;
            case 8:
                number += "eight "; break;
            case 9:
                number += "nine "; break;
        }
        if(bottleTakenAtOnce>9 & bottleTakenAtOnce<20){
            switch (bottleTakenAtOnce){
                case 10:
                    number += "ten "; break;
                case 11:
                    number = "eleven "; break;
                case 12:
                    number = "twelve "; break;
                case 13:
                    number = "thirteen "; break;
                case 14:
                    number = "fourteen "; break;
                case 15:
                    number = "fifteen "; break;
                case 16:
                    number = "sixteen "; break;
                case 17:
                    number = "seventeen "; break;
                case 18:
                    number = "eighteen "; break;
                case 19:
                    number = "nineteen "; break;
            }
        }

        return number;
    }

    public String getBottleSongLyrics() {

        String song="";
        int bottlesOnTheWall=99;
        String number = getNumber(bottleTakenAtOnce);

        while (bottlesOnTheWall > bottleTakenAtOnce) {
            song += bottlesOnTheWall + " bottles of beer on the wall, "
                    + bottlesOnTheWall + " bottles of beer.\nTake "
                    + number + "down and pass around, ";

            bottlesOnTheWall -= bottleTakenAtOnce;
            if(bottlesOnTheWall!=1) {
                song += bottlesOnTheWall + " bottles of beer on the wall.\n";
            }
            else{
                song += bottlesOnTheWall + " bottle of beer on the wall.\n";
            }

        }

        number=getNumber(bottlesOnTheWall);


        if(bottlesOnTheWall!=1) {
            song += bottlesOnTheWall + " bottles of beer on the wall, " + bottlesOnTheWall + " bottles of beer.\nTake ";
        }
        else{
            song += bottlesOnTheWall + " bottle of beer on the wall, " + bottlesOnTheWall + " bottle of beer.\nTake ";
        }
        song += number + "down and pass around, no more bottles of beer on the wall.\n" +
                "No more bottles of beer on the wall, no more bottles of beer.\n" +
                "Go to the store and buy some more, 99 bottles of beer on the wall.\n";


        return song;
    }
}
