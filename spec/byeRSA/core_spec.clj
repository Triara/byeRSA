(ns byeRSA.core-spec
  (:require [speclj.core :refer :all]
            [byeRSA.core :refer :all]))


(describe "Factorization into two prime numbers"
          (it "Factorize into first prime number with another one: 6 = 2 * 3"
              (should= [2 3] (factorize-into-two-primes 6)))
          (it "Factorize into first prime number with another one: 10 = 2 * 5"
              (should= [2 5] (factorize-into-two-primes 10)))
          (it "A prime number can not be factorized"
              (should= nil (factorize-into-two-primes 2)))
          (it "Factorize into any pair of prime number, not necessarily the first one with onother one: 35 = 5 * 7"
              (should= [5 7] (factorize-into-two-primes 35)))
          (it "Some numbers can not be factorized into only two primes"
              (should= nil (factorize-into-two-primes 20)))
          (it "Should handle equal squares of a prime number"
              (should= [997 997] (factorize-into-two-primes 994009))))
