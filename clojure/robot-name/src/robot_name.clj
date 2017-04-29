(ns robot-name)

(defn- new-name []
  (format "RO%03d" (rand-int 1000)))

(defn robot [] {:name (atom (new-name))})

(defn robot-name [rob]
  @(:name rob))

(defn reset-name [rob]
  (reset! (:name rob) (new-name)))
