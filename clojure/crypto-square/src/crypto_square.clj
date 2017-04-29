(ns crypto-square
  (:refer-clojure :exclude [extend])
  (:require [clojure.string :refer [join]]))

(defn valid-char [ch]
  (let [ord (int ch)]
    (or (<= 0x30 ord 0x39) (<= 0x61 ord 0x7A))))

(defn normalize-plaintext [text]
  (->> (.toLowerCase text)
       (mapcat #(when (valid-char %) [%]))
       join))

(defn find-c [len]
  (Math/ceil (Math/sqrt len)))

(defn square-size [text]
  (-> text
      normalize-plaintext
      count
      find-c
      int))

(defn plaintext-segments [text]
  (->> text
       normalize-plaintext
       (partition-all (square-size text))
       (map join)))

(defn extend [length segment]
  (loop [segment segment]
    (if (>= (count segment) length) segment
        (recur (conj (into [] segment) \space)))))

(defn ciphertext [text]
  (->> (plaintext-segments text)
       (map (partial extend (square-size text)))
       (apply map vector)
       (map join)
       (map #(.trim %))
       join))

(defn group-ciphertext [ciphertext]
  (let [cipher-len (count ciphertext)
        group-count (find-c cipher-len)
        size-in-all (int (/ cipher-len group-count))
        groups-with-more (- cipher-len (* group-count size-in-all))
        change-pos (* groups-with-more (inc size-in-all))
        long-groups (subs ciphertext 0 change-pos)
        short-groups (subs ciphertext change-pos)]
    (->> (concat (partition (inc size-in-all) long-groups)
                 (partition size-in-all short-groups))
         (map join))))

(defn normalize-ciphertext [text]
  (->> (ciphertext text)
       group-ciphertext
       (join " ")))
