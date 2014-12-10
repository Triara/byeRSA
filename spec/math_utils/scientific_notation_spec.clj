(ns math_utils.scientific-notation-spec
	(:require [speclj.core :refer :all]
			  [math-utils.scientific-notation :refer :all]))


(describe "In?"
		  (it "Should return true when an element is contained inside a seq"
			  (should (in? 1 '(1 2 3))))
		  (it "Should return false when an element is not contained inside a seq"
			  (should-not (in? 4 '(1 2 3)))))

(describe "Order of a number"
		  (it "150 = 1,5 * 10**2 is of order 2"
			  (should= 2 (order-of 150)))
		  (it "1 = 1 * 10**0 is of order 0"
			  (should= 0 (order-of 1))))

(describe "Extract numbers of a given orden from a seq"
		  (it "Should return all numbers of order 2 from a given sequence"
			  (should= '(230 450) (sort-by-order 2 '(2 5 10 230 450 1890 29822)))))
