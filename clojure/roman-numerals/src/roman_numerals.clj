(ns roman-numerals
  (:require [clojure.string :refer [join]]))

(def codes (partition 3 2 "IVXLCDMↁↂ"))

(defn digits [num]
  (assert (< 0 num 10000))
  (loop [accu []
         num num]
    (if (= num 0) accu
        (recur (conj accu (mod num 10)) (quot num 10)))))

(defn encode-digit [[digit [d1 d5 d10]]]
  (cond
    (= 0 digit) ""
    (= 9 digit) (str d1 d10)
    (= 4 digit) (str d1 d5)
    (< digit 4) (join (repeat digit d1))
    :else (str d5 (encode-digit [(- digit 5) [d1 d5 d10]]))))

(defn numerals [num]
  (->> (map vector (digits num) codes)
       (map encode-digit)
       reverse
       join))
