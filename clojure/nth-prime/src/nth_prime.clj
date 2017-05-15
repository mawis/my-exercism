(ns nth-prime)

;; see https://en.wikipedia.org/wiki/Prime_number_theorem#Approximations_for_the_nth_prime_number
(defn estimate-prime [n]
  (if (< n 6) 12
      (let [log-n (Math/log n)
            log-log-n (Math/log log-n)]
        (int (* n (+ log-n log-log-n))))))

(defn sieve [max]
  (let [sqrt-max (Math/sqrt max)
        candidates (boolean-array max true)]
    (loop [prime 2]
      (when (< prime sqrt-max)
        (when (aget candidates prime)
          (loop [multiple (* prime 2)]
            (when (< multiple max)
              (aset candidates multiple false)
              (recur (+ multiple prime)))))
        (recur (inc prime))))
    (filter #(aget candidates %) (range 2 max))))

(defn nth-prime [n]
  (if-not (> n 0) (throw (IllegalArgumentException.)))
  (nth (sieve (estimate-prime n)) (dec n)))
