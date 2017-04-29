(ns clock
  (:import [java.time LocalTime]))

(defn add-time [clk m]
  (.plusMinutes clk m))

(defn clock [h m]
  (add-time (LocalTime/MIDNIGHT)
            (+ (* h 60) m)))

(defn clock->string [clk]
  (.toString clk))
