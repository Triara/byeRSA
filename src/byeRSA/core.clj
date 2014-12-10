(ns byeRSA.core
	(:require [math-utils.scientific-notation :refer :all]))

(def primes '(2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101 103 107 109 113 127 131 137 139 149 151 157 163 167 173 179 181 191 193 197 199 211 223 227 229 233 239 241 251 257 263 269 271 277 281 283 293 307 311 313 317 331 337 347 349 353 359 367 373 379 383 389 397 401 409 419 421 431 433 439 443 449 457 461 463 467 479 487 491 499 503 509 521 523 541 547 557 563 569 571 577 587 593 599 601 607 613 617 619 631 641 643 647 653 659 661 673 677 683 691 701 709 719 727 733 739 743 751 757 761 769 773 787 797 809 811 821 823 827 829 839 853 857 859 863 877 881 883 887 907 911 919 929 937 941 947 953 967 971 977 983 991 997))

(defn is-prime [x]
	(in? x primes))

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
