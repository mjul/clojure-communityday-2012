(ns communityday.test.polynomials
  (:use [communityday.polynomials])
  (:use [clojure.test]))

(deftest poly-macro
  (is '(1) (poly "1"))
  (is '(x) (poly "x"))
  (is '(+ x 1) (poly "x+1")))
