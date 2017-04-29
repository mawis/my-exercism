(ns strain)

(defn retain [condition list]
  (reduce (fn [accu item] (if (condition item) (conj accu item) accu)) [] list))

(defn discard [condition list]
  (retain (complement condition) list))
