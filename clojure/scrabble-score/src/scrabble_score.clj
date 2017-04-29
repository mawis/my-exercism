(ns scrabble-score)

(def scores ["aeioulnrst"
             "dg"
             "bcmp"
             "fhvwy"
             "k"
             ""
             ""
             "jx"
             ""
             "qz"])

(defn score-letter [ch]
  (let [low-char (.toLowerCase (str ch))]
    (second
     (first (filter (fn [[chars score]]
                      (if (.contains chars low-char) score))
                    (map vector scores (range 1 11))))))
)

(defn score-word [word]
  (reduce + (map score-letter word)))
