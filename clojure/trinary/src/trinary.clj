(ns trinary)

(defn digit [d]
  (case d
    \0 0
    \1 1
    \2 2
    (throw (Exception.))))

(defn to-decimal [tri]
  (try
    (reduce #(+ (* %1 3) (digit %2)) 0 tri)
    (catch Exception e 0)))
