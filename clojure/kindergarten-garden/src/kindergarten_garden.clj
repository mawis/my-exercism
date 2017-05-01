(ns kindergarten-garden
  (:require [clojure.string :refer [lower-case split-lines]]))

(def plants {\G :grass
             \C :clover
             \R :radishes
             \V :violets})

(def default-students [:alice
                       :bob
                       :charlie
                       :david
                       :eve
                       :fred
                       :ginny
                       :harriet
                       :ileana
                       :joseph
                       :kincaid
                       :larry])

(defn student-keywords [students]
  (sort
   (map (fn [student] (if (keyword? student) student
                          (keyword (lower-case student))))
        students)))

(defn garden
  ([plant-order] (garden plant-order default-students))
  ([plant-order students]
   (->> plant-order
        split-lines
        (map (partial map (partial get plants)))
        (map (partial partition 2))
        (apply map vector)
        (map (partial apply concat))
        (map (partial into []))
        (map vector (student-keywords students))
        (reduce #(apply assoc %1 %2) {})
        ))
  )
