(ns allergies)

(def allergen [:eggs
               :peanuts
               :shellfish
               :strawberries
               :tomatoes
               :chocolate
               :pollen
               :cats])

(defn allergies [score]
  (reduce-kv (fn [accu bit item]
               (if (bit-test score bit) (conj accu item) accu))
             []
             allergen))

(defn allergic-to? [score item]
  (some #{item} (allergies score)))
