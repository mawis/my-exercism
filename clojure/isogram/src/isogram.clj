(ns isogram
  (:require [clojure.string :refer [lower-case]]))

(defn isogram? [word]
  (->> (lower-case word)
       (filter #(Character/isLetter %))
       (frequencies)
       vals
       (not-any? #(> % 1))))
