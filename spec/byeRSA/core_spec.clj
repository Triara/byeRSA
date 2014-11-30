(ns byeRSA.core-spec
  (:require [speclj.core :refer :all]
            [byeRSA.core :refer :all]))


(describe "In? method just tells us if an element is contained in a seq"
          (it "Should return true when an element is contained inside a seq"
              (should (in? 1 '(1 2 3)))))
