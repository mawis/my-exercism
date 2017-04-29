(ns word-count
  (:require [clojure.string :as str]))

(defn- words [phrase]
  (-> phrase
      str/lower-case
      (str/replace #"[^a-z0-9 ]" "")
      (str/split #"\s+")))

(defn word-count [phrase]
  (frequencies (words phrase)))
