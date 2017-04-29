(ns leap)

(def leap-year-rules [[400 true] [100 false] [4 true]])

(defn match-rules [year [interval is-leap]]
  (zero? (mod year interval)))

(defn leap-year? [year]
  (or
   (second (first (filter (partial match-rules year) leap-year-rules)))
   false))
