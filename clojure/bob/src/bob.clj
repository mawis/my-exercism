(ns bob
  (:require [clojure.string :refer [blank? ends-with? trim]]))

(defn shout? [phrase]
  (and
   (not-any? #(Character/isLowerCase %) phrase)
   (some #(Character/isUpperCase %) phrase)))

(defn question? [phrase]
  (ends-with? (trim phrase) "?"))

(defn response-for [phrase]
  (cond (blank? phrase) "Fine. Be that way!"
        (shout? phrase) "Whoa, chill out!"
        (question? phrase) "Sure."
        :else "Whatever."))
