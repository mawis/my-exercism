(ns robot-simulator)

(def bearings [:north :east :south :west])

(defn robot [coordinates bearing]
  {:coordinates coordinates
   :bearing bearing})

(defn turn-right [bearing]
  (get bearings (mod (inc (.indexOf bearings bearing)) 4)))

(defn turn-left [bearing]
  (nth (iterate turn-right bearing) 3))

(defmulti advance :bearing)

(defmethod advance :north [robbie]
  (update-in robbie [:coordinates :y] inc))
(defmethod advance :east [robbie]
  (update-in robbie [:coordinates :x] inc))
(defmethod advance :south [robbie]
  (update-in robbie [:coordinates :y] dec))
(defmethod advance :west [robbie]
  (update-in robbie [:coordinates :x] dec))

(def command-map {\A advance
                  \R #(update % :bearing turn-right)
                  \L #(update % :bearing turn-left)})

(defn simulate [commands robbie]
  (reduce (fn [old command] ((get command-map command) old))
          robbie
          commands))
