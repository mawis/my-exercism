(ns phone-number
  (:require [clojure.string :refer [join]]))

(defn number [raw]
  (let [cleaned (join (filter #(Character/isDigit %) raw))]
    (if-let [number (re-matches #"1?(\d{10})" cleaned)]
      (second number)
      "0000000000")))

(defn area-code [raw]
  (subs (number raw) 0 3))

(defn pretty-print [raw]
  (let [number (number raw)]
    (str "(" (subs number 0 3) ") " (subs number 3 6) "-" (subs number 6))))
