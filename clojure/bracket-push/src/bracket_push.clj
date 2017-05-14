(ns bracket-push)

(defn valid? [str]
  (loop [str str
         stack []]
    (cond
      (empty? str)       (empty? stack)
      (= (first str) \[) (recur (rest str) (concat [(first str)] stack))
      (= (first str) \]) (and (= (first stack) \[)
                              (recur (rest str) (rest stack)))
      (= (first str) \() (recur (rest str) (concat [(first str)] stack))
      (= (first str) \)) (and (= (first stack) \()
                              (recur (rest str) (rest stack)))
      (= (first str) \{) (recur (rest str) (concat [(first str)] stack))
      (= (first str) \}) (and (= (first stack) \{)
                              (recur (rest str) (rest stack)))
      :otherwise         (recur (rest str) stack))))
