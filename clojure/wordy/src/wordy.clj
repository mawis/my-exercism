(ns wordy
  (:require [clojure.edn :as edn]))

(defn number-rest [str]
  (when-not (nil? str)
    (when-let [match (re-matches #"(-?\d+)(\s+(.*))?" str)]
      [(edn/read-string (get match 1)) (get match 3)])))

(defn operation-rest [str]
  (when-let [match
             (re-matches #"(plus|minus|multiplied by|divided by)\s+(.*)" str)]
    [(get match 1) (get match 2)]))

(defn operations [str]
  (loop [ops []
         str str]
    (if (nil? str) ops
        (let [[next-op rest] (operation-rest str)
              [number rest'] (number-rest rest)]
          (case next-op
              "plus" (recur (conj ops #(+ % number)) rest')
              "minus" (recur (conj ops #(- % number)) rest')
              "multiplied by" (recur (conj ops #(* % number)) rest')
              "divided by" (recur (conj ops #(/ % number)) rest'))))))

(defn evaluate [exercise]
  (let [match (re-matches #"What is (-?\d+)\s+(.*)\?" exercise)]
    (if match (reduce #(%2 %1)
                      (edn/read-string (get match 1))
                      (operations (get match 2)))
        (throw (IllegalArgumentException.)))))
