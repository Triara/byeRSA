(ns byeRSA.core)

(defn in? [x seq]
	(if (some #(= x %) seq) true false))