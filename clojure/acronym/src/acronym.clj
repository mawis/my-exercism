(ns acronym
  (:require [clojure.string :refer [join split upper-case]]))

(defn shorten-word [word]
  (cond
    (every? #(Character/isUpperCase %) word) (first word)
    (every? #(Character/isLowerCase %) word) (upper-case (first word))
    :otherwise (join (filter #(Character/isUpperCase %) word))))

(defn acronym [name]
  (->>
   (split name #"[ :,\\-]+")
   (map shorten-word)
   (join)))
