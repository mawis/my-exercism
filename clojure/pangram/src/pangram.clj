(ns pangram
  (:require [clojure.string :refer [includes? lower-case]]))

(defn pangram? [text]
  (let [lowercase-text (lower-case text)]
    (->> (range (int \a) (inc (int \z)))
         (map char)
         (map str)
         (every? #(includes? lowercase-text %)))))
