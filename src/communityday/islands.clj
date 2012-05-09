(ns communityday.islands)

;; A Clojure record is not an island
(defrecord Conference [name year])

(def cc (Conference. "Clojure Conj" 2011))
(def cday (Conference. "Community Day" 2012))
(def confs [cc cday])

;; Records works with common functions
(filter #(= 2011 (:year %)) confs)
(sort-by :name confs)

;; a String is a Seq, and Seqs can be counted
;; Sort by the length of the name:
(sort-by (fn [c] (count (:name c))) confs)

;; Fields can be added dynamically
(assoc cday :rating :great)

;; Conference fields have map semantics
(:year cday)

;; A record is also a map of its properties
(seq cday)

(for [[property value] cday]
  (str property "->" value))

