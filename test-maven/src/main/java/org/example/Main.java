package org.example;

import net.thauvin.erik.crypto.CryptoException;
import net.thauvin.erik.crypto.CryptoPrice;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

//        System.out.println("What is btc Price today");
//        var rate = scanner.nextDouble();
        CryptoPrice rate = null;
        try {
            rate = CryptoPrice.spotPrice("BTC");
        } catch (CryptoException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("BTC price is " + rate.getAmount());

        while (true) {
            System.out.println("How mush $ do you have?");
            var dollars = scanner.nextDouble();

            if (dollars == 0)
                break;

            var result = dollars / rate.getAmount().doubleValue();
            System.out.println("Result = " + result);
        }
    }
}