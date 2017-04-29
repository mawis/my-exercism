(ns flatten-array
  (:refer-clojure :exclude [flatten]))

(defn flatten [a]
  (mapcat (fn [e] (cond
                    (nil? e) []
                    (vector? e) (flatten e)
                    :else [e]))
          a))
