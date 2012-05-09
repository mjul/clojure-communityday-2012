(ns communityday.polynomials
  (:require [net.cgrand.parsley :as parsley]))

;; Demonstration of macros
;; We create a couple of macros to add a new polynomial syntax
;; and the ability to diffentiate symbolically.
;; It all happens at compile time.

(defn poly-parser []
  (parsley/parser {:main :poly
                   :space :ws?}
                  :poly [:term \+ :term]
                  :term [:coeff :var :expo]
                  :coeff :num
                  :var :symbol
                  :expo- [\^ :num]
                  :symbol #"[a-zA-Z-]+"
                  :num #"\d+"
                  :ws #"\s+"
                  ))


(defn to-sexp [node]
  (if (map? node)
    (condp (:tag node)
        :net.cgrand.parsley/root (map to-sexp (:content node))
        :poly (list '+ (map to-sexp (:content node)))
        :term  (let [[c v _ e] (:content node)]
                 (list '*
                       (-> c :content first :content first)
                       (-> v :content first :content first)
                       ))
        )
    node))

(defn parse-poly [s]
  ((poly-parser) s))

(defmacro poly
  "Read a polynomial from a string and convert it to a Clojure expression."
  [p]
  (parse-poly p))

