(ns binary)

(defn digit [d]
  (case d
    \0 0
    \1 1
    (throw (Exception.))))

(defn to-decimal [bin]
  (try
    (reduce #(+ (bit-shift-left %1 1) (digit %2)) 0 bin)
    (catch Exception e 0)))
