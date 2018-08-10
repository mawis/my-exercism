(ns run-length-encoding)

(defn encode-group [group]
  (str (when (> (count group) 1) (count group))
       (first group)))

(defn decode-group [[_ length char]]
  (let [length (if (empty? length) 1
                   (Integer/parseInt length))]
    (apply str (repeat length (first char)))))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (->> plain-text
       (partition-by identity)
       (map encode-group)
       (apply str)))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (->> cipher-text
       (re-seq #"(\d*)([a-zA-Z ])")
       (map decode-group)
       (apply str)))
