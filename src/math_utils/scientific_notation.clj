(ns math-utils.scientific-notation)

(defn in? [x seq]
	(if (some #(= x %) seq) true false))

(defn scientific-notation-coefficient [x]
	(if (> x 10)
		(scientific-notation-coefficient x)
		x))

(defn order-of [x]
	(int (Math/floor (Math/log10 x))))

(defn sort-by-order [order seq]
	(reduce
		(fn [out-seq element]
			(if (= order (order-of element))
				(conj out-seq element)
				out-seq))
		[]
		seq))
