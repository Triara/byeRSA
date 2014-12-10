(ns byeRSA.core
	(:require [math-utils.scientific-notation :refer :all]
			  [math-utils.primes-generator :refer :all]))

(defn iterate-over-j [x j seq-j]
	(if (= 0 (count seq-j))
		nil
		(if (= x (* j (first seq-j)))
			(first seq-j)
			(if (= (next seq-j) nil)
				nil
				(iterate-over-j x j (next seq-j))))))

; TODO: Refactor, code duplication
(defn iterate-over-i [x seq-i seq-j]
	(if (= 0 (order-of x))
		[(first seq-i) (iterate-over-j x (first seq-i) (sort-by-order 0 seq-j))]
		(if (= nil (iterate-over-j x (first seq-i) (sort-by-order (- (order-of x) 1 (order-of (first seq-i))) seq-j)))
			(if (= nil (next seq-i))
				nil
				(iterate-over-i x (next seq-i) seq-j))
			[(first seq-i) (iterate-over-j x (first seq-i) (sort-by-order (- (order-of x) 1 (order-of  (first seq-i))) seq-j))])))


(defn factorize-into-two-primes [x]
	(if (is-prime x)
		nil
		(iterate-over-i x primes primes)))
