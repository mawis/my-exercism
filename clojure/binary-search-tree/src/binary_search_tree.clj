(ns binary-search-tree)

(defn singleton [num]
  {:v num})

(defn value [node]
  (:v node))

(defn left [node]
  (:left node))

(defn right [node]
  (:right node))

(defn insert [val node]
  (cond
    (nil? node) {:v val}
    (<= val (value node)) {:v (value node)
                           :left (insert val (left node))
                           :right (right node)}
    :otherwise            {:v (value node)
                           :left (left node)
                           :right (insert val (right node))}))

(defn from-list [list]
  (reduce #(insert %2 %1) nil list))

(defn to-list [list]
  (if (nil? list) []
      (concat (to-list (left list)) [(value list)] (to-list (right list)))))
