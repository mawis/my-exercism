(ns anagram)

(defn- anagram? [w1 w2]
  (let [w1' (.toUpperCase w1)
        w2' (.toUpperCase w2)]
    (and
     (not= w1' w2')
     (= (sort w1') (sort w2')))))

(defn anagrams-for [word wlist]
  (filter (partial anagram? word) wlist))
