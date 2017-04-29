(ns etl (:require [clojure.string :refer [lower-case]]))

(defn transform [m]
  (reduce-kv (fn [m' k v]
               (reduce (fn [m v'] (assoc m
                                         (lower-case v') k))
                       m' v))
             {} m))
