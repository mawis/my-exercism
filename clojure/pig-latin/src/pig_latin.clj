(ns pig-latin
  (:require [clojure.string :refer [join split]]))

(defn translate-word [word]
  (let [vowel-match (re-matches #"(yt|xr|[aeiou]).*" word)
        consonant-match (re-matches #"(ch|qu|squ|thr?|sch|[^aeiou])(.*)" word)]
    (cond
      vowel-match (str word "ay")
      consonant-match (str (get consonant-match 2) (get consonant-match 1) "ay")
      :otherwise word)))

(defn translate [phrase]
  (join " " (map translate-word (split phrase #" "))))
