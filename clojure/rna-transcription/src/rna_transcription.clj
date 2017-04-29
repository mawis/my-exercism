(ns rna-transcription)

(defn dna->rna [nuc]
  (or
   ({\G \C, \C \G, \T \A, \A \U} nuc)
   (throw (AssertionError.))))

(defn to-rna [dna]
  (apply str (map dna->rna dna)))
