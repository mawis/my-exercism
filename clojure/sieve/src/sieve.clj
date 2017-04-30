(ns sieve)

(defn sieve [max]
  (loop [primes []
         candidates (range 2 (inc max))]
    (if (empty? candidates) primes
        (let [prime (first candidates)]
          (recur (conj primes prime)
                 (filter #(pos? (mod % prime)) candidates))))))
