(ns math-utils.primes-generator-spec
	(:require [speclj.core :refer :all]
			  [math-utils.primes-generator :refer :all]))


(describe "Is-prime"
		  (it "Should return true when a number is prime"
			  (should (is-prime 3)))
		  (it "Should return false when a number is not prime"
			  (should-not (is-prime 4)))
		  (it "Non integers are not prime numbers"
			  (should-not (is-prime 3.14))))
