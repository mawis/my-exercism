(ns beer-song
  (:require [clojure.string :refer [join]]))

(defn bottles [n]
  (case n
      1 "1 bottle"
      0 "no more bottles"
      (str n " bottles")))

(defn capital-bottles [n]
  (if (= 0 n) "No more bottles"
      (bottles n)))

(defn one [n]
  (if (= 1 n) "it"
      "one"))

(defn second-line [v]
  (str
   (if (= 0 v) "Go to the store and buy some more, "
       (str "Take " (one v) " down and pass it around, "))
   (bottles (mod (dec  v) 100)) " of beer on the wall.\n"))

(defn verse [v]
  (str (capital-bottles v) " of beer on the wall, " (bottles v) " of beer.\n"
       (second-line v)))

(defn sing
  ([start-verse] (sing start-verse 0))
  ([start end] (join "\n" (map verse (range start (dec end) -1)))))
