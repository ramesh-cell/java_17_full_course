package test.demov1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	/*public static void main(String[] args) {


	}*/

/*    Write a
    program to
    print all
    prime factors
    of a
    given number.


    For example, if
    the input
    number is 12,
    then the
    output should
    be “2 2 3”.
    And if
    the input
    number is 315,
    then the
    output should
    be “3 3 5 7”.*/


    public static void main(String[] args) {

        int num = 12;
        primeFactors(num);

        SpringApplication.run(DemoApplication.class, args);

    }

    public static void primeFactors( int num) {

        while (num % 2 == 0) {
            System.out.println(2 + " ");
             num /= 2;
        }

         int n = num;
       /* final int n = num;
        IntStream.iterate(3, i -> i + 2)
                .limit((int) Math.sqrt(n))
                .filter(i -> n % i == 0)
                .forEach(i -> {
                    while (n % i == 0) {
                        System.out.println(i + " ");
                        n /= i;
                    }
                });*/
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        if (n > 2) {
            System.out.println(n);
        }

    }

}


