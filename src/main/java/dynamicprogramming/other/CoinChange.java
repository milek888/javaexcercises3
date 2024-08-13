package dynamicprogramming.other;


import java.util.Arrays;

/* Leet code 322. Coin Change
 *  Fajne wytlumaczenie https://www.codesdope.com/course/algorithms-coin-change/
 *  https://www.codesdope.com/course/algorithms-coin-change/
 *
 * Tutaj na udemy moze byc fajny tutorial do dynamic programing i nie tylko. Ale jeszcze nie przegladalem tego tutoriala
 * Recursion, Backtracking and Dynamic Programming in Java
 * Created by Holczel Balazs
 * https://www.udemy.com/course/algorithmic-problems-in-java/?utm_source=adwords&utm_medium=udemyads&utm_campaign=Search_Keyword_Beta_Prof_la.EN_cc.ROW-English&campaigntype=Search&portfolio=ROW-English&language=EN&product=Course&test=&audience=Keyword&topic=Dynamic_Programming&priority=Beta&utm_content=deal4584&utm_term=_._ag_159583869254_._ad_696298538858_._kw_dynamic+programming+tutorial_._de_c_._dm__._pl__._ti_aud-2268488108799%3Akwd-566707495161_._li_9067410_._pd__._&matchtype=b&gad_source=1&gclid=Cj0KCQjwiOy1BhDCARIsADGvQnCepAHglZd9aNS6XdcYqoma85zL73LCmpfKm_AENcUYWBbNVHMLCcIaAlc_EALw_wcB&couponCode=2021PM20
 * */
public class CoinChange {

    //bottom up dynamic programming
    public int coinChangeBottomUp(int[] coins, int amount) {
        int[] changes = new int[amount + 1];
        for (int i = 0; i< changes.length;i++) {
            changes[i] = Integer.MAX_VALUE;
        }


        changes[0] = 0;
        for (int j = 1; j <= amount; j++) {
            for (int i = 0; i < coins.length; i++) { // wewnetrzna iteracja jest po tablicy coin-ow. Sprawdzamy wszystkie coiny po kolei ktory jest najlepszy do wymiany zaluzmy ze mamy [1,2,3,10] i amount = 3 i sprawdzamy aktualnie dla coin-a 3 centy
                if (coins[i] <= j) { // jesli coint z tabelki coin-ow ma wartosc wieksza niz amount to nie nadaje sie do wymiany bo przekracza nasza kwote
                    changes[j] = Integer.min(changes[j], 1 + changes[j - coins[i]]); //changes[3] = min(MAX_VALUE, 1+ changes[3 - coins[2]]) = min(MAX_VALUE, 1 + changes[3-3])
                }
            }
        }
        return changes[amount];
    }


    /*
    * Wytlumaczenie top down dosc dobre
    * https://betterprogramming.pub/learn-dynamic-programming-the-coin-change-problem-22a104478f50
    * */
    public int coinChangeTopDownMain(int[] coins, int amount) {
        int[] changes = new int[amount + 1];
        Arrays.fill(changes, Integer.MAX_VALUE);
        return coinChangeTopDown(coins, amount, changes);
    }

    //top down dynamic programming
    public int coinChangeTopDown(int[] coins, int amount, int[] changes) {
        if (amount == 0) { // dla rozmiany amount 0 potrzemujemy 0 monet jednoczesnie oznacza to ze moneta rozmieniajaca byla trafna bo zeszla nam z wartoscia do 0 i w linii *** wyjdzie na z rekurencji zwracajac
                           //  Integer.min(min, 1 + coinChangeTopDown(coins, amount - coins[i], changes));  = Integer.min(Integer.MAX_VALUE, 1 + 0) = 1. Ten przyklad dla 3 centow z linii (&&&&&&) fajnie sobie przegladnac
            return 0;
        }
        if(changes[amount] != Integer.MAX_VALUE) { // jesli juz wyliczylismy w ktorejs z poprzednich glebszych rekursji to nie wyliczamy jeszcze raz tylko reuzywamy
            return changes[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) { // (&&&&&&) zaluzmy ze amount zostalo 3 i mamy monety [1,2,3,10] jak dojdzie do monety 3 centy to Integer.min(min, 1 + coinChangeTopDown(coins, amount - coins[i], changes)); zwroci 1, dla 1, 2 wyzsze wartosci a do 10 nie dojdzie bo if (coins[i] <= amount) nie pusci
            if (coins[i] <= amount) {
                min = Integer.min(min, 1 + coinChangeTopDown(coins, amount - coins[i], changes)); // (***)
            }
        }
        changes[amount] = min; // zapamietujemy wyliczana min ilosc rozmien do reuzycia

        return min;
    }

}
