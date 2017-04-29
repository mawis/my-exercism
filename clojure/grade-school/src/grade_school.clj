(ns grade-school)

(defn add [school name grade]
  (merge-with into school {grade [name]}))

(defn grade [school grade]
  (get school grade []))

(defn sorted [school]
  (->> school
       (map (fn [[k v]] [k (into [] (sort v))]))
       (into (sorted-map))))
