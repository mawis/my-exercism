(ns hello-world)

(defn hello [& n]
  (let [name (or (first n) "World")]
    (str "Hello, " name "!")))
