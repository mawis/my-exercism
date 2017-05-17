(ns word-count
  (:require [clojure.string :as str]))

(defn- words [phrase]
  (->> phrase
       str/lower-case
       (re-seq #"\w+")))

(defn word-count [phrase]
  (frequencies (words phrase)))
