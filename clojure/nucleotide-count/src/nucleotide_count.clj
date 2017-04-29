(ns nucleotide-count
  (:refer-clojure :exclude [count]))

(def nucleotides {\A 0, \C 0, \G 0, \T 0})

(defn illegal-nucleotide []
  (throw (IllegalArgumentException. "Invalid nucleotide!")))

(defn nucleotide-counts [dna]
  (let [counts (merge nucleotides (frequencies dna))]
    (if (= (keys counts) (keys nucleotides)) counts
        (illegal-nucleotide))))

(defn count [nucleotide dna]
  (if (contains? nucleotides nucleotide)
    (get (nucleotide-counts dna) nucleotide)
    (illegal-nucleotide)))
