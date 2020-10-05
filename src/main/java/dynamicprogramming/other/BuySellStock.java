package dynamicprogramming.other;

/* LeetCode 121. Best Time to Buy and Sell Stock
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
* */
public class BuySellStock {

    public int maxProfit(int[] prices) {
        if(prices == null ||prices.length == 0) {
            return 0;
        }
        int tempMax = 0;
        int tempMin = Integer.MAX_VALUE;    //odpowiedz bedzie w tempMin, tempMax
        int globalMin = Integer.MAX_VALUE;

        for (int price : prices) {
            tempMax = Integer.max(tempMax, price);      //jesli znajdziemy nowe max to aktualizujemy tempMax bo zawsze mozemy sprzedac po wyzszej cenie
            globalMin = Integer.min(globalMin, price);  //aktualizujemy globalMin

            if (tempMax - tempMin < price - globalMin) {    //jedyna wartosc ktora moze zagrozic dotychczasowemu wynikowi to nowa najnizsza cena
                tempMin = globalMin;                        //nowa najwyzsza nie zagraza bo dotychczasowy wynik i tak z niej korzysta bo mu ja zawsze aktualizujemy
                tempMax = price;                            // jak znajdziemy lebsza cene do sprzedazy. Mozna te nie wprost zapytac czy mniejsza wartosc
            }                                               // od dotychczasowego minimum moze mu zaszkodzic i wtedy latwo wychodzi ze nie bo bedzie ona miala zawsze rowne lub gorsze min.
        }

        return tempMax - tempMin;
    }

    /*
    We can divide a given problem to solve it recursiveli in 2 ways:
    1) problem(n) = problem(n-1) combine with n
    2) problem(n) = problem(0, i) combine with problem(i+1, n)
     */


    //TODO metoda pomocnicza rekurencyjna ktora zwraca te lokalne
    public MinMax maxProfitRecursive(int[] prices, int n) {//jesli mamy tabele {7, 1, 5, 3, 6, 4}; 6 elementowa to za n podajemy 5
        if (n == 0) {
            return new MinMax(Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
        }

        MinMax minMax = maxProfitRecursive(prices, n - 1);//Zlozonosc procedury rekurencyjnej jest liniowa i diodatkowo tutaj nie
        // powtarzaja sie w rekurencji wyliczenia bo dla danego n tylko raz liczymy wiec dynamic progr top-down podzial nie ma sensu

        int newMax = Integer.max(minMax.getMax(), prices[n]);//tu to samo co w for
        int globalMin = Integer.min(minMax.getGlobalMin(), prices[n]);
        if (prices[n] - globalMin > newMax - minMax.getMin()) {
            return new MinMax(globalMin, prices[n], globalMin);
        }
        return new MinMax(minMax.getMin(), newMax, globalMin);
    }

}
