(ns atbash-cipher
  (:require [clojure.string :refer [join]]))

(defn encode-char [c]
  (let [codepoint (int c)]
    (cond
      (<= 0x30 codepoint 0x39) (str c)
      (<= 0x41 codepoint 0x5A) (str (char (- 0xBB codepoint)))
      (<= 0x61 codepoint 0x7A) (str (char (- 0xDB codepoint)))
      :otherwise "")))

(defn encode [text]
  (->> (map encode-char text)
       (remove empty?)
       (map-indexed (fn [index c]
                      (if (and (pos? index) (zero? (mod index 5)))
                        (str " " c)
                        c)))
       join))
